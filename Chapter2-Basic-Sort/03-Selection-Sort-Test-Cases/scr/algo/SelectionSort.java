package algo;
import java.util.*;

public class SelectionSort {

    // 将构造函数设置为private， 不产生任何对象
    private SelectionSort(){}

    public static void sort(Comparable arr[]){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int MinIndex = i;
            for(int j = i + 1; j < n; j++)
                if(arr[j].compareTo( arr[MinIndex] ) < 0)
                    MinIndex = j;
            
            swap(arr, i, MinIndex);
        }
    }
    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
    public static void main(String[] args){
        Integer[] arr = SortTestHelper.generateRandomArray(10, 0, 10);
        sort(arr);
        SortTestHelper.printArray(arr);
        System.out.println(SortTestHelper.isSorted(arr));
        SortTestHelper.testSort("algo.SelectionSort", arr);
    }
}
