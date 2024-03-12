package com.jspiders.cardekhojdbc.connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Scanner;

public class JdbcConnection {
 static Connection connection;
 static PreparedStatement preparedStatement;
 static Statement statement;
 static ResultSet resultSet;
 static String query;
 public static void insert() {
	try {
		openConnection();
		query="INSERT INTO cars VALUES(?,?,?,?,?,?,?)";

		preparedStatement=connection.prepareStatement(query);
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter how many cars you want to add");
		int count=scanner.nextInt();
		for(int i=1;i<=count;i++)
		{
		   System.out.println("enter user id:");
		   int id=scanner.nextInt();
		   scanner.nextLine();
		   System.out.println("enter user name:");
           String name=scanner.nextLine();
		   System.out.println("enter user brand:");
           String brand=scanner.nextLine();
		   System.out.println("enter user model:");
           String model=scanner.nextLine();
           System.out.println("enter user fueltype:");
           String fueltype=scanner.nextLine();
		   System.out.println("enter user color:");
           String color=scanner.nextLine();
		   System.out.println("enter user price:");
           double price=scanner.nextDouble();
           preparedStatement.setInt(1, id);
           preparedStatement.setString(2, name);
           preparedStatement.setString(3, brand);
           preparedStatement.setString(4, model);
           preparedStatement.setString(5, fueltype);
           preparedStatement.setString(6, color);
           preparedStatement.setDouble(7, price);
           preparedStatement.addBatch();
		}
		preparedStatement.executeBatch();
	} 
 
	
	catch (SQLException e) {
		e.printStackTrace();
	}
	finally {
		try {
			closeConnection();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	 
	 }
 public static void update() {

	 try {
		openConnection();
		query="UPDATE cars SET name=?,brand=?,model=?,fueltype=?,color=?,price=? WHERE id=?";
		preparedStatement=connection.prepareStatement(query);
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter car id:");
		int id=scanner.nextInt();
		scanner.nextLine();
		System.out.println("enter new car name:");
		String name=scanner.nextLine();
		System.out.println("enter new brand:");
		String brand=scanner.nextLine();
		System.out.println("enter latest model:");
		String model=scanner.nextLine();
		System.out.println("enter latest fueltype:");
		String fueltype=scanner.nextLine();
		System.out.println("enter latest color:");
		String color=scanner.nextLine();
		System.out.println("enter latest price:");
		double price=scanner.nextDouble();


		preparedStatement.setString(1, name);
		preparedStatement.setString(2, brand);
		preparedStatement.setString(3, model);
		preparedStatement.setString(4, fueltype);
		preparedStatement.setString(5, color);
		preparedStatement.setDouble(6, price);
		preparedStatement.setInt(7, id);
int res=preparedStatement.executeUpdate();
System.out.println("car updated.");
System.out.println(res +" row(s) affected.");

	} catch (SQLException e) {

		e.printStackTrace();
	}finally {
		try {
			closeConnection();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
 }
public static void delete() {
	Scanner scanner=new Scanner(System.in);
     System.out.println("enter car id:");
     int id=scanner.nextInt();
	try {
		openConnection();
		query="DELETE FROM cars WHERE id=?";
		preparedStatement=connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		int res=preparedStatement.executeUpdate();
		System.out.println("car deleted.");
		System.out.println(res +" row(s) affected.");
	} catch (SQLException e) {

		e.printStackTrace();
	}
	finally {
		try {
			closeConnection();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}

public static void view() {
try {
	openConnection();
	statement=connection.createStatement();
	query="SELECT * FROM cars";
	resultSet=statement.executeQuery(query);
	
	while(resultSet.next()) {
		System.out.print(resultSet.getInt(1));
		System.out.print(" ");
		System.out.print(resultSet.getString(2));
		System.out.print(" ");
		System.out.print(resultSet.getString(3));
		System.out.print(" ");
		System.out.print(resultSet.getString(4));
		System.out.print(" ");
		System.out.print(resultSet.getString(5));
		System.out.print(" ");
		System.out.print(resultSet.getString(6));
		System.out.print(" ");
		System.out.print(resultSet.getDouble(7));
		System.out.println();


	}

} catch (SQLException e) {

	e.printStackTrace();
}finally {
	try {
		closeConnection();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

}
public static void select() {
	Scanner scanner=new Scanner(System.in);
	System.out.println("enter car id:");
	int id=scanner.nextInt();

try {
	openConnection();
	query="SELECT * FROM cars WHERE id=?";

	preparedStatement=connection.prepareStatement(query);

	
	preparedStatement.setInt(1, id);
	resultSet=preparedStatement.executeQuery();
//	scanner.nextLine();
	
	
	while(resultSet.next()) {
		System.out.print(resultSet.getInt(1));
		System.out.print(" ");
		System.out.print(resultSet.getString(2));
		System.out.print(" ");
		System.out.print(resultSet.getString(3));
		System.out.print(" ");
		System.out.print(resultSet.getString(4));
		System.out.print(" ");
		System.out.print(resultSet.getString(5));
		System.out.print(" ");
		System.out.print(resultSet.getString(6));
		System.out.print(" ");
		System.out.print(resultSet.getDouble(7));
		System.out.println();
		
	}}
	 catch (SQLException e) {

		e.printStackTrace();
	}

	

	}


 public static void openConnection() throws SQLException {
	 connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4","root","root");
 }
 public static void closeConnection() throws SQLException {
	 if(resultSet!=null) {
		 resultSet.close();
	 }
	 if(preparedStatement != null) {
		 preparedStatement.close();
	 }
	 if(connection!=null) {
		 connection.close();
	 }
 }

}
