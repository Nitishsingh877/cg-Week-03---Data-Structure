package comparediffrentdatastructure;

import javax.print.DocFlavor;
import java.util.HashSet;
import java.util.Random;
import java.util.Timer;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

public class CompareDiffDataStructure {

    public static int SearchInArray(int[] arr, int target){
        for (int i= 0; i<arr.length; i++ ){
            if(arr[i] == target){
                return i;
            }
        }return -1;
    }

    public static void searchInHashSet(HashSet<Integer> hs, int target){
        hs.contains(target); {
            System.out.println("target found in hash set");
        }
    }
    public static  void searchInTreeSet(TreeSet<Integer> ts , int target){
                ts.contains(target);
        System.out.println("target found in tree set");

    }

    public static void main(String[] args) {
        int size = 1_00_000;
        Random rand = new Random();
        int[] randomNumber = new  int[size];
        int targetIndex = rand.nextInt(size);
        int target = randomNumber[targetIndex];

        for (int i = 0; i < size; i++ ){
            randomNumber[i] = rand.nextInt(size)+1;
        }

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : randomNumber
             ) {
            hashSet.add(i);
        }

        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int it: randomNumber
             ) {
            treeSet.add(it);
        }

        long startTime, endTime;

        startTime = System.nanoTime();
        SearchInArray(randomNumber, target);
        endTime = System.nanoTime();
        System.out.println("time in nano second for array linear search " + (endTime - startTime));
        long diifTime = endTime - startTime;
        System.out.println("in milli second is "  + TimeUnit.NANOSECONDS.toMillis(diifTime));


        System.out.println("\n");


        startTime = System.nanoTime();
        searchInHashSet(hashSet,target);
        endTime = System.nanoTime();
        System.out.println("time in nano second for hash set search " + (endTime - startTime));

        System.out.println("in milli second is " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) );


        System.out.println("\n");

        startTime = System.nanoTime();
        searchInTreeSet(treeSet, target);
        endTime = System.nanoTime();
        System.out.println("time in nano second for tree set search " + (endTime - startTime));
        System.out.println("in milli second is " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime) );



    }
}
