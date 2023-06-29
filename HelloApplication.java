package com.example.majortask;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;

import static com.example.majortask.Library.allOrderList;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Library Management System");
            stage.setScene(scene);
            stage.setHeight(400);
            stage.setWidth(600);
            stage.setResizable(true);
            //Image icon = new Image("src\\Icon.png");
            //stage.getIcons().add(icon);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}