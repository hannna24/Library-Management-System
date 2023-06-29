package com.example.majortask;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class admincontroller {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    Button addUserButton;
    @FXML
    Button removeUserButton;
    @FXML
    Button searchUserButton;
    @FXML
    Button addbookButton;
    @FXML
    Button searchbookButton;
    @FXML
    Button removebookButton;


    public void addUser(ActionEvent event3) throws Exception {
        try {
            root = FXMLLoader.load(getClass().getResource("adduser.fxml"));
            stage = (Stage) ((Node) event3.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("add user error");

        }

    }
    public void viewOrders(ActionEvent event3) throws Exception {
        try {
            root = FXMLLoader.load(getClass().getResource("printinfoallord2.fxml"));
            stage = (Stage) ((Node) event3.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("orders all  error");

        }

    }
    public void viewMyOrders(ActionEvent event3) throws Exception {
        try {
            root = FXMLLoader.load(getClass().getResource("printinfomyord.fxml"));
            stage = (Stage) ((Node) event3.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println(" my orders all  error");

        }

    }
    public void addbook(ActionEvent event6) throws Exception {
        try {
            root = FXMLLoader.load(getClass().getResource("addbook.fxml"));
            stage = (Stage) ((Node) event6.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("add book error");

        }

    }
    public void searchbook(ActionEvent event7) throws Exception {
        try {
            root = FXMLLoader.load(getClass().getResource("searchbook.fxml"));
            stage = (Stage) ((Node) event7.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("add book error");

        }

    }
    public void searchRent(ActionEvent event7) throws Exception {
        try {
            root = FXMLLoader.load(getClass().getResource("searchrent.fxml"));
            stage = (Stage) ((Node) event7.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("add book error");

        }

    }
    public void removebook(ActionEvent event8) throws Exception {
        try {
            root = FXMLLoader.load(getClass().getResource("searchremovebook.fxml"));
            stage = (Stage) ((Node) event8.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("add book error");

        }

    }
    public void searchUser(ActionEvent event4) throws Exception {
        try {
            root = FXMLLoader.load(getClass().getResource("searchuser.fxml"));
            stage = (Stage) ((Node) event4.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("search user errorrrrr");
        }

    }
    public void removeuser(ActionEvent event5) throws Exception {
        try {
            root = FXMLLoader.load(getClass().getResource("searchremoveuser.fxml"));
            stage = (Stage) ((Node) event5.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("add user error");

        }
    }
    public void logout (ActionEvent event) throws Exception {

        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void blockuser(ActionEvent event6) throws Exception {
        try {
            root = FXMLLoader.load(getClass().getResource("searchusertoblock.fxml"));
            stage = (Stage) ((Node) event6.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("add user error");

        }
    }
    public void returnBookButton(ActionEvent event6) throws Exception {
        try {
            root = FXMLLoader.load(getClass().getResource("searchrent.fxml"));
            stage = (Stage) ((Node) event6.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("add user error");

        }
    }
    public void searchreturn(ActionEvent event6) throws Exception {
//        try {
        root = FXMLLoader.load(getClass().getResource("searchreturn.fxml"));
        stage = (Stage) ((Node) event6.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
//        } catch (Exception e) {
//            System.out.println("add user error");
//
//        }
    }
    public void waitingButton(ActionEvent event6) throws Exception {
        try {
            root = FXMLLoader.load(getClass().getResource("waitinglist.fxml"));
            stage = (Stage) ((Node) event6.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            System.out.println("waiting list error");

        }
    }

}