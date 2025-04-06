package Stringbuilder.reverse;

public class ReverseAString {
    public static void main(String[] args) {
        String  str = "Hello";
        StringBuilder sb = new StringBuilder(str);
        System.out.println("reversed string is " + sb.reverse().toString());
    }
}
