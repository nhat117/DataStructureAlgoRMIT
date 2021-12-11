package W7;
//Built in sort
import java.util.Arrays;

public class W7P1 {
    //Implement a frequency sort
    static final int SIZE = 1000000; //Array size
    static final int RANGE = 1000000;// Value range- from zero

    //Generate a random arr

    public int[] generate() {
        int [] res = new int[SIZE] ;
        for (int i = 0; i < SIZE; i ++ ) {
            res[i] = (int)(Math.random() * RANGE);
        }
        return res;
    }

    public void countingSort(int[] arr) {
        //Start a timer
        long startTime = System.currentTimeMillis();

        int size = arr.length;
//Count array
        int [] countArr = new int[RANGE];

        //Counting step
        for(int i = 0; i < size; i ++) {
            countArr[arr[i]] ++;
        }

        //Sortin step
        int i = 0;
        for(int j = 0; j < RANGE; j ++) {
            Arrays.fill(arr,i,i +countArr[j],j);
            i += countArr[j];
        }

        long endTime = System.currentTimeMillis();
        long diff = endTime - startTime;
        System.out.printf("Counting sort: %d ms\n", diff);
    }

    //Java
    public void builtinSort(int[] arr) {
        long startTime = System.currentTimeMillis();
        java.util.Arrays.sort(arr);
        long endTime = System.currentTimeMillis();
        long diff = endTime - startTime;
        System.out.printf("Java built-in sort: %d milli-seconds\n", diff);
    }

    public static void main(String[] args) {
        W7P1 problem1 = new W7P1();
         int[] test1 = problem1.generate();
         int[] test2 = Arrays.copyOf(test1,test1.length);
         problem1.countingSort(test1);
         problem1.builtinSort(test2);
    }
}
