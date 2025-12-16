package management.controller.department;

import management.exception.RepositoryExceptions;
import management.interfaces.Controller;
import management.model.Department;
import management.model.Employee;
import management.service.Repository;
import management.utility.InputReader;
import management.utility.RuleFactory;
import management.view.department.DeleteDepartmentView;

public class DeleteDepartmentController implements Controller {

	DeleteDepartmentView deleteDepartmentView = new DeleteDepartmentView();
	
	@Override
	public void run() {
		Repository repo = Repository.getInstance();
		if (repo.getDepartments().isEmpty()) {
			System.err.println("Error: No available departments to delete.");
			return;
		}
		
		deleteDepartmentView.display();
		
		int id;
		Department department = null;
		while (true) {
			id = InputReader.readInt("Enter department id (-1 to abort): ", 
				RuleFactory.notEmpty("department id"),
				RuleFactory.isInt("department id"));
			
			if (id == -1) return;
				department = repo.getDepartment(id);
			if (department == null) 
				System.err.println("Error: Department does not exist.");
			else
				break;
		}
		
		final int departmentId = id;
		Employee employee = repo.getEmployees().stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .findFirst()
                .orElse(null);
		if (employee!= null) {
			System.err.println("Error: Dependency error. Unable to delete department.");
			return;
		}
		
		String response = InputReader.readString("Are you sure you want to delete " 
				+ department.getDepartmentName() + "(Y/N)? : ", 
			RuleFactory.notEmpty("Response"),
			RuleFactory.responseYN("Response"));
		
		if (response.trim().toLowerCase().equals("y")) {
			try {
				repo.delete(department);
			} catch (RepositoryExceptions e) {
				e.printStackTrace();
			}
		}
	}

}
