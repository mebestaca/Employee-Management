package oldcode;
//
//import java.util.Date;
//import java.util.List;
//
//import management.model.Department;
//import management.model.Employee;

public class OldScreens {
//	public static class MainMenu {
//		public static void display() {
//			System.out.println("Employee Management System");
//			System.out.println("[1] - Employees Menu");
//			System.out.println("[2] - Departments Menu");
//			System.out.println("[3] - Exit");
//		}
//		
//		private static String safe(String s) {
//	        return s == null ? "" : s;
//	    }
//		
//		public static class EmployeeMenu {
//			public static void display() {
//				System.out.println("Employees Menu");
//				System.out.println("[1] - Display all employees");
//				System.out.println("[2] - Add a new employee");
//				System.out.println("[3] - Edit existing employee");
//				System.out.println("[4] - Delete an employee");
//				System.out.println("[5] - Return to main menu");
//			}
//			
//			public static class DisplayEmployees {
//				public static void display(List<Employee> employeeList) {
//					if (employeeList == null || employeeList.isEmpty()) {
//			            System.out.println("No employees found.");
//			            return;
//			        }
//
//			        int idW = 5;
//			        int fNameW = 15;
//			        int lNameW = 15;
//			        int hiredW = 12;
//			        int deptW = 5;
//			        int dobW = 12;
//			        int emailW = 25;
//			        int genderW = 8;
//			        int phoneW = 12;
//			        int addressW = 20;
//			        int statusW = 12;
//
//			        String format = "| %-" + idW + "s"
//			                	 + " | %-" + fNameW + "s"
//			                	 + " | %-" + lNameW + "s"
//			                	 + " | %-" + hiredW + "s"
//			                	 + " | %-" + deptW + "s"
//			                	 + " | %-" + dobW + "s"
//			                	 + " | %-" + emailW + "s"
//			                	 + " | %-" + genderW + "s"
//			                	 + " | %-" + phoneW + "s"
//			                	 + " | %-" + addressW + "s"
//			                	 + " | %-" + statusW + "s |\n";
//
//			        String divider =
//			                "---------------------------------------------------------------------------------------------------------------------------------------------------------------------";
//
//			        System.out.println(divider);
//			        System.out.printf(format,
//			                "ID", "First Name", "Last Name", "Hired", "Dept",
//			                "Birthdate", "Email", "Gender", "Phone", "Address", "Status");
//			        System.out.println(divider);
//
//			        for (Employee e : employeeList) {
//			            System.out.printf(format,
//			                    e.getId(),
//			                    safe(e.getFirstName()),
//			                    safe(e.getLastName()),
//			                    safeDate(e.getDateHired()),
//			                    e.getDepartmentId(),
//			                    safeDate(e.getDateOfBirth()),
//			                    safe(e.getEmail()),
//			                    safe(e.getGender()),
//			                    e.getPhoneNumber(),
//			                    safe(e.getAddress()),
//			                    safe(e.getEmploymentStatus())
//			            );
//			        }
//
//			        System.out.println(divider);
//				}
//			}
//			
//			
//
//		    private static String safeDate(Date d) {
//		        if (d == null) return "";
//		        return new java.text.SimpleDateFormat("yyyy-MM-dd").format(d);
//		    }
//			
//			public static class AddEmployee {
//				public static void display(String prompt) {
//					System.out.println(prompt);	
//				}
//			}
//			
//			public static class EditEmployee {
//				public static void display(String prompt) {
//					System.out.println(prompt);	
//				}
//			}
//			
//			public static class DeleteEmployee {
//				public static void display() {
//					System.out.println("Delete employee: ");
//					System.out.println("Enter employee id:");
//				}
//			}
//			
//		}
//		
//		public static class DepartmentMenu {
//			public static void display() {
//				System.out.println("Departments Menu");
//				System.out.println("[1] - Display all departments");
//				System.out.println("[2] - Add a new department");
//				System.out.println("[3] - Edit existing department");
//				System.out.println("[4] - Delete a department");
//				System.out.println("[5] - Return to main menu");
//			}
//			
//			public static class DisplayDepartments {
//			    public static void display(List<Department> departmentList) {
//
//			        if (departmentList == null || departmentList.isEmpty()) {
//			            System.out.println("No departments found.");
//			            return;
//			        }
//
//			        int idW = 5;
//			        int nameW = 25;
//
//			        String format = "| %-" + idW + "s | %-" + nameW + "s |\n";
//			        String divider = "---------------------------------------------";
//
//			        System.out.println(divider);
//			        System.out.printf(format, "ID", "Department Name");
//			        System.out.println(divider);
//
//			        for (Department d : departmentList) {
//			            System.out.printf(format,
//			                    d.getDepartmentId(),
//			                    safe(d.getDepartmentName())
//			            );
//			        }
//
//			        System.out.println(divider);
//			    }
//			}
//		}
//	}
}
