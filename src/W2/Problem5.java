package W2;
/*
Given a sorted array of positive and negative integers, find two integers in the array whose sum is closest to zero.
Use analytical methods to prove the complexity.
 */

import java.util.ArrayList;

public class Problem5 {
    static class Sum{
        int a;
        int b;
        public  Sum(int a, int b) {
            this.a =a;
            this.b = b;
        }
    }

    public static void findSumZero(int [] arr) {
        for(int i = 1; i < arr.length ; i++) {
            if(!(Math.abs(arr[i -1]) < Math.abs(arr[i]))) {
                int tmp = arr[i-1];
                arr[i-1] = arr[i];
                arr[i] = tmp;
            }
        }
        int min = Integer.MAX_VALUE;
        int a = 0, b = 0;
        ArrayList<Sum> lst = new ArrayList<>();
        for(int i = 1; i < arr.length; i ++) {
            //Show how close it is to zero
            if(Math.abs(arr[i-1] + arr[i]) <= min) {
                //If found closer value update
                min = Math.abs(arr[i -1] + arr[i]);
                 a = i -1;
                 b = i;
                 lst.add(new Sum(a,b));
            }
        }
        System.out.println( arr[a] +" and "+ arr[b] + " have sum closet to 0");
    }

    public static void main(String[] args) {
        int [] arr = {-2,-1,0,1,2,3,4,5};
        findSumZero(arr);
    }
}
