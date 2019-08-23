package sample;

import Connectivity.CennectionClass;
import Model.Drinks;
import Model.Meals;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    public  CennectionClass cont ;
    public TextField numDrinks ;
    public TextField numMeals  ;
    public JFXTextField NoMeal ,NameMeal ,PriceMeal ;
    public JFXTextField NoDrink ,NameDrink ,PriceDrink ;
    public ComboBox TypeMeal,TypeDrink ;
    public AnchorPane Meals ,Drinks;

    public ObservableList<Meals> listM ;
    public TableView <Model.Meals> TableM ;
    public TableColumn<Meals,Integer> numCM ;
    public TableColumn<Meals,String> nameCM ;
    public TableColumn<Meals,String> typeCM ;
    public TableColumn<Meals,Integer> costCM ;

    public ObservableList<Drinks> listD;
    public TableView <Model.Drinks> TableD ;
    public TableColumn<Drinks,Integer> numCD ;
    public TableColumn<Drinks,String> nameCD ;
    public TableColumn<Drinks,String> typeCD ;
    public TableColumn<Drinks,Integer> costCD ;


    public void AddMeals()
    {
        CennectionClass cennectionClass=new CennectionClass() ;
       int id =Integer.parseInt(NoMeal.getText());
        String name =NameMeal.getText() ;
        String type =TypeMeal.getValue().toString();
        int cost =Integer.parseInt(PriceMeal.getText());

        cennectionClass.Add("Meals",String.valueOf(id),name,type,String.valueOf(cost)) ;
        listM.add(new Meals(id ,name,type,cost)) ;
        numMeals.setText(CennectionClass.count("No_meal","Meals")+"");
    }
    public void AddDrinks()
    {
        CennectionClass cennectionClass=new CennectionClass() ;

       cennectionClass.Add("Drinks",NoDrink.getText(),NameDrink.getText(),
            TypeDrink.getValue().toString(),PriceDrink.getText()) ;
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
        numCM.setCellValueFactory(new PropertyValueFactory<Meals,Integer>("num"));
        nameCM.setCellValueFactory(new PropertyValueFactory<Meals,String>("name"));
        typeCM.setCellValueFactory(new PropertyValueFactory<Meals,String>("type"));
        costCM.setCellValueFactory(new PropertyValueFactory<Meals,Integer>("cost"));
        CennectionClass cennectionClass=new CennectionClass() ;
        listM=cennectionClass.getMeals();
        TableM.setItems(listM);

        numCD.setCellValueFactory(new PropertyValueFactory<Drinks,Integer>("num"));
        nameCD.setCellValueFactory(new PropertyValueFactory<Drinks,String>("name"));
        typeCD.setCellValueFactory(new PropertyValueFactory<Drinks,String>("type"));
        costCD.setCellValueFactory(new PropertyValueFactory<Drinks,Integer>("cost"));
        listD=cennectionClass.getDrinks();
        TableD.setItems(listD);

        numDrinks.setText(CennectionClass.count("No_drink","Drinks")+"");
        numMeals.setText(CennectionClass.count("No_meal","Meals")+"");
        TypeMeal.getItems().addAll("Fish","Grills","Meat","Salad") ;
        TypeDrink.getItems().addAll( "Soft","Non-carbonated ","juice") ;
    }
}
