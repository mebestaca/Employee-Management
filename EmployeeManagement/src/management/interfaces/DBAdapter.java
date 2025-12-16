package management.interfaces;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DBAdapter {
	void connect() throws SQLException;
	ResultSet fetch(String query, Object...params) throws SQLException;
	int execute(String query, Object...params) throws SQLException;
	void executeNonQuery(String query) throws SQLException; 
	void disconnect() throws SQLException;
}
