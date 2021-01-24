import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static void main (String []args) throws IOException {

       Scanner in = new Scanner(System.in);

       //This section welcomes the new user ans prompts them to input their data
       System.out.println("Welcome to LinkedUp!");
       System.out.println("First we must set up your account:");
       System.out.println();
       System.out.println("Input your email:");
       String tempEmail = in.next();
       System.out.println("Are you on campus?");
       boolean tempOnCampus = textToBoolean();
       System.out.println("Would you like to allow other users to know if you are on campus?");
       boolean tempVisibility = textToBoolean();
       List<Course> tempCourses = new ArrayList<Course>();
       StringBuilder coursesString = new StringBuilder();
       System.out.println("How many classes are you enrolled in?");
       int classAmount = in.nextInt();

       for (int i = 0; i < classAmount; i++){
           System.out.println("What is the department of class number " + (i+1));
           String tempDep = in.next();
           System.out.println("What is the course number of class number " + (i+1));
           int tempNum = in.nextInt();

           coursesString.append(tempDep);
           coursesString.append(",");
           coursesString.append(tempNum);
           coursesString.append("&&&");
           Course tempCourse = new Course(tempNum, tempDep);
           tempCourses.add(tempCourse);
       }

        //This section saves their data into the data bases, data.txt.
        // The users emails are encrypted for security reasons.
        FileWriter myWriter = new FileWriter("src/data.txt", true);
        myWriter.write(String.valueOf(coursesString)); myWriter.write("~~~");
        myWriter.write(String.valueOf(Security.encrypt(tempEmail))); myWriter.write("~~~");
        myWriter.write(String.valueOf(tempOnCampus)); myWriter.write("~~~");
        myWriter.write(String.valueOf(tempVisibility)); myWriter.write("~~~");
        myWriter.write("\n");
        myWriter.close();

       Student user = new Student(tempCourses, tempEmail, tempOnCampus, tempVisibility);

       System.out.println("Your data has been added to the database");
       System.out.println();
       System.out.println();


        //This while loop is the functions main screen.
        //From here the users is given multiple options as for how to proceed.
       while (true) {

           System.out.println("Options:");
           System.out.println("1 - See users with same class");
           System.out.println("2 - Change location status");
           System.out.println("3 - Change location visibility status");
           System.out.println("4 - Exit programme");

           int nextAction = in.nextInt();

           if (nextAction == 1){
               user.StudentsMatch();
           }
           else if (nextAction == 2){
               if (user.onCampus){
                   System.out.println("You are currently on campus, are you sure you want to change status?");
                   user.onCampus = !textToBoolean();
                   if (user.onCampus){
                       System.out.println("Status has not changed");
                   } else {
                       System.out.println("Status has been changed");
                   }
               } else {
                   System.out.println("You are currently not on campus, are you sure you want to change status?");
                   user.onCampus = textToBoolean();
                   if (!user.onCampus){
                       System.out.println("Status has not changed");
                   } else {
                       System.out.println("Status has been changed");
                   }
               }
           }
           else if (nextAction == 3){
               if (user.locationVisible){
                   System.out.println("Your location is currently visible to other user, are you sure you want to change it?");
                   user.locationVisible = !textToBoolean();
                   if (user.locationVisible){
                       System.out.println("Status has not changed");
                   } else {
                       System.out.println("Status has changed");
                   }
               } else {
                   System.out.println("You are currently not on campus, are you sure you want to change status?");
                   user.locationVisible = textToBoolean();
                   if (!user.locationVisible){
                       System.out.println("Status has not changed");
                   } else {
                       System.out.println("Status has changed");
                   }
               }
           }
            else if (nextAction == 4) {
               break;
           } else {
               System.out.println("Please provide a valid response");
           }
       }
    }

    //This helper function converts a users input to a boolean. (yes -> true, false -> no)
    private static boolean textToBoolean() {

        Scanner in = new Scanner(System.in);
        String text = in.next();

        if (text.equals("YES") || (text.equals("yes")) || (text.equals("Yes")) || (text.equals("Y"))
                || (text.equals("Ye")) || (text.equals("y")) || (text.equals("yeah"))) {
            return true;
        } else if ((text.equals("NO") || (text.equals("no")) || (text.equals("N")) || (text.equals("n")))
                || (text.equals("No")) || (text.equals("Nah")) || (text.equals("nah"))
                || (text.equals("na")) || (text.equals("NA"))) {
            return false;
        } else {
            System.out.println("Please enter a valid response");
            return textToBoolean();
        }
    }
}
