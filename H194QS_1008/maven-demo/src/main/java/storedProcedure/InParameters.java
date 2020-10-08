package storedProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class InParameters {
	private static Connection conn = null;

	public static void main(String[] args) {
		Kapcs();
		TwoParaStoredProcedure();
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

	public static void TwoParaStoredProcedure() {
		try {
			CallableStatement cs = conn.prepareCall("{call twoprocedure(?,?)}");
			cs.setString(1, "Gal Dora");
			cs.setString(2, "Perzsa");
			cs.execute();
			System.out.println("Sikeres módosítás!");
		} catch (SQLException e) {
			System.err.println("Update hiba:" + e.getMessage());
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
