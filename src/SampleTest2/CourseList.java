package SampleTest2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringJoiner;

public class CourseList {
    public static void main(String[] args) {
        Course c1 = new Course("Programming 1", "C123");
        Course c2 = new Course("Web Programming", "C456");
        Course c3 = new Course("Data Structures", "C789");
        Course c4 = new Course("Database Application", "C000");
        CourseList list = new CourseList();
        list.addCourse(c1);
        list.addCourse(c2);
        list.addCourse(c3);
        list.addCourse(c4);
        list.addPrerequisite(c2, c1);  // make Programming 1 a prerequisite of Web Programming
        list.addPrerequisite(c3, c1);  // make Programming 1 a prerequisite of Data Structures
        list.addPrerequisite(c4, c2);  // make Web Programming a prerequisite of Database Application
        list.takeFirst(c1);  // true
        list.takeFirst(c3);  // false
        list.test(list.courseList);
        System.out.println(list.course.size());
        list.coursesTaken(); // return "Programming 1, Web Programming, Data Structures, Database Application"
       // (You can swap Web Programming, Data Structures, and Database Application with each other, as long as Web Programming is positioned before Database Application)
    }

    static class Course {
        String name;
        String code;
        ArrayList<Course> preq;

        public Course(String name, String code) {
            this.name = name;
            this.code = code;
            preq = new ArrayList<Course>();
        }

        public void addPrerequisite(Course requiredCourse) {
            preq.add(requiredCourse);
        }

        public ArrayList<Course> getPrerequisites() {
            return preq;
        }

        @Override
        public String toString() {
            return "Course{" +
                    "name='" + name;
        }
    }
    //Course List
    // maintain courses and number of dependent courses
    ArrayList <Course> courseList;
    HashMap<Course, Integer> course;
    public CourseList () {
        courseList = new ArrayList<>();
        course = new HashMap<>();
        // add all courses and their number of dependent courses
    }

    public void addCourse(Course course) {
        courseList.add(course);
        this.course.put(course, course.preq.size());
    }

    public void addPrerequisite(Course c, Course preq) {
        for(int i = 0; i < courseList.size(); i++) {
            if(courseList.get(i).code.equals(c.code)) {
                //Check duplication
                for(int j = 0; j < courseList.get(i).preq.size(); j++) {
                   if(courseList.get(i).preq.get(j).code.equals(preq.code)) {
                       System.out.println("Course is duplicate");
                       return;
                   }
                }
                courseList.get(i).preq.add(preq);
                course.replace(courseList.get(i), courseList.get(i).preq.size() + 1);
                return;
            }
        }
    }

    public String coursesTaken() {
        int n = course.size();
        ArrayList<Course> res = new ArrayList<Course>();
        boolean []  added = new boolean[n];
        // Do n-times extraction
        for (int i = 0; i < n; i ++) {
            // found an appropriate course?
            if(added[i]) {continue;}
            Course c = courseList.get(i);
            boolean found = false;
            for (int j = 0; j < n; j++) {
                // Get the course that has no dependence
                if (added[j]) continue;
                if (i == j) continue;
                Course pre = courseList.get(j);
                if (c.preq.contains(pre)) {
                    found = true;
                    break;
                }

            }
            if(found) {
                continue;
            }
            res.add(c);
            added[i] = true;
            for(int j = 0; j < n; j++) {
                Course t = courseList.get(j);
                if(t.preq.contains(c)) t.preq.remove(c);
            }
        }

        StringJoiner sb = new StringJoiner(", ");
        for(Course c : res) {
            sb.add(c.name);
        }
        System.out.println(sb);
        return sb.toString();
    }

    public boolean takeFirst(Course c) {
        return (c.preq.size() == 0);
    }

    public void test(ArrayList <Course> input) {
        for(Course c: input) {
            System.out.println(c);
        }
    }
}

