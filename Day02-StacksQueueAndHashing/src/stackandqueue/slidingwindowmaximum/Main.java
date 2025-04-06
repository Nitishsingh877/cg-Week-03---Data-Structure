package stackandqueue.slidingwindowmaximum;

import java.util.*;

public class Main {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];

        int n = nums.length;
        int[] result = new int[n - k + 1]; // Result array for storing maximums
        Deque<Integer> deque = new LinkedList<>(); // Deque to store indices

        for (int i = 0; i < n; i++) {
            // Remove elements that are out of this window
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            // Remove elements that are smaller than the current element (maintain decreasing order)
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }

            // Add current index to deque
            deque.offerLast(i);

            // Store result only after the first k elements
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k))); // Output: [3, 3, 5, 5, 6, 7]
    }
}
