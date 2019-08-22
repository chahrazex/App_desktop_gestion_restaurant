package Connectivity;

import javax.swing.*;
import java.sql.*;

public class CennectionClass {
    Connection connection ;
    public Connection getConnection() throws SQLException {
        String  dbName ="Restaurant" ;
        String  username="root" ;
        String password="" ;

        try {
            Class.forName("com.mysql.jdbc.Driver") ;
             connection =DriverManager.getConnection("jdbc:mysql://localhost/"+dbName,username,password) ;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"No connection");
        }

        return connection ;
    }
    public static int count(String col ,String table)
    {
        CennectionClass cennectionClass =new CennectionClass() ;
        try {
            Connection connection =cennectionClass.getConnection() ;
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT COUNT("+col+") FROM "+table) ;
            ResultSet resultSet=preparedStatement.executeQuery() ;
            if (resultSet.next())
            {
                return Integer.parseInt(resultSet.getString(1) );
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return  0 ;
    }

}
