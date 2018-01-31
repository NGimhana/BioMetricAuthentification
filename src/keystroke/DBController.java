/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keystroke;

import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Gimhana
 */
public class DBController {
    public static boolean InsertBioMetricData(String userName,String passWord ,
            double Typingspeed ){
        
        boolean result=false;
        Connection conn = DBConnector.getDBConnection();
        try {
            // create a Statement from the connection
            Statement statement = conn.createStatement();
            
            //Insert Data
            int executeUpdate = statement.executeUpdate("INSERT INTO UserTable "+" VALUES ( "
                    +'\''+userName+'\'' +" ,"
                    +'\''+passWord+'\''+","                    
                    +'\''+Typingspeed+'\''
                    +")");
            result=executeUpdate>0;
        
        } catch (SQLException ex) {
            //Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public static ResultSet searchBioMetricData(String userName){
        Connection conn=DBConnector.getDBConnection();
        String query = "SELECT * FROM UserTable WHERE UserName = " + '\'' + userName + '\'';
        
        
        
        // create the java statement
        Statement st;
        ResultSet rs = null;        
        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
                        
        } catch (SQLException ex) {
            //Logger.getLogger(DBController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;              
    }
}
