package com.microsoft.projectoxford.emotionsample.helper;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * Created by user on 11/18/17.
 */

public class SQLiteManager {
    private static final String TAG = "SQLITE_MANAGER";
    private static final String CONNECTION_ADDRESS = "jdbc:sqlite:emotion.db";

    public static void createImagesTable()
    {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(CONNECTION_ADDRESS);
            Log.e(TAG, "Opened database successfully");

            stmt = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS IMAGES " +
                    "(ID INT PRIMARY KEY NOT NULL, " +
                    " URI		TEXT	NOT NULL, " +
                    " FACE_DATA		TEXT	NOT NULL " +
                    ");";
            stmt.executeUpdate(sql);
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        Log.e(TAG, "Table created successfully");
    }

    public static void insertNewImage(String ID, String URI, String FACE_DATA)
    {
        Connection c = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection(CONNECTION_ADDRESS);
            c.setAutoCommit(false);xw
            Log.e(TAG, "Opened database successfully");

            //stmt = c.createStatement();

            StringBuffer sql = new StringBuffer(
                    "INSERT INTO BOOKS VALUES ("
                            + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, "
                            + "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            System.out.println(sql.toString());
            stmt = c.prepareStatement(sql.toString());


            stmt.setInt(1, Integer.parseInt(BOOKID));
            stmt.setString(2, BOOKNAME);
            stmt.setString(3, ACCOUNT);
            stmt.setString(4, LICENSE);
            stmt.setString(5, PRESIDENT);
            stmt.setString(6, ADDRESS);
            stmt.setString(7, TYPE);
            stmt.setString(8, ITEM);
            stmt.setString(9, POSTCODE);
            stmt.setString(10, REALADDR1);
            stmt.setString(11, REALADDR2);
            stmt.setString(12, TEL1);
            stmt.setString(13, TEL2);
            stmt.setString(14, FAX);
            stmt.setString(15, OPERATOR);
            stmt.setString(16, _BUY_SALES);
            stmt.setString(17, _CREDIT_CASH);
            stmt.setString(18, _CALCULATE_TAX);
            stmt.setString(19, BASE_BALANCE);
            stmt.setString(20, _BASE_TYPE);
            stmt.setInt(21, 0); //ISDELETED


            stmt.executeUpdate();

            stmt.close();
            c.commit();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "insertNewBook(): " + e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Book created successfully");
    }
}
