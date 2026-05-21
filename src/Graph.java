import java.util.*;

public class Graph {
    private Map<Integer, Vertex> vertices;
    private Map<Integer, List<Edge>> adjacencyList;

    public Graph() {
        vertices = new HashMap<>();
        adjacencyList = new HashMap<>();
    }

    public void addVertex(Vertex v) {
        vertices.put(v.getId(), v);
        adjacencyList.putIfAbsent(v.getId(), new ArrayList<>());
    }

    public void addEdge(int from, int to) {
        addEdge(from, to, 1);
    }

    public void addEdge(int from, int to, int weight) {
        if (!vertices.containsKey(from)) {
            addVertex(new Vertex(from));
        }

        if (!vertices.containsKey(to)) {
            addVertex(new Vertex(to));
        }

        Edge edge = new Edge(vertices.get(from), vertices.get(to), weight);
        adjacencyList.get(from).add(edge);
    }

    public void printGraph() {
        for (int id : adjacencyList.keySet()) {
            System.out.print(id + ": ");

            for (Edge edge : adjacencyList.get(id)) {
                System.out.print(edge.getDestination() + "(" + edge.getWeight() + ") ");
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

            for (Edge edge : adjacencyList.get(current)) {
                int id = edge.getDestination().getId();

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

        for (Edge edge : adjacencyList.get(current)) {
            int id = edge.getDestination().getId();

            if (!visited.contains(id)) {
                dfsHelper(id, visited);
            }
        }
    }

    public void dijkstra(int start) {
        int size = vertices.size();
        int[] distance = new int[size];
        boolean[] visited = new boolean[size];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        for (int i = 0; i < size; i++) {
            int current = getMinDistanceVertex(distance, visited);

            if (current == -1) {
                break;
            }

            visited[current] = true;

            for (Edge edge : adjacencyList.get(current)) {
                int neighbor = edge.getDestination().getId();
                int weight = edge.getWeight();

                if (!visited[neighbor] && distance[current] != Integer.MAX_VALUE) {
                    int newDistance = distance[current] + weight;

                    if (newDistance < distance[neighbor]) {
                        distance[neighbor] = newDistance;
                    }
                }
            }
        }

        System.out.println("Dijkstra shortest paths from vertex " + start + ":");

        for (int i = 0; i < size; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                System.out.println(start + " -> " + i + " = unreachable");
            } else {
                System.out.println(start + " -> " + i + " = " + distance[i]);
            }
        }
    }

    private int getMinDistanceVertex(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < min) {
                min = distance[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}