package ds.graphs;

import java.util.List;

public final class Edge {
    private int from;
    private List<Integer> to;

    public Edge(int from, List<Integer> to) {
        this.from = from;
        this.to = to;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public List<Integer> getTo() {
        return to;
    }

    public void setTo(List<Integer> to) {
        this.to = to;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "from=" + from +
                ", to=" + to +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge edge = (Edge) o;

        if (from != edge.from) return false;
        return to == edge.to;

    }

    @Override
    public int hashCode() {
        int result = from;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        return result;
    }
}
