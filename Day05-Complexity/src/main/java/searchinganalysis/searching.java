package searchinganalysis;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class searching {
    //linear search

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }


    public static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } return -1;
    }


    public static void main(String[] args) {
       // int[] arr = {1,2,3,4,5,6,7,8,9,10,11,35,545,457,4,43,346,636,45454455,54534,2,24,666,6,3354,546,65356556,6,545634,566,5,543,34,55,7,5,34,543,5,5656,3563,356,3565,56,6543,35636,6,6,6,654,75675,89,87,68,776,67986,97,234};
        int size = 1000000;
        int[] randomNumbers = new int[size];
        Random rand = new Random();

        for (int i =0; i<size;i++){
            randomNumbers[i] = rand.nextInt(10000) +1; //(0 to 9999) +1
        }
        int targetIndex = rand.nextInt(size);
        int target = randomNumbers[targetIndex];
        System.out.println(target);

        long startTime,endTime;
        startTime = System.nanoTime();
        int result =  linearSearch(randomNumbers,target);
        endTime=System.nanoTime();
        System.out.println("index is  " + result);
        System.out.println("time taken in nano Seconds for linear search " + TimeUnit.NANOSECONDS.toMillis(endTime-startTime));

        System.out.println("\n");

        //sort array then binary search
        Arrays.sort(randomNumbers);

        
        long Stime, ETime, DiffTime;
        Stime = System.nanoTime();
        int response = binarySearch(randomNumbers, target);
        ETime = System.nanoTime();
        System.out.println("index is " + result);
        DiffTime = ETime - Stime;
        System.out.println("time in binary search is " + TimeUnit.NANOSECONDS.toMillis(DiffTime) +  " nanoSeconds");

    }
}
