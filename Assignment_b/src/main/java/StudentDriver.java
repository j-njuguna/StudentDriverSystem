import org.joda.time.DateTime;

import javax.swing.plaf.synth.SynthDesktopIconUI;
import java.util.ArrayList;
import java.util.List;

public class StudentDriver {

    public static void main(String args[]) {

        //create 5 students
        Student mary = new Student(18280070, "Joy", 20, "05/03/2001");
        Student john = new Student(18278070, "Brian", 21, "05/03/2000");
        Student james = new Student(18289970, "Jessie", 22, "05/03/1999");
        Student kerry = new Student(18297070, "Olivia", 20, "05/03/2001");
        Student simon = new Student(18290070, "Gabriel", 21, "05/03/2000");

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
        machineLearning.addStudents(simon);
        machineLearning.addStudents(john);
        informationRetrieval.addStudents(james);
        informationRetrieval.addStudents(simon);
        informationRetrieval.addStudents(kerry);
        professionalSkills.addStudents(kerry);
        professionalSkills.addStudents(mary);
        professionalSkills.addStudents(john);
        systemsModelling.addStudents(kerry);
        systemsModelling.addStudents(mary);
        systemsModelling.addStudents(simon);

        //right way to add
        mary.addModules(softwareEngineering);
        john.addModules(softwareEngineering);
        mary.addModules(machineLearning);
        simon.addModules(machineLearning);
        john.addModules(machineLearning);
        james.addModules(informationRetrieval);
        simon.addModules(informationRetrieval);
        kerry.addModules(informationRetrieval);
        kerry.addModules(professionalSkills);
        mary.addModules(professionalSkills);
        john.addModules(professionalSkills);
        kerry.addModules(systemsModelling);
        mary.addModules(systemsModelling);
        simon.addModules(systemsModelling);


        //create courses
        Course computerScience = new Course("Computer Science", new DateTime(2018, 9, 5, 8, 30), new DateTime(2022, 5, 15, 7, 29));
        Course engineering = new Course("Engineering", new DateTime(2018, 9, 5, 8, 30), new DateTime(2022, 5, 15, 7, 29));
        Course informationTechnology = new Course("Information Technology", new DateTime(2018, 9, 5, 8, 30), new DateTime(2022, 5, 15, 7, 29));

        //create a list for the courses, then add the courses to the list
        List<Course> listCourses = new ArrayList<>();
        listCourses.add(computerScience);
        listCourses.add(engineering);
        listCourses.add(informationTechnology);

        //add the modules to the courses
        computerScience.addModules(softwareEngineering);
        computerScience.addModules(machineLearning);
        engineering.addModules(informationRetrieval);
        engineering.addModules(professionalSkills);
        informationTechnology.addModules(systemsModelling);
        informationTechnology.addModules(informationRetrieval);

        softwareEngineering.addCourses(computerScience);
        machineLearning.addCourses(computerScience);
        informationRetrieval.addCourses(engineering);
        professionalSkills.addCourses(engineering);
        systemsModelling.addCourses(informationTechnology);
        informationRetrieval.addCourses(informationTechnology);


        System.out.println("List of courses with their respective modules" );
        for (Course course : listCourses){
            System.out.println(course.getCourseName());
            for (Module module : listModules) {
                //check if module belongs to the course
                if (module.getCourses().contains(course)) {
                    System.out.println(" " +module.getModuleName());
                }
            }
        }
        //loop through the list of student objects
        System.out.println("\n List of students and their usernames with their respective modules and courses" );
        for (Student student : listStudent) {
            System.out.println(student.getName() + "  " + student.getUserName());
            //loop through the list of module objects
            for (Module m : listModules) {
                //print out the modules
                if (m.getStudents().contains(student)) {
                    System.out.println(" " + m.getModuleName() );
                }
            }
        }

        System.out.println("\n List of modules with their respective courses");
        for (Module module: listModules){
            System.out.println(module.getModuleName());
            for (Course course : listCourses) {
                //check if module belongs to the course
                if (course.getModules().contains(module)) {
                    System.out.println(" "+course.getCourseName());
                }
            }
        }
    }
}
