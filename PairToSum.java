package il.co.ilrd.InterviewQuestions;

public class PairToSum {
    public static int countPairToSum(int[] arr, int targetSum){
        int min = findMin(arr);
        int max = findMax(arr);
        int count =0;
        int absMin = (min < 0) ? (-1 * min) : min;
        int absMax = (max < 0) ? (-1 * max) : max;
        int lutLength = absMin + absMax +1;
        int[] lut = new int[lutLength];

        for(int i = 0; i < lutLength; ++i){
            lut[i] = 0;
        }
        for(int i = 0; i < arr.length; ++i){
            lut[arr[i] +absMin ]++;
        }

        for(int i = 0; i < arr.length; ++i){
            count +=lut[targetSum- arr[i]+absMin];
            lut[targetSum- arr[i]+absMin] =0;
            lut[arr[i]+absMin]--;
        }
        return count;
    }

    public static int findMin(int[] arr){
        int min =  arr[0];
        for(int i = 1; i < arr.length; ++i){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    public static int findMax(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; ++i){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args){
        int arr1[] = {1,5,7,-1};
        int arr2[] = {1,5,7,-1,5};
        System.out.println(PairToSum.countPairToSum(arr1, 6));
        System.out.println(PairToSum.countPairToSum(arr2, 6));
    }
}
