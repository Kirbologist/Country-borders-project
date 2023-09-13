# Country-borders-project

I thought hit me one day: "what is the largest set of countries you can have such that no pair of countries in the set border each other?"

Seeing no answer online, I decided to find this out myself. Mathematically, this is equivalent to asking "Let G be the undirected graph where the vertices are nations and pairs of vertices are adjacent if the corresponding countries have a land border. What is a maximum independent set of G?" The list of countries I'll be using is all the UN member states, plus Palestine, Holy See, Taiwan and Kosovo. I might do this without Kosovo to see if it makes a difference.

## Credits

The country border database is originally from https://github.com/geodatasource/country-borders
The database has been edited to exclude territories and dependencies, to incorporate Western Sahara into Morocco and to include Kosovo.
