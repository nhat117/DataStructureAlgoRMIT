package W2;
//
public class Power {
    //Describe an efficient algorithm that can calculate a^n in O(log n) (n is a positive integer)
    public static double pow(double a, double b) {
        //If x^0 return 1
        if(b == 0) return 1;

        if(a == 0) return  0;
        //Recursively calculate
        return a *pow(a, b-1);
    }

    public static void main(String[] args) {
        double a =2, b= 0;
        //Test
        if(pow(a,b) == Math.pow(a,b)) System.exit(1);
    }
}
