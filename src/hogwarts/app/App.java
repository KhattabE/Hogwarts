package hogwarts.app;

import hogwarts.app.ui.TextUI;
import hogwarts.data.House;
import hogwarts.data.Student;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    ArrayList<Student> students = new ArrayList<>();


    public void loadStudents(){
        House slytherin = new House("Slytherin");
        House gryffindor = new House("Gryffindor");
        House ravenclaw = new House("Ravenclaw");
        House hufflepuff = new House("Hufflepuff");

        try {
            File file = new File("students.csv");
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("[;\n\r]+");
            String header = scanner.nextLine(); // skip header

            while (scanner.hasNext()) {
                String studentName = scanner.next();
                String houseName = scanner.next();
                int studentAge = scanner.nextInt();

                House studentHouse = new House(houseName); // or reuse existing objects

                Student studentss = new Student(studentName, studentHouse, studentAge);
                students.add(studentss);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        System.out.println("There are " + students.size() + " students in the system:");
        System.out.println("===========================================");
        for (Student s : students) {
            System.out.println(s.getName() + " - age " + s.getAge() + " - house: " + s.getHouse().getName());
        }



    }




    public void start(){
        System.out.println("--------------------------------------------");
        System.out.println("The application has started!");
        System.out.println("--------------------------------------------");

        loadStudents();
        TextUI ui = new TextUI(students, this);
        ui.showMenu();
        saveStudents();


    }


    public void listAllStudents() {
        for (Student student : students){
            System.out.printf("%s, age %d, house: %s%n",
                    student.getName(),
                    student.getAge(),
                    student.getHouse());
        }


    }


    public void saveStudents(){
        System.out.println("Saving students");

        PrintStream output = System.out;
        for (Student student : students){
            output.println(student.getName() + ";" + student.getHouse() + ";" + student.getAge());
        }
    }







}
