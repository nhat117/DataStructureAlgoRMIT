package W3;
//Merge 2 jagged array
public class Ex5 {
    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        createJaggedArray(test1);

        int[] test2 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        createJaggedArray(test2);

        int[] test3 = {1, 5, 2, 9, 10, 13, 17, 21, 11};
        createJaggedArray(test3);
    }
    public static void createJaggedArray(int [] arr) {
        for(int i = 2; i < arr.length ;i ++) {
            if((arr[i] -arr[i-1]) * (arr[i -1] - arr[i -2]) > 0) {
                //2 positive differences or 2 negative differences
                int tmp = arr[i];
                arr[i] = arr[i -1];
                arr[i-1] = tmp;
            }
        }
        StringBuilder tmp = new StringBuilder("{" + arr[0]);
        for(int i = 1; i < arr.length; i++) {
            tmp.append("," + arr[i]);
        }
        tmp.append("}");
        System.out.println(tmp.toString());
    }
}
