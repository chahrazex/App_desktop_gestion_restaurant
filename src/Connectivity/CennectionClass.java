package Connectivity;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

import javax.naming.Context;
import javax.swing.*;
import java.sql.*;

public class CennectionClass {
    StackPane stack ;
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
    public  boolean Add(String table ,String num ,String name , String type, String price)
    {
        CennectionClass cennectionClass =new CennectionClass() ;
        try {
            Connection connection=cennectionClass.getConnection() ;
            Statement statement =connection.createStatement();
           int a= statement.executeUpdate("INSERT INTO "+table+" VALUES ('"+num+"','"+name+"','"+type+"','"+price+"')") ;
           if (a==-1)
           {

           }
           else
           {
               JFXDialogLayout content= new JFXDialogLayout() ;
               content.setHeading(new Text("Sorry !"));
               content.setBody(new Text("Username or Password is Empty"));
               JFXDialog dialog=new JFXDialog(stack,content, JFXDialog.DialogTransition.CENTER) ;
               JFXButton button=new JFXButton("OK");
               button.setOnAction(event1 -> {
                   dialog.close();
               });
               content.setActions(button);
               dialog.show();
           }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true ;
    }

}
