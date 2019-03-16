package com.concretepage;

import javax.persistence.EntityManager;

import com.concretepage.entity.Employee;

public class JPARemoveDemo {
	public static void main(String[] args) {
		EntityManager entityManager = JPAUtility.getEntityManager();	
		Employee emp = entityManager.find(Employee.class, new Integer(1));
		//start removing
		entityManager.getTransaction().begin();
		entityManager.remove(emp);
		entityManager.getTransaction().commit();
		entityManager.close();
		JPAUtility.close();		
		System.out.println("Entity removed.");
	}
}

