package SampleTest;

public class Problem3 {
    public boolean checkPair(int[] A , int S) {
       int N = A.length; //{1}
        for(int i = 0; i < N-1; i ++) {  //{N}
            for(int j = i + 1; j < N-1; j++) { //{sum(N-i-1) for i from - to N -1
                if(A[i] + A[j] == S ) return  true; //{sum(N- i - 1) : for i from 0 to N -1
            }
        }
        return false; //1
    }
    /*
    The statement with largest number of execution is the statement inside the nested loop
Sum(N - i - 1): for i from 0 to (N-1)
i = 0 => the element is N - 1
i = 1 => the element is N - 2
...
i = (N-1) => the element is 0
So, the Sum is: 0 + 1 + 2 + ... + (N - 2) + (N - 1) = N*(N-1)/2
Keep the most significant element and remove the constants, it is N^2
The big-O of above algorithm is O(N^2)

     */

    //sUM : 0 + 1 + 2 + 3 .. + n-2 + n = 1 = N * (n-10/2
    //bigO(N^2)

    ///////////////////////////////////////
    public boolean checkPair2(int [] A, int S) {
        int size = A.length; //1
        int l = 0, r = size -1;  //1
        while(l < r) {   //N
            if(A[l] + A[r] == S) { //N
                return true; //1
            }
            if(A[l] + A[r] < S){ //N
                l ++;  //N
            } else {
                r --;  //N
            }
        }
        return  false; //1
    }
    /*
    Initially, left and right are N-position far away
Inside the loop, either left or right advances one unit closer each step
So, they will eventually meet after N steps
The time complexity in this algorithm is O(N)
     */
}
