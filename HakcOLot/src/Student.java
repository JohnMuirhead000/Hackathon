import java.util.ArrayList;
import java.util.List;

public class Student {

    List<Course> courses = new ArrayList<>();
    String email;
    Boolean onCampus;
    Boolean overOnePartner;



    Student (List<Course> courses, String email, Boolean onCampus, Boolean overOnePartner){
        this.courses = courses;
        this.email = email;
        this.onCampus = onCampus;
        this.overOnePartner = overOnePartner;
    }



    //Checks if the student is a WPI student
    public  boolean WPIStudent(){
        String end = email.substring(email.length()-7);
        return end.equals("wpi.edu");
    }



    //Method takes in another student and produces true if this student shares a class with the student
    public  void StudentsMatch(Student student){
        for (Course course1 : student.courses){
            for (Course course2 : courses){
                if (course1.courseNumber == course2.courseNumber && course1.department.equals(course2.department)){
                    System.out.println(course1.department + course1.courseNumber );
                }
            }
        }
    }

    //Adds a couese to the students POOP
    public void addCourse(Course course){
        courses.add(course);
    }




}
