import java.util.*;

public class Graph {
    private Map<Integer, Vertex> vertices;
    private Map<Integer, List<Vertex>> adjacencyList;

    public Graph() {
        vertices = new HashMap<>();
        adjacencyList = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        vertices.put(v.getId(), v);
        adjacencyList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        if (!vertices.containsKey(from)) {
            addVertex(new Vertex(from));
        }

        if (!vertices.containsKey(to)) {
            addVertex(new Vertex(to));
        }

        adjacencyList.get(from).add(vertices.get(to));
    }

    public void printGraph() {
        for (int id : adjacencyList.keySet()) {
            System.out.print(id + ": ");
            for (Vertex v : adjacencyList.get(id)) {
                System.out.print(v + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (Vertex neighbor : adjacencyList.get(current)) {
                int id = neighbor.getId();

                if (!visited.contains(id)) {
                    visited.add(id);
                    queue.add(id);
                }
            }
        }

        System.out.println();
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int current, Set<Integer> visited) {
        visited.add(current);
        System.out.print(current + " ");

        for (Vertex neighbor : adjacencyList.get(current)) {
            int id = neighbor.getId();

            if (!visited.contains(id)) {
                dfsHelper(id, visited);
            }
        }
    }
}