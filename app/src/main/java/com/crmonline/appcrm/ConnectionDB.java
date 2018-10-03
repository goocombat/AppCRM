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

    public static String getBox() throws SQLException {
        PreparedStatement stm = conn.prepareStatement("SELECT pega_caixa();");
        ResultSet rs = stm.executeQuery();
        String toReturn = null;
        while (rs.next()) {
            toReturn = rs.getString(0);
        }
        return toReturn;
    }

    public static String getGoals() throws SQLException {
        PreparedStatement stm = conn.prepareStatement("SELECT pega_metas();");
        ResultSet rs = stm.executeQuery();
        String toReturn = null;
        while (rs.next()) {
            toReturn = rs.getString(0);
        }
        return toReturn;
    }
}