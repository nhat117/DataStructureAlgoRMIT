package  W2;
/*

 */
public class Problem7 {
    public static int[] merge(int[] arr1, int[] arr2) {
        int len1 = arr1.length, len2 = arr2.length;
        int[] merge = new int[len1 + len2];
        int int1 = 0, int2 = 0;
        for (int i = 0; i < len1 + len2; i++) {
            if (int1 >= len1) {
                merge[i] = arr2[int2++];
                continue;
            }
            if (int2 >= len2) {
                merge[i] = arr1[int1++];
                continue;
            }

            if (arr1[int1] < arr2[int2]) merge[i] = arr1[int1++];
            else merge[i] = arr2[int2++];
        }
        return merge;
    }

    public static void main() {
        int[] A = {3, 6, 10, 15};
        int[] B = {7, 10, 12, 19, 25};
        int[] merge = merge(A, B);
        for (int i : merge) System.out.print(i + " ");
        System.out.println("");
    }
}