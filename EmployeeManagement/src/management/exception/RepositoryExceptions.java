package management.exception;

public class RepositoryExceptions extends Exception {

	private static final long serialVersionUID = 1L;
	public RepositoryExceptions(String msg) {
		super(msg);
	}
	
	public RepositoryExceptions(String msg, Throwable cause) {
		super(msg, cause);
	}
}
