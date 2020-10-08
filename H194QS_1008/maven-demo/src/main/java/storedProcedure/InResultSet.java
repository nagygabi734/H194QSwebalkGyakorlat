package storedProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InResultSet {
	private static Connection conn = null;
	public static void main(String[] args) {
		Kapcs();
		storedProcedure();
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
	
	public static void storedProcedure() {
		try {
			CallableStatement cs=conn.prepareCall("{call storedProcedures(?)}");
			cs.setString(1, "Mekk Elek");
			ResultSet rs=cs.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String breed = rs.getString("breed");
				int age = rs.getInt("age");
				String owner = rs.getString("owner");
				System.out.println(id + " " + name + " " + breed + " " + age + " " + owner + " ");
			}
			rs.close();
		} catch (SQLException e) {
			System.err.println("!!!Lekérdezés hiba: !!!" + e.getMessage());
	}
	}
	
	
	public static void LeKapcs() {
		try {
			conn.close();
			System.out.println("Sikeres Lekapcsolódás!");
		} catch (SQLException e) {
			System.err.println("Insert hiba:" + e.getMessage());
		}

	}

}
