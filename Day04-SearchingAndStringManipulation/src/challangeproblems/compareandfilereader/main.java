package challangeproblems.compareandfilereader;


import java.io.*;
import java.nio.charset.StandardCharsets;

public class main {
    public static void StringBuilder() {
        String str = "hello";
        long quantity = 1000000;

        StringBuilder sb = new StringBuilder();

        long startTime = System.nanoTime();
        for (int i=0;i<=quantity;i++){
            sb.append(str);
        }
        long endTime = System.nanoTime();
        long resultforStringBuilder = endTime - startTime;
        System.out.println("for string builder " + resultforStringBuilder + " nano Seconds");
    }

    public  static void StringBuffer() {

        String str = "hello";
        long quantity = 1000000;

        StringBuffer sbu = new StringBuffer();

        long startTime = System.nanoTime();
        for (int i=0;i<=quantity;i++){
            sbu.append(str);
        }
        long endTime = System.nanoTime();
        long resultforStringBuffer = endTime - startTime;
        System.out.println("for string buffer " + resultforStringBuffer + " nanoSeconds");
    }
    public static long fileReaderWordsCount(){
        long startTime = System.currentTimeMillis();
        String filePath = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\notes\\Day01.txt";
        int words = 0;

        try(FileReader fr = new FileReader(filePath);
            BufferedReader br = new BufferedReader(fr))
        {
            String line;
            while ((line = br.readLine())!= null){
                words += line.split("\\s+").length;
            }
        }catch (IOException e){
            System.err.println("error in file handling" + e.getMessage());
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Words count is " + words);
        return endTime - startTime;
    }

    public static long countWordsUsingISR(){
        long startTime = System.currentTimeMillis();
        String filePath = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\notes\\Day01.txt";
        int words = 0;

        try(InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8);
           BufferedReader br = new BufferedReader(isr)
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                words  += line.split("\\s+").length;
            }
        }catch (IOException e){
            System.out.println("error while file handling "+ e.getMessage());
        }
        long endTime = System.currentTimeMillis();
        System.out.println("words in isr count is " + words);
        return endTime - startTime;
    }


    public static void main(String[] args) {
        StringBuffer();
        StringBuilder();
        System.out.println("time taken by file reader is " + fileReaderWordsCount() + "  milli second");
        System.out.println("time taken by input stream  reader is " + countWordsUsingISR() + "  milli second");
    }
}
