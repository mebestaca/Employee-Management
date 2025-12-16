package management.controller.department;

import management.interfaces.Controller;
import management.view.department.AllDepartmentView;

public class AllDepartmentController implements Controller{

	AllDepartmentView allDepartmentView = new AllDepartmentView();
	
	@Override
	public void run() {
		allDepartmentView.display();
	}
}
