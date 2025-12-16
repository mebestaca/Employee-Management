package management.controller.employee;

import management.interfaces.Controller;
import management.view.employee.AllEmployeesView;

public class AllEmployeesController implements Controller{

	@Override
	public void run() {
		new AllEmployeesView().display();
	}

}
