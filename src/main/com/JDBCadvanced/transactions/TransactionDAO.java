package main.com.JDBCadvanced.transactions;

import java.sql.*;

public class TransactionDAO {

    public static void main(String[] args){

        Connection conn = null;
        try {

             conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:6603/mydb", "root", "mypassword");
            Statement stm = conn.createStatement();

            conn.setAutoCommit(false);

            stm.executeUpdate("UPDATE account SET bal = bal-500 WHERE accno=2");
            stm.executeUpdate("UPDATE account SET bal = bal+500 WHERE accno=1");

            conn.commit();

        } catch (SQLException e){
            e.printStackTrace();
            try{
                conn.rollback();
                conn.close();
            } catch (SQLException e1){
                e1.printStackTrace();
            }
        }
    }
}
