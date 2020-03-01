package algo;

public class Components{

    private Graph G;
    private int ccount;
    private boolean[] visited;
    private int[] id;


    public Components(Graph G){
        this.G = G;
        //forgot to initialize
        visited = new boolean[G.V()];
        id = new int[G.V()];
        ccount = 0;
        //forgot to initialize
        int numOfNodes = G.V();
        for(int i = 0; i < numOfNodes; i++){
            visited[i] = false;
            //the id of first group of nodes would be 0, so initialize with -1  
            id[i] = -1; 
        }

        for(int i = 0; i < numOfNodes; i++){
            if( !visited[i] ){
                dfs(i);
                ccount ++;
            }
        }
    }

    private void dfs(int v){
        visited[v] = true;
        id[v] = ccount;
        for(Integer node: G.adj(v)){
            if(!visited[node])
                dfs(node);
        }
    }

    public boolean isConnected(int v, int w){
        assert v >= 0 && v <= G.V();
        assert w >= 0 && w <= G.V();
        return id[v] == id[w];
    }

    public int count(){ return ccount; }
}