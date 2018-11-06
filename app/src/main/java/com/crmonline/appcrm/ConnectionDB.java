package com.crmonline.appcrm;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by rick on 02/10/2018.
 */

public class ConnectionDB {

    static java.sql.Connection conn;

    public static boolean connect() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/banco?useTimezone=true&serverTimezone=UTC", "root", "");
            return true;
        } catch (SQLException e) {
            return false;
        }
    }


    }
