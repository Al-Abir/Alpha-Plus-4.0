package Graph;

import java.util.ArrayList;
import java.util.Collections;

public class Kruskal {
    // Edge class to store graph edges
    public static class Edge implements Comparable<Edge> {
        int src;
        int dest;
        int wt;

        Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }

        @Override
        public int compareTo(Edge e2) {
            return this.wt - e2.wt; // Sort by weight
        }
    }

    // Create a sample graph
    public static void createGraph(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    // Disjoint Set Union-Find
    static int n = 4; // Number of vertices
    static int[] par = new int[n];
    static int[] rank = new int[n];

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }

    // Find with path compression
    public static int find(int x) {
        if (x != par[x]) {
            par[x] = find(par[x]); // Path compression
        }
        return par[x];
    }

    // Union by rank
    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (parA != parB) { // Union only if in different sets
            if (rank[parA] > rank[parB]) {
                par[parB] = parA;
            } else if (rank[parA] < rank[parB]) {
                par[parA] = parB;
            } else {
                par[parB] = parA;
                rank[parA]++;
            }
        }
    }

    // Kruskal's MST Algorithm
    public static void kruskalsMST(ArrayList<Edge> edges, int V) {
        Collections.sort(edges); // Sort edges by weight
        init(); // Initialize disjoint set

        int mstCost = 0;
        ArrayList<Edge> mst = new ArrayList<>();

        for (Edge edge : edges) {
            // Check if including this edge creates a cycle
            int parA = find(edge.src);
            int parB = find(edge.dest);

            if (parA != parB) {
                union(parA, parB);
                mstCost += edge.wt;
                mst.add(edge); // Add edge to MST
            }
        }

        // Print the MST and its cost
        System.out.println("Edges in the MST:");
        for (Edge edge : mst) {
            System.out.println(edge.src + " -- " + edge.dest + " == " + edge.wt);
        }
        System.out.println("Total cost of MST: " + mstCost);
    }

    public static void main(String[] args) {
        int V = 4; // Number of vertices
        ArrayList<Edge> edges = new ArrayList<>();
        createGraph(edges);

        kruskalsMST(edges, V);
    }
}
