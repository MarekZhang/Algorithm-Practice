package algo;

import java.util.Vector;
import java.util.Stack;

public class Path{

    private Graph graph;
    private boolean[] visited;
    private int[] from;
    // the start node of path 
    private int s;

    public Path(Graph G, int s){
        this.graph = G;
        int numOfNode = G.V();
        assert s >= 0 && s < numOfNode;
        this.s = s;
        visited = new boolean[numOfNode];
        from  = new int[numOfNode];

        for(int i = 0; i < numOfNode; i++){
            visited[i] = false;
            from[i] = -1;
        }
        dfs(s);
    }

    private void dfs(int v){
        assert v >= 0 && v < graph.V();
        visited[v] = true;
        for(int node: graph.adj(v)){
            if(!visited[node]){
                from[node] = v;
                dfs(node);
            }
        }
    }

    private boolean hasPath(int w){
        assert w >= 0 && w < graph.V();
        return visited[w] == true;
    }

    private Vector<Integer> path(int w){
        //need to assert has path
        assert hasPath(w);
        Vector<Integer> vec = new Vector<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = w; i != -1;){
            stack.push(i);
            i = from[i];
        }
        while(!stack.isEmpty()){
            Integer tempt = stack.pop();
            vec.add(tempt);
        }

        return vec;
    }

    public void showPath( int w){
        Vector<Integer> vec = new Vector<>();
        vec = path(w);
        for( int i = 0; i < vec.size(); i++){
            System.out.print(vec.get(i));
            if(i == vec.size() - 1)
                return;
            System.out.print(" -> ");
        }

    }

    public boolean[] getVisited(){ return visited; }
}   