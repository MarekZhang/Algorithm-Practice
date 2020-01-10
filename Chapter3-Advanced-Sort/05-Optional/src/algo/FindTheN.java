//由快速排序所衍生的问题：找到数组中第N大的数值，要求O(N) = N

package algo;


public class FindTheN{

    private FindTheN(){}

    public static Comparable find(Comparable[] arr, int N){

        int n = arr.length;
        Comparable result = QuickSort(arr,0, n-1, N);
        return result;

    }
    private static Comparable QuickSort(Comparable[] arr, int l, int r, int N){
        
        int p = partition(arr,l, r);

        if(l >=r)
            return arr[l];
        if(p > N)
            return QuickSort(arr,l, p-1,N); //到这部分去递归
        else if(p < N)
            return QuickSort(arr, p+1, r,N); //到这部分去递归
        else{
            return arr[p];
        }

    }
    private static int partition(Comparable[] arr, int l, int r){

        int rand = (int)(Math.random() * (r - l +1)) + l;
        swap(arr, l, rand);

        Comparable e = arr[l];

        //2-ways QuickSort arr[l+1...i)< e; arr(j...r] > e
        int i = l + 1;
        int j = r;
        while(true){
            while( i <= r && arr[i].compareTo(e) < 0) i++;
            while( j >= l + 1 && arr[j].compareTo(e) > 0) j--;

            if(i > j) //不能把这部分写到while判断中去，不然如果数组已经有序就会有bug
                break;
            swap(arr, i, j);
            i++;
            j--;
        }
        swap(arr,l , j);

        return j;
    }

    private static void swap(Comparable[] arr, int i, int j){
        Comparable tempt = arr[i];
        arr[i] = arr[j];
        arr[j] = tempt;
    }

    public static void main(String[] args){
        Integer[] arr = new Integer[]{10,9,8,7,6,5,4,3,2,1};
        System.out.println(find(arr, 3));
    }
}