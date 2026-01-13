package management.view.department;

import management.interfaces.Screen;

public class DepartmentMenuView implements Screen{

	@Override
	public  void display() {
		System.out.println();
		System.out.println("╔════════════════════════════╗");
		System.out.println("║       Departments Menu     ║");
		System.out.println("╚════════════════════════════╝");
		System.out.println();
		System.out.println("[1] - Display all departments");
		System.out.println("[2] - Add a new department");
		System.out.println("[3] - Edit existing department");
		System.out.println("[4] - Delete a department");
		System.out.println();
		System.out.println("[5] - Return to main menu");
		System.out.println();
	}

}
