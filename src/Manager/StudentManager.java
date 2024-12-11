package Manager;

import StudentManagerSystem.Student;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class StudentManager {
    //Private attributes
    private static StudentManager instance;
    private final Map<String, Student> studentMap;
    private static final String fileName = "students.txt";

    //Creating a method with a hashmap
    private StudentManager() {
        studentMap = new HashMap<>();
    }

    //A method for making sure there is only one instance of the StudentManager class
    public static StudentManager getInstance() {
        if (instance == null) {
            instance = new StudentManager();
        }
        return instance;
    }

    //Method for adding a new student
    public void addStudent(Student student) {
        studentMap.put(student.getId(), student);
    }

    //Method for finding a student by ID
    public Student getStudentById(String id) {
        return studentMap.get(id);
    }

    //Method for showing all added students
    public void showAllStudents() {
        if (studentMap.isEmpty()) {
            System.out.println("No students found.");
        } else {
            studentMap.values().forEach(System.out::println);
        }
    }

    //Method for saving added students to file
    public void saveToFile() {
        File file = new File(fileName);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (Student student : studentMap.values()) {
                writer.write(student.getId() + "," + student.getName() + "," + student.getGrade());
                writer.newLine();
            }
            System.out.println("Students saved to: " + fileName);
        } catch (IOException e) {
            System.err.println("Couldn't save to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //Method for loading students from file
    public void loadFromFile() {
        File file = new File(fileName);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 3) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String grade = parts[2].trim();
                    Student student = new Student(id, name, grade);
                    studentMap.put(id, student);
                } else {
                    System.err.println("Malformed line: " + line);
                }
            }
            System.out.println("Students loaded from: " + fileName);
        } catch (FileNotFoundException e) {
            System.err.println("Student file not found: " + fileName);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Couldn't read from file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}




