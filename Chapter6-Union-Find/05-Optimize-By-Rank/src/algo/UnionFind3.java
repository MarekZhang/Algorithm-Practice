package algo;

public class UnionFind3{
    private int[] parent;
    private int[] size;
    private int count;

    public UnionFind3(int count){
        this.count = count;
        parent = new int[count];
        size = new int[count];

        for(int i = 0; i < count; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int p){
        assert p >= 0 && count > 0;
        while(p != parent[p])
            p = parent[p];
        
        return p;
    }

    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    public void Union(int p, int q){
        int parentP = parent[p];
        int parentQ = parent[q];

        if(parentP == parentQ)
            return;
        
        if(size[parentP] > size[parentQ]){
            parent[parentQ] = parentP;
            size[parentP] += size[parentP];
        }else{
            parent[parentP] = parentQ;
            size[parentQ] += size[parentP];
        }
    }

}