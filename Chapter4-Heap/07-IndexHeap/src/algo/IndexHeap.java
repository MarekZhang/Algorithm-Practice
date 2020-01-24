package algo;

public class IndexHeap<Item extends Comparable>{

    private Item[] data;
    private int[] Index;
    private int capacity;
    private int count;

    public IndexHeap(int capacity){
        data = (Item[]) new Comparable[capacity + 1];
        Index = new int[capacity + 1];
        this.capacity = capacity;
        this.count = 0;
    }

    public boolean isEmpty() {
        return count == 0; 
    }

    public int size(){
        return count;
    }

    private void ShiftDown(int k){
        while(k * 2 >= count){
            int j = k * 2;
            if(j + 1 <= count && data[Index[j+1]].compareTo(data[Index[j]]) > 0)
                j += 1;
            swapIndexes(k, j);

            k = j;
        }
    }

    private void ShiftUp(int k){
        while( k / 2 >= 1 && data[Index[k]].compareTo(data[Index[k / 2]]) > 0){
            swapIndexes(k, k/2);
            k /= 2;
        }

    }   

    private void swapIndexes(int i, int j){
        int tempt = Index[i];
        Index[i] = Index[j];
        Index[j] = tempt;
    }

    public Item Extract(){

        Item res = data[Index[1]];
        swapIndexes(1,count--);
        ShiftDown(1);

        return res;
    }

    public int ExtractMaxIndex(){
        assert count >= 1;

        int ind = Index[1] - 1;
        swapIndexes(1,count--);
        ShiftDown(1);

        return ind;
    }

    //用户给出i的位置，向此位置插入数据，i从0开始
    public void Insert(int i, Item item){
        assert count+1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity; 

        data[++i] = item;
        Index[++count] = i;
        ShiftUp(count);
    }

    //将指定位置的值做修改,用户方从0开始索引
    public void change(int i, Item newItem){
        data[ ++i ] = newItem;
        //找到data[i]对应的值在MaxHeap中的位置，即其索引的位置
        for(int k = 1; k <= count; k++){
            if(Index[k] == i){
                ShiftUp(k);
                ShiftDown(k);
                return;
            }

        }
    }
}