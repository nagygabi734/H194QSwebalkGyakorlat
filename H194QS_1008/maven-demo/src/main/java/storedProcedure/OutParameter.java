package storedProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class OutParameter {
	private static Connection conn = null;
	public static void main(String[] args) {
		Kapcs();
		StoredPrecedureOutParam();
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
	
	public static void StoredPrecedureOutParam() {
		try {
			CallableStatement cs=conn.prepareCall("{call inoutprocedure(?,?)}");
			cs.setString(1, "Perzsa");
			cs.registerOutParameter(2, Types.INTEGER);
			cs.execute();
			int x=cs.getInt(2);
			cs.close();
			System.out.println("Breed count: "+x);
		} catch (SQLException e) {
			System.err.println("Hibás megszámlálás" + e.getMessage());
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
