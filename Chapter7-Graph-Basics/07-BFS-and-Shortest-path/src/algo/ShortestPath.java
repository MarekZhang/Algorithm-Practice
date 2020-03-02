package algo;

import java.util.*;

public class ShortestPath{

    private boolean[] visited;
    private int[] order;
    private Graph graph;
    private int[] from;
    private int s;

    public ShortestPath(Graph G, int s){
        assert s >= 0 && s < G.V();
        graph = G;
        this.s = s;
        visited = new boolean[G.V()];
        order = new int[G.V()];
        from = new int[G.V()];
        for(int i = 0; i < graph.V(); i++){
            visited[i] = false;
            order[i] = -1;
            from[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        order[s] = 0;
        int p = s;
        while(!queue.isEmpty()){
            p = queue.remove();
            Vector<Integer> adjList = (Vector<Integer>)graph.adj(p);
            for(Integer node: adjList){
                if(!visited[node]){
                    queue.add(node);
                    visited[node] = true;
                    from[node] = p;
                    order[node] = order[p] + 1;
                }
            }

        }
    }

    private boolean hasPath(int w){
        assert w >= 0 && w < graph.V();
        return visited[w] == true;
    }

    private Vector<Integer> path(int w){
        assert w >= 0 && w < graph.V();
        Vector<Integer> vec = new Vector<>();
        Stack<Integer> stack = new Stack<>();
        int p = w;

        while(p!= -1){
            stack.push(p);
            p = from[p];
        }
        while(!stack.isEmpty()){
            vec.add(stack.pop());
        }
        return vec;
    }

    public void showPath(int w){
        assert hasPath(w);
        Vector<Integer> vec = path(w);
        for(int i = 0; i < vec.size(); i++){
            System.out.print(vec.get(i));
            if(i == vec.size() - 1)
                return;
            System.out.print(" -> ");
        }
    }

}