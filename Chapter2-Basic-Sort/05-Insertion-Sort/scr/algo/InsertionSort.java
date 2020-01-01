package algo;

public class InsertionSort{
    private InsertionSort(){}

    public static void swap(Object[] arr, int i, int j){
        Object tempt = arr[i];
        arr[i] = arr[j];
        arr[j] = tempt;
    }

    public static void sort(Comparable[] arr){
        int n = arr.length;
        for(int i = 1; i < n; i++){
            for(int j = i; j > 0; j--)
                if(arr[j].compareTo(arr[j-1]) < 0)
                    swap(arr, j, j-1);
                else
                    break;
        }
    }

    public static void main(String[] args){
        Integer[] arr = SortTestHelper.generateRandomArray(10, 0, 100);
        SortTestHelper.printArray(arr);
        sort(arr);
        SortTestHelper.printArray(arr);
        System.out.println(SortTestHelper.isSorted(arr));
        SortTestHelper.testSort("algo.InsertionSort", arr);
    }
}