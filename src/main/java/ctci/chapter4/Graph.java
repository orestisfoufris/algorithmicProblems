package ctci.chapter4;

import java.util.*;

/**
 * A a simple directed graph needed for 4.2 exercise
 */
class Graph {

    private Map<Integer, Node> mapOfNodes = new HashMap<>();

    void printGraph() {
        StringBuilder sb = new StringBuilder();

        for (Node node : mapOfNodes.values()) {
            sb.append(node.data).append("->").append("[ ");

            for (Node adjNode : node.adjacentNodes) {
                sb.append(adjNode.data).append(", ");
            }

            sb.append("] ");
        }

        System.out.println(sb.toString());
    }

    void addNode(Integer data, Integer... to) {
        Node node = new Node(data);
        Set<Node> adjacentNodes = node.adjacentNodes;

        for (Integer eachData : to) {
            Node adjNode = new Node(eachData);
            mapOfNodes.computeIfAbsent(eachData, key -> adjNode);
            adjacentNodes.add(adjNode);
        }

        mapOfNodes.put(node.data, node);
    }

    /**
     * Check if path exists from @param fromNode to @param toNode
     * @return true if path exists otherwise false
     */
    boolean bfs(Integer fromNode, Integer toNode) {

        Node from = mapOfNodes.get(fromNode);
        Node to = mapOfNodes.get(toNode);

        if (from == null || to == null) {
            return false;
        }

        if (from.equals(to)) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        from.color = Color.GREY;
        queue.add(from);

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (Node adjNode : node.adjacentNodes) {
                if (adjNode.color.equals(Color.WHITE)) {
                    adjNode.color = Color.GREY;
                    queue.add(adjNode);
                    adjNode.parent = node;

                    if (adjNode.equals(to)) {
                        return true;
                    }
                }
            }

            node.color =Color.BLACK;

        }

        return false;
    }

    private enum Color {
        WHITE, GREY, BLACK;
    }

    private static class Node {
        Color color = Color.WHITE;
        Node parent = null;
        Set<Node> adjacentNodes = new HashSet<>();
        final Integer data;

        private Node(Integer data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(data, node.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }
    }
}
