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
        List<String> countries = index();
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

    public static Set<String> maximalIndependentSets() {
        Set<String> maxIndepSet = new HashSet<>();
        Set<String> graphVertices = new HashSet<>(index());
        Map<String, Set<String>> adjacencyList = adjacencyList();
        while (!graphVertices.isEmpty()) {
            int minDegree = Integer.MAX_VALUE;
            String minDegreeVertex = "";
            for (String country : graphVertices) {
                Set<String> neighbours = adjacencyList.get(country);
                neighbours.retainAll(graphVertices);
                if (neighbours.size() < minDegree) {
                    minDegree = neighbours.size();
                    minDegreeVertex = country;
                }
                if (minDegree == 0)
                    break;
            }
            maxIndepSet.add(minDegreeVertex);
            graphVertices.removeAll(adjacencyList.get(minDegreeVertex));
            graphVertices.remove(minDegreeVertex);
        }
        return maxIndepSet;
    }

    public static void main(String[] args) {
        Set<String> maxIndepSet = maximalIndependentSets();
        System.out.println(maxIndepSet);
    }
}