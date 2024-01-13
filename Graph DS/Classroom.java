import java.util.*;

public class Classroom{
    static class Edge {
        int src;
        int dest;

        public Edge(int s, int d)
        {
            this.src = s;
            this.dest = d;
        }
    }

public static void createGraph(ArrayList<Edge> graph[]){
    for(int i = 0; i < graph.length; i++)
    graph[i]=new ArrayList<Edge>();

    graph[0].add(new Edge(0,2));
    
    graph[1].add(new Edge(1,2));
    graph[1].add(new Edge(1,3));

    graph[2].add(new Edge(2,0));
    graph[2].add(new Edge(2,1));
    graph[2].add(new Edge(2,3));

    graph[3].add(new Edge(0,1));
    graph[3].add(new Edge(0,2));
}

    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge> graph[] = new ArrayList[v];
    }
}




/*
Graph can be represented or created using the following methods: 

Adjacency list
Adjacency Matrix
Edge list
2D matrix(Implicit graph)

 */

