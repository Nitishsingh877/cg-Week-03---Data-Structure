package sorting.quicksort;

import java.util.Arrays;

public class Quicksort {

    public static int partition(int arr[],int low, int high){
        int pivot = arr[high];
        int i= low-1;

        for(int j=low; j<high; j++){
            if(arr[j] < pivot){
                i++;
                //swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i; //pivot index

    }
    public static void quicksort(int arr[], int low, int high){
        if(low<high){
            int pividx = partition(arr,low,high);

            quicksort(arr,low, pividx-1);
            quicksort(arr,pividx+1,high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {6,4,3,6,7,8,3,0};
        int n = arr.length;

        quicksort(arr,0,n-1);

       for(int i=0;i<n;i++){
           System.out.print(arr[i] +  " ");
       }
        System.out.println();
    }

}
