package algo;

public class HeapSort2{

    private HeapSort2(){}

    public static void sort(Comparable[] arr){

        MaxHeap<Comparable> hp = new MaxHeap<Comparable>(arr);

        int N = arr.length;
        for(int i = N - 1; i >= 0; i--){
            arr[i] = hp.Extract();
        }

    }

    public static void main(String[] args){

        Integer[] arr = SortTestHelper.generateRandomArray(10, 0, 100);
        SortTestHelper.printArray(arr);
        SortTestHelper.testSort("algo.HeapSort2", arr);
        System.out.println(SortTestHelper.isSorted(arr));
        SortTestHelper.printArray(arr);
    }
}