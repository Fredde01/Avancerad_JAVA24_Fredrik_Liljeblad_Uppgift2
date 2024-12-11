package StudentManagerSystem;

import Manager.StudentManager;

import java.util.Scanner;

public class Menu {
    //Private attribute
    private final StudentManager manager;

    //Constructor for calling the instance from StudentManager
    public Menu() {
        manager = StudentManager.getInstance();
    }

    //A method that gives the user different choices for handling students
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("---Menu---");
            System.out.println("1. Add Student");
            System.out.println("2. Find student with ID");
            System.out.println("3. Show all students");
            System.out.println("4. Load all students from file");
            System.out.println("5. Save all students to file");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            //Checking what choice the user picks
            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;

                case 2:
                    findStudent(scanner);
                    break;

                case 3:
                    showAllStudents();
                    break;

                case 4:
                    loadStudents();
                    break;

                case 5:
                    saveStudents();
                    break;

                case 6:
                    System.out.println("Exiting the program...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice, try again.");
            }
        }

    }

    //Private method for adding student/giving them special details
    private void addStudent(Scanner scanner) {
        System.out.println("Enter student ID: ");
        String studentID = scanner.nextLine();

        System.out.println("Enter student name: ");
        String studentName = scanner.nextLine();

        System.out.println("Enter student grade: ");
        String grade = scanner.nextLine();
        manager.addStudent(new Student(studentID, studentName, grade));
        System.out.println("Student added successfully.");
    }

    //A private method for finding student via ID
    private void findStudent(Scanner scanner) {
        System.out.println("Enter student ID: ");
        String id = scanner.nextLine();
        Student student = manager.getStudentById(id);

        if(student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }

    }

    //A private method for showing all
    private void showAllStudents() {
        manager.showAllStudents();
    }

    //A private method for loading student details
    private void loadStudents() {
        manager.loadFromFile();
    }

    //A private method for saving student details
    private void saveStudents() {
        manager.saveToFile();
    }

}
