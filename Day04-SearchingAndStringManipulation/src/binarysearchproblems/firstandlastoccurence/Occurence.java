package binarysearchproblems.firstandlastoccurence;

import java.util.HashSet;

public class Occurence {
    public static int firstOccurence(int[] arr, int target){
        int low =0;
        int high = arr.length-1;
        int result = -1;

        while (low < high){
            int mid = low + (high - low)/2;

            if(arr[mid] == target){
               result = mid;
               high = mid-1;
            }
            else if(arr[mid] > target){
                high = mid -1;
            }else {
                low = mid+1;
            }
        }return  result;

    }

    public static  int lastOccurence(int[] arr, int target){
        int low =0;
        int high = arr.length-1;
        int result = -1;

        while (low <= high){
            int mid = low + (high - low)/2;

        if(arr[mid] == target){
            result = mid;
            low = mid+1;
        }
        else if(arr[mid] > target){
            high = mid -1;
        }else {
            low = mid+1;
        }
    }return  result;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 3, 4, 5, 6};
        int target = 2;

        int firstIndex = firstOccurence(arr, target);
        if (firstIndex != -1) {
            System.out.println("First occurrence of " + target + " is at index: " + firstIndex);
        } else {
            System.out.println(target + " is not present in the array.");
        }

        int LastIndex = lastOccurence(arr, target);
        if (LastIndex != -1) {
            System.out.println("last occurrence of " + target + " is at index: " + LastIndex);
        } else {
            System.out.println(target + " is not present in the array.");
        }


    }
}
