# Understanding country borders as a graph theorist

A thought hit me one day: "what is the largest set of countries you can have such that no pair of countries in the set border each other?"

Seeing no answer online, I decided to find this out myself. Mathematically, this is equivalent to asking "Let G be the undirected graph where the vertices are nations and pairs of vertices are adjacent if the corresponding countries have a land border. What is a maximum independent set of G?"

I'll also be investigating other questions about world countries from a graph-theoretical point of view. For example, which are the two countries such that the amount of borders you must cross in any land path from one to the other is the largest? Mathematically, this is equivalent to asking "What is the eccentricity of G and which two vertices have distance equal to this eccentricity?"

The list of countries I'll be using is all the UN member states, plus Palestine, Holy See, Taiwan and Kosovo.

## Result

### Maximum Independent Set

This is the result given to me by my algorithm and one of many possible maximum independent sets. A maximum independent set consists of 112 countries, 40 of which are island countries/Australia, with no other countries bordering it. If we were to exclude Kosovo from the list of countries, we can simply replace Kosovo and Bulgaria with Serbia and Greece in the set given below. Since Taiwan is an island country, the inclusion or exclusion of Taiwan to any set of countries wouldn't change whether it's independent or not. Therefore, excluding Taiwan from the list would still result in the same maximum independent sets, but with Taiwan excluded.

Czechia, Congo, Benin, Georgia, Kosovo, Lesotho, Tuvalu, Fiji, Tunisia, Palau, Belize, South Sudan, Cabo Verde, Lithuania, Saint Lucia, Switzerland, Kuwait, Lebanon, Somalia, Jordan, Turkmenistan, Sri Lanka, Tonga, Holy See, Estonia, Panama, Maldives, Saint Vincent and the Grenadines, Malta, Eritrea, Chad, Paraguay, Bahamas, Zimbabwe, Mali, Eswatini, Thailand, Finland, Sierra Leone, United Kingdom, Marshall Islands, Guinea-Bissau, Ghana, Bulgaria, Ecuador, El Salvador, Taiwan, South Korea, Namibia, Slovenia, Federated States of Micronesia, Nicaragua, Morocco, Monaco, Comoros, Luxembourg, Portugal, Bosnia and Herzegovina, the Gambia , Haiti, Venezuela, Saint Kitts and Nevis, Bangladesh, Pakistan, Mauritius, Nepal, Sao Tome and Principe, Barbados, Papua New Guinea, Madagascar, Antigua and Barbuda, Equatorial Guinea, Nauru, Moldova, San Marino, Malawi, Brunei Darussalam, Bahrain, Burundi, Chile, Suriname, Qatar, Jamaica, New Zealand, Australia, Philippines, Singapore, Timor-Leste, Cyprus, Samoa, Seychelles, Denmark, Kiribati, Netherlands, United States of America, Egypt, Iceland, Kyrgyzstan, Cuba, Dominica, Mongolia, Trinidad and Tobago, Bhutan, Uruguay, Vietnam, Yemen, United Arab Emirates, Solomon Islands, Japan, Andorra, Vanuatu, Grenada

![A maximum independent set of countries of the world](MapChart_Map.png)

### Most land border crossings between two countries

Which two countries are the furthest away by the standard graph-theory metric? Which two countries are such that the amount of borders you have to cross to get from one to the other is the largest? The way this is answered in this project is weird; going from any point to any other point in the same country will never add any border crossings, even if it's something like going from Siberia to Kaliningrad.

With that in mind, we have 3 pairs of countries such that the number of land border crossings between them is the largest, with all 3 tied at 18 crossings:

- Lesotho and Papua New Guinea
- Lesotho and Timor-Leste
- Lesotho and El Salvador

Going to either Papua New Guinea or Timor-Leste requires going across the open ocean to get from one part of Malaysia to another part of Malaysia and one part of Indonesia to another part of Indonesia. Going to El Salvador requires going from Spain's North African territories across the Mediterranean to mainland Spain and then either flying from Metropolitan France to French Guyana, or crossing from Denmark to Canada on Hans Island.

If we had to do everything by foot, then I'd guess the most land border crossings between any two countries is between Lesotho and Portugal, also with 18 crossings.

## Sources

The country border dataset was originally from [The dataset by geodatasource](https://github.com/geodatasource/country-borders).
The database has been edited to exclude territories and dependencies, to incorporate Western Sahara into Morocco, to include Kosovo and to include the new Danish-Canadian land border.
