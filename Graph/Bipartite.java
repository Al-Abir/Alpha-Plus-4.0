package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bipartite {
    public static class Edge {
        int src;
        int des;

        Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
        graph[4].add(new Edge(4, 3));
    }

    public static boolean isBipartite(ArrayList<Edge>[] graph) {
        int[] col = new int[graph.length];
        for (int i = 0; i < col.length; i++) {
            col[i] = -1; // Initialize all nodes as uncolored
        }

        for (int i = 0; i < graph.length; i++) {
            if (col[i] == -1) { // Unvisited node
                if (!bfsCheck(graph, col, i)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean bfsCheck(ArrayList<Edge>[] graph, int[] col, int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        col[start] = 0; // Start coloring with 0

        while (!q.isEmpty()) {
            int curr = q.remove();

            for (Edge e : graph[curr]) {
                if (col[e.des] == -1) { // If the node is not colored
                    col[e.des] = 1 - col[curr]; // Assign opposite color
                    q.add(e.des);
                } else if (col[e.des] == col[curr]) { // If adjacent nodes have the same color
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int N = 6;
        ArrayList<Edge>[] graph = new ArrayList[N];
        createGraph(graph);

        System.out.println(isBipartite(graph)); // Output: true or false based on the graph
    }
}
