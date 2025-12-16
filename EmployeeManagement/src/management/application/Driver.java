package management.application;

import management.controller.MainMenuController;

public class Driver {
	static MainMenuController application = new MainMenuController();
	
	public static void main(String[] args) {
		application.run();
	}
}
