import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLAccess {

	private Connection connect = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	
	final private String host = "localhost:3307/ddbbrol";
	final private String user = "root";
	final private String passwd = "";
	
	/**
	 * Pre:---
	 * Post: Este método realiza la conexión con la base de datos.
	 */
	public void conectarBD() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://" + host 
					+ "?user=" + user + "&password=" + passwd);
			statement = connect.createStatement();
		} catch (Exception e) {throw e;};
	}
	
	/**
	 * Pre:---
	 * Post: Este método cierra la conexión con la base de datos.
	 */
	public void cerrarBD() {
		try {
			if (resultSet != null) {
				resultSet.close();
			} if (statement != null) {
				statement.close();
			} if (connect != null) {
				connect.close();
			}
		} catch (Exception e) {}
	}
	
	// Metodos getter y setter
	public Connection getConnect() {
		return connect;
	}

	public void setConnect(Connection connect) {
		this.connect = connect;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}

	public ResultSet getResultSet() {
		return resultSet;
	}

	public void setResultSet(ResultSet resultSet) {
		this.resultSet = resultSet;
	}

}
