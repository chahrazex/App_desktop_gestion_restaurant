package sample;

import Connectivity.CennectionClass;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class Login implements Initializable {
    @FXML
    JFXTextField username  ;
    @FXML
    JFXPasswordField password ;
    public  void login(Event event) throws IOException {
        if(username.getText().isEmpty() || password.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(null, "username or password is Empty");
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
