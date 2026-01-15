package management.view.employee;

import management.interfaces.Screen;

public class EmployeeMenuView implements Screen{

	@Override
	public void display() {
		System.out.println();
		System.out.println("╔═════════════════════════════╗");
		System.out.println("║        Employees Menu       ║");
		System.out.println("╚═════════════════════════════╝");
		System.out.println();
		System.out.println(" [1] - Display all employees");
		System.out.println(" [2] - Add a new employee");
		System.out.println(" [3] - Edit existing employee");
		System.out.println(" [4] - Delete an employee");
		System.out.println();
		System.out.println(" [5] - Return to main menu");
		System.out.println();
	}

}
