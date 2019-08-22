package sample;

import Connectivity.CennectionClass;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public TextField numDrinks ;
    public TextField numMeals  ;
    public JFXTextField NoMeal ,NameMeal ,PriceMeal ;
    public ComboBox TypeMeal,TypeDrink ;
    public AnchorPane Meals ,Drinks;
    public void AddMeals()
    {
        CennectionClass cennectionClass=new CennectionClass() ;
        try {
            Connection connection =cennectionClass.getConnection() ;
            Statement statement=connection.createStatement() ;
            statement.executeUpdate("INSERT INTO MEALS (No_meal,Name_meal,Type_meal,Price_meal) " +
                    "VALUES ('"+NoMeal.getText()+"','"+NameMeal.getText()+"','"+TypeMeal.getValue()+"','"+PriceMeal.getText()+"')");
            numMeals.setText(CennectionClass.count("No_meal","Meals")+"");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void showMeals()
    {
        Meals.setVisible(true);
        Drinks.setVisible(false);
    }
    public void showDrinks()
    {
        Meals.setVisible(false);
        Drinks.setVisible(true);
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        numDrinks.setText(CennectionClass.count("No_drink","Drinks")+"");
        numMeals.setText(CennectionClass.count("No_meal","Meals")+"");
        TypeMeal.getItems().addAll("Fish","Grills","Meat","Salad") ;
        TypeDrink.getItems().addAll( "Soft","Non-carbonated ","juice") ;
    }
}
