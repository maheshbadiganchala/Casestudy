package com.casestudy;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection="StaffServices")
public class Staff {
	
	@Id
	private String id;
	private String employeeName;
	private String employeeAddress;
	private String nic;
	private String salary;
	private String age;
	private String occupation;
	private String email;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public String getSalary() {
		return salary;
	}
	public void setSalary(String salary) {
		this.salary = salary;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Staff(String id, String employeeName, String employeeAddress, String nic, String salary, String age,
			String occupation, String email) {
		super();
		this.id = id;
		this.employeeName = employeeName;
		this.employeeAddress = employeeAddress;
		this.nic = nic;
		this.salary = salary;
		this.age = age;
		this.occupation = occupation;
		this.email = email;
	}
	@Override
	public String toString() {
		return "Staff [id=" + id + ", employeeName=" + employeeName + ", employeeAddress=" + employeeAddress + ", nic="
				+ nic + ", salary=" + salary + ", age=" + age + ", occupation=" + occupation + ", email=" + email + "]";
	}

	
}
