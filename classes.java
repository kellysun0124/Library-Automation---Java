package javaString;

class Person {
    private String name;
    private String address;
    private Date dob;
    private String email;
    private String ssn;

    // constructors, getters, and setters
}

class Employee extends Person {
    private String employeeID;
    private Date hireDate;
    private double salary;

    // constructors, getters, and setters
}

class Member extends Person {
    private String memberID;
    private Date membershipStartDate;
    private Date membershipEndDate;

    // constructors, getters, and setters
}

class Librarian extends Employee {
    private String librarianID;
    private String libraryBranch;

    // constructors, getters, and setters
}

class Technician extends Employee {
    private String technicianID;
    private String department;

    // constructors, getters, and setters
}

class Student extends Member {
    private String studentID;
    private String major;

    // constructors, getters, and setters
}

class Professor extends Member {
    private String professorID;
    private String department;

    // constructors, getters, and setters
}

class External extends Member {
    private String organizationName;

    // constructors, getters, and setters
}
