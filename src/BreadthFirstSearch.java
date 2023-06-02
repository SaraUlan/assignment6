import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch<Vertex> extends Search<Vertex> {

    public BreadthFirstSearch(MyGraph<Vertex> graph, Vertex source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(MyGraph<Vertex> graph, Vertex current) {
        marked.add(current);
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(current);
        while (!queue.isEmpty()) {
            Vertex v = queue.remove();
            for (VertexEdge<Vertex> edge : graph.getEdges(v)) {
                Vertex vertex = edge.getDest();
                if (!marked.contains(vertex)) {
                    marked.add(vertex);
                    edgeTo.put(vertex, new VertexEdge<>(v, vertex, edge.getWeight()));
                    queue.add(vertex);
                }
            }
        }
    }
}
