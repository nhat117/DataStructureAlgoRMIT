package W7;

import java.sql.Struct;

public class W7P3 {
    public static void main(String[] args) {
        W7Hashtable2 table = new W7Hashtable2();
        System.out.println("Adding to the Hashtable - Linear probing");
        table.put(new RMITStudent("S123", "IT", "Tri", 82.00));
        table.put(new RMITStudent("S456", "SE", "Tom", 70.50));
        table.put(new RMITStudent("S789", "Business", "Alice", 85.50));
        table.put(new RMITStudent("S213", "Music", "Bob", 79.50));
        table.put(new RMITStudent("S231", "Psychology", "An", 65.50));
        table.put(new RMITStudent("S123", "Aviation", "Teo", 90.00));
        table.put(new RMITStudent("S312", "Security", "Winner", 80.50));
        table.put(new RMITStudent("S312", "Marketing", "Loser", 71.50));

        System.out.println("Retrieving from the Hashtable");
        table.get("S123");
        table.get("S456");
        table.get("S789");
        table.get("S312");
        table.get("S321");
        table.get("S999");
        table.get("S564");
    }
    static class W7Hashtable2 {
        private static final int N = 13;
        private int size;

        private RMITStudent[] items;

        public W7Hashtable2() {
            size = 0;
            items = new RMITStudent[N];
        }

        //Hashing function
        private int hash(String s) {
            int res = 0;
            for (char c : s.toCharArray()) {
                res += hashChar(c);
            }
            return res % N;
        }

        private int hashChar(char c) {
            if(c >= '0' && c <= '9') {
                return c - '0' + 26;
            }
            return c - 'A';
        }

        public int size() {return size;}

        //Add a student to the collections

        public boolean put(RMITStudent s) {
            int hash = hash(s.studentId);
            //Count the number of collision
            int count = 0;
            //Linear Probing

            while(items[hash] != null) {
                if(items[hash].studentId.equals(s.studentId)) {
                    System.out.printf("Not Added, collision: %d\n", count);
                    return false;
                }
                count ++;
                hash = (hash + 1) % N;
            }
            items[hash] = s;
            size ++;
            System.out.printf("Added, collisions: %d\n", count);
            return true;
        }

        public RMITStudent get(String id) {
            int hash = hash(id);
            //Count the number of step
            int step = 1;
            //Linear Probing
            while (items[hash] != null) {
                if(items[hash].studentId.equals(id)) {
                    System.out.printf("Found, steps: %d\n", step);
                    return items[hash];
                }
                step ++;
                hash = (hash + 1) %N;
            }
            System.out.printf("Not found, steps: %d\n", step);
            return null;
        }
    }

    static class RMITStudent {
        String studentId;
        String major;
        String fullName;
        double GPA;

        public RMITStudent(String studentId, String major, String fullName, double GPA) {
            this.studentId = studentId;
            this.major = major;
            this.fullName = fullName;
            this.GPA = GPA;
        }
    }
}
