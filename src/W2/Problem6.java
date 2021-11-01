package W2;

/*
What is the complexity of an algorithm that merges two sorted arrays so that the
resultant array is also sorted?
For example, if A = [3, 6, 10, 15] and
B = [7, 10, 12, 19, 25],
the result would be [3, 6, 7, 10, 10, 12, 15, 19, 25].
 */
public class Problem6 {
    public static int[] merge(int[] arr1, int[] arr2) {
        int i1 = 0, i2 = 0, i3 = 0;
        int[] res = new int[arr1.length + arr2.length];
        while (i1 < arr1.length && i2 < arr2.length) {
            if(arr1[i1] < arr2[i2]) {
                res[i3 ++] = arr1[i1 ++];
            } else {
                res[i3 ++] = arr2[i2++];
            }
        }
        //Storing remaining elements of the first array
        while (i1 < arr1.length) {
            res[i3 ++] = arr1[i1++];
        }
        //Storing the remaining element on the second array
        while (i2 < arr2.length) {
            res[i3 ++] = arr2[i2++];
        }
        return  res;
    }

    public static void main(String[] args) {
       int [] A = {3, 6, 10, 15};
       int[] B = {7, 10, 12, 19, 25};
       int [] merge = merge(A,B);
        for (int a: merge) {
            System.out.print(a + " ");
        }
    }
}
