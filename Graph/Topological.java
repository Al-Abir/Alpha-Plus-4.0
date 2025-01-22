package Graph;

import java.util.ArrayList;
import java.util.Stack;

public class Topological {

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

        graph[2].add(new Edge(2, 3));
    

        graph[3].add(new Edge(3, 1));


        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));



        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
    }
    public static void topSort(ArrayList<Edge>[] graph){
        boolean [] vis = new boolean[graph.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<graph.length; i++){
            
               if(!vis[i]){
                  topSortUtil(graph, i, vis, st);
               }
        }
        while (!st.isEmpty()) {

            System.out.print(st.pop() + "->");
           
            
        }
    }
    public static void topSortUtil(ArrayList<Edge>graph[],int curr, boolean []vis, Stack<Integer> st){
              
        vis[curr]= true;
          

        for(int i =0; i<graph[curr].size(); i++){
            Edge e = graph[curr].get(i);

            if(!vis[e.des]){
                topSortUtil(graph, e.des, vis, st);
            }

            
            
        }
        st.push(curr);

    }
    public static void main(String[] args) {
        
       int N = 6;
        ArrayList<Edge>[] graph = new ArrayList[N];
        createGraph(graph);
        topSort(graph);
    }
}
