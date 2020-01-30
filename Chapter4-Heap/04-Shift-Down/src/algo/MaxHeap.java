package algo;

//MaxHeap 采用从1开始索引的数组
public class MaxHeap<Item extends Comparable>{
    private Item[] data;
    private int count;

    private void swap(Item[] data, int i, int j){
        Item tempt = data[i];
        data[i] = data[j];
        data[j] = tempt;
    }

    private void ShiftUp( int k){

        while( k > 1 && data[k].compareTo(data[k / 2]) > 0){
            swap(data, k, k / 2);
            k /= 2;
        }

    }
    private void ShiftDown( int k){

        while( k * 2 <= count){
            int j = k * 2;
            if(j + 1 <= count && data[j + 1].compareTo(data[j]) > 0)
                j++;
            if(data[k].compareTo(data[j]) < 0){
                swap(data, k, j);
                k = j;
            }else{
                return;
            }
            
        }
    }

    public MaxHeap(int capacity){
        data = (Item[])new Comparable[capacity + 1]; //MaxHeap采用从 1 开始索引的方法
        count = 0;
    }

    public int size(){
        return count;
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public void Insert(Item element){
        data[++ count] = element;
        ShiftUp(count);
    }

    public Item Extract(){
        assert count > 0;
        Item ele = data[1];
        data[1] = data[count --];
        ShiftDown(1); //取出data[1]
        return ele;
    }

    public static void main(String[] args){
        MaxHeap<Integer> arr = new MaxHeap<Integer>(100);
        for(int i = 0; i < 10; i++){
            int ele = (int)(Math.random() * 100) + 1;
            arr.Insert(ele);
        }
        for(int i = 0; i < 10; i++){
            System.out.println(arr.Extract());
        }
        System.out.println(arr.size());
        
    }
}   