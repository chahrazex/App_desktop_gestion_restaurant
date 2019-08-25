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

    public  int indexM=-1 ,indexD=-1;

    /*----------------------Fonctions of Meals------------------------*/
    public void showMeals()
    {
        Meals.setVisible(true);
        Drinks.setVisible(false);
    }
    public void AddMeals()
    {
        try {
            CennectionClass cennectionClass=new CennectionClass() ;
            int id =Integer.parseInt(NoMeal.getText());
            String name =NameMeal.getText() ;
            String type =TypeMeal.getValue().toString();
            int cost =Integer.parseInt(PriceMeal.getText());
            cennectionClass.Add("Meals",String.valueOf(id),name,type,String.valueOf(cost)) ;
            listM.add(new Meals(id ,name,type,cost)) ;
            numMeals.setText(CennectionClass.count("No_meal","Meals")+"");
            clearM();
        }catch (Exception e)
        {

        }

    }
    public void  EditMeals()
    {
        try {
            int id =Integer.parseInt(NoMeal.getText());
            String name =NameMeal.getText() ;
            String type =TypeMeal.getValue().toString();
            int cost =Integer.parseInt(PriceMeal.getText());
            CennectionClass cennectionClass=new CennectionClass() ;
            cennectionClass.Edit("Meals","where No_meal="+id ,name,type,cost)  ;
            listM.set(indexM ,new Meals(listM.get(indexM).getNum() ,name,type,cost)) ;
            clearM();
        }catch (Exception e){}

    }
    public  void DeleteMeals()
    {
        try {
            int id =Integer.parseInt(NoMeal.getText());
            CennectionClass cennectionClass=new CennectionClass() ;
            cennectionClass.Delete("Meals","where No_meal="+id);
            numMeals.setText(CennectionClass.count("No_meal","Meals")+"");
            listM.remove(indexM);
        }catch (Exception e){}
        clearM();

    }
    public void  getSelectionM()
    {
        indexM=TableM.getSelectionModel().getSelectedIndex() ;

        if (indexM<=-1) {
            return;
        }
        else {
            NoMeal.setText(numCM.getCellData(indexM).toString());
            NameMeal.setText(nameCM.getCellData(indexM));
            TypeMeal.getSelectionModel().select(typeCM.getCellData(indexM));
            PriceMeal.setText(costCM.getCellData(indexM).toString());
        }
    }
    public void clearM()
    {
        NameMeal.clear();
        NoMeal.clear();
        PriceMeal.clear();
        TypeMeal.getSelectionModel().select(-1);
    }
    /*-----------------------Fonctions of Drinks----------------------*/
    public void showDrinks()
    {
        Meals.setVisible(false);
        Drinks.setVisible(true);
    }
    public void AddDrinks()
    {
        try {
            CennectionClass cennectionClass=new CennectionClass() ;
            int id =Integer.parseInt(NoDrink.getText());
            String name =NameDrink.getText() ;
            String type =TypeDrink.getValue().toString();
            int cost =Integer.parseInt(PriceDrink.getText());
            cennectionClass.Add("Drinks",String.valueOf(id),name, type,String.valueOf(cost)) ;
            listD.add(new Drinks(id ,name,type,cost)) ;
            numDrinks.setText(CennectionClass.count("No_drink","Drinks")+"");
            clearD();
        }catch (Exception e) {}

    }
    public void  EditDrinks()
    {
        try {
            CennectionClass cennectionClass=new CennectionClass() ;
            int id =Integer.parseInt(NoDrink.getText());
            String name =NameDrink.getText() ;
            String type =TypeDrink.getValue().toString();
            int cost =Integer.parseInt(PriceDrink.getText());
            cennectionClass.Edit("Drinks","where No_drink="+id ,name,type,cost)  ;
            listD.set(indexD ,new Drinks(listD.get(indexD).getNum() ,name,type,cost)) ;
            clearD();
        }catch (Exception e){}

    }
    public  void DeleteDrinks()
    {
        try {
            int id =Integer.parseInt(NoDrink.getText());
            CennectionClass cennectionClass=new CennectionClass() ;
            cennectionClass.Delete("Drinks","where No_drink="+id);
            numDrinks.setText(CennectionClass.count("No_drink","Drinks")+"");
            listD.remove(indexD);
        }catch (Exception e){}
        clearD();
    }
    public void clearD()
    {
        NameDrink.clear();
        NoDrink.clear();
        PriceDrink.clear();
        TypeDrink.getSelectionModel().select(-1);
    }
    public void  getSelectionD()
    {
        indexD=TableD.getSelectionModel().getSelectedIndex() ;
       if(indexD !=-1)
       {
            NoDrink.setText(numCD.getCellData(indexD).toString());
            NameDrink.setText(nameCD.getCellData(indexD));
           TypeDrink.getSelectionModel().select(typeCD.getCellData(indexD));
            PriceDrink.setText(costCD.getCellData(indexD).toString());
        }
    }
    /*-------------------------------------------------------------------*/
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
