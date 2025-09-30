package hogwarts.data;

public class Student {

    private String id;
    private String name;
    private House house;
    private int age;


    public Student(String name, House house, int age) {
        this.name = name;
        this.house = house;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public House getHouse() {
        return house;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
