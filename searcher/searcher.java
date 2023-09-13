package searcher;

import java.io.*;
import java.util.*;

public class searcher {
    public static List<String> index() {
        String inputFile = "GEODATASOURCE-COUNTRY-BORDERS.CSV";
        List<String> countries = new ArrayList<>();

        try {
            Scanner sc = new Scanner(new File(inputFile));
            String code = sc.nextLine();
            while (sc.hasNext())
            {
                String[] line = sc.nextLine().split(",");
                String newCode = line[0];
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

    public static Map<String, List<String>> adjacencyList() {
        String inputFile = "GEODATASOURCE-COUNTRY-BORDERS.CSV";
        Map<String, List<String>> list = new HashMap<>();
        List<String> countries = index();
        for (String code : countries)
            list.put(code, new ArrayList<>());

        try {
            Scanner sc = new Scanner(new File(inputFile));
            String code = sc.nextLine();
            while (sc.hasNext())
            {
                String[] line = sc.nextLine().split(",");
                list.get(line[0]).add(line[2]);
            }
            sc.close();
        } catch(Exception e) {
            System.out.println("didn't work :((");
        }
        return list;
    }

    public static void main(String[] args) {
        Map<String, List<String>> list = adjacencyList();
        System.out.print(list);
    }
}