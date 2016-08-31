package com.usernameDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {
	public static final String JBDC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root&autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "root";

	static Connection CONN = null;
	static Statement STMT = null;
	static PreparedStatement PREP_STMT = null;
	static ResultSet RES_SET = null;

	public static void connToDB() {
		try {
			Class.forName(JBDC_DRIVER);
			
			System.out.println("Connecting to the database");
			CONN = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to the database");
			System.out.println("");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println("Database connection failed.");
			e.printStackTrace();
		}
	}// connect method

	public static ArrayList<Users> readFromDB() {
		ArrayList<Users> allUsers = new ArrayList<>();

		connToDB();

		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM username_info.users;");

			while (RES_SET.next()) {
				Users usersInDB = new Users();

				usersInDB.setUserID(RES_SET.getString("user_id"));
				usersInDB.setUserName(RES_SET.getString("username"));
				usersInDB.setRealName(RES_SET.getString("realname"));
				usersInDB.setEmail(RES_SET.getString("email"));
				usersInDB.setAge(RES_SET.getString("age"));

				allUsers.add(usersInDB);
			}

			for (Users users : allUsers) {
				System.out.println(users.toString());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allUsers;
	}// read method

	public static void findInDB(String userID) {
		connToDB();

		try {
			STMT = CONN.createStatement();
			RES_SET = STMT.executeQuery("SELECT * FROM username_info.users WHERE user_id = '" + userID + "';");
			// RES_SET = STMT.executeQuery("SELECT * FROM username_info.users
			// limit 1;");
			Users userInDB = new Users();

			while (RES_SET.next()) {
				userInDB.setUserID(RES_SET.getString("user_id"));
				userInDB.setUserName(RES_SET.getString("username"));
				userInDB.setRealName(RES_SET.getString("realname"));
				userInDB.setEmail(RES_SET.getString("email"));
				userInDB.setAge(RES_SET.getString("age"));

				System.out.println(userInDB.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// find individual method

	public static void addToDB(Users user) {
		connToDB();

		try {

			PREP_STMT = CONN.prepareStatement(insertToTable);
			PREP_STMT.setString(1, user.getUserName());
			PREP_STMT.setString(2, user.getRealName());
			PREP_STMT.setString(3, user.getEmail());
			PREP_STMT.setString(4, user.getAge());
			
			PREP_STMT.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// add method

	public static void deleteFromDB(String userID) {
		connToDB();

		try {
			STMT = CONN.createStatement();
			STMT.executeUpdate("DELETE FROM username_info.users WHERE user_id = '" + userID + "';");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// delete method

	public static void updateDB(String userID, String userName, String realName, String email, String age) {
		connToDB();

		try {
			STMT = CONN.createStatement();
			STMT.executeUpdate("UPDATE username_info.users SET username = '" + userName + "', realname = '" + realName
					+ "', email = '" + email + "', age = '" + age + "' WHERE user_id = '" + userID + "';");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// update method

	private static String insertToTable = "INSERT INTO `username_info`.`users` "
		+ "(username, realname, email, age)"
		+ " VALUES "
		+ "(?, ?, ?, ?);";

}// class