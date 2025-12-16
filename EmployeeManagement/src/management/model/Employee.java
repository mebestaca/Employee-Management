package management.model;

import java.util.Date;

public class Employee {
	int id;
	String firstName;
	String lastName;
	Date dateHired;
	int departmentId;
	Date dateOfBirth;
	String email;
	String gender;
	long phoneNumber;
	String address;
	String employmentStatus;
	
	private Employee(Builder builder) {
		this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.dateHired = builder.dateHired;
        this.departmentId = builder.departmentId;
        this.dateOfBirth = builder.dateOfBirth;
        this.email = builder.email;
        this.gender = builder.gender;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
        this.employmentStatus = builder.employmentStatus;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateHired() {
		return dateHired;
	}

	public void setDateHired(Date dateHired) {
		this.dateHired = dateHired;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmploymentStatus() {
		return employmentStatus;
	}

	public void setEmploymentStatus(String employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dateHired=" + dateHired
				+ ", departmentId=" + departmentId + ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", gender="
				+ gender + ", phoneNumber=" + phoneNumber + ", address=" + address + ", employmentStatus="
				+ employmentStatus + "]";
	}
	
	public static class Builder {
		int id;
		String firstName;
		String lastName;
		Date dateHired;
		int departmentId;
		Date dateOfBirth;
		String email;
		String gender;
		long phoneNumber;
		String address;
		String employmentStatus;
		
		public Builder(int id) {
			this.id = id;
		}
		
        public Builder firstName(String firstName) { this.firstName = firstName; return this; }
        public Builder lastName(String lastName) { this.lastName = lastName; return this; }
        public Builder dateHired(Date dateHired) { this.dateHired = dateHired; return this; }
        public Builder departmentId(int departmentId) { this.departmentId = departmentId; return this; }
        public Builder dateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; return this; }
        public Builder email(String email) { this.email = email; return this; }
        public Builder gender(String gender) { this.gender = gender; return this; }
        public Builder phoneNumber(long phoneNumber) { this.phoneNumber = phoneNumber; return this; }
        public Builder address(String address) { this.address = address; return this; }
        public Builder employmentStatus(String employmentStatus) { this.employmentStatus = employmentStatus; return this; }
		
		public Employee build() {
            return new Employee(this);
        }
	}
}
