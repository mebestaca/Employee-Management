package management.controller.employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import management.exception.RepositoryExceptions;
import management.interfaces.Controller;
import management.model.Employee;
import management.service.Repository;
import management.utility.InputReader;
import management.utility.RuleFactory;
import management.view.employee.EditEmployeeView;

public class EditEmployeeController implements Controller{

	EditEmployeeView editEmployeeView = new EditEmployeeView();
	
	@Override
	public void run() {
		Repository repo = Repository.getInstance();
		if (repo.getEmployees().isEmpty()) {
			System.err.println("Error: No available employees to edit.");
			return;
		}
		
		editEmployeeView.display();
		
		int id;
		Employee employee = null;
		while (true) {
			id = InputReader.readInt("Enter employee id (-1 to abort): ", 
				RuleFactory.notEmpty("employee id"),
				RuleFactory.isInt("employee id"));
			
			if (id == -1) return;
			employee = repo.getEmployee(id);
			if (employee == null) 
				System.err.println("Error: Employee does not exist.");
			else
				break;
		}
		
		// firstname
		String firstname = InputReader.readString("Enter firstname: ", 
				RuleFactory.notEmpty("firstname"),
				RuleFactory.lengthCheck("firstname", 3, 40));
		
		// lastname
		String lastname = InputReader.readString("Enter lastname: ", 
				RuleFactory.notEmpty("lastname"),
				RuleFactory.lengthCheck("lastname", 3, 40));
		
		// date hired
		Date dateHired;
		String dateHiredInput = InputReader.readString("Enter date hired (yyyy-MM-dd): ", 
				RuleFactory.notEmpty("date hired"),
				RuleFactory.isDate("date hired", "yyyy-MM-dd"));
		try {
			dateHired = new SimpleDateFormat("yyyy-MM-dd").parse(dateHiredInput);
		} catch (ParseException e) {
		    throw new RuntimeException(e);
		}
		
		// birthday
		Date birthday;
		String birthdayInput = InputReader.readString("Enter birthday (yyyy-MM-dd): ", 
				RuleFactory.notEmpty("birthday"),
				RuleFactory.isDate("birthday", "yyyy-MM-dd"));
		try {
		    birthday = new SimpleDateFormat("yyyy-MM-dd").parse(birthdayInput);
		} catch (ParseException e) {
		    throw new RuntimeException(e);
		}
		
		// email
		String email = InputReader.readString("Enter email: ", 
				RuleFactory.notEmpty("email"),
				RuleFactory.lengthCheck("email", 3, 40),
				RuleFactory.isEmail("email"));
		
		// gender
		String gender = InputReader.readString("Enter gender: ", 
				RuleFactory.notEmpty("gender"),
				RuleFactory.lengthCheck("gender", 1, 40));
		
		// phone number
		long phoneNumber;
		String phoneInput = InputReader.readString("Enter phone number: ",
				RuleFactory.lengthCheck("phone number", 10, 10),
				RuleFactory.isLong("phone number"));
		phoneNumber = Long.parseLong(phoneInput);
		
		// address
		String address = InputReader.readString("Enter address: ", 
				RuleFactory.notEmpty("address"),
				RuleFactory.lengthCheck("address", 3, 40));
		
		// status
		String status = InputReader.readString("Enter employment status: ", 
				RuleFactory.notEmpty("employment status"),
				RuleFactory.lengthCheck("employment status", 3, 40));

		// department
		int department;
		while(true) {
			department = InputReader.readInt("Enter department number (-1 to abort): ", 
					RuleFactory.notEmpty("department number"),
					RuleFactory.isInt("department number"));
			if (department == -1) return;
			if (repo.getDepartment(department) == null) 
			    System.err.println("Error: Department does not exist.");
			else
				break;
		}

		employee.setFirstName(firstname);
		employee.setLastName(lastname);
		employee.setDateHired(dateHired);
		employee.setDateOfBirth(birthday);
		employee.setEmail(email);
		employee.setGender(gender);
		employee.setPhoneNumber(phoneNumber);
		employee.setAddress(address);
		employee.setEmploymentStatus(status);
		employee.setDepartmentId(department);
				
		try {
			repo.edit(employee);
		} catch (RepositoryExceptions e) {
			e.printStackTrace();
		}		
		
	}
}
