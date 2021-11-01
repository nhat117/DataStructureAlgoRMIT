package W2;

/*
Given the arrival and departure time of planes reaching a particular airport.
You need to find the minimum number of gates required to accommodate the planes at any point in time.
For example if arrival[] = {1:00, 1:40, 1:50, 2:00, 2:15, 4:00]
and departure[] = {1:10, 3:00, 2:20, 2:30, 3:15, 6:00}
then number of gates required = 4.
Note that arrival time is in chronological order.
Use analytical methods to prove the complexity.
The size of this problem is the size of the arrival/departure array.
 O(n)
 */

public class Problem4 {
    public static int gateNumber(double[] arrival, double[] departures) {
        //Starting point is one gate
        int gatenum = 1;
        for(int i = 1; i < arrival.length; i ++) {
            if(departures[i -1] > arrival[i]) gatenum ++;
        }
        return  gatenum;
    }

    public static void main(String[] args) {
        double [] arrival = {1.00, 1.40, 1.50, 2.00, 2.15, 4.00};
        double [] departure = {1.10, 3.00, 2.20, 2.30, 3.15, 6.00};
        System.out.println(gateNumber(arrival,departure));

    }

}
