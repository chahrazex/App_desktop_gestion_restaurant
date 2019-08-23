package sample;

import Connectivity.CennectionClass;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
    public JFXTextField NoDrink ,NameDrink ,PriceDrink ;
    public ComboBox TypeMeal,TypeDrink ;
    public AnchorPane Meals ,Drinks;
    public void AddMeals()
    {
        CennectionClass cennectionClass=new CennectionClass() ;
        cennectionClass.Add("Meals",NoMeal.getText(),NameMeal.getText(),TypeMeal.getValue().toString(),PriceMeal.getText()) ;
        numMeals.setText(CennectionClass.count("No_meal","Meals")+"");
    }
    public void AddDrinks()
    {
        CennectionClass cennectionClass=new CennectionClass() ;
        cennectionClass.Add("Drinks",NoDrink.getText(),NameDrink.getText(),TypeDrink.getValue().toString(),PriceDrink.getText()) ;
        numDrinks.setText(CennectionClass.count("No_drink","Drinks")+"");
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
