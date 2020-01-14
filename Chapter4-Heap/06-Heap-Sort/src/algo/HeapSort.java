package algo;

//不使用额外数组，在原有数组基础上进行排序

public class HeapSort{

    private HeapSort(){}

    public static void sort(Comparable[] arr){

        int N = arr.length;
        //Heapify array
        for(int i = (N - 1 - 1) / 2; i >= 0; i--){ //i = (N-1-1)/2 是因为 2k+1 <= N-1 k=(N-1-1)/2
            ShiftDown2(arr, N, i);
        }

        for(int i = N - 1; i > 0; i--){
            swap(arr, 0, i);
            ShiftDown2(arr, i, 0);
        }
    }

    private static void swap(Comparable[] arr, int i, int j){
        Comparable tempt = arr[i];
        arr[i] = arr[j];
        arr[j] = tempt;
    }

    private static void ShiftDown1(Comparable[] arr, int N, int k){

        Comparable e = arr[k];
        //最后一位是 N-1， 叶子与父节点间的关系为 parent(i) = [child(k) - 1]/2
        while(2 * k + 1 < N){ //相当于 2(N-1)/2 >=k 以是否有左孩子作为判断依据，因为只有没有左孩子才证明此节点为叶子，没有右孩子不一定是叶子
            int j = 2 * k + 1;
            if(j+1 < N && arr[j].compareTo(arr[j+1]) < 0)
                j += 1;
            if(e.compareTo(arr[j]) >= 0)
                break;
            swap(arr, k, j);
            k = j;
        }
    }
    //优化掉不断调用swap函数所造成掉开销
    private static void ShiftDown2(Comparable[] arr, int N, int k){

        Comparable e = arr[k];
        //最后一位是 N-1， 叶子与父节点间的关系为 parent(i) = [child(k) - 1]/2
        while(2 * k + 1 < N){ //相当于 2(N-1)/2 >=k 以是否有左孩子作为判断依据，因为只有没有左孩子才证明此节点为叶子，没有右孩子不一定是叶子
            int j = 2 * k + 1;
            if(j+1 < N && arr[j].compareTo(arr[j+1]) < 0)
                j += 1;
            if(e.compareTo(arr[j]) >= 0)
                break;
            arr[k] = arr[j];
            k = j;
        }
        arr[k] = e;
    }

    public static void main(String args[]){

        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 200000);
        SortTestHelper.testSort("algo.HeapSort", arr);
        System.out.println(SortTestHelper.isSorted(arr));
    }
}