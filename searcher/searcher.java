package searcher;

import java.util.*;
import javafx.util.Pair;

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

    public static Pair<String, Integer> vertexEccentricity(String baseCountry) {
        Map<String, Integer> distances = new HashMap<>();
        for (String country : countries)
            distances.put(country, Integer.MAX_VALUE);
        distances.put(baseCountry, 0);

        Queue<String> searchQueue = new LinkedList<>();
        searchQueue.add(baseCountry);
        Set<String> visitedSet = new HashSet<>();
        visitedSet.add(baseCountry);
        Integer eccentricity = 0;
        String furthestVertex = "";

        while (!searchQueue.isEmpty()) {
            String vertex = searchQueue.remove();
            for (String neighbour : borders.get(vertex)) {
                if (!visitedSet.contains(neighbour)) {
                    searchQueue.add(neighbour);
                    distances.put(neighbour, distances.get(vertex) + 1);
                    visitedSet.add(neighbour);
                    if (eccentricity == distances.get(vertex)) {
                        eccentricity++;
                        furthestVertex = neighbour;
                    }
                }
            }
        }
        System.out.println(distances);
        return new Pair(furthestVertex, eccentricity);
    }

    public static Map<String, Pair<String, Integer>> allEccentricities() {
        Map<String, Pair<String, Integer>> distances = new HashMap<>();
        for (String country : countries)
            distances.put(country, vertexEccentricity(country));
        return distances;
    }

    public static void main(String[] args) {
        //Map<String, Pair<String, Integer>> distances = allEccentricities();
        //System.out.println(distances);
        vertexEccentricity("Lesotho");
    }
}