package SampleTest;

import java.util.Arrays;

public class StudentCollection {
    static class Student {
        public String ID;
        public String name;
        public double gpa;

        public Student(String ID, String name, double gpa) {
            this.ID = ID;
            this.name = name;
            this.gpa = gpa;
        }
    }
    //Head of the collecion
    Element head;
    int size = 0;
    //One element
    static class Element{
        Student stud;
        Element nextEle;
        Element (Student stud) {
            this.stud = stud;
            nextEle = null;
        }
    }

    public void addStudent(Student student) {
        Element newEle =  new Element(student);
        newEle.nextEle = head;
        head = newEle;
        this.size ++;
    }

    public Student searchByName(String name) {
        return searchHelper(this.head,name);
    }

    public Student searchHelper(Element head, String name) {
        if (head == null) return null;
        if (head.stud.name.contains(name)) return head.stud;
        return searchHelper(head.nextEle, name);
    }

    public static void main(String[] args) {
        StudentCollection collection = new StudentCollection();
        collection.addStudent(new Student("s1","Jack",3.3));
        collection.addStudent(new Student("s2","Becky",3.4));
        collection.addStudent(new Student("s3","Tom",3.5));
        collection.addStudent(new Student("s4","Jack",3.5));
        System.out.println(collection.searchByName("B").gpa);
        System.out.println("Rank of the student :");
        System.out.println(collection.rankStudent("s1"));
        System.out.println(collection.rankStudent("s2"));
        System.out.println(collection.rankStudent("s3"));
        System.out.println(collection.rankStudent("s4"));
        System.out.println(collection.size);

    }

    public int rankStudent(String sID) {
        double [] score =deDuplicate(extract());
        Arrays.sort(score);
        //Search for sID
        Student tmp = searchByID(sID);
        int rank = 0;
        if(tmp == null) return -1;
        for(int i = 0; i < score.length; i ++) {
            if(tmp.gpa == score[i]) {
                rank = i;
                break;
            }
        }
        return  rank;
    }

    public Student searchByID(String id) {
        return searchIDHelper(this.head,id);
    }

    public Student searchIDHelper(Element head, String id) {
        if (head == null) return null;
        if (head.stud.ID.matches(id)) return head.stud;
        return searchIDHelper(head.nextEle, id);
    }


    private double [] deDuplicate(double [] arr) {
        if(arr.length == 0 || arr.length == 1) return null;

        double [] tmp = new double[arr.length];
        int j = 0;
        for(int i = 0; i < arr.length -1; i ++) {
            if(arr[i] != arr[i + 1]) tmp[j ++] = arr[i];
        }
        tmp[j++] = arr[arr.length -1];
        return  tmp;
    }

    private double[] extract() {
        Element ele = this.head;
        double [] stud = new double[this.size];
        int i = 0;
        while(ele != null) {
            stud[i] = ele.stud.gpa;
            i ++;
            ele = ele.nextEle;
        }
        return stud;
    }

//    private int split(double[] arr, int highPoint, int lowPoint) {
//        double piv = arr[highPoint];
//        int i = lowPoint -1;
//        for(int j = lowPoint; highPoint >= j; j ++) {
//            if(arr[j] <piv) {
//                i ++;
//                swap(arr,i,j);
//            }
//        }
//        swap(arr, i +1, highPoint);
//        return i +1;
//    }
//
//    private void quickSort(double []arr) {
//        quickSortHelper(arr, 0, arr.length -1);
//    }
//
//    private void quickSortHelper(double [] arr, double lowPoint, double highPoint) {
//        double piv = split(arr,(int)highPoint,(int)lowPoint);
//        quickSortHelper(arr,lowPoint, piv -1);
//        quickSortHelper(arr,piv + 1, highPoint);
//    }
//
//    private void swap(double[] arr, int i, int j)
//    {
//        double temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }

}
