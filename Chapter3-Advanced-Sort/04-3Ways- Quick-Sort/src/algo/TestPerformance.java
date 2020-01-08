package algo;
import java.util.Arrays;

public class TestPerformance{

    public static void main(String[] args){

        int N = 1000000;

        //对于重复值较多的数组
        Comparable[] arr1 = SortTestHelper.generateRandomArray(N, 0, 100);
        Comparable[] arr2 = Arrays.copyOf(arr1,arr1.length);
        Comparable[] arr3 = Arrays.copyOf(arr1,arr1.length);
        Comparable[] arr4 = Arrays.copyOf(arr1,arr1.length);
        Comparable[] arr5 = Arrays.copyOf(arr1,arr1.length);

        System.out.println("对于重复值较多的数组的排序-------");
        SortTestHelper.testSort("algo.MergeSort", arr1);
        SortTestHelper.testSort("algo.MergeSortBTU", arr2);
        SortTestHelper.testSort("algo.QuickSort2Ways", arr3);
        SortTestHelper.testSort("algo.QuickSort3Ways", arr4);
        SortTestHelper.testSort("algo.QuickSort", arr5);
        System.out.println("---------------------------------");

        System.out.println("对于近乎有序的数组的排序-------");
        arr1 = SortTestHelper.generateNearlyOrderedArray(N, 1000);
        arr2 = Arrays.copyOf(arr1,arr1.length);
        arr3 = Arrays.copyOf(arr1,arr1.length);
        arr4 = Arrays.copyOf(arr1,arr1.length);
        arr5 = Arrays.copyOf(arr1,arr1.length);
        SortTestHelper.testSort("algo.MergeSort", arr1);
        SortTestHelper.testSort("algo.MergeSortBTU", arr2);
        SortTestHelper.testSort("algo.QuickSort2Ways", arr3);
        SortTestHelper.testSort("algo.QuickSort3Ways", arr4);
        SortTestHelper.testSort("algo.QuickSort", arr5);
        System.out.println("---------------------------------");
    }
}