package inputstreamreader.readandwriteuserinput;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class ReadAndWriteINput {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\NITISH SINGH\\OneDrive\\Desktop\\Cg-training\\notes\\Day01.txt";

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
            FileWriter fw = new FileWriter(filePath, true);
        ) {
            String line;
            System.out.println("Enetr text to write to the file and type exit to exit");
            while (!(line = br.readLine()).equalsIgnoreCase("exit")){
                fw.write(line+System.lineSeparator());
            }
            System.out.println("input saved to file " + filePath);
        }catch (IOException e){
            System.err.println("error handling file " + e.getMessage());
        }

    }
}
