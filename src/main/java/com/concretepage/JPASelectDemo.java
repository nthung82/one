package com.concretepage;

import javax.persistence.EntityManager;

import com.concretepage.entity.Employee;



public class JPASelectDemo {
	public static void main(String[] args) {
		EntityManager entityManager = JPAUtility.getEntityManager();
		
		Employee emp = entityManager.find(Employee.class, new Integer(1));
		//Employee emp1 = entityManager.find(Employee.class, new Integer(2));
		System.out.println("Name:"+ emp.getName()+", City:"+ emp.getCity());
		JPAUtility.close();		
		System.out.println("Done12221");
	}
}
