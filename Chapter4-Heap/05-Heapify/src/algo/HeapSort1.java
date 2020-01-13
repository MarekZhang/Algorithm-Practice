package algo;

public class HeapSort1{

    private HeapSort1(){}

    public static void sort(Comparable[] arr){
        
        int N = arr.length;
        MaxHeap<Comparable> hp = new MaxHeap<Comparable>(N);
        //将数组存储为MaxHeap的形式，这样调用extract方法就能按照从大到小出堆
        for(int i = 0; i < N; i++) 
            hp.Insert(arr[i]);
        //将数组重新按照从小到大排序

        for(int i = N - 1; i >= 0; i--)
            arr[i] = hp.Extract();
    }

}