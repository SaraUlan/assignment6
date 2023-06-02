public class DepthFirstSearch<Vertex> extends Search<Vertex> {
    public DepthFirstSearch(MyGraph<Vertex> graph, Vertex source) {
        super(source);
        dfs(graph, source);
    }

    private void dfs(MyGraph<Vertex> graph, Vertex current) {
        marked.add(current);
        count++;
        for (VertexEdge<Vertex> edge : graph.getEdges(current)) {
            Vertex v = edge.getDest();
            if (!marked.contains(v)) {
                edgeTo.put(v, new VertexEdge<>(current, v, edge.getWeight()));
                dfs(graph, v);
            }
        }
    }
}

