package linearsearch.firstnegativenumber;

import com.sun.source.tree.BreakTree;

public class NegativeNumber {
        public static void main (String[]args){
            int[] arr = {1, 2, 5, -2, -5, -6, 43, 3455, 90};

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < 0) {
                    System.out.println("first negative number at index " + i);
                    return;
                }
        }
            System.out.println("no negative number found ");
        }
}
