package stringconcatenationperformance;

import java.util.Random;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

public class StringAnalysis {

    public static void String(int iterartion){
        String str = " ";
        for(int i = 0 ; i<iterartion; i++){
            str += "a";
        }
    }

    public static void StringBuilder(int it){
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<it; i++){
            sb.append("a");
        }
    }

    public static  void stringBuffer(int t){
        StringBuffer sbb = new StringBuffer();
        for(int i=0; i<t; i++){
            sbb.append("a");
        }
    }


    public static void main(String[] args) {
         int iteration  = 1_00_000;

         long startTime, endTime;

         startTime = System.nanoTime();
         String(iteration);
         endTime = System.nanoTime();
        System.out.println("for string in nano Secons" + (endTime - startTime));
        System.out.println("for string in milii seconds" + TimeUnit.NANOSECONDS.toMillis((endTime-startTime)));

        System.out.println("\n");

        startTime = System.nanoTime();
        StringBuilder(iteration);
        endTime = System.nanoTime();
        System.out.println("for string builder in nano Secons" + (endTime - startTime));
        System.out.println("for string builder in milii seconds" + TimeUnit.NANOSECONDS.toMillis((endTime-startTime)));

        System.out.println("\n");

        startTime = System.nanoTime();
        stringBuffer(iteration);
        endTime = System.nanoTime();
        System.out.println(" for string buffer in nano Secons" + (endTime - startTime));
        System.out.println("for string buffer in milii seconds" + TimeUnit.NANOSECONDS.toMillis((endTime-startTime)));

        System.out.println("\n");




    }
}
