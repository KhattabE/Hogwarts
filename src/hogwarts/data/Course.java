package hogwarts.data;

import java.util.ArrayList;

public class Course {

    private String name;
    private Teacher teacher;
    private ArrayList<Student> students = new ArrayList<>();

    public Course(String name, ArrayList<Student> students, Teacher teacher) {
        this.name = name;
        this.students = students;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Student> addStudent(Student student){
        this.students.add(student);
        return students;
    }

    public ArrayList<Student> removeStudent(Student student){
        this.students.remove(student);
        return students;
    }


}
