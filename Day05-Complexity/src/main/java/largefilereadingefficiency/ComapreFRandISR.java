package largefilereadingefficiency;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeUnit;

public class ComapreFRandISR {

    public static void fileReaderTime(String filePath){
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null){

            }
        }catch (IOException e){
            System.err.println("error reading file " + e.getMessage());
        }
    }

    public static void InputStreamReaderTime(String filePath){
        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))){
            String line;
            while ((line = br.readLine()) != null){

            }
        }catch (IOException e){
            System.err.println("error reading file " + e.getMessage());
        }
    }




    public static void main(String[] args) {
        String filePath = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\notes\\example.txt";


//        if(filePath == null){
//            System.out.println("error reading file path");
//            return;
//        }

        long startTime,endTime;
        startTime = System.nanoTime();
        fileReaderTime(filePath);
        endTime = System.nanoTime();

        System.out.println("time for 100mb file reader is " + (endTime - startTime) + " nano seconds");
        System.out.println("in milli seconds " + TimeUnit.NANOSECONDS.toMillis(endTime - startTime));


        System.out.println("\n");

        long startTimes , endTimes;
        startTimes = System.nanoTime();
        InputStreamReaderTime(filePath);
        endTimes = System.nanoTime();

        System.out.println("time for 100mb input stream readerr is " + (endTimes - startTimes) + " nano seconds");
        System.out.println("in milli seconds " + TimeUnit.NANOSECONDS.toMillis(endTimes - startTimes));

    }
}
