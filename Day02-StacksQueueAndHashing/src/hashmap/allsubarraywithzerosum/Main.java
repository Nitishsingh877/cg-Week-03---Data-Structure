package hashmap.allsubarraywithzerosum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static List<int[]> findSubArrayWithZeroSum(int[] arr){
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        //traverse through array
        for (int i=0; i< arr.length;i++){
            sum += arr[i];

            //if sum =0 add in result
            if(sum == 0){
                result.add(new int[]{0,i});
            }

            //if sum alreday exsits in hashmap it means subaaray alreday exsits
            if(map.containsKey(sum)){
//                //get all previous indices
                for (int startIndex : map.get(sum)) {
                    result.add(new int[] {startIndex+1,i});
                }
            }
            //add the current sum to the hashmap
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, -1, 3, 2, -2, 2, -3};
        List<int[]> subarrays = findSubArrayWithZeroSum(arr);

        System.out.println("Subarrays with zero sum:");
        for (int[] subarray : subarrays) {
            System.out.println("Start index: " + subarray[0] + ", End index: " + subarray[1]);
        }

    }


    }


