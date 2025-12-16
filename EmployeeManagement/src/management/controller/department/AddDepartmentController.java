package management.controller.department;

import management.exception.RepositoryExceptions;
import management.interfaces.Controller;
import management.model.Department;
import management.service.Repository;
import management.service.Sequence;
import management.utility.InputReader;
import management.utility.RuleFactory;
import management.view.department.AddDepartmentView;

public class AddDepartmentController implements Controller{

	AddDepartmentView addDepartmentView = new AddDepartmentView();
	
	@Override
	public void run() {
		
		addDepartmentView.display();
		
		String departmentName = InputReader.readString("Enter department name: ", 
				RuleFactory.notEmpty("department name"),
				RuleFactory.lengthCheck("department name", 3, 40));
		
		Sequence.init();
		int seq = Sequence.Department.next();
		Department department = new Department(seq, departmentName);
		try {
			Repository.getInstance().add(department);
		} catch (RepositoryExceptions e) {
			e.printStackTrace();
		}
		
	}
}
