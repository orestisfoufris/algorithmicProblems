package ds.graphs;


public final class Vertex {
    private final int label;
    private Color color = Color.WHITE;

    private Vertex(int label) {
        this.label = label;
    }

    public int getLabel() {
        return label;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Vertex{" +
                "label=" + label +
                ", color=" + color +
                '}';
    }
}
