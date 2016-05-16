package core.ConnectionDDBB;

import core.ErrorManager.ErrorManager;
import core.TestDriver.TestDriver;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by otorandell on 15/02/2016.
 */
public class DDBBInteractions {

    public static List<String[]> readUser(ConnectionMSSQL connection) {
        List<String[]> users = new ArrayList<>();

        try {
            java.sql.Statement stmt = connection.getConn().createStatement();
            java.sql.ResultSet rs = stmt.executeQuery("SELECT users, pass, priority FROM USERS_AUTOTEST");
            while (rs.next()) {
                users.add(new String[]{rs.getString(1), rs.getString(2), Integer.toString(rs.getInt(3))});
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            String ecode = "--ERROR: readUser(): Unable to select data from DB, please check the status.";
            e.printStackTrace();
        }
        return users;
    }

    public static void deleteTable(TestDriver driver, ConnectionMSSQL connection){
        String deleteTable = "DELETE USER_AUTOTEST";
        try{
            Statement sta=connection.getConn().createStatement();
            if (sta.execute(deleteTable))
                sta.close();}
        catch(Exception e){
            String ecode = "--ERROR: deleteTable(): Unable to delete data from DB, please check the status.";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
        }
    }

    public static void updateTable(ConnectionMSSQL connection, String user, int priority){
        try{
            String updateUser = "UPDATE USERS_AUTOTEST SET priority = priority+"+priority+" WHERE users = '"+user+"'";
            Statement sta=connection.getConn().createStatement();
            if (sta.execute(updateUser))
                sta.close();}
        catch(Exception e){
            String ecode = "--ERROR: updateTable(): Unable to update data from DB, please check the status.";
            e.printStackTrace();
        }
    }

    public static String getPrior(TestDriver driver, ConnectionMSSQL connection, String user){
        String myreturn= "";
        try{
            String getUser = "SELECT priority FROM USERS_AUTOTEST WHERE users = '"+user+"'";
            PreparedStatement pstmt = connection.getConn().prepareStatement(getUser);
            ResultSet rs = pstmt.executeQuery();
            int j = 0;
            String[][] priority  = new String[0][0];
            priority[0][0] = Integer.toString(rs.getInt(3)); //Priority
            j++;
            myreturn = priority[0][0];}
        catch(Exception e){
            String ecode = "--ERROR: getPrior(): Unable to select data from DB, please check the status.";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
        }
        return myreturn;
    }

    public static void doSQL(TestDriver driver, ConnectionMSSQL connection, String SQLFunction){
        try{
            String doSQLFunction = SQLFunction;
            Statement sta=connection.getConn().createStatement();
            if (sta.execute(doSQLFunction))
                sta.close();}
        catch (Exception e){
            String ecode = "--ERROR: doSQL(): Unable to interact with DB, please check the status.";
            e.printStackTrace();
            ErrorManager.process(driver, ecode);
        }
    }

    public static String[] getOptimalUser(ConnectionMSSQL connection){
        List<String[]> users;
        String[] finaluser ={"NaN","NaN","999"};
        boolean saturated = false;
        int toomuchwait =0;
        do{
            users = readUser(connection);
            for(String[] user : users){
                if(Integer.parseInt(user[2])<Integer.parseInt(finaluser[2])){
                    finaluser = user;
                }
                if(Integer.parseInt(finaluser[2])>8){
                    saturated=true;
                    toomuchwait++;
                    try {
                        Thread.sleep(60000);

                    }
                    catch (Exception e){}
                }
                else{
                    saturated=false;
                }
            }}while(saturated && toomuchwait<=5);
        if(toomuchwait>5){
            String message = "-- ERROR getOptimalUser() -- ALL USERS ARE BEEN USING THEIR MAXIMUM LOGIN INSTANCES BY MORE THAN 5 MINUTES. SETTING USER BY DEFAULT";

        }
        return finaluser;
    }
}
