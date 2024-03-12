package com.jspiders.cardekhojdbc.main;

import java.sql.Connection;
import java.util.Scanner;

import com.jspiders.cardekhojdbc.connections.JdbcConnection;


import com.jspiders.cardekhojdbc.connections.JdbcConnection;


public class JdbcMain {
	static boolean loop=true;
    static JdbcConnection jdbcConnection=new JdbcConnection();
public static void main(String[] args) {
	System.out.println("WELCOME TO CARDEKHO APPLICATION!!!!!");
	while(loop) {
		System.out.println();
	System.out.println(" 1. view all cars.\n"
			+ "2. search cars.\n"
			+ "3. insert cars.\n"
			+ "4. update car(s).\n"
			+ "5. delete car detilas.\n"
			+ "6. Exit.");
	Scanner scanner=new Scanner(System.in);
	int choice=scanner.nextInt();
	switch (choice) {
	case 1:
		System.out.println("view all cars.");
		JdbcConnection.view();
		break;
	case 2:
		System.out.println("search cars.");
		JdbcConnection.select();
        break;
	case 3:
		System.out.println("insert car(s)");
		JdbcConnection.insert();
		break;
	case 4:
		System.out.println("update car(s)");
		JdbcConnection.update();
		
		break;
	case 5:
		System.out.println("delete car(s)");
		JdbcConnection.delete();
		break;
	case 6:
		loop=false;
		System.out.println("THANK YOU!!!!");
		break;
	default:
		System.out.println("Invalid choice please try again!!!!!");

	}}
}
}
