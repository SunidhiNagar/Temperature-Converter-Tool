package com.example.demo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MyController implements Initializable {
    @FXML
    public Label labelWelcome;

    @FXML
    public TextField text;

    @FXML
    public ChoiceBox<String>choice;

    @FXML
    public Button button;
    private static final String C_to_F="Celsius to Fahrenheit";
    private static final String F_to_C=" Fahrenheit to Celsius";
private  boolean isC_to_F=true;
    @Override

    public void initialize(URL url, ResourceBundle resourceBundle) {
        choice.getItems().add(C_to_F);
        choice.getItems().add(F_to_C);
        choice.setValue(C_to_F);

        choice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                if(t1.equals(C_to_F)){
                    isC_to_F=true;
                }else{
                    isC_to_F=false;
                }
            }
        });
        button.setOnAction(actionEvent ->convert());

    }
    public void convert() {
        String input = text.getText(); //23.4->  "23.4"
      float enteredTemp=0.0f;
       try {
            enteredTemp = Float.parseFloat(input);//converts it again to float or int i.e 23.4f
       }catch(Exception e){
           warnUser();
           return; //no code will be excecuted further
       }


       float newTemperature=0.0f;
        if (isC_to_F) {
            newTemperature = (enteredTemp * 9 / 5) + 32;
        }else{
            newTemperature=(enteredTemp-32)*5/9;
        }
            display(newTemperature);
    }
public void warnUser(){
    Alert alert = new Alert(Alert.AlertType.ERROR);
   alert.setHeaderText("Invalid Temperature Entered");
    alert.setTitle("Error Occured");
    alert.setContentText("Enter a valid Temperature");
    alert.show();


}

    private void display(float newTemperature ) {
        String unit = isC_to_F ? "F" : "C";
        System.out.println("The new temperature is :" + newTemperature + unit);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("The new Temperature is " + newTemperature + unit);
   alert.show();
    }

}
