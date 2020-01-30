package algo;

public class QuickSort3Ways{

    private QuickSort3Ways(){}

    public static void sort(Comparable[] arr){

        int N = arr.length;
        QuickSort(arr, 0, N-1);
    }

    private static void QuickSort(Comparable[] arr, int l, int r){

        if(l >= r)
            return;
        
        // Function of partition
        int rand = (int)(Math.random() * (r - l + 1)) + l;
        swap(arr, l, rand);
        // arr[l+1...lt] < e; arr[lt+1...gt-1] == e ; arr[gt...r] > e;
        Comparable e = arr[l];
        int lt = l;
        int i = l + 1;
        int gt = r+1;

        while(i < gt){

            if(arr[i].compareTo(e) < 0){
                swap(arr,i, lt + 1);
                lt++;
                i++;
            }else if(arr[i].compareTo(e) == 0){
                i++;
            }else{
                swap(arr,i, gt-1);
                gt--;
            }
        }

        swap(arr, l, lt);
        lt --;

        QuickSort(arr, l, lt);
        QuickSort(arr,gt, r);

    }

    private static void swap(Comparable[] arr, int i, int j){

        Comparable tempt = arr[i];
        arr[i] = arr[j];
        arr[j] = tempt;
    }

    public static void main(String args[]){
        int N = 100000;
        Comparable[] arr = SortTestHelper.generateNearlyOrderedArray(N, 1000000);

        SortTestHelper.testSort("algo.QuickSort3Ways", arr);
        System.out.println(SortTestHelper.isSorted(arr));
    }
}