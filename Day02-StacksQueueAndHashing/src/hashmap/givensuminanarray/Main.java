package hashmap.givensuminanarray;

import java.util.HashSet;

public class Main {
    public static boolean hasPairWithSum(int[] nums, int target){
        HashSet<Integer> seen = new HashSet<>();

        for(int num : nums){
            int complement = target - num;

            if(seen.contains(complement)){
                return true;
            }
            seen.add(num);
        }return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,7,12,5};
        int target = 9;


        if (hasPairWithSum(nums, target)) {
            System.out.println("Pair with the given sum exists.");
        } else {
            System.out.println("No pair found.");
        }
    }

}
