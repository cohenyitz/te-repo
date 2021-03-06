package com.techelevator;

public class Employee {
	
	private int  employeeId;
	private String firstName;
	private String lastName;
	private String fullName;
	private String department;
	private double annualSalary;
	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the employeeId
	 */
	public int getEmployeeId() {
		return employeeId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @return the fullName
	 */
	public String getFullName() {
		this.fullName = lastName + "," + " " + firstName;
		return fullName;
		
	}
	/**
	 * @return the annualSalary
	 */
	public double getAnnualSalary() {
		return annualSalary;
	}

	public Employee(int employeeId, String firstName, String lastName, double salary) {
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.annualSalary = salary;
		
	
	}
	
	public void raiseSalary(double percent) {
		percent = (percent/ 100);
		double additionalSalary = (annualSalary * percent);
		annualSalary = annualSalary + additionalSalary;
		System.out.println(annualSalary);
	}

}
