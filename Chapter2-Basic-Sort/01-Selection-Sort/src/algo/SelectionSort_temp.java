package algo;
import java.util.*;

class SelectionSort_temp {

    // 将构造函数设置为private， 不产生任何对象
    private SelectionSort_temp(){}

    static void sort(Comparable[] arr){
        int n = arr.length;
        for(int i = 0; i < n; i++){
            int MinIndex = i;
            for(int j = i + 1; j < n; j++){
                if(arr[j].compareTo(arr[MinIndex]) < 0)
                    MinIndex = j;

                swap(arr, i, MinIndex);    
                
            }
        }
    }
    static void swap(Object[] arr, int i, int j){
        Object tempt = arr[i];
        arr[i] = arr[j];
        arr[j] = tempt;
    }
    public static void main(String[] args){
        Integer[] arr = new Integer[] {9, 8, 7, 6, 5, 4, 3, 2, 1};
        sort(arr);
        for(int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        System.out.println();

        Double[] arrD = new Double[] {9.1, 9.0, 8.2, 8.1, 7.3, 7.2, 6.0, 4.3};
        sort(arrD);
        for(int i = 0; i < arrD.length; i++)
            System.out.print(arrD[i] + " ");
        
        System.out.println();
        Student[] arrS = new Student[4];
        arrS[0] = new Student("D",90);
        arrS[1] = new Student("C",100);
        arrS[2] = new Student("B",95);
        arrS[3] = new Student("A",95);
        sort(arrS);
        for(int i = 0; i < arrS.length; i++)
            System.out.println(arrS[i]);
    }

}
