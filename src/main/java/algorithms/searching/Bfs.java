package algorithms.searching;

import datastructures.graphs.SimpleAdjacencyList;
import datastructures.graphs.Vertex;
import datastructures.graphs.VertexColor;

import java.util.*;

public final class Bfs {
    private static final StringBuilder sb = new StringBuilder();
    private Queue<Vertex> queue = new LinkedList<>();

    public void bfs(Map<Integer, List<Vertex>> adjacencyList, Vertex source) {
        for (List<Vertex> list : adjacencyList.values()) {
            Vertex vertex = list.get(0);
            vertex.setColor(VertexColor.WHITE);
            vertex.setDistance(Integer.MAX_VALUE);
            vertex.setParent(null);
        }

        source.setColor(VertexColor.GREY);
        source.setDistance(0);
        source.setParent(null);

        queue.offer(source);
        while(!(queue.isEmpty())){
            Vertex u = queue.poll();
            adjacencyList.get(u.getLabel()).stream()
                    .forEach(vertex -> {
                        if (vertex.getColor().equals(VertexColor.WHITE)) {
                            vertex.setColor(VertexColor.GREY);
                            vertex.setDistance(u.getDistance() + 1);
                            vertex.setParent(u);
                            queue.offer(vertex);
                            // System.out.println(queue);
                        }
                    });
            u.setColor(VertexColor.BLACK);
        }
    }
    public void printShortestPath(Map<Integer, List<Vertex>> graph, int from, int to) {
        Vertex s = graph.get(from).get(0);
        Vertex v = graph.get(to).get(0);
        bfs(graph, s);

        printPath(s, v);
        getSb();

    }

    private void printPath (Vertex s, Vertex v) {
        if (s.getLabel() == v.getLabel()) {
            sb.append(s.getLabel() + " --> ");
        } else if (null == v.getParent()) {
            System.out.println("No path from " + s + " to " + v);
        } else {
            printPath(s, v.getParent());
            sb.append(v.getLabel() + " --> ");
        }
    }

    private void getSb () {
        System.out.println(sb);
    }

    public static void main(String[] args) {
        Bfs bfs = new Bfs();
        Map<Integer, List<Vertex>> graph =
                SimpleAdjacencyList.createSimpleAdjacencyList("/Users/foufriso/Documents/test2.txt");
        // bfs.bfs(graph, graph.get(1).get(0));
        // System.out.println(graph);

        bfs.printShortestPath(graph, 1, 4);
    }
}
