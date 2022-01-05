package W11;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(1000000000));
        System.out.println(fibRec(10000000));
    }
    //Dynamic programming implementation of fibonaci
    static int fib(int n) {
        int [] store = new int[n +2];
        int i;
        store[0] =0;
        store[1] =1;

        for(i = 2; i <= n; i ++) {
            store[i] =store[i-1] +store[i -2];
        }
        return store[n];
    }
    static int fibRec(int n) {
        if(n <= 1) return n;
        return fib(n - 2)+ fib(n - 1);
    }
}
