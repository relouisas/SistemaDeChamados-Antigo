package Sistema.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection con = null;
	private static final String banco = "agenda_laercio";
	private static final String user = "root";
	private static final String password = "lab01";

	public static Connection getConnection() {
		if (con == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/" + banco, user, password);

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
}
