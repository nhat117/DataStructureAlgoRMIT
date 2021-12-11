package W7;


public class W7HashtableSeparateChainning {
    public static void main(String[] args) {
        W7HashTable table = new W7HashTable();
        System.out.println("Adding to the HashTable - separate chaining");
        table.put(new RMITStudent("S1234567", "Tri", 75.50));
        table.put(new RMITStudent("S2234567", "Tom", 80.00));
        table.put(new RMITStudent("S3234567", "Alice", 60.50));
        table.put(new RMITStudent("S4234567", "Bob", 75.50));
        table.put(new RMITStudent("S1134567", "An", 79.00));
        table.put(new RMITStudent("S1234567", "Teo", 82.50));
        table.put(new RMITStudent("S1334567", "Winner", 90.50));
        table.put(new RMITStudent("S1334567", "Loser", 50.50));

        System.out.println("Retrieving from the Hashtable");
        table.get("S1234567");
        table.get("S2234567");
        table.get("S3234567");
        table.get("S4234567");
        table.get("S1134567");
        table.get("S1334567");
        table.get("S9999999");
        table.get("S1111111");
    }
    static class StudentNode {
        RMITStudent stud;
        StudentNode next;
    // A hashing table
        public StudentNode(RMITStudent student) {
            this.stud = student;
            next = null;
        }
    }

    static class RMITStudent {
        String studentId;
        String fullName;
        double GPA;

        public RMITStudent(String studentId, String fullName, double GPA) {
            this.studentId = studentId;
            this.fullName = fullName;
            this.GPA = GPA;
        }
    }

    static class W7HashTable {
        private static final int N = 10;
        private int size;
        private StudentNode[] studs; //Student storage

        public W7HashTable() {
            size = 0;
            studs = new StudentNode[N];
        }

        public int size() {
            return size;
        }

        //A typical hashing function
        // Assume student id always has the format
        // Sabcdxyz, where a, b, c, d, x, y, z are 7 digits
        // E.g., S1234567 or S9995444 are 2 valid cases
        // And we use the first digit as the hash value
        private int hash(String studID) {
            return studID.charAt(1) - '0';
        }

        //Add an RMIT Student to the collection
        public boolean put(RMITStudent stud) {
            int i = hash(stud.studentId);
            StudentNode node = new StudentNode(stud);
            //Count of how many collision

            int count = 0;
            //Empty slot
            if(studs[i] == null) {
                studs[i] = node;
                size ++;
                System.out.printf("Added, collision: %d\n", count);
                return true;
            }
            //Collision resoluton
            StudentNode parent = null;
            StudentNode t = studs[i];
            while (t != null) {
                if(t.stud.studentId.equals(stud.studentId)) {
                    System.out.printf("Found, steps %d\n",count);
                    return false;
                }
                count ++;
                parent = t;
                t = t.next;
            }
            parent.next = node;
            size ++;
            System.out.printf("Added, collisions: %d\n", count);
            return true;
        }
        //TODO: Implement a get methode

        public RMITStudent get(String studentID) {
            int i = hash(studentID);

            int step = 1;
            //Empty slot ?
            if(studs[i] == null) {
                System.out.printf("Not found, steps: %d\n", step);
                return  null;
            }

            //Possible answer
            StudentNode t = studs[i];
            while (t != null) {
                if(t.stud.studentId.equals(studentID)) {
                    System.out.printf("found, steps: %d\n", step);
                    return t.stud;
                }
                step ++;
                t = t.next;
            }
            System.out.printf("Not Found, steps: %d\n", step);
            return null;
        }
    }
}
