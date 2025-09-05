import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection conn;

    // Constructor: connect to MySQL
public StudentDAO() {
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection(
            "jdbc:mysql://localhost:3306/student_db", "root", "Tarun@199");
        System.out.println("Connected to MySQL successfully!");
    } catch (ClassNotFoundException e) {
        System.out.println("MySQL JDBC Driver not found!");
        e.printStackTrace();
    } catch (SQLException e) {
        System.out.println("Connection failed! Check MySQL server, database, username, and password.");
        e.printStackTrace();
    }
}


    // Add student
    public void addStudent(Student s) {
        String sql = "INSERT INTO students (roll_no, name, department, email, phone) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, s.getRollNo());
            stmt.setString(2, s.getName());
            stmt.setString(3, s.getDepartment());
            stmt.setString(4, s.getEmail());
            stmt.setString(5, s.getPhone());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Update student name
    public void updateStudent(int rollNo, String oldName, String newName) {
        String sql = "UPDATE students SET name=? WHERE roll_no=? AND name=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, newName);
            stmt.setInt(2, rollNo);
            stmt.setString(3, oldName);
            int rows = stmt.executeUpdate();
            if (rows == 0) {
                System.out.println("No student found with roll no " + rollNo + " and name " + oldName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all students
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM students";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student(
                    rs.getInt("roll_no"),
                    rs.getString("name"),
                    rs.getString("department"),
                    rs.getString("email"),
                    rs.getString("phone")
                );
                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
