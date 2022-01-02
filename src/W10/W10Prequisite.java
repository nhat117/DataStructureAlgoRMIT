package W10;

import java.util.ArrayList;
import java.util.HashMap;

public class W10Prequisite {
    public static void main(String[] args) {
        // Some courses
        Course c1 = new Course("Intro to Programming");
        Course c2 = new Course("Programming 1");
        Course c3 = new Course("Data Structures & Algorithms");
        Course c4 = new Course("Practical Database Concepts");
        Course c5 = new Course("Database Applications");
        // Add prerequisites
        c2.addPreq(c1);
        c3.addPreq(c1);
        c3.addPreq(c2);
        c5.addPreq(c1);
        c5.addPreq(c4);
        // c1.addPreq(c5);
        // Prepare the necessary parameter
        ArrayList<Course> c = new ArrayList<Course>();
        c.add(c2);
        c.add(c1);
        c.add(c3);
        c.add(c4);
        c.add(c5);
        CourseGraph g = new CourseGraph(c);
        ArrayList<Course> result = g.getCourses();
        if (result != null) {
            for (Course course : result) {
                System.out.println(course);
            }
        }
    }

    static class Course {
        String name;
        ArrayList<Course> preq;

        public Course(String name) {
            this.name = name;
            preq = new ArrayList<Course>();
        }

        public void addPreq(Course requiredCourse) {
            preq.add(requiredCourse);
        }

        public ArrayList<Course> getPreq() {
            return preq;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    static class CourseGraph {
        HashMap<Course, Integer> courses;
        public CourseGraph(ArrayList<Course> c) {
            courses = new HashMap<Course, Integer>();
            // add all courses and their number of dependent courses
            for (Course c2 : c) {
                courses.put(c2, c2.getPreq().size());
            }
        }

        //Return course list
        public ArrayList<Course> getCourses() {
            int n = courses.size();
            ArrayList<Course> res = new ArrayList<>();

            //Doing ntimes extraction
            for(int i = 0; i < n; i ++) {
                boolean found = false;
                for(Course c : courses.keySet()) {
                    if(courses.get(c) == 0) {
                        res.add(c);
                        for(Course depended : courses.keySet()) {
                            if(depended.getPreq().contains(c)) {
                                int curr = courses.get(depended);
                                courses.put(depended,curr - 1);
                            }
                        }
                    }
                    courses.remove(c);
                    found = true;
                    break;
                }
                if (!found) {
                    System.out.println("Courses are mutually dependent!");
                    return null;
                }
            }
            return res;
        }

    }
}
