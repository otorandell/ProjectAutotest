package core.ConnectionDDBB;

import core.ErrorManager.ErrorManager;
import core.TestDriver.TestDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by otorandell on 15/02/2016.
 */
public class ConnectionMSSQL {
    Connection conn;
    public ConnectionMSSQL() {
    }

    public Connection getConn() {
        return conn;
    }

    public void dbConnect(String db_connect_string, String db_userid, String db_password) {
        try {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            conn = DriverManager.getConnection(

                    db_connect_string, db_userid, db_password);
            System.out.println("connected");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void closeConnection() {
        try {
            conn.close();
        } catch (Exception e) {
            String ecode = "--ERROR: closeConnection(): Unable to close connection, probably is already closed.";
            e.printStackTrace();
        }
    }
}
