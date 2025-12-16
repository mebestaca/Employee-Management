package management.controller.department;

import management.interfaces.Controller;
import management.utility.InputReader;
import management.utility.RuleFactory;
import management.view.department.DepartmentMenuView;

public class DepartmentController implements Controller{

	DepartmentMenuView departmentMenuView = new DepartmentMenuView();
	private boolean isRunning = true;
	
	@Override
	public void run() {
		while(isRunning) {
			departmentMenuView.display();
			
			int choice = InputReader.readInt("Enter choice: ", 
					RuleFactory.notEmpty("choice"),
					RuleFactory.isInt("choice")); 
			
			switch(choice) {
				case 1 -> new AllDepartmentController().run();
				case 2 -> new AddDepartmentController().run();
				case 3 -> new EditDepartmentController().run();
				case 4 -> new DeleteDepartmentController().run();
				case 5 -> isRunning = false;
				default -> System.err.println("Error: Invalid choice. Try again.");
			}
		}
	}

}
