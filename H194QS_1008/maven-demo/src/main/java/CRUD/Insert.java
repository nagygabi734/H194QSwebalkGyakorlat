package CRUD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {
	private static Connection conn = null;
	
	public static void main(String[] args) {
		Kapcs();
		//InsertCats();
		catsSelectAll();
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
	public static void InsertCats() {
		Statement s=null;
		try {
			String sqlp="insert into cats values(5,'Sanyika','Bengáli',7,'Koszsos Sanyi')";
			s=conn.createStatement();
			s.executeUpdate(sqlp);
			System.out.println("Cica felvéve");
			s.close();
		}catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
	
	public static void catsSelectAll() {
		ResultSet rs = null;
		Statement s=null;
		if (conn != null) {
			String sqlparancs = "select * from cats";
			try {
				s = conn.createStatement();
				rs = s.executeQuery(sqlparancs);
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String breed = rs.getString("breed");
					int age = rs.getInt("age");
					String owner = rs.getString("owner");
					System.out.println(id +" "+ name +" "+ breed +" "+ age +" "+ owner + " ");
				}
				rs.close();
			} catch (Exception ex) {
				System.err.println("!!!Nem sikerült a cats adatainak lekérdezése:!!!" + ex.getMessage());
			}
		}

	}
		
	
	public static void LeKapcs() {
		try {
			conn.close();
			System.out.println("Sikeres Lekapcsolódás!");
		} catch (SQLException e) {
			System.err.println("Insert hiba:"+e.getMessage());
		}
		
	}
	
}
