package sorting.mergesort;

import java.util.Arrays;

public class Main {


    public static void divide(int[] arr,int si, int ei){
        if(si < ei){
            int mid = si + (ei-si)/2;

            divide(arr,si,mid);
            divide(arr,mid+1,ei);

            merge(arr,si,mid,ei);
        }
    }

    public static void merge(int[]arr,int si,int mid, int ei){
        int leftArrSize = mid-si+1;
        int rightArrSize  = ei - mid;


        // Temporary arrays
        int[] leftArray = new int[leftArrSize];
        int[] rightArray = new int[rightArrSize];

        System.arraycopy(arr,si,leftArray,0,leftArrSize);
        System.arraycopy(arr,mid+1,rightArray,0,rightArrSize);

        int i=0,j=0,k = si;

        while (i<leftArrSize && j<rightArrSize){
            if(leftArray[i] <= rightArray[j]){
                arr[k] = leftArray[i];
                i++;
            }else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        // Copy remaining elements from leftArray
        while (i < leftArrSize) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy remaining elements from rightArray
        while (j < rightArrSize) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 6, 3};
        int n = arr.length;

        System.out.println("Original Array: " + Arrays.toString(arr));
        divide(arr,0,n-1);

        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }

}
