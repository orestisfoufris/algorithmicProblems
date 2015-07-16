package ds.graphs;


public final class Vertex {
    private final int label;
    private VertexColor color = VertexColor.WHITE;
    private int distance;
    private Vertex parent;

    public Vertex(int label) {
        this.label = label;
    }

    public Vertex(int label, int distance, Vertex parent) {
        this(label);
        this.distance = distance;
        this.parent = parent;
    }

    public int getLabel() {
        return label;
    }

    public VertexColor getColor() {
        return color;
    }

    public void setColor(VertexColor color) {
        this.color = color;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label=" + label +
                ", color=" + color +
                ", distance=" + distance +
                //", parent=" + parent +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vertex vertex = (Vertex) o;

        if (label != vertex.label) return false;
        if (distance != vertex.distance) return false;
        if (color != vertex.color) return false;
        return !(parent != null ? !parent.equals(vertex.parent) : vertex.parent != null);

    }

    @Override
    public int hashCode() {
        int result = label;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + distance;
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        return result;
    }
}
