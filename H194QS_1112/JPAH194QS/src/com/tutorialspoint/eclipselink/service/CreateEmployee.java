package com.tutorialspoint.eclipselink.service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import com.tutorialspoint.eclipselink.entity.Employee;

public class CreateEmployee {

	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Employee employee1 = new Employee();
		employee1.setEid(1201);
		employee1.setEname("Nagy Gábor");
		employee1.setSalary(40000);
		employee1.setDeg("Programmer");
		entitymanager.persist(employee1);

		Employee employee2 = new Employee();
		employee2.setEid(1202);
		employee2.setEname("Sáros Sándor");
		employee2.setSalary(25000);
		employee2.setDeg("Manager");
		entitymanager.persist(employee2);		

		Employee employee3 = new Employee();
		employee3.setEid(1203);
		employee3.setEname("Koszos Sanyi");
		employee3.setSalary(12000);
		employee3.setDeg("Technical Manager");
		entitymanager.persist(employee3);

		Employee employee4 = new Employee();
		employee4.setEid(1204);
		employee4.setEname("Nyilas Károly");
		employee4.setSalary(62000);
		employee4.setDeg("Webprogrammer");
		entitymanager.persist(employee4);
		
		Employee employee5 = new Employee();
		employee5.setEid(1205);
		employee5.setEname("Fekete Ferenc");
		employee5.setSalary(80000);
		employee5.setDeg("Developer");
		entitymanager.persist(employee5);
		
		Employee employee6 = new Employee();
		employee6.setEid(1206);
		employee6.setEname("Ördög Dániel");
		employee6.setSalary(99000);
		employee6.setDeg("Hacker");
		entitymanager.persist(employee6);		
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}

}
