package algo;
import java.util.Arrays;

public class ShellSort{

    private ShellSort(){}

    public static void sort(Comparable[] arr){
        int n = arr.length;
        int h = 1;
        while ( h < n / 3) h = h * 3 + 1; // increment 1, 4, 13, 40...
        while(h >=1){
            for(int i = h; i < n; i++){
                Comparable MinValue = arr[i];
                int j = i;
                for(; j >= h && arr[j - h].compareTo(MinValue) > 0; j-=h)
                    arr[j] = arr[j-h];
                arr[j] = MinValue;
            }
            h /= 3;
        }

    }

    public static void main(String[] args){
        int N = 200000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10000);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        SortTestHelper.testSort("algo.ShellSort", arr);
        System.out.println(SortTestHelper.isSorted(arr));

        SortTestHelper.testSort("algo.InsertionSort", arr2);
        System.out.println(SortTestHelper.isSorted(arr2));


    }

}