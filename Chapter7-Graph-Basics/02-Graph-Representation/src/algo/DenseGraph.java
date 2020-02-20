package algo;

public class DenseGraph{

    // n represents the number of nodes; m represents the number of edges
    private int n, m;
    private boolean directed; // if the graph is directed
    private boolean[][] g;

    public DenseGraph(int n, boolean directed){
        assert n >= 0;
        this.directed = directed;
        g = new boolean[n][n];
        this.n = n;
        this.m = 0;
    }

    public int V(){ return n; } //return the number of nodes;
    public int E(){ return m; } //return the number of edges;

    public void addEdge(int v, int w){
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        if(hasEdge(v, w))
            return;

        g[v][w] = true;
        if(!directed)
            g[w][v] = true;
            
        m++;
    }

    public boolean hasEdge(int v, int w){
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[m][n];
    } 
    
}