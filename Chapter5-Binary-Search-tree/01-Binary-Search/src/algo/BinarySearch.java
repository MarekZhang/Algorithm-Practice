package algo;

public class BinarySearch{

    private BinarySearch(){}

    public static int Find(final Comparable[] arr, final Comparable target) {

        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            // //会造成溢出问题，假设l和r均为int最大值
            // int mid = (l + r) / 2;
            final int mid = l + (r - l) / 2;
            if (arr[mid].compareTo(target) == 0)
                return mid;
            else if (arr[mid].compareTo(target) < 0)
                l = mid + 1;
            else
                r = mid - 1;
        }

        return -1;
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
