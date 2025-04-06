package binarysearchproblems.searchin2d;

public class TaregtInTwoD {
    public static boolean checkValue(int[][] arr, int target){

        if(arr == null || arr.length == 0 || arr[0].length == 0){
            return false;
        }
        int numrows = arr.length;
        int numCols = arr[0].length;
        int low =0;
        int high = (numrows * numCols) - 1;

        while (low <= high){
            int mid = low + (high - low)/2;

            int row = mid/numCols;
            int col = mid%numCols;

            if(arr[row][col] == target){
                return true;
            }
            else if(arr[row][col] < target){
                low = mid+1;
            }else {
                high = mid-1;
            }
        }return false;


    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 4, 7, 11},
                {2, 5, 8, 12},
                {3, 6, 9, 16},
                {10, 13, 14, 17}
        };
        int target = 16;
        boolean result = checkValue(arr, target);
        if (result) {
            System.out.println("Target " + target + " found in the matrix.");
        } else {
            System.out.println("Target " + target + " not found in the matrix.");
        }
    }

}
