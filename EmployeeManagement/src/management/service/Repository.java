package management.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import management.exception.RepositoryExceptions;
import management.interfaces.IRepository;
import management.model.Department;
import management.model.Employee;

public class Repository implements IRepository{

	private List<Employee> employeeList;
	private List<Department> departmentList;
	private static Repository instance;
	private Database db;
	
	private Repository() {
		this.employeeList = new ArrayList<>();
        this.departmentList = new ArrayList<>();
        this.db = Database.getInstance();
        try {
        	createTables();
			loadEmployees();
			loadDepartments();
        	seedDatabase();
		} catch (RepositoryExceptions e) {
			System.err.println(e.getMessage());
		}
        
    }
	
	public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
    }
	
	public void createTables() throws RepositoryExceptions {
	    try {
	        db.connect();

	        db.executeNonQuery(
	            "CREATE TABLE IF NOT EXISTS Departments (" +
	            "departmentId INT PRIMARY KEY, " +
	            "name VARCHAR(100) NOT NULL" +
	            ")"
	        );

	        db.executeNonQuery(
	            "CREATE TABLE IF NOT EXISTS Employees (" +
	            "id INT PRIMARY KEY, " +
	            "firstName VARCHAR(100) NOT NULL, " +
	            "lastName VARCHAR(100) NOT NULL, " +
	            "dateHired DATE NOT NULL, " +
	            "departmentId INT NOT NULL, " +
	            "dateOfBirth DATE NOT NULL, " +
	            "email VARCHAR(120) NOT NULL, " +
	            "gender VARCHAR(20) NOT NULL, " +
	            "phoneNumber BIGINT NOT NULL, " +
	            "address VARCHAR(255) NOT NULL, " +
	            "employmentStatus VARCHAR(50) NOT NULL, " +
	            "FOREIGN KEY (departmentId) REFERENCES Departments(departmentId)" +
	            ")"
	        );

	    } catch (SQLException e) {
	    	throw new RepositoryExceptions("Failed to craete tables", e);
	    } 
	    finally {
	        try { 
	        	db.disconnect(); 
	        } 
	        catch (SQLException e) { 
	        	throw new RepositoryExceptions("Failed to disconnect from database", e);
	        }
	    }
	}
	
	private void loadEmployees() throws RepositoryExceptions {
        try {
            db.connect();
            Query query = new Query.Builder()
                    .select("*")
                    .from("Employees")
                    .build();
            
            ResultSet rs = db.fetch(query.toString());
            
            while (rs.next()) {
                Employee emp = new Employee.Builder(rs.getInt("id"))
                        .firstName(rs.getString("firstName"))
                        .lastName(rs.getString("lastName"))
                        .dateHired(rs.getDate("dateHired"))
                        .departmentId(rs.getInt("departmentId"))
                        .dateOfBirth(rs.getDate("dateOfBirth"))
                        .email(rs.getString("email"))
                        .gender(rs.getString("gender"))
                        .phoneNumber(rs.getLong("phoneNumber"))
                        .address(rs.getString("address"))
                        .employmentStatus(rs.getString("employmentStatus"))
                        .build();
                employeeList.add(emp);
            }
        } catch (SQLException e) {
        	throw new RepositoryExceptions("Failed to load employees", e);
        }
        finally {
            try {
                db.disconnect();  
            } catch (SQLException e) {
            	throw new RepositoryExceptions("Failed to disconnect from database", e);
            }
        }
    }
	
	private void loadDepartments() throws RepositoryExceptions {
        try {
        	db.connect();
            Query query = new Query.Builder()
                    .select("*")
                    .from("Departments")
                    .build();
            ResultSet rs = db.fetch(query.toString());
            while (rs.next()) {
                Department dept = new Department(
                        rs.getInt("departmentId"),
                        rs.getString("name")
                );
                departmentList.add(dept);
            }
        } catch (SQLException e) {
        	throw new RepositoryExceptions("Failed to load departments", e);
        }
        finally {
            try {
                db.disconnect();  
            } catch (SQLException e) {
            	throw new RepositoryExceptions("Failed to disconnect from database", e);
            }
        }
    }
	
	private void seedDatabase() throws RepositoryExceptions {
	    if (!departmentList.isEmpty() || !employeeList.isEmpty()) {
	        return;
	    }

	    try {
	        db.connect();

	        // ---- Seed Departments ----
	        db.execute(
	            "INSERT INTO Departments (departmentId, name) VALUES (?, ?)",
	            1, "Human Resources"
	        );
	        db.execute(
	            "INSERT INTO Departments (departmentId, name) VALUES (?, ?)",
	            2, "IT"
	        );
	        db.execute(
	            "INSERT INTO Departments (departmentId, name) VALUES (?, ?)",
	            3, "Finance"
	        );

	        departmentList.add(new Department(1, "Human Resources"));
	        departmentList.add(new Department(2, "IT"));
	        departmentList.add(new Department(3, "Finance"));

	        // ---- Seed Employees ----
	        db.execute(
	            "INSERT INTO Employees VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
	            1,
	            "John",
	            "Doe",
	            java.sql.Date.valueOf("2020-01-15"),
	            2,
	            java.sql.Date.valueOf("1995-06-20"),
	            "john.doe@email.com",
	            "Male",
	            1234567890L,
	            "123 Main St",
	            "Full-time"
	        );

	        employeeList.add(
	            new Employee.Builder(1001)
	                .firstName("John")
	                .lastName("Doe")
	                .dateHired(java.sql.Date.valueOf("2020-01-15"))
	                .departmentId(2)
	                .dateOfBirth(java.sql.Date.valueOf("1995-06-20"))
	                .email("john.doe@email.com")
	                .gender("Male")
	                .phoneNumber(1234567890L)
	                .address("123 Main St")
	                .employmentStatus("Full-time")
	                .build()
	        );

	    } catch (SQLException e) {
	        throw new RepositoryExceptions("Failed to seed database", e);
	    } finally {
	        try {
	            db.disconnect();
	        } catch (SQLException e) {
	            throw new RepositoryExceptions("Failed to disconnect from database", e);
	        }
	    }
	}
	
	@Override
	public void add(Employee employee) throws RepositoryExceptions {
		try {
            db.connect();
            Query query = new Query.Builder()
                    .insert("Employees", "id, firstName, lastName, dateHired, departmentId, dateOfBirth, email, gender, phoneNumber, address, employmentStatus",
                            "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?")
                    .build();
            
            db.execute(query.toString(),
                    employee.getId(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getDateHired(),
                    employee.getDepartmentId(),
                    employee.getDateOfBirth(),
                    employee.getEmail(),
                    employee.getGender(),
                    employee.getPhoneNumber(),
                    employee.getAddress(),
                    employee.getEmploymentStatus());
            
            System.out.println("Successfully added " + employee.getFirstName() + " " + employee.getLastName());
            
            employeeList.add(employee);
        } 
		catch (SQLException e) {
			throw new RepositoryExceptions("Failed to add employee to database", e);
        }
		finally {
            try {
                db.disconnect();  
            } catch (SQLException e) {
            	throw new RepositoryExceptions("Failed to disconnect from database", e);
            }
        }
	}

	@Override
	public void edit(Employee employee) throws RepositoryExceptions {
		try {
			db.connect();
			Query query = new Query.Builder()
                    .update("Employees",
                            "firstName = ?, lastName = ?, dateHired = ?, departmentId = ?, dateOfBirth = ?, email = ?, gender = ?, phoneNumber = ?, address = ?, employmentStatus = ?",
                            "id = ?")
                    .build();
			
			db.execute(query.toString(),
                    employee.getFirstName(),
                    employee.getLastName(),
                    employee.getDateHired(),
                    employee.getDepartmentId(),
                    employee.getDateOfBirth(),
                    employee.getEmail(),
                    employee.getGender(),
                    employee.getPhoneNumber(),
                    employee.getAddress(),
                    employee.getEmploymentStatus(),
                    employee.getId());

			System.out.println("Successfully updated " + employee.getFirstName() + " " + employee.getLastName());
			
            for (int i = 0; i < employeeList.size(); i++) {
                if (employeeList.get(i).getId() == employee.getId()) {
                    employeeList.set(i, employee);
                    break;
                }
            }
		}
		catch(SQLException e) {
			throw new RepositoryExceptions("Failed to update employee", e);
		}
		finally {
            try {
                db.disconnect();  
            } catch (SQLException e) {
            	throw new RepositoryExceptions("Failed to disconnect from database", e);
            }
        }
	}

	@Override
	public void delete(Employee employee) throws RepositoryExceptions {
		try {
            db.connect();
            Query query = new Query.Builder()
                    .delete("Employees", "id = ?")
                    .build();
            db.execute(query.toString(), employee.getId());
            
            System.out.println("Successfully deleted " + employee.getFirstName() + " " + employee.getLastName());
            
            employeeList.removeIf(emp -> emp.getId() == employee.getId());
        } 
		catch (SQLException e) {
			throw new RepositoryExceptions("Failed to delete employee", e);
        }
		finally {
            try {
                db.disconnect();  
            } catch (SQLException e) {
            	throw new RepositoryExceptions("Failed to disconnect from database", e);
            }
        }
	}

	@Override
	public Employee getEmployee(int id) {
		return employeeList.stream()                
	        .filter(emp -> emp.getId() == id)
	        .findFirst()
	        .orElse(null); 
	}

	@Override
	public List<Employee> getEmployees() {
		return new ArrayList<>(employeeList); 
	}

	@Override
	public void add(Department department) throws RepositoryExceptions {
		try {
            db.connect();
            Query query = new Query.Builder()
                    .insert("Departments", "departmentId, name", "?, ?")
                    .build();
            db.execute(query.toString(), department.getDepartmentId(), department.getDepartmentName());
            System.out.println("Successfully added " + department.getDepartmentName());
            departmentList.add(department);
        } catch (SQLException e) {
        	throw new RepositoryExceptions("Failed to add department to database", e);
        }
		finally {
            try {
                db.disconnect();  
            } catch (SQLException e) {
            	throw new RepositoryExceptions("Failed to disconnect from database", e);
            }
        }
	}
	

	@Override
	public void edit(Department department) throws RepositoryExceptions {
		try {
            db.connect();
            Query query = new Query.Builder()
                    .update("Departments", "name = ?", "departmentId = ?")
                    .build();
            db.execute(query.toString(), department.getDepartmentName(), department.getDepartmentId());
            System.out.println("Successfully updated " + department.getDepartmentName());
            for (int i = 0; i < departmentList.size(); i++) {
                if (departmentList.get(i).getDepartmentId() == department.getDepartmentId()) {
                    departmentList.set(i, department);
                    break;
                }
            }
        } 
		catch (SQLException e) {
			throw new RepositoryExceptions("Failed to update department", e);
        }
		finally {
            try {
                db.disconnect();  
            } catch (SQLException e) {
            	throw new RepositoryExceptions("Failed to disconnect from database", e);
            }
        }
	}

	@Override
	public void delete(Department department) throws RepositoryExceptions {
		try {
            db.connect();
            Query query = new Query.Builder()
                    .delete("Departments", "departmentId = ?")
                    .build();
            db.execute(query.toString(), department.getDepartmentId());
            System.out.println("Successfully deleted " + department.getDepartmentName());
            departmentList.removeIf(d -> d.getDepartmentId() == department.getDepartmentId());
        } 
		catch (SQLException e) {
			throw new RepositoryExceptions("Failed to delete department", e);
        }
		finally {
            try {
                db.disconnect();  
            } catch (SQLException e) {
            	throw new RepositoryExceptions("Failed to disconnect from database", e);
            }
        }
	}

	@Override
	public Department getDepartment(int id) {
		return departmentList.stream()                
		        .filter(dept -> dept.getDepartmentId() == id)
		        .findFirst()
		        .orElse(null); 
	}

	@Override
	public List<Department> getDepartments() {
		return new ArrayList<>(departmentList);
	}
}
