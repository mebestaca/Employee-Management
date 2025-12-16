package oldcode;

public class OldDriver {
//	public static void main(String[] args) {
//		Repository repo = Repository.getInstance();
//		boolean isRunning = true;
//		
//		while(isRunning) {
//			Screens.MainMenu.display();
//			int mainMenuChoice = Input.MainMenu.read();
//			
//			switch (mainMenuChoice) {
//				case 1 -> {
//					Screens.MainMenu.EmployeeMenu.display();
//					int employeeMenuChoice = Input.MainMenu.EmployeeMenu.read();
//					
//					switch(employeeMenuChoice) {
//						case 1 -> {
//							List<Employee> employees = repo.getEmployees();
//							Screens.MainMenu.EmployeeMenu.DisplayEmployees.display(employees);
//						}
//						case 2 -> {
//							Screens.MainMenu.EmployeeMenu.AddEmployee.display("Enter firstname: ");
//							String firstname = Input
//									.MainMenu
//									.EmployeeMenu
//									.Operation.readString("firstname");
//							
//							Screens.MainMenu.EmployeeMenu.AddEmployee.display("Enter lastname: ");
//							String lastname = Input
//									.MainMenu
//									.EmployeeMenu
//									.Operation.readString("lastname");
//							
//							Screens.MainMenu.EmployeeMenu.AddEmployee.display("Enter birthday (yyyy-MM-dd): ");
//							Date birthday = Input
//									.MainMenu
//									.EmployeeMenu
//									.Operation.readDate("birthday");
//							
//							Screens.MainMenu.EmployeeMenu.AddEmployee.display("Enter email: ");
//							String email = Input
//									.MainMenu
//									.EmployeeMenu
//									.Operation.readEmail("email");
//							
//							Screens.MainMenu.EmployeeMenu.AddEmployee.display("Enter gender: ");
//							String gender = Input
//									.MainMenu
//									.EmployeeMenu
//									.Operation.readString("gender");
//							
//							Screens.MainMenu.EmployeeMenu.AddEmployee.display("Enter phone number: ");
//							Long phoneNumber = Input
//									.MainMenu
//									.EmployeeMenu
//									.Operation.readPhoneNumber("phone number");
//							
//							Screens.MainMenu.EmployeeMenu.AddEmployee.display("Enter department: ");
////							int department = Input.MainMenu.EmployeeMenu.Operation.readString(gender)
//						} 
//						case 3 -> {
//							
//						}
//						case 4 -> {
//							
//						}
//						case 5 -> { 
//							break;
//						}
//					}
//				}
//				case 2 -> {
//					Screens.MainMenu.DepartmentMenu.display();
//					int departmentChoice = Input.MainMenu.DepartmentMenu.read();
//					
//					switch(departmentChoice) {
//						case 1 -> {
//							
//						}
//						case 2 -> {
//							
//						} 
//						case 3 -> {
//							
//						}
//						case 4 -> {
//							
//						}
//						case 5 -> { 
//							break;
//						}
//					}
//				}
//				case 3 -> {
//					System.out.println("Good bye!!");
//					isRunning = false;
//					break;
//				}
//			}
//		}
//	}
}
