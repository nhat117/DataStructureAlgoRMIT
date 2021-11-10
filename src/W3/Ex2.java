package W3;
/*
An array contains the maximum temperature measured at noon in Saigon for each day for the last 10 years.
You believe that an important metric that will prove global warming is to derive the maximum increase in temperature from its lowest to its highest value across the ten years.
So, you need to find which two days - lowDay and highDay (where lowDay < = highDay) that has the largest increase. For example: if the temperatures were [14, 12, 70, 15, 95, 65, 22, 99, 8] the maximum increase = 99-12 = 87.

Provide pseudo-code to calculate this
 */

public class Ex2 {
    public static void main(String[] args) {
        int[] test1 = {1, 2, 6, 9, 10, 20};
        // lowDay = 0 and highDay = 5
        searchLowHigh(test1);

        int[] test2 = {20, 15, 12, 10, 8, 7};
        // lowDay = 0 and highDay = 0
        searchLowHigh(test2);

        int[] test3 = {14, 12, 70, 15, 95, 65, 22, 99, 8};
        // lowDay = 1 and highDay = 7
        searchLowHigh(test3);
    }

    public  static int[] searchLowHigh(int[] arr) {
        int[] res = new int[2];
        int low,highDay,min,minIndex,diff;
        low = highDay = diff = minIndex = 0;
        min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i ++) {
            if(arr[i] - arr[minIndex] > diff) {
                low = minIndex;
                highDay = i;
                diff = arr[i] - arr[minIndex];
            }
            if(arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        res[0] = low;
        res[1] = highDay;
        System.out.printf("lowDay = %d and highDay = %d\n", low, highDay);
        return res;

    }
}
