package sorting.bubblesort.sortstudentmarks;

import java.lang.reflect.Array;
import java.util.Arrays;

public class main {
public static String bubbleSort(int arr[]){
    for (int turns = 0; turns< arr.length;turns++){
        for (int j =0; j< arr.length-1-turns;j++){
            if(arr[j]>arr[j+1]){
                //swap
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    } return Arrays.toString(arr);

        }

    public static void main(String[] args) {


        int arr[] = {85, 56, 89, 52, 45, 100};
        System.out.println(bubbleSort(arr));
    }
}
