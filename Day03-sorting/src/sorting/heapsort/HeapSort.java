package sorting.heapsort;



import java.util.Arrays;

public class HeapSort {

    // Function to heapify a subtree with root at index `i`
    public static void heapify(int arr[], int n, int i) {
        int largest = i; // Assume root is the largest
        int left = 2 * i + 1; // Left child index
        int right = 2 * i + 2; // Right child index

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // If right child is larger than the largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    // Function to perform Heap Sort
    public static void heapSort(int arr[]) {
        int n = arr.length;

        // Step 1: Build a max heap (rearrange the array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap the root (max element) with the last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Main method to test Heap Sort
    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 6, 7, 8, 3, 0};

        System.out.println("Original Array: " + Arrays.toString(arr));
        heapSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
