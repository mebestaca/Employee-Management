package management.view;

import management.interfaces.Screen;

public class MainMenuView implements Screen{

	@Override
	public void display() {
		System.out.println();
		System.out.println("--------------------------");
		System.out.println("Employee Management System");
		System.out.println("--------------------------");
		System.out.println();
		System.out.println("[1] - Employees Menu");
		System.out.println("[2] - Departments Menu");
		System.out.println();
		System.out.println("[3] - Exit");
		System.out.println();
	}

}
