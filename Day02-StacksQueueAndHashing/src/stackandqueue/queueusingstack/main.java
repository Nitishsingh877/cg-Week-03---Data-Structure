package stackandqueue.queueusingstack;

import java.util.Queue;
import java.util.Stack;

public class main {
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();//enque
        static  Stack<Integer> s2 = new Stack<>();//dequeue

        public  static boolean isEmpty(){
            return s1.isEmpty();
        }
        //add
        //logic is if s1 is not empty push in s1
        //if s1 have element pop and psuh in s2
        //add in s1 then
        //again repeat the same process
        public  static void add(int data){
            while (!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        //remove
        public static int remove(){
            if(isEmpty()){
                System.out.println("queue empty");
                return -1;
            }
            return s1.pop();
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("empty queue");
                return -1;
            }
            return s1.peek();
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
                    }
    }
}
