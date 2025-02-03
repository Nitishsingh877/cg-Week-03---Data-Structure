package stringbuffer.concatenatestrings;

import com.sun.source.tree.BreakTree;

public class ConcateAllStrings {

    public static String Concat(String[] arr){
        StringBuffer sb = new StringBuffer();
        for(int i =0; i< arr.length; i++){
            sb.append(arr[i]);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] arr = {"hello","my","name","is","nitish!!"};

        String result = Concat(arr);
        System.out.println(result);
    }
}
