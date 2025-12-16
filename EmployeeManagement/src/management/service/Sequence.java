package management.service;

public class Sequence {
	private static int lastEmployeeId;
    private static int lastDepartmentId;

    private static final int STEP = 1;

    public static void init() {
        Repository repo = Repository.getInstance();

        lastEmployeeId = repo.getEmployees().stream()
                .mapToInt(e -> e.getId())
                .max()
                .orElse(0);

        lastDepartmentId = repo.getDepartments().stream()
                .mapToInt(d -> d.getDepartmentId())
                .max()
                .orElse(0);
    }

    public static class Employee {
    	public static int next() {
            lastEmployeeId += STEP;
            return lastEmployeeId;
        }
    }
    
    public static class Department {
    	public static int next() {
            lastDepartmentId += STEP;
            return lastDepartmentId;
        }
    }
}
