package algo;
import java.util.*;

public class InsertionSort{
    private InsertionSort(){}

    public static void sort(Comparable[] arr){
        int n = arr.length;
        for(int i = 1; i < n  ; i++){
            Object tempt = arr[i];
            for(int j = i ; 0 < j &&  arr[j - 1].compareTo(tempt) > 0; j--){
                if(arr[j].compareTo(arr[j-1]) < 0)
                    arr[j] = arr[j-1];
            }
        }
    }

    public static void swap (Object[] arr,int i, int j){
        Object tempt = arr[j];
        arr[j] = arr[i];
        arr[i] = tempt;
    }

    public static void main(String[] args){
        int N = 20000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        sort(arr);
        SortTestHelper.printArray(arr);
        System.out.println(SortTestHelper.isSorted(arr));
        SortTestHelper.testSort("algo.InsertionSort", arr);
    }
}