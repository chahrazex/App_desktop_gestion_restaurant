package sample;

import Connectivity.CennectionClass;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Login extends StackPane implements Initializable {
    @FXML
    JFXTextField username  ;
    @FXML
    JFXPasswordField password ;
    @FXML
    StackPane stack ;
    public  void login(Event event) throws IOException {
        if(username.getText().isEmpty() || password.getText().isEmpty())
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
        else
        {
            if (username.getText().trim().equals("admin")&& password.getText().equals("1234"))
            {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                    Scene scene =new Scene(root) ;
                    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow() ;
                    stage.setScene(scene);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
