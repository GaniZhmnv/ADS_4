Assignment 4 - Graph Traversal and Shortest Path

This project implements graph traversal and shortest path algorithms using Java.

The project includes:
Breadth-First Search (BFS)
Depth-First Search (DFS)
Dijkstra Algorithm

The graph is represented using adjacency list structure.

The main goal of this assignment was to understand graph representation, graph traversal algorithms, weighted graphs and shortest path calculations.

The project was implemented using object-oriented programming principles with separate classes for vertices, edges, graph structure and experiments.

Vertex Class

The Vertex class represents one node in the graph.

Each vertex contains:
unique id

Methods:
constructor
getId()
toString()

The vertex id is used to identify vertices inside the graph.

Edge Class

The Edge class represents connection between two vertices.

Each edge contains:
source vertex
destination vertex
weight

Methods:
constructor
getters
toString()

The weight field is used for weighted graphs and Dijkstra shortest path algorithm.

Graph Class

The Graph class stores the whole graph structure using adjacency list representation.

Adjacency list stores neighbors for every vertex.

Example:

0 -> 1(4), 2(3)|
1 -> 3(2)|
2 -> 4(5)

The graph supports:
adding vertices
adding edges
graph traversal
shortest path calculations

Methods:
addVertex()
addEdge()
printGraph()
bfs()
dfs()
dijkstra()

The graph in this project is directed and weighted.

Breadth-First Search

Breadth-First Search visits graph level by level.

The algorithm uses Queue data structure.

Algorithm steps:
1. Start from selected vertex
2. Visit current vertex
3. Add all unvisited neighbors into queue
4. Continue until queue becomes empty

Example traversal:

0 1 2 3 4

BFS complexity:
O(V + E)
