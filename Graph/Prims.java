package Graph;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Prims {
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
            graph[i] = new ArrayList<>(); // insilization 0 by default value assign null
        }
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 2, 15));
        graph[0].add(new Edge(0, 3, 30));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));
        graph[2].add(new Edge(2, 0, 15));
        graph[2].add(new Edge(2, 3, 50));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 2, 50));
    }

    public static class Pair implements Comparable<Pair> {
        int vertex;
        int cost;

        Pair(int verstex, int cost) {
            this.vertex = verstex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair p2) {
            return this.cost - p2.cost;
        }

    }

    public static void Prims_algo(ArrayList<Edge>[] graph) {
        // undrected, weighted , not cylce, all verstex conteted with minimum value,
        // subgraph
        boolean vis[] = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));

        int finalCost = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();

            if (!vis[curr.vertex]) {
                vis[curr.vertex] = true;
                finalCost += curr.cost;
                // for (int i = 0; i < graph[curr.vertex].size(); i++) {
                //     Edge e = graph[curr.vertex].get(i);
                //     pq.add(new Pair(e.des, e.wt));
                // }

                for (Edge e : graph[curr.vertex]) {
                    pq.add(new Pair(e.des, e.wt));
                }

            }

        }

        System.out.println(finalCost);

    }

    public static void main(String[] args) {

        int V = 4;
        ArrayList<Edge> graph[] = new ArrayList[V];
        CreateGraph(graph);

        Prims_algo(graph);

    }
}
