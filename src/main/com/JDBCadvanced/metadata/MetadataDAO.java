package main.com.JDBCadvanced.metadata;

import java.sql.*;

public class MetadataDAO {

    public static void main(String[] args){
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:6603/mydb", "root", "mypassword");
            Statement stm = conn.createStatement();
        ){

            ResultSet resultSet = stm.executeQuery("SELECT * FROM account");
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            int columnCount = resultSetMetaData.getColumnCount();

            for(int i=1; i<=columnCount;i++){
                System.out.println(resultSetMetaData.getColumnName(i) + " - " + resultSetMetaData.getColumnTypeName(i));

            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
