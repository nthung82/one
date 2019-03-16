package com.concretepage;

import javax.persistence.EntityManager;

import com.concretepage.entity.Employee;

public class JPAUpdateDemo {
	public static void main(String[] args) {
		EntityManager entityManager = JPAUtility.getEntityManager();	
		Employee emp = entityManager.find(Employee.class, new Integer(1));
		System.out.println("Name:"+ emp.getName()+", City:"+ emp.getCity());
		//start updating
		entityManager.getTransaction().begin();
		emp.setName("Krishna");
		emp.setCity("Allahabad");
		entityManager.getTransaction().commit();
		emp = entityManager.find(Employee.class, new Integer(1));
		entityManager.close();
		JPAUtility.close();				
		System.out.println("Name:"+ emp.getName()+", City:"+ emp.getCity());
		System.out.println("Entity updated.");
	}
}

