package com.example.demo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hello-view.fxml"));
        VBox rootNode = loader.load();

        // Corrected the Scene creation to use rootNode
        Scene scene = new Scene(rootNode, 320, 240);

        stage.setTitle("Temperature Converter Tool");
        stage.setScene(scene);
        stage.show();

        // Calling the CreateMenu method with the rootNode
        CreateMenu(rootNode);
    }

    // Changed the return type to void
    private void CreateMenu(VBox rootNode) {
        Menu menu = new Menu("File");
        MenuItem menuitem = new MenuItem("New");
        menuitem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Clicked");
            }
        });
        MenuItem quit = new MenuItem("Quit");

        quit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
                System.exit(0);
            }
        });
        //lambda is used minimize the above code in
        // a simple way as given below

        /*  2 ways
        1....        either hover on"new EventHandle........"
        2.........     write as below

        quit.setOnAction(ActionEvent->{   Platform.exit();
                System.exit(0);
            });
         */











        SeparatorMenuItem s = new SeparatorMenuItem();
        menu.getItems().addAll(menuitem,s,quit);
        Menu help = new Menu("Help");
        MenuItem helpItem = new MenuItem("help");


        MenuItem aboutItem=new MenuItem("About");
        // Calling a method
        aboutItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                About();
            }
        });
        help.getItems().addAll(helpItem,aboutItem);
        MenuBar menuBar = new MenuBar();

        rootNode.getChildren().add(0,menuBar);
        menuBar.getMenus().addAll(menu, help);
    }

    public static void About(){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Desktop Application");
        alert.setHeaderText("Learning FX");
        alert.setContentText("Are you sure");
        ButtonType buttonType=new ButtonType("yes");
        ButtonType buttonType2=new ButtonType("No");
alert.getButtonTypes().setAll(buttonType,buttonType2);
        Optional<ButtonType>ClickedBtn=alert.showAndWait();
        if(ClickedBtn.isPresent()&&ClickedBtn.get()==buttonType){
            System.out.println("Yes button clicked ");
        }
        else{
            System.out.println("No button clicked ");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}


