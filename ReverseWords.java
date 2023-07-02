package il.co.ilrd.InterviewQuestions;

import java.util.Stack;

public class ReverseWords {

    public void reverseWords(String words){
        Stack<Character> stack = new Stack<>();

        for(int i =0; i<words.length();++i){
            if(words.charAt(i) == ' '){
                stack = printAndEmptyStack(stack);
            }
            else {
                stack.push(words.charAt(i));
            }
        }
        printAndEmptyStack(stack);
    }

    public Stack<Character> printAndEmptyStack(Stack<Character> stack){

        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
        System.out.print(" ");
        return stack;
    }

    public static void main(String[] args){
        ReverseWords rw = new ReverseWords();

        rw.reverseWords("hello world");
    }
}
