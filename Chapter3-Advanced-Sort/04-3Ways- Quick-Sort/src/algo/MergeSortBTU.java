// 自底向上底归并排序

package algo;
import java.util.*;


public class MergeSortBTU{

    private MergeSortBTU(){}

    public static void sort(Comparable[] arr){
        int n = arr.length;
        for(int sz = 1; sz < n; sz *= 2 )
            for(int i = 0; i < n - sz ; i += 2*sz){// i < n - sz : 保证第二部分存在 -- arr[i+sz ... i + 2sz -1]存在
            // 对 arr[i ... i + sz -1] 和 arr[i + sz ... i + 2sz -1] 进行归并排序
                if(arr[i + sz - 1].compareTo(arr[i + sz]) > 0) 
                    merge(arr, i, i + sz-1, Math.min(i + 2 * sz - 1, n-1));
            }
    }

    private static void merge(Comparable[] arr, int l, int mid, int r){

        Comparable[] Aux = Arrays.copyOfRange(arr, l, r + 1);

        int i = l;
        int j = mid + 1;

        for(int k = l; k <= r; k++){
            if(i > mid){
                arr[k] = Aux[j - l]; j++;
            }else if(j > r){
                arr[k] = Aux[i - l]; i++;
            }else if(Aux[i - l].compareTo(Aux[j - l]) < 0 ){
                arr[k] = Aux[i - l]; i++;
            }else{
                arr[k] = Aux[j - l]; j++;
            }
        }
    }

    public static void main(String[] args){

        int N = 100000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 200000);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        SortTestHelper.testSort("algo.MergeSortBTU", arr);
        SortTestHelper.testSort("algo.MergeSort", arr2);
    
        System.out.println(SortTestHelper.isSorted(arr));
    }


}