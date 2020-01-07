package algo;
import java.util.Arrays;

public class QuickSort2{

    private QuickSort2(){}

    public static void sort(Comparable[] arr){
        
        int N = arr.length;
        QuickSort2(arr, 0, N-1);
    }

    private static void QuickSort2(Comparable[] arr, int l, int r){

        if(l >= r)
            return;
        int p = partition(arr, l, r);
        QuickSort2(arr, l, p - 1);
        QuickSort2(arr, p + 1, r);
    }

    private static int partition(Comparable[] arr, int l, int r){

        //int rand = (int)(Math.random() * ( r - l + 1)) + l;
        //swap(arr, l, rand);

        Comparable e = arr[l];
        int i = l + 1;
        int j = r;
        // partition arr[l+1...i) < arr[l]   arr(j...r] > arr[l]; 因为i停止的位置是 >= e的； j停止的位置是 <= e的，所以是开区间
        while(true){

            while(i <= r && arr[i].compareTo(e) < 0 ) i++;
            while(j >= l + 1 && arr[j].compareTo(e) > 0 ) j--;
            if( i > j )
                break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr, l, j);
        return j;
        
    }

    private static void swap(Comparable[] arr, int i, int j){
        Comparable tempt = arr[i];
        arr[i] = arr[j];
        arr[j] = tempt;
    }

    public static void main(String[] args){

        int N = 10000;
        Comparable[] arr = SortTestHelper.generateRandomArray(N, 0, 10);
        Comparable[] arr2 = Arrays.copyOf(arr, arr.length);

        SortTestHelper.testSort("algo.QuickSort2", arr);
        SortTestHelper.testSort("algo.QuickSort", arr);
        System.out.println(SortTestHelper.isSorted(arr));
    }
}