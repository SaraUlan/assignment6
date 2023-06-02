import java.util.*;

public class MyGraph<Vertex> {
    private final boolean undirected;
    private Map<Vertex, List<VertexEdge<Vertex>>> map = new HashMap<>();

    public MyGraph() {
        this.undirected = true;
    }

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(Vertex v) {
        map.put(v, new LinkedList<>());
    }

    public void addEdge(Vertex source, Vertex dest, double weight) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest) || source.equals(dest))
            return; // reject parallels & self-loops

        map.get(source).add(new VertexEdge<>(source, dest, weight));

        if (undirected)
            map.get(dest).add(new VertexEdge<>(dest, source, weight));
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex v : map.keySet()) {
            count += map.get(v).size();
        }

        if (undirected)
            count /= 2;

        return count;
    }

    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source))
            return false;

        for (VertexEdge<Vertex> edge : map.get(source)) {
            if (edge.getDest().equals(dest))
                return true;
        }

        return false;
    }

    public Iterable<Vertex> adjacencyList(Vertex v) {
        if (!hasVertex(v))
            return null;

        List<Vertex> vertices = new LinkedList<>();
        for (VertexEdge<Vertex> edge : map.get(v)) {
            vertices.add(edge.getDest());
        }

        return vertices;
    }

    public Iterable<VertexEdge<Vertex>> getEdges(Vertex v) {
        if (!hasVertex(v))
            return null;

        return map.get(v);
    }
}