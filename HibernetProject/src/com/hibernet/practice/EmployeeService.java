package com.hibernet.practice;

import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class EmployeeService {

	
	public Employee createEmployee(String firstName,String lastName)
	{
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		createEmployee(employee);
		return employee;
	}
	
	
	
	protected void createEmployee(Employee employee)
	{
		Session session = NexGSessionFactory.getSession();
		Transaction t= session.beginTransaction();
		session.persist(employee);
		t.commit();
		session.close();
	}
	
	
	public void findAllEmployee()
	{
		Session session = NexGSessionFactory.getSession();
		Transaction t= session.beginTransaction();
		Query namedQuery = session.createQuery("from Employee");
		List<Employee> employees =  namedQuery.list();
		if(employees!=null){
			for(Employee employee : employees){
				System.out.println("Id :"+employee.getId());
				System.out.println("Name :"+employee.getFirstName()+" "+employee.getLastName());
				System.out.println("------------------------------------------------");
			}
		}
		t.commit();
		session.close();
	}
	
	public Employee findEployeeById(Integer employeeId)
	{
		Session session = null;
		Employee employee = null;
		try {
			session = NexGSessionFactory.getSession();
			employee = (Employee) session.load(Employee.class, employeeId);
			System.out.println("Id :"+employee.getId());
			System.out.println("Name :"+employee.getFirstName()+" "+employee.getLastName());
			
			System.out.println("------------------------------------------------");
		} catch (ObjectNotFoundException e) {
			// TODO: handle exception
			System.out.println("Employee does not exist for Employee Id "+ employeeId);
			employee = null;
		}finally{
			session.close();
		}
		return employee;
	}
	
	public void updateEmployeeData(Integer employeeId,String firstName,String lastName){
		Session session =NexGSessionFactory.getSession();
		Transaction t =session.beginTransaction();
		Employee employee= findEployeeById(employeeId);
		if(employee!=null){
			employee.setFirstName(firstName);
			employee.setLastName(lastName);
		}
		t.commit();
		session.close();
		
	}
	
	public void deleteEmployeeData(Integer employeeId){
		Session session= NexGSessionFactory.getSession();
		
		Transaction t= session.beginTransaction();
		Employee employee = findEployeeById(employeeId);
		if (employee!=null){
			session.delete(employee);
		}
		t.commit();
		session.close();
		
	}
	
	/*public static void main(String[] args) {
		
		EmployeeService sd = new EmployeeService();
		//sd.createEmployee(sd.buildEmployee("Neha", "Das"));
		//sd.findEployeeById(1);
	//	sd.findEployeeById(2);
		//sd.findEployeeById(12);
		//sd.updateEmployeeData(15, "Partha", "Das");
		sd.deleteEmployeeData(1);
	}*/

}
