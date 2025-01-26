package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmonFord {

    public static int[] bellmanFord(int V, int[][]edges, int src){

           int dis[]= new int[V];
           Arrays.fill(dis, (int)1e8);
           dis[src]=0;

           for(int i=0; i<V; i++){
             for(int edge[] :edges){
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if(dis[u] !=1e8 && dis[u]+wt<dis[v]){

                    if (i == V - 1)
                    return new int[]{-1};
                    dis[v] = dis[u]+wt;
                }
             }
           }
           return dis;


    }
    public static void main(String[] args) {
        int V=5;
        int [][] edges = new int[][]{
            {1, 3, 2},
            {4, 3, -1},
            {2, 4, 1},
            {1, 2, 1},
            {0, 1, 5}
        };
    
       int src=0;

       int[] ans = bellmanFord(V, edges, src);

       for(int i=0; i<ans.length; i++){
        System.out.println(ans[i] + " ");
       }
       System.out.println();
      for(int e : ans){
         System.out.println(e + " ");
      }
    }
}


/*
        edges.add(new ArrayList<>(Arrays.asList(1, 3, 2))); 
        edges = [
                [1, 3, 2]
               ];
        edges.add(new ArrayList<>(Arrays.asList(4, 3, -1)));
        edges.add(new ArrayList<>(Arrays.asList(2, 4, 1)));
        edges.add(new ArrayList<>(Arrays.asList(1, 2, 1)));
        edges.add(new ArrayList<>(Arrays.asList(0, 1, 5)));
int[][] edges = new int[][] {
    {1, 3, 2},
    {4, 3, -1},
    {2, 4, 1},
    {1, 2, 1},
    {0, 1, 5}
};
static class Edge {
    int u, v, weight;

    Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}
List<Edge> edges = new ArrayList<>();
  edges.add(new Edge(1, 3, 2));
  edges.add(new Edge(4, 3, -1));

  [
    Edge(1, 3, 2),  // Edge from 1 to 3, weight 2
    Edge(4, 3, -1), // Edge from 4 to 3, weight -1
    Edge(2, 4, 1),  // Edge from 2 to 4, weight 1
    Edge(1, 2, 1),  // Edge from 1 to 2, weight 1
    Edge(0, 1, 5)   // Edge from 0 to 1, weight 5
]

*/