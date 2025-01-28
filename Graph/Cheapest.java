package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cheapest {
    public static class Edge {
        int src;
        int dest;
        int cost;

        Edge(int src, int dest, int cost) {
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph, int[][] flights) {
        for (int[] flight : flights) {
            int src = flight[0];
            int dest = flight[1];
            int cost = flight[2];

            Edge e = new Edge(src, dest, cost);
            graph[src].add(e);
        }
    }

    public static class Info {
        int v;
        int cost;
        int stops;

        Info(int v, int cost, int stops) {
            this.v = v;
            this.cost = cost;
            this.stops = stops;
        }
    }

    public static int cheapestFlight(int n, int src, int dest, int k, int[][] flights) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        createGraph(graph, flights);

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            if (i != src) {
                dist[i] = Integer.MAX_VALUE;
            }
        }

        Queue<Info> q = new LinkedList<>();
        q.add(new Info(src, 0, 0)); // Start from source with 0 cost and 0 stops

        while (!q.isEmpty()) {
            Info curr = q.poll();

            if (curr.stops > k) {
                break;
            }

            for (Edge e : graph[curr.v]) {
                int v = e.dest;
                int cost = e.cost;

                if (curr.cost + cost < dist[v] && curr.stops <= k) {
                    dist[v] = curr.cost + cost;
                    q.add(new Info(v, dist[v], curr.stops + 1));
                }
            }
        }

        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }

    public static void main(String[] args) {
        int n = 4, src = 0, dest = 3, k = 1;
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};

        int result = cheapestFlight(n, src, dest, k, flights);

        System.out.println(result);
    }
}