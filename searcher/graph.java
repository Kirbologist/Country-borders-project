package searcher;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class graph {
    public static Set<String> vertices() {
        String inputFile = "GEODATASOURCE-COUNTRY-BORDERS.CSV";
        Set<String> countries = new HashSet<>();

        try {
            Scanner sc = new Scanner(new File(inputFile));
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

    public static Map<String, Set<String>> adjacencyList() {
        String inputFile = "GEODATASOURCE-COUNTRY-BORDERS.CSV";
        Map<String, Set<String>> list = new HashMap<>();
        Set<String> countries = vertices();
        for (String code : countries)
            list.put(code, new HashSet<>());

        try {
            Scanner sc = new Scanner(new File(inputFile));
            sc.nextLine();
            while (sc.hasNext())
            {
                String[] line = sc.nextLine().split(",");
                if (!line[2].equals("\"\""))
                    list.get(line[1]).add(line[3]);
            }
            sc.close();
        } catch(Exception e) {
            System.out.println("didn't work :((");
        }
        return list;
    }
}
