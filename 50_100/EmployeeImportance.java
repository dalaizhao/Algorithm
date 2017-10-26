package com.dalai.par;

import java.util.*;

//690. Employee Importance
public class EmployeeImportance {

	/*
	 * You are given a data structure of employee information, which includes the
	 * employee's unique id, his importance value and his direct subordinates' id.
	 * 
	 * For example, employee 1 is the leader of employee 2, and employee 2 is the
	 * leader of employee 3. They have importance value 15, 10 and 5, respectively.
	 * Then employee 1 has a data structure like [1, 15, [2]], and employee 2 has
	 * [2, 10, [3]], and employee 3 has [3, 5, []]. Note that although employee 3 is
	 * also a subordinate of employee 1, the relationship is not direct.
	 */
	public int getImportance(List<Employee> employees, int id) {

		int total = 0;
		Map<Integer, Employee> map = new HashMap<>();
		for (Employee employee : employees) {
			map.put(employee.id, employee);
		}
		Queue<Employee> queue = new LinkedList<>();
		queue.offer(map.get(id));
		while (!queue.isEmpty()) {
			Employee current = queue.poll();
			total += current.importance;
			for (int subordinate : current.subordinates) {
				queue.offer(map.get(subordinate));
			}
		}
		return total;
	}
}
