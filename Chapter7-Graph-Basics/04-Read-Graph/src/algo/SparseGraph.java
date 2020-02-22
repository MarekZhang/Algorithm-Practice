package algo;
import java.util.Vector;

public class SparseGraph implements Graph{

    // n represents the number of nodes; m represents the number of edges
    private int n, m;
    private boolean directed;
    private Vector<Integer>[] g;

    public SparseGraph(int n, boolean directed){
        assert n >= 0;
        g = new Vector[n]; //Java did not support initialize array with Generic
        for(int i = 0; i < n; i++)
            g[i] = new Vector<Integer>();
        this.n = n;
        this.m = 0;
        this.directed = directed;
    }

    public int V() { return n; } // return the number of nodes
    public int E() { return m; } // return the number of edges

    public void addEdge( int v, int w){
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        
        // 由于邻接表判断两个nodes是否相连的开销为O(n),
        // 每次都判断的话时间开销较大，所以此处忽略平行边（平行边 m也加1）
        // if(hasEdge(v,w))
        //     return;

        g[v].add(w);
        if( v != w && !directed)
            g[w].add(v);

        m++;
    }

    public boolean hasEdge(int v, int w){
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        for(int i = 0; i < g[v].size(); i++){
            if(g[v].elementAt(i) == w)
                return true;
        }
        return false;
    }

    public Iterable<Integer> adj(int v){
        assert v >= 0 && v < n;
        return g[v];
    } 

    @Override
    public void show(){
        assert n > 0;
        for(int i = 0; i < n; i++){
            System.out.print("Vertex" + i + ": ");
            for(int j = 0; j < g[i].size(); j++){
                System.out.print(g[i].elementAt(j) + "\t");
            }
            System.out.println();
        }
    }
}