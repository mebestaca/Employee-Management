package management.view.employee;

import java.util.Date;
import java.util.List;

import management.interfaces.Screen;
import management.model.Employee;
import management.service.Repository;

public class AllEmployeesView implements Screen{
	
	private final String dividerTop =    "╔═══════╦════════════╦════════════╦══════════════╦═══════╦══════════════╦════════════════════╦══════════╦══════════════╦═════════════════╦══════════════╗";
	private final String dividerMiddle = "╠═══════╬════════════╬════════════╬══════════════╬═══════╬══════════════╬════════════════════╬══════════╬══════════════╬═════════════════╬══════════════╣";
	private final String dividerBottom = "╚═══════╩════════════╩════════════╩══════════════╩═══════╩══════════════╩════════════════════╩══════════╩══════════════╩═════════════════╩══════════════╝";
	
	@Override
	public void display() {
		List<Employee> employeeList = Repository.getInstance().getEmployees();
		
		if (employeeList == null || employeeList.isEmpty()) {
	        System.out.println("No employees found.");
	        return;
	    }

	    int idW = 5;
	    int fNameW = 10;
	    int lNameW = 10;
	    int hiredW = 12;
	    int deptW = 5;
	    int dobW = 12;
	    int emailW = 18;
	    int genderW = 8;
	    int phoneW = 12;
	    int addressW = 15;
	    int statusW = 12;

	    String format = "║ %-" + idW + "s"
	            	 + " ║ %-" + fNameW + "s"
	            	 + " ║ %-" + lNameW + "s"
	            	 + " ║ %-" + hiredW + "s"
	            	 + " ║ %-" + deptW + "s"
	            	 + " ║ %-" + dobW + "s"
	            	 + " ║ %-" + emailW + "s"
	            	 + " ║ %-" + genderW + "s"
	            	 + " ║ %-" + phoneW + "s"
	            	 + " ║ %-" + addressW + "s"
	            	 + " ║ %-" + statusW + "s ║\n";

	    
	
	    System.out.println(dividerTop);
	    System.out.printf(format,
	            "ID", "First Name", "Last Name", "Hired", "Dept",
	            "Birthdate", "Email", "Gender", "Phone", "Address", "Status");
	    System.out.println(dividerMiddle);

	    for (Employee e : employeeList) {
	        System.out.printf(format,
	                e.getId(),
	                safe(e.getFirstName()),
	                safe(e.getLastName()),
	                safeDate(e.getDateHired()),
	                e.getDepartmentId(),
	                safeDate(e.getDateOfBirth()),
	                safe(e.getEmail()),
	                safe(e.getGender()),
	                e.getPhoneNumber(),
	                safe(e.getAddress()),
	                safe(e.getEmploymentStatus())
	        );
	    }
	
	    System.out.println(dividerBottom);
	}

	private static String safeDate(Date d) {
		if (d == null) return "";
			return new java.text.SimpleDateFormat("yyyy-MM-dd").format(d);
	}
	
	private static String safe(String s) {
        return s == null ? "" : s;
    }
}
