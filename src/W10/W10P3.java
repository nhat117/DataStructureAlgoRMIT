package W10;

public class W10P3 {
    public static void main(String[] args) {
        System.out.println(squareRoot(4));
    }
    static double squareRoot(double v) {
        double min = 1;
        double max = v;
        double eps = 0.0000001;
        while (max - min > eps) {
            double mid = (min + max) /2;
            if(mid * mid > v) {
                max = mid;
            } else {
                min = mid;
            }
        }
        System.out.println(min);
        return min;
    }
}
