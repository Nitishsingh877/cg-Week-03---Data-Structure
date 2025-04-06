package stackandqueue.stockspanproblem;

import java.util.Stack;

//The Stock Span Problem requires finding the span of stock prices
// for each day, which is the number of consecutive days (including the
// current day) where the price was less than or equal to the current day's price.
public class Main {

    public static void stocksSpan(int stocks[], int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for (int i=1; i<stocks.length;i++){
            int currPrice = stocks[i];
            while (!s.isEmpty() && currPrice > stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }else {
                int prevhigh = s.peek();
                span[i] = i-prevhigh;
            }
            s.push(i);

        }
    }


    public static void main(String[] args) {
        int stocks[] = {100,80,60,70,85,100};
        int span[] = new int[stocks.length];
        stocksSpan(stocks,span);

        for(int i=0;i<span.length;i++){
            System.out.println(span[i] + " ");
        }

    }
}
