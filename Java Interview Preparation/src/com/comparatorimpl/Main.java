package com.comparatorimpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "John", "Male", "Manager", 60000, "HR", 40));
        list.add(new Employee(2, "Alice", "Female", "Developer", 60000, "IT", 28));
        list.add(new Employee(3, "Bob", "Male", "Tester", 50000, "QA", 28));
        list.add(new Employee(4, "John", "Male", "Architect", 90000, "IT", 35));
        list.add(new Employee(5, "Alice", "Female", "Analyst", 55000, "Finance", 28));
        
        Collections.sort(list, new SortEmpByNameSal());
        for(Employee e : list) {
        	System.out.println(e);
        }
        System.out.println();
        
        Collections.sort(list, new SortEmpByAgeSal());
        for(Employee e : list) {
        	System.out.println(e);
        }

	}

}
