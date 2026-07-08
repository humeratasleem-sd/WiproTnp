package OOPS_Inheritance.OptionalClass;

import java.util.Optional;

class Employee {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    void display() {
        System.out.println("Employee ID : " + id);
        System.out.println("Employee Name : " + name);
    }
}

class InvalidEmployeeException extends RuntimeException {
    InvalidEmployeeException(String message) {
        super(message);
    }
}

public class Problem3 {

    public static void main(String[] args) {

        Employee emp = null;

        try {
            Employee employee = Optional.ofNullable(emp)
                    .orElseThrow(() ->
                            new InvalidEmployeeException("Employee is null"));

            employee.display();

        } catch (InvalidEmployeeException e) {
            System.out.println(e.getMessage());
        }
    }
}