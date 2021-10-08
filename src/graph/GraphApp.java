package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class GraphApp {
    public static void main(String[] args) {
        implementGraph();
    }

    public static void implementGraph(){
        GraphClass<String> g = new GraphClass<>(false);
        g.AddVertex("a");
        g.AddEdge("a", "b");
        g.AddEdge("a", "c");
        g.AddEdge("a", "d");
        g.AddEdge("a", "e");

        g.AddVertex("b");
        g.AddEdge("b", "a");
        g.AddEdge("b", "c");
        g.AddEdge("b", "g");

        g.AddVertex("g");
        g.AddEdge("g", "b");
        g.AddEdge("g", "f");

        g.AddVertex("f");
        g.AddEdge("f", "e");
        g.AddEdge("f", "g");
        g.AddEdge("f", "h");

        g.AddVertex("h");
        g.AddEdge("h", "d");
        g.AddEdge("h", "e");
        g.AddEdge("h", "f");

        g.AddVertex("d");
        g.AddEdge("d", "a");
        g.AddEdge("d", "c");
        g.AddEdge("d", "e");
        g.AddEdge("d", "h");

        g.AddVertex("e");
        g.AddEdge("e", "a");
        g.AddEdge("e", "d");
        g.AddEdge("e", "f");

        g.AddVertex("c");
        g.AddEdge("c", "a");
        g.AddEdge("c", "b");
        g.AddEdge("c", "d");

        //g.SearchMangoSeller("a");

        g.BFSPrint("f");

        g.PrintGraph();
        System.out.println(g.getEdgesCount());
    }
}
