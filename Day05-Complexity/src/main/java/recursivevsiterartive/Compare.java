package recursivevsiterartive;

import com.sun.source.tree.BreakTree;

import java.util.concurrent.TimeUnit;

public class Compare {

    public static int fibonacciRecursive(int n) {
        if (n <= 1) {
            return n;
        } return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    }

    public static int fibonacciIterative(int n){
        int a = 0, b = 1, sum;
        for (int i = 2;i<= n; i++){
            sum = a+b;
            a = b;
            b = sum;
        } return b;
    }

    public static void main(String[] args) {
        int n = 30;
        long startTime, endTime;

        startTime = System.nanoTime();
        fibonacciRecursive(n);
        endTime = System.nanoTime();
        System.out.println("recursive approach for fibonacci time is  " + (endTime - startTime) + " nano seconds.");
        System.out.println("in milli seconds " + TimeUnit.NANOSECONDS.toMillis(endTime-startTime));

        System.out.println("\n");

        startTime = System.nanoTime();
        fibonacciIterative(n);
        endTime = System.nanoTime();
        System.out.println("iterative approach for fibonacci time is  " + (endTime - startTime) + " nano seconds.");
        System.out.println("in milli seconds " + TimeUnit.NANOSECONDS.toMillis(endTime-startTime));
    }
}
