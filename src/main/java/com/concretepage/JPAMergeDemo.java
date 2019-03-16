package com.concretepage;

import javax.persistence.EntityManager;

import com.concretepage.entity.Employee;

public class JPAMergeDemo {
	public static void main(String[] args) {
		EntityManager entityManager = JPAUtility.getEntityManager();
		//fetch entity
		Employee emp = entityManager.find(Employee.class, new Integer(1));
		System.out.println("Name:"+emp.getName()+","+ "City: "+ emp.getCity());
		System.out.println("Contains(before detach):"+ entityManager.contains(emp));
		//detach entity
		entityManager.detach(emp);
		System.out.println("Contains(After detach):"+ entityManager.contains(emp));
		//merge entity
		entityManager.getTransaction().begin();
		emp.setName("Brahma");
		emp.setCity("Kanpxcvcxvur");
		emp = entityManager.merge(emp);
		entityManager.getTransaction().commit();
		System.out.println("Contains(After merge):"+ entityManager.contains(emp));
		System.out.println("Name:"+emp.getName()+","+ "City: "+ emp.getCity());		
		entityManager.close();
		JPAUtility.close();		
		System.out.println("Entity merged.");
	}
}


