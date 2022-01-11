package SampleTest2;

import java.util.ArrayList;
import java.util.HashMap;

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
//        list.takeFirst(c1);  // true
//        list.takeFirst(c3);  // false
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
        if(courseList.isEmpty()) {
            courseList.add(course);
            this.course.put(course, course.preq.size());
            return;
        }
        //Check duplication
        for(int i = 0; i < courseList.size(); i++) {
            if(courseList.get(i).code.equals(course.code)) {
                return;
            }
        }
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

    public ArrayList<Course> getCourses() {
        int n = course.size();
        ArrayList<Course> res = new ArrayList<Course>();

        // Do n-times extraction
        for (int i = 0; i < n; i ++) {
            // found an appropriate course?
            boolean found = false;
            for (Course c : course.keySet()) {
                // Get the course that has no dependence
                if (course.get(c) == 0) {
                    res.add(c);
                    // Update other dependent courses
                    for (Course depended : course.keySet()) {
                        if (depended.preq.contains(c)) {
                            int currentCount = course.get(depended);
                            course.put(depended, currentCount - 1);
                        }
                    }
                    // Remove this cours
                    course.remove(c);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Courses are mutually dependent!");
                return null;
            }
        }
        return res;
    }

    public String coursesTaken() {
        StringBuilder sb = new StringBuilder();
        ArrayList<Course> res = getCourses();
        for(int i = 0; i < res.size(); i ++) {
            sb.append(res.get(i).name + " ");
        }
        return sb.toString();
    }

    public void test(ArrayList <Course> input) {
        for(Course c: input) {
            System.out.println(c);
        }
    }
}

