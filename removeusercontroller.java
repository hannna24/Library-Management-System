package com.example.majortask;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class removeusercontroller
{
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    Button searchUserButton;
    @FXML
    Button backbutton;
    @FXML
    TextField searchtext;
    public void search(ActionEvent event) {
        String searchText = searchtext.getText(); // Get the text from the search text
        int i = Library.searchMember(searchText); // Pass the text to the search function in the Library class
        if (i == -1) {
            System.out.println("heee");
        } else {
            System.out.println(searchText + " is found at index " + i);
            try {
                root = FXMLLoader.load(getClass().getResource("printuserinfowithdelete.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                System.out.println("add user error");
            }
        }
    }

    public void backTOadmin (ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("admin.fxml"));
        stage = (Stage) backbutton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}