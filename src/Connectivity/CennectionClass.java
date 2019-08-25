package Connectivity;

import Model.Drinks;
import Model.Meals;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    public  boolean Add(String table ,String num ,String name , String type, String price)
    {
        CennectionClass cennectionClass =new CennectionClass() ;
        try {
            Connection connection=cennectionClass.getConnection() ;
            Statement statement =connection.createStatement();
           return statement.execute("INSERT INTO "+table+" VALUES ('"+num+"','"+name+"','"+type+"','"+price+"')");
        } catch (SQLException e) {
            if (table.equals("Meals"))
            {
                JOptionPane.showMessageDialog(null,"Number or Name of meals exist");
            }
            if (table.equals("Drinks"))
            {
                JOptionPane.showMessageDialog(null,"Number or Name of drink exist");
            }
        }

        return true ;
    }
    public ObservableList<Drinks> getDrinks()
    {
        CennectionClass cennectionClass =new CennectionClass() ;
        ObservableList<Drinks> list = FXCollections.observableArrayList() ;
        try {
            Connection connection =cennectionClass.getConnection() ;
            Statement statement=connection.createStatement();
            ResultSet set=statement.executeQuery("SELECT * FROM Drinks") ;
            while (set.next())
            {
                list.add(new Drinks(set.getInt("No_Drink"),set.getString("Name_Drink"),set.getString("Type_Drink"),
                        set.getInt("Price_Drink")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list ;
    }
    public ObservableList<Meals> getMeals()
    {
        CennectionClass cennectionClass =new CennectionClass() ;
        ObservableList<Meals> list = FXCollections.observableArrayList() ;
        try {
            Connection connection =cennectionClass.getConnection() ;
            Statement statement=connection.createStatement();
            ResultSet set=statement.executeQuery("SELECT * FROM Meals") ;
            while (set.next())
            {
                list.add(new Meals(set.getInt("No_Meal"),set.getString("Name_Meal"),set.getString("Type_Meal"),
                        set.getInt("Price_Meal")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list ;
    }
    public boolean Edit(String table ,String cond ,String name , String type, int cost)
    {
        CennectionClass cennectionClass=new CennectionClass() ;
        String sql  ;
        if (table.equals("Drinks"))
        {
            sql="UPDATE Drinks SET Name_drink ='"+name+"', Type_drink='"+type+"', Price_drink='"+cost+ "'"+cond;
        }
        else
        {
            sql="UPDATE Meals SET  Name_meal ='"+name+"', Type_meal='"+type+"', Price_meal="+cost+" "+cond;
        }

        try {
            Connection connection=cennectionClass.getConnection() ;
            Statement statement =connection.createStatement() ;
              statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  false ;
    }
    public boolean Delete(String table ,String cond)
    {
        CennectionClass cennectionClass=new CennectionClass() ;
        String sql ;
        if (table.equals("Meals"))
        {
             sql="DELETE FROM Meals "+cond ;
        }
        else
        {
             sql="DELETE FROM Drinks "+cond ;
        }

        try {
            Connection connection=cennectionClass.getConnection();
            Statement statement=connection.createStatement() ;
            return statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
