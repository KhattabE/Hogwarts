package hogwarts.app.ui;

import hogwarts.data.House;
import hogwarts.data.Student;

import java.util.ArrayList;
import java.util.Scanner;


public class TextUI {

    private ArrayList<Student> students;


    public TextUI(ArrayList<Student> students) {
        this.students = students;
    }

    Scanner scanner = new Scanner(System.in);




    public void showMenu(){

        int userChoice = -1;

        while (userChoice != 3){
            System.out.println("--------------------------------------------");
            System.out.println("You got the following options: ");
            System.out.println("1: List all students: ");
            System.out.println("2: Create new student: ");
            System.out.println("3: Exit");
            System.out.println("--------------------------------------------");

            System.out.print("Enter your choice: ");
            userChoice = Integer.parseInt(scanner.nextLine());

            while (userChoice < 1 || userChoice > 3){
                System.out.println("Must be a number from 1-3!");
                System.out.print("Try Again: ");
                userChoice = Integer.parseInt(scanner.nextLine());
            }

            switch (userChoice){
                case 1 -> listAllStudents();
                case 2 -> createNewStudent();
                case 3 -> System.exit(0);
            }

            userChoice = -1;
        }


    }

    private void loadStudents() {
        // Opret huse
        House gryffindor = new House("Gryffindor");
        House slytherin = new House("Slytherin");
        House ravenclaw = new House("Ravenclaw");
        House hufflepuff = new House("Hufflepuff");

        // Opret studerende (navn, hus, alder)
        Student harry = new Student("Harry Potter", gryffindor, 17);
        Student ron = new Student("Ronald Weasley", gryffindor, 17);
        Student hermione = new Student("Hermione Granger", gryffindor, 17);

        // Tilføj til listen
        students.add(harry);
        students.add(ron);
        students.add(hermione);
    }

    private void listAllStudents() {
        System.out.println("\nList of all students:");
        System.out.println("----------------------");

        for (Student student : students) {
            System.out.println("Name: " + student.getName());
            System.out.println("House: " + student.getHouse().getName());
            System.out.println("Age: " + student.getAge());
            System.out.println();
        }

        System.out.println("----------------------\n");
    }

    private void createNewStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student age: ");
        int age = Integer.parseInt(scanner.nextLine());

        System.out.println("Choose a house:");
        System.out.println("1. Gryffindor");
        System.out.println("2. Slytherin");
        System.out.println("3. Ravenclaw");
        System.out.println("4. Hufflepuff");

        int houseChoice = Integer.parseInt(scanner.nextLine());
        House selectedHouse = null;

        switch (houseChoice) {
            case 1 -> selectedHouse = new House("Gryffindor");
            case 2 -> selectedHouse = new House("Slytherin");
            case 3 -> selectedHouse = new House("Ravenclaw");
            case 4 -> selectedHouse = new House("Hufflepuff");
            default -> {
                System.out.println("Invalid choice. Student not created.");
                return;
            }
        }

        Student newStudent = new Student(name, selectedHouse, age);
        students.add(newStudent);

        System.out.println("Student successfully created!\n");
    }


}
