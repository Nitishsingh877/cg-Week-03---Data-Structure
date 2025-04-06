package inputstreamreader.convertbytetochar;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ConvertByteToChar {
    public static void main(String[] args) {


        String filePath = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\notes\\Day01.txt";
       // String filePath  = "C:\\Users\\NITISH SINGH\\OneDrive\\Pictures\\Screenshots//Screenshot(40).png";
        try(
        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr)) {
            String line;
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }

        }catch (FileNotFoundException e){
            System.err.println("file not found" + filePath);
        } catch (IOException e){
            System.err.println("error reading file " + e.getMessage());
        }

    }
}
