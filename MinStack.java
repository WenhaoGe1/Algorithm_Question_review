import java.util.Deque;
import java.util.LinkedList;

public class MinStack {
    private static Deque<Integer> stack;
    private static Deque<Integer> min;
    public MinStack() {
        // do intialization if necessary
        stack = new LinkedList<Integer>();
        min = new LinkedList<Integer>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public static void push(int number) {
        // write your code here
        
        
        if (min.isEmpty()){
            min.offerLast(number);
        } else {
            int temp = min.pollLast();
            if (number >= temp){
                min.offerLast(temp);
            } else {
                min.offerLast(number);
            }
        }
        
        stack.offerLast(number);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if (stack.isEmpty()){
            return -1;
        }
        int temp = stack.pollLast();
        min.pollLast();
        return temp;
    }

    /*
     * @return: An integer
     */
    public static int min() {
        // write your code here
        if (stack.isEmpty()){
            return -1;
        }
        return min.pollLast();
    }

    
    public static void main(String[] args) {
    	push(1);
    	min();
    	push(2);
    	min();
    
    	
    }
    
}