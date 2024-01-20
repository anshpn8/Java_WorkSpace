import java.util.*;
// undirected and unweighted graph
//using adjacency list
//1.unweighted and undirected graph

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
    //the given for loop is required for handling the null pointer exception
    for(int i = 0; i < graph.length; i++)
    graph[i]=new ArrayList<Edge>();

    graph[0].add(new Edge(0,2));
    
    graph[1].add(new Edge(1,2));
    graph[1].add(new Edge(1,3));

    graph[2].add(new Edge(2,0));
    graph[2].add(new Edge(2,1));
    graph[2].add(new Edge(2,3));

    graph[3].add(new Edge(3,1));
    graph[3].add(new Edge(3,2));
}

    public static void main(String[] args) {
        int v=4;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);

        //print 2's neighbors
        for(int i=0;i<graph[2].size();i++)
        {
            Edge e = graph[2].get(i);
            System.out.println(e.dest+" ");
        }
    }
}




/*
Graph can be represented or created using the following methods: 

Adjacency list
{
    easy to find the length of the adjacency list
}
Adjacency Matrix
Edge list
2D matrix(Implicit graph)

 */


 /*
  * 
    1.unweighted and undirected graph
    2.weighted and undirected graph
    3.unweighted and directed graph
    4.weighted and directed graph

  */
