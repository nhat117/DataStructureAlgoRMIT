package W2;

import java.util.HashMap;

/*
Describe an efficient algorithm that prints out all the unique elements in an array.
What is the complexity of your algorithm?
Clarification: If your array is [6, 8, 10, 11, 6, 10]
=> print out [6, 8, 10, 11] (there is no requirement about output order,
so you can print the values in any order)
 */
public class Problem3 {
    public static void unique(int [] arr) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int i = 0; i < arr.length; i ++) {
            hash.put(arr[i], i);
        }
        System.out.println(hash.keySet());
    }

    public static void main(String[] args) {
        int[] arr = {6,7,8,10,11,6,10};
        unique(arr);
    }
}
