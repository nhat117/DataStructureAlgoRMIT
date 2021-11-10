package W3;


/*
The data that is downloaded from the COVID application on a smartphone is stored with a timestamp in a buffer of length 100,000 that is overwritten when the buffer gets full.
For example, if the buffer was of size 15, the first 15 entries could be [3, 5, 7, 8, 10, 11, 12, 13, 20, 23, 27, 100, 103, 105, 108].
As the buffer is now full, when the 16th entry arrives it would overwrite location 1 and likewise, the 17th entry would overwrite entry 2 . etc.
 So, at time T, the buffer might contain data with the following timestamps  [113, 115, 117, 118, 10, 11, 12, 13, 20, 23, 27, 100, 103, 105, 108].
 You have decided that to gain insight into the spread of COVID you need to be able to efficiently find data at a specific time and be able to compare the oldest and newest data in the buffer.

Provide efficient pseudocode to read the data with a specific timestamp (e.g. look for the data with timestamp 117)

Provide efficient pseudocode that will access the oldest and newest data in the buffer

What is the order of complexity of your code?
 */
public class Ex3 {
    public static void main(String[] args) {

    }

    public static void searchBuffer(int [] arr) {
        int l = 0, r = arr.length - 1;
        while (l < r && arr[l] > arr[r]) {
            int m = (1/2) * (l + r );
            if(arr[m] > arr[m +1]) {
                System.out.println("Oldest " + m + 1 + "Newest : " + m);
                return;
            }
            if(arr[l] < arr[m]) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        System.out.println("Oldest " + l + "Newest : " + r);
    }
}
