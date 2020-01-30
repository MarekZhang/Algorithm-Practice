package algo;

public class BinarySearch2{

    private BinarySearch2(){}

    private static int Find(Comparable[] arr, Comparable target, int l, int r){

       int mid = l + (r - l) / 2;

       if(l > r)
           return -1;

       if(arr[mid].compareTo(target) == 0)
            return mid;
        if(arr[mid].compareTo(target) < 0)
            return Find(arr, target, mid + 1, r);
        else
            return Find(arr, target, l, mid-1);
        
    }

    public static int Find(Comparable[] arr, Comparable target){
        return Find(arr, target, 0, arr.length-1);
    }

    public static void main(final String[] args) {

        final int N = 1000000;
        final Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++)
            arr[i] = i;

        for (int i = 0; i < 2 * N; i++) {
            final int v = BinarySearch.Find(arr, i);
            if(i < N)
                assert v == i;
            else
                assert v == -1;
        }
        System.out.println("Test successful");
        return;
    }
}