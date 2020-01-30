package algo;


public class InsertionSort{

    private InsertionSort() {}

    public static void sort(Comparable[] arr){

        int n = arr.length;
        for(int i = 1; i < n; i++){
            Comparable MinValue = arr[i];
            int j = i;
            for(; j > 0 && arr[j - 1].compareTo(MinValue) > 0; j--)
                    arr[j] = arr[j - 1];
            arr[j] = MinValue;
        }
    }

    private static void swap(Object[] arr, int i, int j){
        Object tempt = arr[i];
        arr[i] = arr[j];
        arr[j] = tempt;
    }

    public static void main(String[] args){
        Integer[] arr = SortTestHelper.generateRandomArray(10000, 0, 10000);
        SortTestHelper.testSort("algo.InsertionSort", arr);
        System.out.println(SortTestHelper.isSorted(arr));
    }
}