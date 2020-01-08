package algo;
import java.util.Arrays;

public class CountInverse{

    private CountInverse() {}

    public static long sort(Comparable[] arr){

        int N = arr.length;

        return mergeSort(arr, 0, N-1);
    }

    private static long mergeSort(Comparable[] arr, int l, int r){

        if(l >= r)
            return 0;

        int mid = (l + r) / 2;
        long count_lp = mergeSort(arr,l, mid); //把上一层未排序的逆序对个数返回来
        long count_rp = mergeSort(arr, mid+1, r);//把上一层未排序对逆袭对返回来
        long count_merge = 0;
        if(arr[mid].compareTo(arr[mid+1]) > 0)
           count_merge = merge(arr, l, mid, r);

        return count_lp + count_rp + count_merge;
    }

    private static long merge(Comparable[] arr, int l, int mid, int r){

         Comparable[] Aux = Arrays.copyOfRange(arr, l, r + 1);
         int i = l;
         int j = mid + 1;
         long count = 0;
         for(int k = l; k <= r; k++){
            if(i > mid){
                arr[k] = Aux[ j - l];
                j++;
            }else if(j > r){
                arr[k] = Aux[i - l];
                i++;
            }else if(Aux[i - l].compareTo(Aux[j - l]) <= 0){
                arr[k] = Aux[i - l];
                i++;
            }else{
                arr[k] = Aux[j - l];
                j++;

                count += (mid - i + 1);
            }
         }
         return count;
    }

    public static void main(String args[]){

        Comparable[] arr = SortTestHelper.generateRandomArray(10, 0, 20);
        SortTestHelper.printArray(arr);
        System.out.println(sort(arr));
        SortTestHelper.printArray(arr);

    }
}