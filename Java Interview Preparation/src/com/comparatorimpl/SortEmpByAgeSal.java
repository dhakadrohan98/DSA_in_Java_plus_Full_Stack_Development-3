package com.comparatorimpl;

import java.util.Comparator;

public class SortEmpByAgeSal implements Comparator<Employee> {

	@Override
	public int compare(Employee e1, Employee e2) {
		if(e1.age == e2.age) {
			return (int) (e2.salary - e1.salary);
		}
		return e1.age - e2.age;
	}

}
