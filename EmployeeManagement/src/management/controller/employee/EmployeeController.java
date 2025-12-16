package management.controller.employee;

import management.interfaces.Controller;
import management.utility.InputReader;
import management.utility.RuleFactory;
import management.view.employee.EmployeeMenuView;

public class EmployeeController implements Controller{

	private EmployeeMenuView employeeMenu = new EmployeeMenuView();
	private boolean isRunning = true;
	
	@Override
	public void run() {
		while(isRunning) {
			employeeMenu.display();
			
			int choice = InputReader.readInt("Enter choice: ", 
					RuleFactory.notEmpty("choice"),
					RuleFactory.isInt("choice")); 
			
			switch(choice) {
				case 1 -> new AllEmployeesController().run();
				case 2 -> new AddEmployeeController().run();
				case 3 -> new EditEmployeeController().run();
				case 4 -> new DeleteEmployeeController().run();
				case 5 -> isRunning = false;
				default -> System.err.println("Error: Invalid choice. Try again.");
			}
		}
	}
}
