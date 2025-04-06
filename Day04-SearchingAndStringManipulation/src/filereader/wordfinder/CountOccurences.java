package filereader.wordfinder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountOccurences {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\notes\\Day01.txt";

        int count = 0;
        String target = "git";
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
           String line;
            //read file line by line
            while ((line = br.readLine()) != null){
               if(line.contains(target)){
                   count++;
               }
            }System.out.println("count is " + count);
        } catch (IOException e){
            System.err.println("error reading file "+ e.getMessage() );
        }

    }
}
