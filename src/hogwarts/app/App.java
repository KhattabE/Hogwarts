package hogwarts.app;

import hogwarts.app.ui.TextUI;
import hogwarts.data.House;
import hogwarts.data.Student;

import java.util.ArrayList;

public class App {

    ArrayList<Student> students = new ArrayList<>();





    public void start(){
        System.out.println("--------------------------------------------");
        System.out.println("The application has started!");
        System.out.println("--------------------------------------------");

        TextUI ui = new TextUI(students, this);
        ui.showMenu();


    }


    public void listAllStudents() {
        for (Student student : students){
            System.out.printf("%s, age %d, house: %s%n",
                    student.getName(),
                    student.getAge(),
                    student.getHouse());
        }


    }







}
