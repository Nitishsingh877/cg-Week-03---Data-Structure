package Stringbuilder.removeduplicates;

import java.util.HashSet;
import java.util.Scanner;

public class RemoveDuplicates {
    public static String removeDuplicatesFromWords(String input){
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (char c:input.toCharArray()
             ) {
            if(!seen.contains(c)){
                sb.append(c);
                seen.add(c);
            }

        } return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter the string ");
        String input = sc.nextLine().trim();

        String result = removeDuplicatesFromWords(input);
        System.out.println("String without duplicates is " + result);
    }
}
