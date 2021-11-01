package W2;

/*
A sorted array (A) of length N is populated with N consecutive different integers ranging from 0 to N has one number missing.
 For example, if N=7 and the array = [0, 1, 2, 3, 4, 6, 7] then the missing value is 5.
Find an algorithm that finds and prints out the missing integer. What is the big O of your code? Can you find an O(log N) algorithm? No i cant fuck you
 */
//O(n)
public class Problem2 {
    public static void printMissingElement(int arr[]) {
        //Set the missing element to 0;

        int[] tmp = new int[arr[arr.length - 1] + 1];
        for(int i = 0; i < arr.length; i ++) {
            tmp[arr[i]] = 1;
        }
        //Print the missing element
        for(int i = arr[0]; i <= arr[arr.length -1]; i ++) {
            if(tmp[i] == 0) System.out.println(i + " ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {0,1,2,3,4,6,7};
        printMissingElement(arr);
    }
}
