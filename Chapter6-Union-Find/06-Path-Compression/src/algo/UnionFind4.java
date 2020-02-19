package algo;

public class UnionFind4{

    private int[] parent;
    private int[] rank;
    private int count;

    public UnionFind4(int count){
        parent = new int[count];
        rank = new int[count];
        this.count = count;
        for(int i = 0; i < count; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int p){
        assert( p >= 0 && count > 0 );
        while(p != parent[p])
            p = parent[p];

        return p;
    }

    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    public void Union(int p, int q){
        int rootP = find(p); //这里不应该用parentP 因为rootP 和 parentP可能会不同 e.g.一个节点与另一个节点连接在一串上有相同根但是parent不同
        int rootQ = find(q);

        if(rank[rootP] > rank[rootQ]){ //rank不用维护 因为rank大的值可以覆盖到rank小的值
            parent[rootQ] = rootP;
        }else if(rank[rootQ] > rank[rootP]){
            parent[rootP] = rootQ;
        }else{
            parent[rootQ] = rootP;
            rank[rootP] += 1;
        }

    }




}