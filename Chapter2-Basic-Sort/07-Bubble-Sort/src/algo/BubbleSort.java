package algo;
import java.util.*;

public class BubbleSort{

    private BubbleSort() {}

    public static void sort(Comparable[] arr){

        int n = arr.length;
        for(int i = 0; i < n-1; i++)
            for(int j = 0; j < n - i -1; j++)
                if(arr[j].compareTo(arr[j + 1]) > 0)
                    swap(arr, j, j+1);
        
    }

    private static void swap(Object[] arr, int i, int j){
        Object tempt = arr[i];
        arr[i] = arr[j];
        arr[j] = tempt;
    }

    public static void main(String[] args){
        Integer[] arr = SortTestHelper.generateRandomArray(1000, 0, 2000);

        SortTestHelper.testSort("algo.BubbleSort", arr);
        System.out.println(SortTestHelper.isSorted(arr));
    }
}