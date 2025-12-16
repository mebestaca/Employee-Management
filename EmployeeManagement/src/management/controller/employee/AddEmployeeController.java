package management.controller.employee;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import management.exception.RepositoryExceptions;
import management.interfaces.Controller;
import management.model.Employee;
import management.service.Repository;
import management.service.Sequence;
import management.utility.InputReader;
import management.utility.RuleFactory;
import management.view.employee.AddEmployeeView;

public class AddEmployeeController implements Controller{

	AddEmployeeView addEmployeeView = new AddEmployeeView();
	
	@Override
	public void run() {
		Repository repo = Repository.getInstance();
		if (repo.getDepartments().isEmpty()) {
			System.err.println("Error: Unable to add employee. There are no available departments.");
			return;
		}
		
		addEmployeeView.display();
		
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

		Sequence.init();
		int seq = Sequence.Employee.next();
		Employee employee = new Employee.Builder(seq)
				.firstName(firstname)
				.lastName(lastname)
				.dateHired(dateHired)
				.dateOfBirth(birthday)
				.email(email)
				.gender(gender)
				.phoneNumber(phoneNumber)
				.address(address)
				.employmentStatus(status)
				.departmentId(department)
				.build();
		try {
			repo.add(employee);
		} catch (RepositoryExceptions e) {
			e.printStackTrace();
		}
	}
}
