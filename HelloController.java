package com.example.majortask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class HelloController {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    Button logoutButton ;
    @FXML
    Button loginButton ;

    @FXML
    TextField IDField ;
    @FXML
    Label LoginFailedMessage=null ;
    @FXML
    PasswordField PassField ;
    public void logout(ActionEvent event) throws Exception {

        root =  FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public  void AuthLogin(ActionEvent event) throws Exception {
        RWfile.readuser();
        RWfile.readbook();
        RWfile.readOrders();
//        RWfile.readBlocks();
        RWfile.readwaitinglist();
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter username: ");
        String inpUser = IDField.getText();
        System.out.print("Enter password: ");
        String inpPass = PassField.getText();

        int  index = Library.searchMemberById(inpUser);
        if (index != -1 && Library.membersList.get(index).password == Integer.valueOf(inpPass)) {
            System.out.println("Login successful");

            if (Library.membersList.get(index).getType().equals("reader")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("printuserinfo.fxml"));
                root = loader.load();
                printuserinfocontroller printuserinfocontroller = loader.getController();
                printuserinfocontroller.setloginindex(index);
                searchusercontroller.setloginindex(index);
                searchBookcontroller.setloginindex(index);
                myordercontroller.setloginindex(index);
                waitingcontroller.setloginindex(index);


                // Go to admin user page
                FXMLLoader adminLoader = new FXMLLoader(getClass().getResource("adminuser.fxml"));
                Parent adminRoot = adminLoader.load();
                stage = (Stage) loginButton.getScene().getWindow();
                scene = new Scene(adminRoot);
                stage.setScene(scene);
                stage.show();
            } else {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("printuserinfo.fxml"));
                root = loader.load();
                printuserinfocontroller printuserinfocontroller = loader.getController();
                com.example.majortask.printuserinfocontroller.setloginindex(index);


                // Go to admin page
                FXMLLoader adminLoader = new FXMLLoader(getClass().getResource("admin.fxml"));
                Parent adminRoot = adminLoader.load();
                stage = (Stage) loginButton.getScene().getWindow();
                scene = new Scene(adminRoot);
                stage.setScene(scene);
                stage.show();
            }
        } else {
            System.out.println("Login failed");
            LoginFailedMessage.setText("Wrong Credentials");
        }
    }
}