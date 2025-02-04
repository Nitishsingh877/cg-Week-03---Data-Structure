package binarysearchproblems.indexofelement;

public class IndexOfSmallestElement {
    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int mid = left + (right-left)/2;

            if(arr[mid] > arr[right]){
                left = mid+1;
            }else {
                right = mid;
            }

        }
        return left;
    }

    public static void main(String[] args) {
        int[] arr1 = {6, 7, 9, 15, 19, 2, 3};
        int[] arr2 = {4, 5, 6, 7, 0, 1, 2};

        System.out.println("index of smallest element " + findRotationPoint(arr1));
        System.out.println("index of smalllest element in arr2 "+ findRotationPoint(arr2));
    }
}
