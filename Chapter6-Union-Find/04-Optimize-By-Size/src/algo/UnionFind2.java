package algo;

public class UnionFind2{

    private int[] parent;
    private int count;

    public UnionFind2(int count){
        parent = new int[count];
        count = count;
        for(int i = 0; i < count; i++)
            parent[i] = i;
    }

    public int find(int i){
        assert i >= 0 && i < count;
        while(parent[i] != i)
            i = parent[i];
        
        return i;
    }

    public boolean isConnected(int p, int q){
        return find(p) == find(q);
    }

    public void unionElements(int p, int q){
        int parentP = parent[p];
        int parentQ = parent[q];

        if(parentP != parentQ)
            parent[parentP] = parentQ;
    }

}