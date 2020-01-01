package algo;
import java.util.*;


public class BubbleSort2{
    private BubbleSort2(){}

    public static void sort(Comparable[] arr){
        int n = arr.length;
        int lab = 0;
        while(n > 0){
            lab = 0; //用来跳出循环，因为前几位可能已经有序了，这样就不会再排序了，lab的值也不会更新了。
            for(int i = 0; i < n - 1; i++){
                if(arr[i].compareTo(arr[i+1]) > 0) {
                    swap(arr, i, i+1);
                    lab = i + 1;
                }
            }
            n = lab;
        }
    }

    public static void swap (Object[] arr,int i, int j){
        Object tempt = arr[j];
        arr[j] = arr[i];
        arr[i] = tempt;
    }

    public static void main(String[] args){
        int N = 40000;
        Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, 10000);
        Integer[] arr2 = Arrays.copyOf(arr1, arr1.length);
        Integer[] arr3 = Arrays.copyOf(arr1, arr1.length);

        SortTestHelper.testSort("algo.BubbleSort",arr1);
        SortTestHelper.testSort("algo.BubbleSort2", arr2);
        SortTestHelper.testSort("algo.BubbleSort3", arr3);


    }
}