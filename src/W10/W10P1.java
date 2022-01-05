package W10;
//Insertionsort of the implementation

public class W10P1 {
    public static void main(String[] args) {
        int [] test = {5,4,3,2,1};
        print(test);
        insertionSort(test);
    }
    static void insertionSort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            int v = array[i];
            //Find the correct location of v
            int index = getLocation(array, i -1, v);
            //Shift all the element
            for(int j = i -1; j >= index; j --) {
                array[j + 1] = array[j];
            }
            array[index] = v;
            print(array);
        }
    }

    static  int getLocation(int [] array, int r, int v) {
        int l = 0;
        while(r > l) {
            int m = (l + r) /2;
            if(array[m] <= v) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        if(array[l] > v) {
            return l;
        }
        return l +1;
    }

    private static void print(int[] arr) {
        StringBuilder sb = new StringBuilder();
        boolean first = true;
        for(int n : arr) {
            if(!first) {
                sb.append(", " + n);
            } else {
                sb.append(n);
                first = false;
            }
        }
        System.out.println(sb);
    }
}
