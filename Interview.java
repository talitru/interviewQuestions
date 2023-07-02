package il.co.ilrd.InterviewQuestions;

public class Interview {
    public static int stringToInt(String str){

        int strSize = str.length();
        int j=1, result = 0;
        int sign  = 1;
        if(str.charAt(0) == '-'){
            sign = -1;
        }

        for(int i =strSize-1; i>=0 && isDigit(str.charAt(i)); --i){
            result += (getNum(str.charAt(i)) * j);
            j*=10;
        }

        return result*sign;
    }

    private static boolean isDigit(char ch){
        int num = ch - '0';
        return num >=0 && num <=9;
    }
    private static int getNum(char ch){
        return ch - '0';
    }

    public static void main(String[] args){
        System.out.println(stringToInt("-123"));
        System.out.println(stringToInt("-102563"));
    }
}
