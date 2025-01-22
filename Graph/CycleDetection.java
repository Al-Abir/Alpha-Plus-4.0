package Graph;

import java.util.ArrayList;

public class CycleDetection {
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
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
    }

    public static boolean cycleDetection(ArrayList<Edge>[] graph) {
        boolean[] vis = new boolean[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                if (cycleDetectionUtil(graph, vis, i, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean cycleDetectionUtil(ArrayList<Edge>[] graph, boolean[] vis, int curr, int parent) {
        vis[curr] = true;

        for (Edge e : graph[curr]) {
            if (!vis[e.des]) {
                if (cycleDetectionUtil(graph, vis, e.des, curr)) {
                    return true;
                }
            } else if (e.des != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int N = 6;
        ArrayList<Edge>[] graph = new ArrayList[N];
        createGraph(graph);

        System.out.println(cycleDetection(graph)); // Output: true or false based on the graph
    }
}
