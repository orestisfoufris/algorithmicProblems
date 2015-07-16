package datastructures.graphs;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class SimpleAdjacencyList {
    /**
     * Initializes a new graph from a file.
     * @param file format should be:
     * 1    2   4
     * 2    3   1
     * 3    2   4
     * 4    3   1
     */
    public static Map<Integer, List<Vertex>> createSimpleAdjacencyList(String file) {
        Map<Integer, List<Vertex>> adjacencyList = new HashMap<>();
        Map<Integer, Vertex> verticesMap = new HashMap<>();

        String line;
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                String[] numbers = line.trim().split("(\\s)+");
                int key = Integer.parseInt(numbers[0]);
                List<Vertex> vertices = new ArrayList<>(numbers.length);
                Vertex parent;
                if(verticesMap.containsKey(key)){
                    parent = verticesMap.get(key);
                } else {
                    parent = new Vertex(key);
                    verticesMap.put(key, parent);
                }
                vertices.add(parent);
                for(int i = 1; i < numbers.length; i++){
                    int label = Integer.parseInt(numbers[i]);
                    if (verticesMap.containsKey(label)) {
                        vertices.add(verticesMap.get(label));
                    } else {
                        Vertex vertex = new Vertex(label, 0, null);
                        vertices.add(vertex);
                        verticesMap.put(label, vertex);
                    }
                }
                adjacencyList.put(key, vertices);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return adjacencyList;
    }

    public static List<Vertex> getVertices(Map<Integer, List<Vertex>> adjacencyList){
        List<Vertex> vertices = adjacencyList.values()
                .stream()
                .map(list -> list.get(0)).collect(Collectors.toList());

        return vertices;
    }

}
