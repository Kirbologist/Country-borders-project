package searcher;

import java.io.*;
import java.util.*;
import searcher.graph;

public class searcher {
    public static Set<String> countries = graph.vertices();
    public static Map<String, Set<String>> borders = graph.adjacencyList();

    public static Set<String> maximalIndependentSet() {
        Set<String> maxIndepSet = new HashSet<>();
        Set<String> graphVertices = new HashSet<>(countries);
        Map<String, Set<String>> adjacencyList = borders;
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
        Set<String> maxIndepSet = maximalIndependentSet();
        System.out.println(maxIndepSet);
    }
}