package W11;

import java.util.Arrays;
import java.util.Stack;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] test = {5,2,3,9,6,7,8};
        int[] res = longestIncreasingSubsequence(test);
        print(res);
    }
    static int[] longestIncreasingSubsequence(int [] arr) {
        int n = arr.length;
        int[] maxCount = new int[n];
        //Store the length of the longest increasing sybsequebce ending at i
        Arrays.fill(maxCount, -1);
        int[]prevElement = new int[n];
        //Store index of previous element
        //Trace back to the beginning element
        Arrays.fill(prevElement, -1);
        //Calculate
        for(int i = 0; i < arr.length;i ++) {
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {
                    //Expand the sunsequence ends at jth
                    //Include the element ith
                    if(maxCount[i] < maxCount[j] + 1) {
                        //If the new subsequence is longer than the current one
                        maxCount[i] = maxCount[j] + 1;
                        prevElement[i] = j;
                    }
                }
            }
        }

        //Get the longest subsequence
        //The longest subsequence has tp end at one of the element 0 ->(n-1_
        int maxEnd = 0;
        for(int i = 1; i < arr.length;i ++) {
            if(maxCount[maxEnd] < maxCount[i]) {
                maxEnd = i;
            }
        }

        //Go backward from the max index to the first element
        Stack<Integer> elements = new Stack<>();
        do {
            // in this implementation, the values of the elements in the
            // longest increasing subsequence are returned
            // you can change the assignment below to return the indices
            // of the elements instead, i.e., elements.push(maxEnding);
            elements.push(arr[maxEnd]);
            maxEnd = prevElement[maxEnd];
        } while(maxEnd != -1);

        //Prepare the result
        int[]res = new int[elements.size()];
        int i = 0;
        while(!elements.isEmpty()) {
            res[i] = elements.pop();
            i ++;
        }
        return res;
    }

    //Print out the fucking array
    static void print(int[] arr) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for(int n : arr) {
            if(!first) {
                sb.append(", " + n);
            } else {
                sb.append(n);
                first = false;
            }
        }
        System.out.println(sb);
    }
}
