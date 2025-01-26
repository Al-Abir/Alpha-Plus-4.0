package Graph;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Topological_BFS {
    public static class Edge {
        int src;
        int des;

        Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }

    public static void CreateGraph(ArrayList<Edge> graph[]) {
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
    public static void calculate_Indeg(ArrayList<Edge>[]graph, int indeg[]){
        for(int i =0; i<graph.length; i++){
            for(int j=0 ; j<graph[i].size(); j++){
                 Edge e = graph[i].get(j);
                 indeg[e.des]++;
            }
            // for(ArrayList<Edge> edge: graph){
            //     for(Edge e: edge){
            //         indeg[e.des]++;
            //   } 
            // }
          
        }
    }

    public static void topSort(ArrayList<Edge> []graph){
        int indeg[] = new int[graph.length];
        Queue<Integer> q = new LinkedList<Integer>(); // সঠিকভাবে generic টাইপ ব্যবহার করা হয়েছে

        calculate_Indeg(graph, indeg); // helper function call
        for(int i=0; i<indeg.length; i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        //bfs apply
        while(!q.isEmpty()){
            int curr = q.remove();
            System.out.print(curr+ " ");

            for(Edge e : graph[curr]){
                indeg[e.des]--;

                if(indeg[e.des]==0){
                    q.add(e.des);
                }
            }
        }
    }

    public static void main(String[] args) {

        int V = 6;
        ArrayList<Edge> graph[] = new ArrayList[V];
        CreateGraph(graph);
        topSort(graph);
    }
}
