package stringbuffer.comparestringbuffer;

public class CompareBuilderAndBuffer {
    public static void main(String[] arg) {

        int iteration = 1000000;
        StringBuffer sb = new StringBuffer();
        StringBuilder sbb = new StringBuilder();
        String str = "hello";

        //time for sb
        long startTimeBuffer = System.nanoTime();
        for(int i = 0; i<iteration;i++){
            sb.append(str);
        }
        long endTimeBuffer = System.nanoTime();
        long durationBuffer = endTimeBuffer - startTimeBuffer;


        //measure for sbb
        long startTimeBuilder = System.nanoTime(); // Start time for StringBuilder
        for (int i = 0; i < iteration; i++) {
            sbb.append(str);
        }
        long endTimeBuilder = System.nanoTime(); // End time for StringBuilder
        long durationBuilder = endTimeBuilder - startTimeBuilder;


        //result

        System.out.println("string buffer time is " + durationBuffer + " nanoSeconds");
        System.out.println("string builder time is " + durationBuilder + " nanoSeconds");
    }


    }

