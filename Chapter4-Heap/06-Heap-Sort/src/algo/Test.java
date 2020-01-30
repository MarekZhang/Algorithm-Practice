package algo;
import java.util.Arrays;

public class Test{

    public static void main(String[] args){
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, N);
        Integer[] arr1 = Arrays.copyOf(arr, arr.length);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);
        Integer[] arr4 = Arrays.copyOf(arr, arr.length);

        System.out.println("Random Array Test");
        SortTestHelper.testSort("algo.HeapSort", arr);
        SortTestHelper.testSort("algo.HeapSort1", arr1);
        SortTestHelper.testSort("algo.HeapSort2", arr2);
        SortTestHelper.testSort("algo.QuickSort3Ways", arr3);
        SortTestHelper.testSort("algo.MergeSort", arr4);

        System.out.println("--------------------------------------------------------");

        System.out.println("Nearly Ordered Array Test");
        Integer[] arr5 = SortTestHelper.generateNearlyOrderedArray(N, 100);
        Integer[] arr6 = Arrays.copyOf(arr5, arr5.length);
        Integer[] arr7 = Arrays.copyOf(arr5, arr5.length);
        Integer[] arr8 = Arrays.copyOf(arr5, arr5.length);
        Integer[] arr9 = Arrays.copyOf(arr5, arr5.length);
        
        SortTestHelper.testSort("algo.HeapSort", arr5);
        SortTestHelper.testSort("algo.HeapSort1", arr6);
        SortTestHelper.testSort("algo.HeapSort2", arr7);
        SortTestHelper.testSort("algo.QuickSort3Ways", arr8);
        SortTestHelper.testSort("algo.MergeSort", arr9);

    }
}