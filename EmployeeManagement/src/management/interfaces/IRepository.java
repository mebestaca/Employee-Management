package management.interfaces;

import java.util.List;

import management.exception.RepositoryExceptions;
import management.model.Department;
import management.model.Employee;

public interface IRepository{
	public void add(Employee employee) throws RepositoryExceptions;
	public void edit(Employee employee) throws RepositoryExceptions;
	public void delete(Employee employee) throws RepositoryExceptions;
	public Employee getEmployee(int id);
	public List<Employee> getEmployees();
	
	public void add(Department department) throws RepositoryExceptions;
	public void edit(Department department) throws RepositoryExceptions;
	public void delete(Department department) throws RepositoryExceptions;
	public Department getDepartment(int id);
	public List<Department> getDepartments();
}
