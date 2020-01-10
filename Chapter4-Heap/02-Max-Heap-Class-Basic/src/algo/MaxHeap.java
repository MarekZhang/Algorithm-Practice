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

    public static void main(String[] args){
        MaxHeap<Integer> arr = new MaxHeap<Integer>(100);
        for(int i = 0; i < 10; i++){
            int ele = (int)(Math.random() * 100) + 1;
            arr.Insert(ele);
        }
        System.out.println(arr.size());
    }
}   