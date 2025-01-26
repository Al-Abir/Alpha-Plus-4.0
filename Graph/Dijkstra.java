package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Dijkstra {
    public static class Edge {
        int src;
        int des;
        int wt;

        Edge(int src, int des, int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }
    }

    public static void CreateGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 3, 7));
        graph[1].add(new Edge(1, 2, 1));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));
    }

    public static class Pair implements Comparable<Pair> {
        int n;
        int path;

        Pair(int n, int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.path - p2.path;
        }
    }

    public static void Dijkstra_algo(ArrayList<Edge>[] graph) {
        int dis[] = new int[graph.length];
        Arrays.fill(dis, (int) 1e8);
        dis[0] = 0; // Distance to source node is 0

        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0)); // Source node with distance 0

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!vis[curr.n]) {
                vis[curr.n] = true;

                for (Edge e : graph[curr.n]) {
                    int u = e.src;
                    int v = e.des;
                    int wt = e.wt;

                    if (dis[u] + wt < dis[v]) {
                        dis[v] = dis[u] + wt;
                        pq.add(new Pair(v, dis[v]));
                    }
                }
            }
        }

        for (int i : dis) {
            System.out.print((i == (int) 1e8 ? "INF" : i) + " ");
        }
    }

    public static void main(String[] args) {
        int v = 6;

        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[v];
        CreateGraph(graph);

        Dijkstra_algo(graph);
    }
}
