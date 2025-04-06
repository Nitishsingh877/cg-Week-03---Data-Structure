package hashmap.LongestConsecutiveSequence;

import java.util.HashSet;

public class Main {
    public static int findLongestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num); // Store all numbers in the HashSet
        }

        int longestStreak = 0;

        for(int num : nums){
            //check num-1 not in set
            if(!set.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;

                //count cons numbers
                while (set.contains(currentNum + 1)){
                    currentStreak++;
                    currentNum++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }return longestStreak;
    }
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println("Longest Consecutive Sequence Length: " + findLongestConsecutive(nums));

    }
}

