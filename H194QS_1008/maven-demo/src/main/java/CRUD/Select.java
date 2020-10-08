package CRUD;

import java.sql.*;

public class Select {
	private static Connection conn = null;
	private static PreparedStatement ps = null;

	public static void main(String[] args) {
		Kapcs();
		System.out.println("Tábla lekérdezés:\n");
		catsSelectAll();
		System.out.println("1. lekérdezés:\n");
		catsSelect1();
		System.out.println("\n2. lekérdezés:\n");
		catsSelect2();
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

	public static void catsSelectAll() {
		ResultSet rs = null;
		Statement s = null;
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
					System.out.println(id + " " + name + " " + breed + " " + age + " " + owner + " ");
				}
				rs.close();
			} catch (Exception ex) {
				System.err.println("!!!Nem sikerült a cats adatainak lekérdezése:!!!" + ex.getMessage());
			}
		}
	}

	public static void catsSelect1() {
		ResultSet rs = null;
		if (conn != null) {
			String sqlparancs = "select * from cats where age>?";
			try {
				ps = conn.prepareStatement(sqlparancs);
				ps.setInt(1, 1);
				rs = ps.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String breed = rs.getString("breed");
					int age = rs.getInt("age");
					String owner = rs.getString("owner");
					System.out.println(id + " " + name + " " + breed + " " + age + " " + owner + " ");
				}
				rs.close();
			} catch (Exception ex) {
				System.err.println("!!!Nem sikerült a cats adatainak lekérdezése:!!!" + ex.getMessage());
			}
		}

	}

	public static void catsSelect2() {
		ResultSet rs = null;
		if (conn != null) {
			String sqlparancs = "select * from cats where age>?";
			try {
				ps = conn.prepareStatement(sqlparancs);
				ps.setInt(1, 5);
				rs = ps.executeQuery();
				while (rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String breed = rs.getString("breed");
					int age = rs.getInt("age");
					String owner = rs.getString("owner");
					System.out.println(id + " " + name + " " + breed + " " + age + " " + owner + " ");
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
			System.out.println("Sikeres lekapcsolódás!");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}
}