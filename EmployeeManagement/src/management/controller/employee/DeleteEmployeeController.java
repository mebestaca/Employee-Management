package management.controller.employee;

import management.exception.RepositoryExceptions;
import management.interfaces.Controller;
import management.model.Employee;
import management.service.Repository;
import management.utility.InputReader;
import management.utility.RuleFactory;
import management.view.employee.DeleteEmployeeView;

public class DeleteEmployeeController implements Controller{

	DeleteEmployeeView deleteEmployee = new DeleteEmployeeView();
	
	@Override
	public void run() {
		Repository repo = Repository.getInstance();
		if (repo.getEmployees().isEmpty()) {
			System.err.println("Error: No available employees to delete.");
			return;
		}
		
		deleteEmployee.display();
		
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
		
		
		String response = InputReader.readString("Are you sure you want to delete " 
				+ employee.getFirstName() + " " + employee.getLastName() + "(Y/N)? : ", 
			RuleFactory.notEmpty("Response"),
			RuleFactory.responseYN("Response"));
		
		if (response.trim().toLowerCase().equals("y")) {
			try {
				repo.delete(employee);
			} catch (RepositoryExceptions e) {
				e.printStackTrace();
			}
		}
	}
}
