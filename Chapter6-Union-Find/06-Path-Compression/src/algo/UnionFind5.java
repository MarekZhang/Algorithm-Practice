package algo;

public class UnionFind5{
    private int[] parent;
    private int[] rank;
    private int count;

    public UnionFind5( int count ){
        this.count = count;
        parent = new int[count];
        rank = new int[count];

        for(int i = 0; i < count; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int p){
        assert (p >= 0 && count > 0);
        /* 两步一跳的路径压缩
        while(p != parent[p]){
            parent[p] = parent[parent[p]]; //跳两步到p父节点到父节点
            p = parent[p];
        }
           
        return p;
        */

        //使用递归的路径压缩
        if(p != parent[p]){
            parent[p] = find(parent[p]);
        }
        return parent[p];

    }

    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    public void Union(int p, int q){
        int rootP = find(p);
        int rootQ = find(q);

        if(rank[rootP] > rank[rootQ]){
            parent[rootQ] = rootP;
        }else if(rank[rootQ] > rank[rootP]){
            parent[rootP] = rootQ;
        }else{
            parent[rootQ] = rootP;
            rank[rootP] += 1;
        }
    }

}