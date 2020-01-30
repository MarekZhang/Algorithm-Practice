package algo;

public class Test{

    private Test(){}

    public static void sort(Comparable[] arr){

        int N = arr.length;
        QuickSort(arr, 0, N-1);
    }
    private static void QuickSort(Comparable[] arr, int l, int r){
    
        if(l >= r)
            return;

        int rand = (int)(Math.random() * (r - l + 1)) + l;
        swap(arr, l, rand);

        int p = Partition(arr, l, r);
        QuickSort(arr, l, p-1);
        QuickSort(arr, p+1, r);
    }

    private static int Partition(Comparable[] arr, int l, int r){

        Comparable e = arr[l];
        int j = l;
        for(int i = l + 1; i <= r ; i++){
            if(arr[i].compareTo(e) < 0){
                swap(arr, j+1, i);
                j++;
            }
        }
        swap(arr, l, j);

        return j;
    }

    private static void swap(Comparable[] arr, int i, int j){

        Comparable tempt = arr[i];
        arr[i] = arr[j];
        arr[j] = tempt;
    }

    public static void main(String args[]){

        int N = 100000;
        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(N, 10);
        SortTestHelper.testSort("algo.Test", arr);
        System.out.println(SortTestHelper.isSorted(arr));


    }
}