//自顶向下顶归并排序

package algo;
import java.util.*;

public class MergeSort{

    private MergeSort(){}

    public static void sort(Comparable[] arr){
        int N = arr.length;
        mergeSort(arr,0, N-1);
    }

    private static void mergeSort(Comparable[] arr, int l, int r){

        if( l >= r)
            return;

        int mid = (l + r) / 2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        if(arr[mid].compareTo(arr[mid + 1]) > 0)
            merge(arr, l, mid, r);
    }

    private static void merge(Comparable[] arr, int l, int mid, int r){
        int i = l;

        int j = mid + 1;

        Comparable[] Aux = Arrays.copyOfRange(arr,l, r+1);


        for(int m = l; m <= r; m++){

            if(i > mid){
                arr[m] = Aux[j - l];
                j++;
            }else if( j > r){
                arr[m] = Aux[i - l];
                i++;
            }else if(Aux[i - l].compareTo(Aux[j - l]) < 0){
                arr[m] = Aux[i - l];
                i ++;
            }
            else {
                arr[m] = Aux[j - l];
                j ++;
            }
        }
    }

    public static void main(String args[]){
        int N = 100000;
        Comparable[] arr = SortTestHelper.generateRandomArray(N, 0, 10000000);

        SortTestHelper.testSort("algo.Test", arr);

        System.out.println(SortTestHelper.isSorted(arr));

    }


}