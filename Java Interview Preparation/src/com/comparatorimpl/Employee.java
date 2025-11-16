package com.comparatorimpl;

public class Employee {
    public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getDesignation() {
		return designation;
	}

	public double getSalary() {
		return salary;
	}

	public String getDeptName() {
		return deptName;
	}

	public int getAge() {
		return age;
	}

	int id;
    String name;
    String gender;
    String designation;
    double salary;
    String deptName;
    int age;

    public Employee(int id, String name, String gender, String designation,
                    double salary, String deptName, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.designation = designation;
        this.salary = salary;
        this.deptName = deptName;
        this.age = age;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + gender + " | " + designation +
               " | " + salary + " | " + deptName + " | " + age;
    }
}
