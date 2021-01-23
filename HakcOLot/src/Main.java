import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main (String []args){

        Course UnifiedRobotics = new Course(2001, "RBE", 'c');
        Course cCourse = new Course(2057, "CS", 'c');
        Course dataCourse = new Course(3054, "CS", 'c');
        Course CellBiology = new Course(2550, "BB", 'c');
        Course BiomedicalDataAnalysis = new Course(2211, "BME", 'd');
        Course BiomedicalEngineeringDesign = new Course(3300, "BME", 'c');
        Course IntermediateChineseIV = new Course(2544, "CN", 'c');
        Course IntroductionToElectricalAndComputerEngineering = new Course(2010, "ECE", 'd');
        Course Wellness = new Course(1006, "PE", 'c');
        Course EmbeddedDesign = new Course(2049, "ECE", 'c');
        Course LinAlgII = new Course(2073, "MA", 'c');
        Course Philosophy = new Course(2001, "PY", 'c');
        Course Systems = new Course(2049, "ECE", 'd');
        Course DiffGeometry = new Course(4895, "MA", 'd');
        Course GraphTheory = new Course(2273, "MA", 'd');
        Course IntroductionToDynamicSystems = new Course(2503, "ES", 'c');
        Course LinearAlgebraII = new Course(2073, "MA", 'c');
        Course PrisonFilms = new Course(3900, "HU", 'c');
        Course IntroductionToThermodynamics = new Course(3001, "ES", 'd');
        Course BridgeToHigherMathematics = new Course(1971, "MA", 'd');
        Course IntroductionToECE = new Course(2010, "ECE", 'd');


        List<Course> jackCourses = new ArrayList<>();
         jackCourses.add(UnifiedRobotics);
         jackCourses.add(cCourse);
         jackCourses.add(dataCourse);


        List<Course> timCourses = new ArrayList<>();
        timCourses.add(IntroductionToDynamicSystems);
        timCourses.add(LinearAlgebraII);
        timCourses.add(PrisonFilms);
        timCourses.add(IntroductionToThermodynamics);
        timCourses.add(BridgeToHigherMathematics);
        timCourses.add(IntroductionToECE);


        List<Course> brandonsCourses = new ArrayList<>();
        brandonsCourses.add(LinAlgII);
        brandonsCourses.add(EmbeddedDesign );
        brandonsCourses.add(Philosophy );
        brandonsCourses.add(Systems );
        brandonsCourses.add(DiffGeometry );
        brandonsCourses.add(GraphTheory );



        List<Course> rachelCourses = new ArrayList<>();
        rachelCourses.add(CellBiology);
        rachelCourses.add(BiomedicalDataAnalysis);
        rachelCourses.add(BiomedicalEngineeringDesign);
        rachelCourses.add(IntermediateChineseIV);
        rachelCourses.add(IntroductionToElectricalAndComputerEngineering);
        rachelCourses.add(IntroductionToDynamicSystems);
        rachelCourses.add(IntroductionToThermodynamics);
        rachelCourses.add(Wellness);

        Student Brandon = new Student(brandonsCourses, "bavoci@wpi.edu", true, true);
        Student Rachel = new Student(rachelCourses, "rhchan@wpi.edu", true, true);
        Student Tim = new Student(timCourses, "tjduval@wpi.edu", true, true);
        Student Jack = new Student(jackCourses, "jmuirhead@wpi.edu", true, true);


        List<Student> students = new ArrayList<>();
        students.add(Brandon);
        students.add(Rachel);
        students.add(Jack);
        students.add(Tim);



       for (Student s : students) {
           System.out.println(Tim.email + " and " + s.email + " have the following classes together:");
           Tim.StudentsMatch(s);
       }
    }
}
