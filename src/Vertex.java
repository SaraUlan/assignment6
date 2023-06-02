class VertexEdge<Vertex> {
    private final Vertex source;
    private final Vertex dest;
    private final double weight;

    public VertexEdge(Vertex source, Vertex dest, double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public Vertex getSource() {
        return source;
    }

    public Vertex getDest() {
        return dest;
    }

    public double getWeight() {
        return weight;
    }
}