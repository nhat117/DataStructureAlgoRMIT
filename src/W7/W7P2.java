package W7;
//Making a hash table
public class W7P2 {
    //Implement a hash table

    public static  void main(String[] args) {
        W7HashTableLinearProbing  table= new W7HashTableLinearProbing();
        System.out.println(table.put("A"));
        System.out.println(table.put("B"));
        System.out.println(table.put("C"));
        System.out.println(table.put("ABC"));
        System.out.println(table.put("D"));
        System.out.println(table.put("E"));
        System.out.println(table.put("F"));
        System.out.println(table.put("DEF"));
        System.out.println(table.put("CBA"));
        System.out.println(table.put("XYZ"));
        System.out.println(table.put("BAC"));

        System.out.println(table.get("A"));
        System.out.println(table.get("BCA"));
    }

    static class W7HashTableLinearProbing {

        private static final int N = 13;
        private int size;
        private  String[] items;

        public W7HashTableLinearProbing() {
            size = 0;
            items = new String[N];
        }

        //Hash function for
        private int hash(String s) {
            int res = 0;
            for (char c: s.toCharArray()) {
                res += hashChar(c);
            }
            return res %N;
        }

        //Hash function for individual character
        private int hashChar(char c) {
            return c - 'A';
        }

        public int size() {
            return size;
        }

        //Add a String to the colleciton
        //Assume the hashtable will never be full
        public boolean put(String s) {
            int hash = hash(s);

            int count = 0;
            //Linear probinh
            while(items[hash] != null) {
                if(items[hash].equals(s)) {
                    System.out.printf("Not added, collisions: $d\n", count);
                    return false;
                }
                count ++;
                hash = (hash + 1) % N;
            }
            items[hash] = s;
            size ++;
            System.out.printf("Added, collissions: %d\n", count);
            return true;
        }

        //Check if a String exist in a collection
        public boolean get(String s) {
            int hash = hash(s);
            int step = 1;
            while (items[hash] != null) {
                if(items[hash].equals(s)) {
                    System.out.printf("Found, steps: %d\n", step);
                    return true;
                }
                step ++;
                hash = (hash + 1) %N;
            }
            System.out.printf("Not found, steps: %d\n", step);
            return false;
        }
    }
}
