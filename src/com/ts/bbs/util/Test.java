package com.ts.bbs.util;

import java.sql.Connection;

public class Test {
	public static void main(String[] args) {
		Connection conn = DBConnection.getConn();
		System.out.println(conn);
	}
	
}
