package hogwarts.app.ui;

import hogwarts.app.App;
import hogwarts.data.House;
import hogwarts.data.Student;

import java.util.ArrayList;
import java.util.Scanner;


public class TextUI {

    private ArrayList<Student> students;
    private App app;


    public TextUI(ArrayList<Student> students, App app) {
        this.students = students;
        this.app =  app;
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
                case 1 -> app.listAllStudents();
                case 2 -> createNewStudent();
                case 3 -> System.exit(0);

            }


        }


    }

    public void createNewStudent() {
        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        System.out.print("Enter student age: ");
        int studentAge = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter student house: ");
        String houseName = scanner.nextLine();

        House studentHouse = new House(houseName);

        Student studentss = new Student(studentName, studentHouse, studentAge);
        students.add(studentss);

    }




}
