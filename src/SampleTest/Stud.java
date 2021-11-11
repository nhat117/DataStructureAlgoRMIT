package SampleTest;

public class Stud {
    static class Student{
        String ID;
        String name;
        double GPA;

        public Student(String ID, String name, double GPA) {
            this.ID = ID;
            this.name = name;
            this.GPA = GPA;
        }
    }

    /*
     * This class is used to represent a student collection
     */
    public static class StudentCollection {
        Student [] stud;
        int size;
        int MAX_SIZE = 100;

        public StudentCollection() {
            stud = new Student[MAX_SIZE];
            size = 0;
        }

        public void addStudent(Student std) {
            //Check for duplicate id
            for(int i = 0; i < size; i ++) {
                if(stud[i].ID.equals(std.ID)) return;
            }
            //Add
            stud[size] = std;
            size ++;
        }

        public Student searchByName(String name) {
            for (int i = 0; i < size; i++) {
                if(stud[i].name.contains(name)) return stud[i];
            }
            return null;
        }

        public int rankStudent(String ID) {
            //fIND OUT THE STUDENT WITH ID FRIST
            Student tmp = null;
            for(int i = 0; i < size; i ++) {
                if(stud[i].ID.equals(ID)) {
                    tmp = stud[i];
                    break;
                }
            }

            //Not found
            if(tmp == null) return  -1;

            //Count number of gpa over this student
            int count = 0;
            double stdGPA = tmp.GPA;
            double epsilon = 0.000001;
            for(int i = 0; i < size; i ++) {
                if(stud[i].GPA - stdGPA >= epsilon) {
                    count ++;
                }
            }
            return count + 1;
        }

        // This method is not required
        // but it may help you test your implementation
        private void printAll() {
            System.out.println("--------");
            for (int i = 0; i < size; i++) {
                System.out.printf("%s %s %.2f\n", stud[i].ID,
                        stud[i].name, stud[i].GPA);
            }
            System.out.println("--------");
        }

        public static void main(String[] args) {
            StudentCollection col = new StudentCollection();
            col.printAll();

            // add one student
            col.addStudent(new Student("001", "Tom", 9.0));
            col.printAll();

            // add one student
            col.addStudent(new Student("002", "Jerry", 8.0));
            col.printAll();

            // add one duplicated student
            col.addStudent(new Student("002", "Name does not matter", 8.0));
            col.printAll();

            // add one student
            col.addStudent(new Student("003", "Donald", 8.5));

            // search by name, must return student whose name is Donald
            Student s = col.searchByName("a");
            System.out.printf("%s %s %.2f\n", s.ID, s.name, s.GPA);

            // search by name, must return null
            s = col.searchByName("ABC");
            if (s == null) {
                System.out.println("Null as expected");
            }

            // get rank of Donald, must be 2
            int rank = col.rankStudent("003");
            System.out.println("Rank = " + rank);

            // get rank of "111", must be -1 (No such student)
            rank = col.rankStudent("111");
            System.out.println("Rank = " + rank);

            // Add one student whose score is better than Donald
            col.addStudent(new Student("004", "Mickey", 9.0));

            // Rank of Donald should be 3 now
            rank = col.rankStudent("003");
            System.out.println("Rank = " + rank);
        }
    }
}
