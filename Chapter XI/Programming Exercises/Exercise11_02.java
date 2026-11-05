import java.time.*;

public class Exercise11_02 {
    public static void main(String[] args) {
        Person person = new Person();
        person.setName("George");
        person.setE_Mail("thegeorge@email.com");
        System.out.println(person.toString());

        Student student = new Student(3);
        student.setName("Peter");
        System.out.println(student.toString());

        Employee employee = new Employee();
        employee.setName("Ivan");
        employee.setSalary(1500.00);
        System.out.println(employee.toString());

        Faculty faculty = new Faculty();
        faculty.setName("Alex");
        faculty.setRank("Head of Faculty");
        faculty.setSalary(2500);
        System.out.println(faculty.toString());

        Staff staff = new Staff();
        staff.setName("Naomi");
        staff.setTitle("Head of Staff");
        staff.setSalary(5000);
        System.out.println(staff.toString());
    }
}

class MyDate {
    private int year;
    private int month;
    private int day;

    public MyDate() {
        setDate(System.currentTimeMillis());
    }

    public MyDate(long elapsedTime) {
        setDate(elapsedTime);
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setDate(long elapsedTime) {
        LocalDate date = Instant.ofEpochMilli(elapsedTime).atZone(ZoneOffset.UTC).toLocalDate();
        this.year = date.getYear();
        this.month = date.getMonthValue();
        this.day = date.getDayOfMonth();
    }
    
}

class Person {
    protected String name = "N/A";
    protected String address = "N/A";
    protected String phoneNumber = "N/A";
    protected String e_Mail = "N/A";

    public Person() {
    }

    public Person(String name, String address, String phoneNumber, String e_Mail) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.e_Mail = e_Mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNUmber) {
        this.phoneNumber = phoneNUmber;
    }

    public String getE_Mail() {
        return e_Mail;
    }

    public void setE_Mail(String e_Mail) {
        this.e_Mail = e_Mail;
    }

    public String toString() {
        return "Class name: " + Person.class.getName() +
        "\nPerson name: " + this.name;
    }
}

class Student extends Person {
    private int index = 0;
    final private String[] status = {"freshman", "sophomore", "junior", "senior"};
    final private String classStatus = assignStatus(index);

    public Student() {}

    public Student(int index) {
        this.index = index <= 3 && index > 0 ? index : 0;
    }

    private String assignStatus(int index) {
        return this.status[index];
    }

    public String getStatus() {
        return this.classStatus;
    }

    @Override
    public String toString() {
        return "Class name: " + Student.class.getName() +
        "\nPerson name: " + this.name;
    }
}

class Employee extends Person{
    protected String office = "N/A";
    protected double salary = 0.00;
    protected MyDate dateHired;

    public Employee() {
        this.dateHired = new MyDate();
    }

    public Employee(String office, double salary, MyDate dateHired) {
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public MyDate getDate() {
        return dateHired;
    }

    public void setDate(MyDate dateHired) {
        this.dateHired = dateHired;
    }

    @Override
    public String toString() {
        return "Class name: " + Employee.class.getName() +
        "\nPerson name: " + this.name;
    }
}

class Faculty extends Employee {
    protected int officeHours = 0;
    protected String rank = "N/A";

    public Faculty() {}
    public Faculty(int officeHours, String rank) {
        this.officeHours = officeHours;
        this.rank = rank;
    }

    public int getOfficeHours() {
        return officeHours;
    }

    public void setOfficeHours(int officeHours) {
        this.officeHours = officeHours;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Class name: " + Faculty.class.getName() +
        "\nPerson name: " + this.name;
    }
}

class Staff extends Employee {
    protected String title = "N/A";

    public Staff() {}
    public Staff(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Class name: " + Staff.class.getName() +
        "\nPerson name: " + this.name;
    }
}
