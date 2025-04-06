package sortinganalysis;


import java.util.Random;
import java.util.concurrent.TimeUnit;

public class sorting {

    public static void BubbleSort(int[] arr){
        for(int turns = 0 ; turns < arr.length-1;turns++){
            for (int j = turns+1; j< arr.length-1-turns; j++){
                //swap
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }


    public static void MergeSort(int[] arr,int left,int right) {

        if (left < right) {
            int mid = left + (right - left) / 2;

            MergeSort(arr,left,mid);
            MergeSort(arr,mid+1,right);

            merge(arr,left,mid,right);
        }
    }
    public static  void merge(int[] arr,int left, int mid, int right){
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        int[] leftSizeArray = new int[leftSize];
        int[] rightSizeArray = new int[rightSize];

        System.arraycopy(arr,left,leftSizeArray,0,leftSize);
        //(sourcearray,srcstart,fromwheretocopy,destpostion kha se copy source arr me, number of element to copy)
        System.arraycopy(arr,mid+1,rightSizeArray,0,rightSize);

        int i = 0,j = 0,k = left;

        while (i<leftSize && j < rightSize){
            if (leftSizeArray[i] > rightSizeArray[j]){
                arr[k] = rightSizeArray[j];
                j++;
            }else {
                arr[k] = leftSizeArray[i];
                i++;
            } k++;
        }

        while (i < leftSize){
            arr[k] = leftSizeArray[i];
            i++;
            k++;
        }
        while (j < rightSize){
            arr[k] = rightSizeArray[j];
            j++;
            k++;
        }
    }

    public static void QuickSort(int[] arr,int low, int high){
        if(low < high){
            int pidx = Partition(arr, low, high);

            QuickSort(arr, low, pidx-1);
            QuickSort(arr, pidx+1,high);
        }
    }
    public static int Partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;

        for(int j = low; j<high; j++){
            if(arr[j]  < pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        } i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }
    public static void main(String[] args) {
        int size = 10000;
        int[] a = new int[size];
        int[] b = new int[size];
        int[] c = new int[size];
        Random rand = new Random();


        for (int i = 0; i<size;i++){
            a[i] = rand.nextInt(10000) + 1;
        }
        for (int i = 0; i<size;i++){
            b[i] = rand.nextInt(10000) + 1;
        }
        for (int i = 0; i<size;i++){
            c[i] = rand.nextInt(10000) + 1;
        }
        long startTime, endTime;
        startTime = System.nanoTime();
        BubbleSort(a);
        endTime = System.nanoTime();
        System.out.println("bubble sort take time is  " +(endTime - startTime) + " nano Seconds.");
        System.out.println("in milli seconds is " + TimeUnit.NANOSECONDS.toMillis(endTime-startTime));
        System.out.println("\n");

        //merge sort

        startTime = System.nanoTime();
        MergeSort(b,0,b.length-1);
        endTime = System.nanoTime();
        System.out.println("time taken for merge sort is "  + (endTime - startTime) + "nano seconds");
        System.out.println("time in milli seconds " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime));


        System.out.println("\n");

        startTime = System.nanoTime();
        QuickSort(c,0,c.length-1);
        endTime = System.nanoTime();
        System.out.println("time for quick sort in nano second is " + (endTime-startTime));
        System.out.println("in milli seconds is " + TimeUnit.NANOSECONDS.toMillis(endTime-startTime));
    }
}
