package sorting.selectionsort;

import java.util.Arrays;

public class Main {

    public static String selectionsort(int[] arr){
        for(int i =0; i< arr.length-1;i++){
            int minPos = i;
            for (int j=i+1;j< arr.length;j++){
                if(arr[minPos] > arr[j]){
                    minPos = j;
                }
            }
            //swap
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
        return Arrays.toString(arr);
    }
    public static void main(String[] args) {
        int[] arr = {3,9,2,5,7,8};
        System.out.println(selectionsort(arr));
    }
}
