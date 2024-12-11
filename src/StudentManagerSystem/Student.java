package StudentManagerSystem;

public class Student {

    //Private attributes for the students
    private final String id;
    private final String name;
    private final String grade;

    //Constructor
    public Student(String id, String name, String grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    //Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGrade() {
        return grade;
    }

    //Represents the object as a String in this format when written
    @Override
    public String toString() {
        System.out.print("Student-> ");
        return "[ID = " + id + ", NAME = " + name + ", GRADE = " + grade + "]";
    }


}
