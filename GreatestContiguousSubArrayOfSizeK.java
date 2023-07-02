package il.co.ilrd.InterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class GreatestContiguousSubArrayOfSizeK {

    public static ArrayList<Integer> GreatestSubArray(int [] arr, int k){
        int n = arr.length;


        // Data-structure to store all
        // the sub-arrays of size K
        ArrayList<
                ArrayList<Integer>> vec = new ArrayList<
                ArrayList<Integer>>();

        // Iterate to find all the sub-arrays
        for(int i = 0; i < n - k + 1; i++)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>();

            // Store the sub-array elements in the array
            for(int j = i; j < i + k; j++)
            {
                temp.add(arr[j]);
            }

            // Push the vector in the container
            vec.add(temp);
        }

        // Sort the vector of elements
        Collections.sort(vec, new Comparator<ArrayList<Integer>>()
        {
            @Override
            public int compare(ArrayList<Integer> o1,
                               ArrayList<Integer> o2)
            {
                return o1.get(0).compareTo(o2.get(0));
            }
        });

        // The last sub-array in the sorted order
        // will be the answer
        return vec.get(vec.size() - 1);

    }

    public static void main(String[] args)
    {
        int a[] = { 1, 9, 4, 9, 3, 7};
        int k = 3;

        // Get the sub-array
        ArrayList<Integer> ans = GreatestSubArray(a, k);

        for(int it: ans)
        {
            System.out.print(it + " ");
        }
    }

}
