import java.util.*;
// undirected and unweighted graph
//using adjacency list
//1.unweighted and undirected graph

public class DFS_DISTRIBUTED{
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

    graph[0].add(new Edge(0,1));
    graph[0].add(new Edge(0,2));
    
    graph[1].add(new Edge(1,0));
    graph[1].add(new Edge(1,3));

    graph[2].add(new Edge(2,0));
    graph[2].add(new Edge(2,4));
    
    graph[3].add(new Edge(3,1));
    graph[3].add(new Edge(3,4));
    graph[3].add(new Edge(3,5));

    graph[4].add(new Edge(4,2));
    graph[4].add(new Edge(4,3));
    graph[4].add(new Edge(4,5));

    graph[5].add(new Edge(5,3));
    graph[5].add(new Edge(5,4));
    graph[5].add(new Edge(5,6));

    graph[6].add(new Edge(6,5));
}

public static void dfs(ArrayList<Edge> graph[],int curr ,boolean viz[]) {
   
    
            System.out.print(curr+" ");
            viz[curr]=true;

            for(int i=0;i<graph[curr].size();i++){
                Edge e = graph[curr].get(i);
                if(viz[e.dest]==false)
                dfs(graph,e.dest,viz);
            }
}



    public static void main(String[] args) {


        /*
         * 
         *     1------3
         *    /       | \
         *   0        |  5-- 6
         *    \       | /
         *     2------4  
         * 
         */
        int v=7;
        ArrayList<Edge> graph[] = new ArrayList[v];
        createGraph(graph);
        boolean viz[] = new boolean[v];
        for(int i=0;i<v;i++)
        {
            if(viz[i]==false)
            dfs(graph,i,viz);
        }
        System.out.println();

    }
}


