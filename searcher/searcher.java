package searcher;

import java.io.*;
import java.util.*;

public class searcher {
    public static List<String> index() {
        String inputFile = "GEODATASOURCE-COUNTRY-BORDERS.CSV";
        List<String> countries = new ArrayList<>();

        try {
            File test = new File(inputFile);
            Scanner sc = new Scanner(test);
            String code = sc.nextLine();
            while (sc.hasNext())
            {
                String[] line = sc.nextLine().split(",");
                String newCode = line[1];
                if (!newCode.equals(code)) {
                    countries.add(newCode);
                    code = newCode;
                }
            }
            sc.close();
        } catch(Exception e) {
            System.out.println("didn't work :(");
        }
        return countries;
    }

    public static void main(String[] args) {
        List<String> result = index();
        System.out.println(result.size());
        System.out.println(result);
    }
}