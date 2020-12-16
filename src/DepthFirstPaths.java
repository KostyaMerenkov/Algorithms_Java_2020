
import java.util.LinkedList;

public class DepthFirstPaths extends Paths{

    public DepthFirstPaths(Graph g, int source) {
        this.source = source;
        edgeTo = new int[g.getVertexCount()];
        marked = new boolean[g.getVertexCount()];
        dfs(g, source);
    }

    private void dfs(Graph g, int v) {
        marked[v] = true;
        for (int w : g.getAdjList(v)) {
            if(!marked[w]){
                edgeTo[w] = v;
                dfs(g, w);
            }
        }
    }

}
