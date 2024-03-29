package revision.streams;

import java.util.Objects;

public class Employee {
    private String name;
    private Integer salary;
    private String department;

    public Employee() {}

    public Employee(String name, int salary, String house) {
        this.name = name;
        this.salary = salary;
        this.department = house;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (!salary.equals(employee.salary)) return false;
        if (!Objects.equals(name, employee.name)) return false;
        return Objects.equals(department, employee.department);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + salary;
        result = 31 * result + (department != null ? department.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s of House %s(%d)", name, department, salary);
    }
}
