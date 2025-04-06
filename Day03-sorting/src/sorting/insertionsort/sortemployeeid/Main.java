package sorting.insertionsort.sortemployeeid;

import java.util.Arrays;

public class Main {

    public static String insertionsort(int arr[]){
        for(int i=1;i<arr.length;i++){
            int curr = arr[i];
            int prev = i-1;

            while (prev >= 0 && arr[prev]>curr){
                //find out exact postion
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
        }
        return Arrays.toString(arr);
    }
    public static void main(String[] args) {


        int[] arr= {5, 2, 3, 6, 9};
        System.out.println(insertionsort(arr));
    }

}
