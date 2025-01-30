package stackandqueue.implementaqueueusingstack;

import java.util.Stack;

public class Main {

    private static void sortedInsert(Stack<Integer> stack , int element){
        if(stack.isEmpty() || stack.peek() <= element){
            stack.push(element);
        }else {
            int x = stack.pop();
            sortedInsert(stack, element);
            stack.push(x);
        }
    }

    public static void sortStack(Stack<Integer> stack){
        if(!stack.isEmpty()){
            int x= stack.pop();
            sortStack(stack);
            sortedInsert(stack,x);
        }
    }
     public static void main(String[] args) {
         Stack<Integer> stack = new Stack<>();

         stack.push(5);
         stack.push(1);
         stack.push(0);
         stack.push(2);

         System.out.println("original stack " + stack);
         sortStack(stack);
         System.out.println("sorted stack " + stack);

     }
}
