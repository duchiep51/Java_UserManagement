/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hieptd.conn;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Hiep
 */
public class MyConnection implements Serializable {
    
    static public Connection getConnection() throws NamingException, SQLException{
        Context context = new InitialContext();
        Context tomcatCtx = (Context) context.lookup("java:comp/env");
        DataSource ds = (DataSource) tomcatCtx.lookup("LAB01");
        return ds.getConnection();
    }
    
//    static public Connection getConnection() throws Exception {
//        Connection conn = null;
//        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//        conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=Lab_01", "sa", "123");
//        return conn;
//    }
}
