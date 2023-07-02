package il.co.ilrd.InterviewQuestions;

import java.util.Stack;

public class StackSort {

    public static Stack<Integer> sortStackAscending(Stack<Integer> stackToSort) {

        Stack<Integer> auxiliaryStack = new Stack<Integer>();

        while (!stackToSort.isEmpty()){

            if(auxiliaryStack.isEmpty() || (stackToSort.peek() >= auxiliaryStack.peek())){
                auxiliaryStack.push(stackToSort.pop());
            }
            else{
                Integer currValue = stackToSort.pop();
                while (!auxiliaryStack.isEmpty() && currValue < auxiliaryStack.peek()){
                    stackToSort.push(auxiliaryStack.pop());
                }
                auxiliaryStack.push(currValue);
            }
        }
        return auxiliaryStack;
    }

    public static void main(String[] args){

        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        stack.push(7);
        stack.push(1);
        stack.push(3);
        stack.push(6);
        stack.push(1);

        stack = sortStackAscending(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
