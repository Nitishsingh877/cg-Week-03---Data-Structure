package binarysearchproblems.peakelement;

public class PeakElement {
    public static int peak(int[] arr){
        int low = 0;
        int high = arr.length-1;

        while (low < high){
            int mid = low + (high - low)/2;

            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1]){
                return arr[mid];
            }
            else if(arr[mid] < arr[mid-1]) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }return  -1;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 3, 20, 4, 1};
        int[] arr2 = {1, 2, 3, 4, 5, 6, 7};
        int[] arr3 = {5, 10, 20, 15};

        System.out.println("Peak element index in arr1: " + peak(arr1));
        System.out.println("Peak element index in arr2: " + peak(arr2));
        System.out.println("Peak element index in arr3: " + peak(arr3));

    }
}
