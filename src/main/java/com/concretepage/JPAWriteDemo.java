package com.concretepage;

import javax.persistence.EntityManager;

import com.concretepage.entity.Employee;

public class JPAWriteDemo {
	public static void main(String[] args) {
	    hung();
	   
	}
	static void find(){
	    EntityManager entityManager = JPAUtility.getEntityManager();
		Employee emp1 = entityManager.find(Employee.class, new Integer(1));
		System.out.println(entityManager.contains(emp1));
		Employee emp2 = new Employee(2, "Suresh", "New Delhi");
		System.out.println(entityManager.contains(emp2));
		
		entityManager.close();
		JPAUtility.close();		
		System.out.println("Done");
	}
	
	static void hung(){
	    EntityManager entityManager = JPAUtility.getEntityManager();	
		
		long m= System.currentTimeMillis();
		for(int i=0;i<9001;i++)
		{
		// 
		Employee employee = new Employee(i, "Maasdsadhesh"+i, "Varanasdsadasi"+i);
		entityManager.persist(employee);
		// find();
		//Employee emp = entityManager.find(Employee.class, new Integer(1));
		if(i==9000)
		{
		    entityManager.getTransaction().begin();    
		entityManager.getTransaction().commit();
		}
		}
		
		System.err.println(System.currentTimeMillis()-m);
		
		entityManager.close();
		//JPAUtility.close();
		
		System.out.println("Entity saved.");
	}
	static void hung1(){
	    
	}
}

