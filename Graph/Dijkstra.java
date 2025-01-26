package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
    public static class Edge {
        int des;
        int wt;

        Edge(int des, int wt) {
            this.des = des;
            this.wt = wt;
        }
    }

    public static void CreateGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(1, 2));
        graph[0].add(new Edge(2, 4));

        graph[1].add(new Edge(3, 7));
        graph[1].add(new Edge(2, 1));

        graph[2].add(new Edge(4, 3));

        graph[3].add(new Edge(5, 1));

        graph[4].add(new Edge(3, 2));
        graph[4].add(new Edge(5, 5));
    }

    public static class Pair implements Comparable<Pair> {
        int node;
        int path;

        Pair(int node, int path) {
            this.node = node;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void Dijkstra_algo(ArrayList<Edge>[] graph, int src) {
        int[] dis = new int[graph.length];
        Arrays.fill(dis, (int) 1e8);
        dis[src] = 0;

        boolean[] vis = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.node]) {
                vis[curr.node] = true;

                for (Edge e : graph[curr.node]) {
                    int v = e.des;
                    int wt = e.wt;

                    if (dis[curr.node] + wt < dis[v]) {
                        dis[v] = dis[curr.node] + wt;
                        pq.add(new Pair(v, dis[v]));
                    }
                }
            }
        }

        // Print distances
        for (int i = 0; i < dis.length; i++) {
            if (dis[i] == (int) 1e8) {
                System.out.print("INF ");
            } else {
                System.out.print(dis[i] + " ");
            }
        }
    }

    public static void main(String[] args) {
        int v = 6;
        ArrayList<Edge>[] graph = new ArrayList[v];
        CreateGraph(graph);

        // Run Dijkstra's algorithm from source node 0
        Dijkstra_algo(graph, 0);
    }
}
