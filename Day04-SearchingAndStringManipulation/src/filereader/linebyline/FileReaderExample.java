package filereader.linebyline;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\notes\\Day01.txt";

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            //read file line by line
            while ((line = br.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e){
            System.err.println("error reading file "+ e.getMessage() );
        }
    }
}
