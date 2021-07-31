package controllers;

import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import mysock.SockClient;
import javafx.concurrent.Task;

public class MainController{




@FXML
private Button someThing;



    public void clickUP(ActionEvent e){
        System.out.println(someThing.getText());
        System.out.println("WORKING");
      
    }

}
