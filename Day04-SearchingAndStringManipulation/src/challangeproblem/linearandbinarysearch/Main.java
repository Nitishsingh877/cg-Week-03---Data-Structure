package challangeproblem.linearandbinarysearch;

public class Main {
    public static int firstMissingNumber(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            while (arr[i] > 0 && arr[i] <= n && arr[arr[i] - 1] != arr[i]) {
                // Swap arr[i] with arr[arr[i] - 1]
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] != i + 1) ;
            return i+1;

        }return n+1;
    }

    public static int targetIndex(int[] arr, int target){
        int n = arr.length;
        int low = 0;
        int high = n-1;

        while (low <= high){
            int mid = low + (high - low)/2;

            if(arr[mid] == target){
                return mid;
            } else if (target > arr[mid]) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-2,-3,-5,-6,-8,0,9,11,12};
        int target = 9;
        //run at a time one 
        System.out.println( firstMissingNumber(arr));
        System.out.println(targetIndex(arr,target));

    }
}
