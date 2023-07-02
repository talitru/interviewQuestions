package il.co.ilrd.InterviewQuestions;

public class MissingElements {

    public static void printMissingElements(long[] arr, long low , long high){
        int size = (int) (high - low + 1);
        boolean[] lut = new boolean[size];

        for (int i =0; i<arr.length;++i){
            lut[(int) (arr[i]-low)] =  true;
        }
        for (int i = 0; i<lut.length; ++i){
            if(lut[i] == false){
                System.out.print(i+low+", ");
            }
        }
    }
    public static void main(String[] args){
        long[]arr = {10,12,4,20,2,18};

        MissingElements.printMissingElements(arr, 0,25 );
    }
}
