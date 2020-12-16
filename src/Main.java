import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph(10);
        graph.addEdge(0,4);
        graph.addEdge(4,2);
        graph.addEdge(4,7);
        graph.addEdge(2,1);
        graph.addEdge(1,3);
        graph.addEdge(5,1);
        graph.addEdge(5,3);
        graph.addEdge(7,5);
        graph.addEdge(6,4);
        graph.addEdge(6,2);
        graph.addEdge(1,0);

//        System.out.println(graph.getAdjList(1));

//        DepthFirstPaths dfp = new DepthFirstPaths(graph, 2);
//        System.out.println(dfp.hasPathTo(0));
//        System.out.println(dfp.pathTo(0));
        System.out.println(graph.getAdjList(0));

        BreadthFirstPaths bfp = new BreadthFirstPaths(graph, 8);
        //System.out.println(bfp.hasPathTo(4));
        System.out.println(bfp);

    }
}
