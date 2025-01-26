package Graph;

import java.util.Arrays;

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
