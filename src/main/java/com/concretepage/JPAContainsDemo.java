package com.concretepage;

import javax.persistence.EntityManager;

import com.concretepage.entity.Employee;

public class JPAContainsDemo {
	public static void main(String[] args) {
	    find();
	}
	static void find(){
	    EntityManager entityManager = JPAUtility.getEntityManager();
		Employee emp1 = entityManager.find(Employee.class, new Integer(1));
		System.out.println(entityManager.contains(emp1));
		Employee emp2 = new Employee(2, "Suresh", "New Delhi");
		System.out.println(entityManager.contains(emp2));
		entityManager.close();
		JPAUtility.close();		
		System.out.println("Done111");
	}
}

