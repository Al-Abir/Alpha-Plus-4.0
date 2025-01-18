package Graph;

import java.util.ArrayList;

public class BFS_DFS {
    public class Edge {

        int src;
        int des;
        int wt;

        Edge(int src, int des, int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }

    }
    public static void createGraph(ArrayList<Edge> graph[]){
         
        for(int i=0; i<graph.length; i++){
            graph[i]= new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));

        graph[1].add(new Edge(1, 0, 1));

        graph[1].add(new Edge(1, 3, 1));

        


    }

    public static void main(String[] args) {

        ArrayList<Edge> graph[] = new ArrayList[5];
        createGraph(graph);
    }
}
