package management.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import management.interfaces.DBAdapter;


public class Database implements DBAdapter{

	private static final Database instance = new Database();
	private static final String JDBC = "jdbc:mariadb://%s:%d/%s";
	private static final String SERVER = "localhost";
	private static final int PORT = 3306;
	private static final String DATABASE = "employee_management";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";
	
	private Connection connection = null;
	private Database() {}
	
	public static Database getInstance() {
		return instance;
	}
	
	private String getConnectionString()
	{
		return String.format(JDBC, SERVER, PORT, DATABASE);
	}
	
	@Override
	public void connect() throws SQLException {
		String connectionString = this.getConnectionString();
		connection = DriverManager.getConnection(connectionString, USERNAME, PASSWORD);
	}

	@Override
	public ResultSet fetch(String query, Object...params) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(query);
		setParameters(statement, params);
		return statement.executeQuery();
	}

	@Override
	public int execute(String query, Object...params) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(query);
	    setParameters(stmt, params);
	    return stmt.executeUpdate();
	}

	@Override
	public void executeNonQuery(String query) throws SQLException {
		PreparedStatement stmt = connection.prepareStatement(query);
	    stmt.execute();
	}
	
	@Override
	public void disconnect() throws SQLException {
		if(connection!=null && !connection.isClosed())
			connection.close();
	}
	
	private void setParameters(PreparedStatement stmt, Object... params) throws SQLException {
	    if (params == null) return;
	    for (int i = 0; i < params.length; i++) {
	        stmt.setObject(i + 1, params[i]);
	    }
	}
}
