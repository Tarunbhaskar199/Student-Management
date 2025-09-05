import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO(); // MySQL-connected DAO

        while (true) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student Name");
            System.out.println("3. View All Students");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    // --- Add Student ---
                    System.out.print("Enter roll number: ");
                    int rollNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter email: ");
                    String email = sc.nextLine();

                    System.out.print("Enter phone: ");
                    String phone = sc.nextLine();

                    // Create Student object
                    Student s = new Student(rollNo, name, department, email, phone);
                    dao.addStudent(s);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    // --- Update Student Name ---
                    System.out.print("Enter roll number to update: ");
                    int updateRoll = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter old name: ");
                    String oldName = sc.nextLine();

                    System.out.print("Enter new name: ");
                    String newName = sc.nextLine();

                    dao.updateStudent(updateRoll, oldName, newName);
                    System.out.println("Student updated successfully!");
                    break;

                case 3:
                    // --- View All Students ---
                    List<Student> students = dao.getAllStudents();
                    if (students.isEmpty()) {
                        System.out.println("No students found!");
                    } else {
                        System.out.printf("%-10s %-20s %-15s %-25s %-15s%n",
                                "Roll No", "Name", "Department", "Email", "Phone");
                        System.out.println("-------------------------------------------------------------------------------");
                        for (Student st : students) {
                            System.out.printf("%-10d %-20s %-15s %-25s %-15s%n",
                                    st.getRollNo(), st.getName(), st.getDepartment(),
                                    st.getEmail(), st.getPhone());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
