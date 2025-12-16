package management.controller.department;

import management.exception.RepositoryExceptions;
import management.interfaces.Controller;
import management.model.Department;
import management.service.Repository;
import management.utility.InputReader;
import management.utility.RuleFactory;
import management.view.department.EditDepartmentView;

public class EditDepartmentController implements Controller{

	EditDepartmentView editDepartmentView = new EditDepartmentView();
	
	@Override
	public void run() {
		Repository repo = Repository.getInstance();
		if (repo.getDepartments().isEmpty()) {
			System.out.println("No departments found.");
			return;
        }
		editDepartmentView.display();
		
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
		
		String departmentName = InputReader.readString("Enter department name: ", 
				RuleFactory.notEmpty("department name"),
				RuleFactory.lengthCheck("department name", 3, 40));
	
		department.setDepartmentName(departmentName);
	
		try {
			Repository.getInstance().edit(department);
		} catch (RepositoryExceptions e) {
			e.printStackTrace();
		}
		
	}

}
