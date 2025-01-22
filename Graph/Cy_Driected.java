package Graph;

import java.util.ArrayList;

public class Cy_Driected {

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

        graph[0].add(new Edge(0, 2));
    

        graph[1].add(new Edge(1, 0));


        graph[2].add(new Edge(2, 3));


        graph[3].add(new Edge(3, 0));
    }

    public static boolean Driected_Graph_Cycle(ArrayList<Edge>[] graph){
         boolean vis [] = new boolean[graph.length];
         boolean stack[] = new boolean[graph.length];
         for(int i=0; i<graph.length; i++){

             if(!vis[i]){
               if( !DFSutil(graph, i, vis, stack)){
                return false;
               }
             }
         }
       return true;
    }

    public static boolean DFSutil(ArrayList<Edge>[] graph, int curr, boolean vis[], boolean stack[]){
                 vis[curr] =true;
                 stack[curr]= true;

                 for(int i=0; i<graph[curr].size();i++){
                      Edge e = graph[curr].get(i);

                      // 1st case
                      if(stack[e.des]==true){
                        return true;
                      } 

                      if(!vis[e.des] && DFSutil(graph, e.des, vis, stack)){
                        return true;
                      }
                 }
                 stack[curr]=false;
                 return false;

    }
    public static void main(String[] args) {
        int N = 4;
        ArrayList<Edge>[] graph = new ArrayList[N];
        createGraph(graph);

        System.out.println(Driected_Graph_Cycle(graph));
    }
}
