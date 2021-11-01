package SampleTest;

public class StudentLinkedList {
        public static class Student {
            private String sid;
            private String name;
            private double gpa;
            private int rank;
            private Student nextStudent;

            public Student(String sid, String name, double gpa) {
                this.sid = sid;
                this.name = name;
                this.gpa = gpa;
                rank = -1;
            }

            public String getSid() {
                return sid;
            }

            public void setSid(String sid) {
                this.sid = sid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public double getGpa() {
                return gpa;
            }

            public void setGpa(double gpa) {
                this.gpa = gpa;
            }

            public int getRank() {
                return rank;
            }

            public void setRank(int rank) {
                this.rank = rank;
            }

            public Student getNextStudent() {
                return nextStudent;
            }

            public void setNextStudent(Student nextStudent) {
                this.nextStudent = nextStudent;
            }

            @Override
            public String toString() {
                return "sid: " + sid + "; name: " + name + "; gpa: " + gpa + "; rank: " + rank;
            }
        }
        private Student head;

        public Student getStudentById(String id) {
            if (head != null) {
                Student currentStudent = head;
                while(currentStudent.getNextStudent() != null) {
                    if (currentStudent.getSid().equals(id)) return currentStudent;
                    currentStudent = currentStudent.getNextStudent();
                }
                if (currentStudent.getSid().equals(id)) return currentStudent;
            }
            return null;
        }

        private Student getStudentAndSetRank(Student student) {
            int rank = 1;
            Student existed = null;
            if (head != null) {
                Student currentStudent = head;
                if (currentStudent.getGpa() > student.getGpa()) rank++;
                if (currentStudent.getGpa() < student.getGpa()) currentStudent.setRank(currentStudent.getRank() + 1);
                while(currentStudent.getNextStudent() != null) {
                    if (currentStudent.getGpa() > student.getGpa()) rank++;
                    if (currentStudent.getGpa() < student.getGpa()) currentStudent.setRank(currentStudent.getRank() + 1);
                    if (currentStudent.getSid().equals(student.getSid())) existed = currentStudent;
                    currentStudent = currentStudent.getNextStudent();
                }
                if (currentStudent.getSid().equals(student.getSid())) existed = currentStudent;
            }
            student.setRank(rank);
            return existed;
        }

        public void addStudent(Student student){
            // This part is not generalized
            if (getStudentAndSetRank(student) == null) {
                student.setNextStudent(head);
                head = student;
            } else System.out.println("There are dups");
        }

        public void display(){
            if(head != null){
                Student currentStudent = head;
                while(currentStudent.getNextStudent() != null){
                    System.out.println(currentStudent);
                    currentStudent = currentStudent.getNextStudent();
                }
                System.out.println(currentStudent);
            }
        }

        public int getStudentRankById(String sid) {
            Student temp = getStudentById(sid);
            return temp == null ? -1 : temp.getRank();
        }

    void main(String[] args) {
        //TODO solution 1
//        StudentLinkedList list = new StudentLinkedList();
//        list.addHead(new Student("s1", "Hoang", 10.0));
//        list.addHead(new Student("s2", "Tuyen", 9.0));
//        list.addHead(new Student("s3", "Luan", 8.0));
//        list.addHead(new Student("s4", "Nhat", 7.0));
//
//        list.display();
//
//        list.addHead(new Student("s1", "Hoang", 10.0));
//
//        System.out.println(list.getById("s2").getData());
//
//        System.out.println(list.getByName("Lu").getData());

        //TODO solution 2
        StudentLinkedList list = new StudentLinkedList();
        list.addStudent(new StudentLinkedList.Student("s1", "Hoang", 10.0));
        list.addStudent(new StudentLinkedList.Student("s5", "Nhi", 10.0));
        list.addStudent(new StudentLinkedList.Student("s5", "Nhin", 10.0));
        list.addStudent(new StudentLinkedList.Student("s2", "Tuyen", 9.0));
        list.addStudent(new StudentLinkedList.Student("s3", "Luan", 8.0));
        list.addStudent(new StudentLinkedList.Student("s4", "Nhat", 7.0));

        list.display();

        System.out.println(list.getStudentRankById("s4"));
    }
}
