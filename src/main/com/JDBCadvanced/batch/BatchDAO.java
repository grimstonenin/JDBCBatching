package main.com.JDBCadvanced.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchDAO {

    public static void main(String[] args){
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:6603/mydb", "root", "mypassword");
                Statement stm = conn.createStatement();
        ){

            stm.addBatch("INSERT INTO account VALUES (1,'Clinton','Bill',1000)");
            stm.addBatch("INSERT INTO account VALUES (2,'Clinton','Hillary',10000)");

           int[] results = stm.executeBatch();

           for(int i : results){
               System.out.println(i);
           }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

}
