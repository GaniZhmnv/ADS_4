public class Experiment {
    public void runTraversals(Graph g) {
        long startBfs = System.nanoTime();
        g.bfs(0);
        long endBfs = System.nanoTime();

        long startDfs = System.nanoTime();
        g.dfs(0);
        long endDfs = System.nanoTime();

        System.out.println("BFS time: " + (endBfs - startBfs) + " ns");
        System.out.println("DFS time: " + (endDfs - startDfs) + " ns");
    }

    public void runMultipleTests() {
        testGraph(10);
        testGraph(30);
        testGraph(100);
    }

    private void testGraph(int size) {
        Graph g = new Graph();

        for (int i = 0; i < size; i++) {
            g.addVertex(new Vertex(i));
        }

        for (int i = 0; i < size - 1; i++) {
            g.addEdge(i, i + 1, i + 2);
        }

        for (int i = 0; i < size - 2; i += 2) {
            g.addEdge(i, i + 2, i + 3);
        }

        System.out.println("Graph size: " + size);

        if (size == 10) {
            System.out.println("Graph structure:");
            g.printGraph();
        }

        runTraversals(g);

        long startDijkstra = System.nanoTime();
        g.dijkstra(0);
        long endDijkstra = System.nanoTime();

        System.out.println("Dijkstra time: " + (endDijkstra - startDijkstra) + " ns");
        System.out.println();
    }

    public void printResults() {
        System.out.println("BFS and DFS were tested on 10, 30, and 100 vertices.");
        System.out.println("Dijkstra was tested on weighted graphs.");
        System.out.println("BFS and DFS expected complexity: O(V + E).");
        System.out.println("Dijkstra without priority queue expected complexity: O(V^2 + E).");
    }
}