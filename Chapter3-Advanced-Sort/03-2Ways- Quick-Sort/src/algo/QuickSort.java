package algo;

public class QuickSort{

    private QuickSort(){}

    private static int partition(Comparable[] arr, int l, int r){

        //swap(arr, l, (int)(Math.random()*(r -l +1) + l));

        Comparable v = arr[l];

        int j = l; // arr[l+1...j] < arr[l]; arr[j+1...i) > arr[l]
        for(int i = l + 1; i <= r; i++){
            if(arr[i].compareTo(v) < 0){
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr,l,j);

        return j;
    }
    //对 arr[l...r]进行快速排序
    private static void sort(Comparable[] arr, int l, int r){
        if(l >= r)
            return;

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p+1, r);

    }
    //对arr[l...r]进行partition操作
    //返回p值使得 arr[l...p-1] < arr[p]; arr[p+1...r] > arr[p];
    public static void sort(Comparable[] arr){
        int n = arr.length;
        sort(arr, 0, n -1);
    }

    private static void swap(Object[] arr, int i, int j){
        Object tempt = arr[i];
        arr[i] = arr[j];
        arr[j] = tempt;
    }

    public static void main(String[] args) {

        // Quick Sort也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 100000;
        Integer[] arr = SortTestHelper.generateNearlyOrderedArray(N, 10);
        SortTestHelper.testSort("algo.QuickSort", arr);

        return;
    }

}