import java.util.ArrayList;
import java.util.Scanner;

class Student {
    int id;
    String name;
    double marks;

    Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Marks: " + marks;
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n----- Student Management System -----");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1: // Add Student
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume new line

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    list.add(new Student(id, name, marks));
                    System.out.println("Student Added!");
                    break;

                case 2: // View Students
                    if (list.isEmpty()) {
                        System.out.println("No records found.");
                    } else {
                        System.out.println("\n--- Student Records ---");
                        for (Student s : list) {
                            System.out.println(s);
                        }
                    }
                    break;

                case 3: // Update Student
                    System.out.print("Enter student ID to update: ");
                    int updateId = sc.nextInt();
                    boolean foundUpdate = false;

                    for (Student s : list) {
                        if (s.id == updateId) {
                            sc.nextLine(); // consume new line
                            System.out.print("Enter new name: ");
                            s.name = sc.nextLine();
                            System.out.print("Enter new marks: ");
                            s.marks = sc.nextDouble();
                            System.out.println("Record Updated!");
                            foundUpdate = true;
                            break;
                        }
                    }

                    if (!foundUpdate) {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4: // Delete Student
                    System.out.print("Enter student ID to delete: ");
                    int deleteId = sc.nextInt();
                    boolean foundDelete = false;

                    for (Student s : list) {
                        if (s.id == deleteId) {
                            list.remove(s);
                            System.out.println("Record Deleted!");
                            foundDelete = true;
                            break;
                        }
                    }

                    if (!foundDelete) {
                        System.out.println("Student not found!");
                    }
                    break;

                case 5: // Exit
                    System.out.println("Exiting Program...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
