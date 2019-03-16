package com.concretepage;

import javax.persistence.EntityManager;

import com.concretepage.entity.Employee;

public class JPADetachDemo {
	public static void main(String[] args) {
		EntityManager entityManager = JPAUtility.getEntityManager();
		Employee emp = entityManager.find(Employee.class, new Integer(1));
		System.out.println("Contains(before detach):"+ entityManager.contains(emp));
		//Detach entity
		entityManager.detach(emp);
		System.out.println("Contains(After detach):"+ entityManager.contains(emp));
		entityManager.close();
		JPAUtility.close();		
		System.out.println("Entity detached.");
	}
}


