package management.controller;

import management.controller.department.DepartmentController;
import management.controller.employee.EmployeeController;
import management.interfaces.Controller;
import management.service.Repository;
import management.utility.InputReader;
import management.utility.RuleFactory;
import management.view.MainMenuView;

public class MainMenuController implements Controller {

	private boolean isRunning = true;
	private MainMenuView mainMenu = new MainMenuView(); 
	
	@Override
	public void run() {
		Repository.getInstance();
		while (isRunning) {
			mainMenu.display();
			
			int choice = InputReader.readInt("Enter choice: ", 
					RuleFactory.notEmpty("choice"),
					RuleFactory.isInt("choice")); 
			
			switch(choice) {
				case 1 -> new EmployeeController().run();
				case 2 -> new DepartmentController().run();
				case 3 -> isRunning = false;
				default -> System.err.println("Error: Invalid choice. Try again.");
			}
		}
		System.out.println("Good bye!!");
	}
}
