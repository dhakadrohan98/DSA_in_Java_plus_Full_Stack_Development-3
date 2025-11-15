package com.comparatorimpl;

import java.util.Comparator;

public class SortEmpByNameSal implements Comparator<Employee> {
	
	//if name are same then sort by salary in descending order otherwise sort in the lexicographical order based on name
	@Override
	public int compare(Employee e1, Employee e2) {
		if(!e1.getName().equals(e2.getName())) {
			return e1.getName().compareToIgnoreCase(e2.getName());
		}
		return (int) (e2.salary - e1.salary);
	}

}
