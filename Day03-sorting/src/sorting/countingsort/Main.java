package sorting.countingsort;

import java.util.Arrays;

public class Main {

    public static String countingSort(int[] arr){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<arr.length;i++){
            largest = Math.max(largest,arr[i]);
        }
        int count[] = new int[largest+1];
        //store frequecy
        for(int i=0; i<arr.length;i++){
            count[arr[i]]++;
        }
        //freq show
        int j=0;
        for(int i=0; i<count.length;i++){
            while (count[i]>0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
        return Arrays.toString(arr);

    }
    public static void main(String[] args) {


        int[] arr = {10, 15, 12, 15, 18, 14, 15, 10, 18, 18};
        System.out.println(countingSort(arr));
    }
}
