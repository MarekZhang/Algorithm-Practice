package algo;

public class Test{

    private Test(){}

    public static void sort(int[] arr){
        int n = arr.length;
        int h = 1;
        while ( h < n / 3) h = h * 3 + 1; // increment 1, 4, 13, 40...
        while(h >=1){
            for(int i = h; i < n; i++){
                int MinValue = arr[i];
                int j = i;
                for(; j >= h && arr[j - h] > MinValue; j-=h)
                    arr[j] = arr[j-h];

                arr[j] = MinValue;
                for(int ele = 0; ele < arr.length; ele++){
                    System.out.print(arr[ele] + " ");
                }
                System.out.println();
            }
            h /= 3;
        }
}

    public static void main(String[] args){
        int[] arr = new int[]{10, 9 ,8 ,7 ,6 ,5, 4, 3, 2, 1};
        sort(arr);
        System.out.println(arr.length);
        for(int ele: arr)
            System.out.print( " " + ele);
    }

}