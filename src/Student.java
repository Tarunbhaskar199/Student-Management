public class Student {
    private int rollNo;
    private String name;
    private String department;
    private String email;
    private String phone;

    // Constructor
    public Student(int rollNo, String name, String department, String email, String phone) {
        this.rollNo = rollNo;
        this.name = name;
        this.department = department;
        this.email = email;
        this.phone = phone;
    }

    // Getters
    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    // Setters (optional, in case you want to modify fields)
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
