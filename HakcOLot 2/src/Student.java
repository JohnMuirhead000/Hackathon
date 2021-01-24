import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Student {

    private List<Course> courses;
    private String email;
    Boolean onCampus;
    Boolean locationVisible;

    Student(List<Course> courses, String email, Boolean onCampus, Boolean locationVisible) {
        this.courses = courses;
        this.email = email;
        this.onCampus = onCampus;
        this.locationVisible = locationVisible;
    }



    //Method takes in another student and produces true if this student shares a class with the student
    public void StudentsMatch() throws FileNotFoundException {

        File myObj = new File("src/data.txt");
        Scanner myReader = new Scanner(myObj);
        int counter = 0;
        while (myReader.hasNextLine()) {

            String data = myReader.nextLine();
            String[] tempSplit = data.split("~~~");
            String[] tempSplit2 = tempSplit[0].split("&&&");

            for (Course c : courses) {
                for (int i = 0; i < tempSplit2.length; i++) {
                    String[] tempSplit3 = tempSplit2[i].split(",");
                    if ((tempSplit3[0].equals(c.department)) && (Integer.parseInt(tempSplit3[1]) == c.courseNumber)) {
                        StringBuilder tb = new StringBuilder();
                        tb.append(tempSplit[1]);
                        if (!Security.decrypt(tb).toString().equals(email)) {

                            counter++;
                            System.out.println("You share the following course with " + Security.decrypt(tb) + ": \n" + tempSplit3[0] + tempSplit3[1]);
                            if (tempSplit[3].equals("true")){
                                if (tempSplit[2].equals("true")){System.out.println("This user is on campus");} else
                                {System.out.println("This user is not on campus");}
                            }
                            System.out.println("\n");
                        }
                    }
                }
            }
        }
        if (counter == 0) {
            System.out.println("You do not share a class with anyone");
            System.out.println();
        }
    }
}
