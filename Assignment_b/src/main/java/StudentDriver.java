import org.joda.time.DateTime;

import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.util.ArrayList;
import java.util.List;

public class StudentDriver {

    public static void main(String args[]) {

        //create 5 students
        Student mary = new Student(18280070, "Mary", 20, "05/03/2001");
        Student john = new Student(18278070, "John", 21, "05/03/2000");
        Student james = new Student(18289970, "James", 22, "05/03/1999");
        Student kerry = new Student(18297070, "Kerry", 20, "05/03/2001");
        Student simon = new Student(18290070, "Simon", 21, "05/03/2000");

        //create a list for the students, then add the students to the list
        List<Student> listStudent = new ArrayList<>();
        listStudent.add(mary);
        listStudent.add(john);
        listStudent.add(james);
        listStudent.add(kerry);
        listStudent.add(simon);

        //create 5 modules
        Module softwareEngineering = new Module("CT417", "Software Engineering");
        Module machineLearning = new Module("CT789", "Machine Learning");
        Module informationRetrieval = new Module("CT590", "Information Retrieval");
        Module professionalSkills = new Module("CT612", "Professional Skills");
        Module systemsModelling = new Module("CT849", "Systems Modelling");

        //create a list for the modules, then add the modules to the list
        List<Module> listModules = new ArrayList<>();
        listModules.add(softwareEngineering);
        listModules.add(machineLearning);
        listModules.add(informationRetrieval);
        listModules.add(professionalSkills);
        listModules.add(systemsModelling);

        //add the students to the modules
        softwareEngineering.addStudents(mary);
        softwareEngineering.addStudents(john);
        machineLearning.addStudents(mary);
        machineLearning.addStudents(john);
        informationRetrieval.addStudents(james);
        informationRetrieval.addStudents(simon);
        informationRetrieval.addStudents(kerry);
        professionalSkills.addStudents(kerry);
        professionalSkills.addStudents(mary);
        professionalSkills.addStudents(john);
        systemsModelling.addStudents(mary);
        systemsModelling.addStudents(simon);


        //create courses
        Course computerScience = new Course("Computer Science", new DateTime(2018, 9, 5, 8, 30), new DateTime(2022, 5, 15, 7, 29));
        Course engineering = new Course("Engineering", new DateTime(2018, 9, 5, 8, 30), new DateTime(2022, 5, 15, 7, 29));
        Course informationTechnology = new Course("Information Technology", new DateTime(2018, 9, 5, 8, 30), new DateTime(2022, 5, 15, 7, 29));

        //create a list for the courses, then add the courses to the list
        List<Course> listCourses = new ArrayList<>();
        listCourses.add(computerScience);
        listCourses.add(engineering);
        listCourses.add(informationTechnology);

        //add courses to modules
        softwareEngineering.addCourses(computerScience);
        machineLearning.addCourses(computerScience);
        professionalSkills.addCourses(engineering);
        systemsModelling.addCourses(informationTechnology);
        informationRetrieval.addCourses(informationTechnology);

        //add student to course
        computerScience.addStudents(mary);
        computerScience.addStudents(john);
        computerScience.addStudents(james);
        computerScience.addStudents(simon);

        engineering.addStudents(mary);
        engineering.addStudents(john);
        engineering.addStudents(james);
        engineering.addStudents(kerry);

        informationTechnology.addStudents(mary);
        informationTechnology.addStudents(john);
        informationTechnology.addStudents(kerry);
        informationTechnology.addStudents(simon);


        System.out.println("List of courses with their respective modules" );
        //loop through the list of course objects
        for (Course course : listCourses){
            System.out.println(course.getCourseName());
            //loop through the list of module objects
            for (Module module : listModules) {
                //check if module belongs to the course
                if (module.getCourses().contains(course)) {
                    //print out the modules associated with the course
                    System.out.println(" " +module.getModuleName());
                }
            }
        }

        //loop through the list of student objects
        System.out.println("\n List of students and their usernames with their respective modules and courses" );
        for (Student student : listStudent) {
            System.out.println("\n Student:  "+ student.getName() + "  " + student.getUserName());
            //loop through the list of module objects
            for (Module m : listModules) {
                //check if module is associated with the student
                if (m.getStudents().contains(student)) {
                    //print out the modules associated with the student
                    System.out.println("  Respective Module :  " + m.getModuleName() );
                }
            }
            //loop through the list of course objects
            for (Course c : listCourses){
                //check if course is registered to the student
                if(c.getStudents().contains(student)){
                    //print out the courses associated with the student
                    System.out.println("   Courses Registered for : "+c.getCourseName());
                }
            }
        }
    }
}
