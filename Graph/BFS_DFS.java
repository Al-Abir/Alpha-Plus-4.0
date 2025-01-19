package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS_DFS {
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

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
    }

    public static void bfs(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];

        q.add(0); // Start BFS from node 0
        vis[0] = true; // Mark the starting node as visited

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");

            // Add all unvisited neighbors to the queue
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                if (!vis[e.des]) {
                    q.add(e.des);
                    vis[e.des] = true;
                }
            }
        }
    }
  public static void dfs(ArrayList<Edge>graph[], int curr,boolean vis[]){
      System.out.print(curr + " ");
      vis[curr]= true;
      for(int i=0; i<graph[curr].size(); i++){
        Edge e = graph[curr].get(i);
        if(!vis[e.des]){
            dfs(graph,e.des,vis);
        }
      }
  }
    public static void main(String[] args) {
        int n = 7; // Total number of nodes
        ArrayList<Edge>[] graph = new ArrayList[n];
        createGraph(graph);

        System.out.println("BFS Traversal:");
        bfs(graph);
        System.out.println();
        dfs(graph,0, new boolean[n]);
    }
}
