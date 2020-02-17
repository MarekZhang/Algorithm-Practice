package algo;

public class UnionFind1{
    private int[] id;
    private int count;

    public UnionFind1(int n){
        id = new int[n];
        for(int i = 0; i < n; i++){
            id[i] = i;
        }
    }

    public int Find(int p){
        assert p >=0 && p < count;
        return id[p];
    }

    public boolean isConnected(int p, int q){
        return Find(p) == Find(q);
    }

    //O(n)
    public void unionElements(int p, int q){
        int pId = Find(p);
        int qId = Find(q);

        if(pId == qId)
            return;
        //遍历所有元素，只要是与p同组的元素，id全部更改为q的id
        for(int i = 0; i < count; i++){
            if(id[i] == pId)
                id[i] = qId;
        }
    }

}