package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {
	private static Connection conn = null;

	public static void main(String[] args) {
		Kapcs();
		catsUpdate();
		LeKapcs();

	}

	public static void Kapcs() {
		try {
			// Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/webalk?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String user = "H194QS";
			String pswd = "password";
			conn = DriverManager.getConnection(url, user, pswd);
			System.out.println("Sikeres csatlakozás!");
			System.out.println("------------------------");
		} catch (Exception ex) {
			System.err.println("!!!Kapcsolódási hiba: !!!" + ex.getMessage());
		}
	}

	public static void catsUpdate() {
		Statement s = null;
		try {
			String sqlp = "Update cats set owner='Piros Ferenc' where breed='sziami'";
			s = conn.createStatement();
			s.executeUpdate(sqlp);
			System.out.println("Cats update-je sikerült!");
		} catch (SQLException e) {
			System.err.println("Update hiba: " + e.getMessage());
		}
	}

	public static void LeKapcs() {
		try {
			conn.close();
			System.out.println("Sikeres Lekapcsolódás!");
		} catch (SQLException e) {
			System.err.println("Sikertelen lekapcs:"+e.getMessage());
		}

	}
}
