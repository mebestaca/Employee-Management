package management.view.department;

import java.util.List;

import management.interfaces.Screen;
import management.model.Department;
import management.service.Repository;

public class AllDepartmentView implements Screen{
	final String dividerTop    = "╔═══════╦═══════════════════════════╗";
	final String dividerMiddle = "╚═══════════════════════════════════╝";
	final String dividerBottom = "╚═══════════════════════════════════╝";
	
	@Override
	public void display() {
		List<Department> departmentList = Repository.getInstance().getDepartments();
		
		if (departmentList == null || departmentList.isEmpty()) {
            System.out.println("No departments found.");
            return;
        }

        int idW = 5;
        int nameW = 25;

        String format = "║ %-" + idW + "s ║ %-" + nameW + "s ║\n";
        

        System.out.println(dividerTop);
        System.out.printf(format, "ID", "Department Name");
        System.out.println(dividerMiddle);

        for (Department d : departmentList) {
            System.out.printf(format,
                    d.getDepartmentId(),
                    safe(d.getDepartmentName())
            );
        }

        System.out.println(dividerBottom);
		
	}
	
	private static String safe(String s) {
        return s == null ? "" : s;
    }

}
