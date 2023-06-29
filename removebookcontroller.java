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
public class removebookcontroller {
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    TextField searchtext;
    @FXML
    TextField foundtext;
    @FXML
    Button backbutton;
    public void search(ActionEvent event) throws Exception {
        String searchText = searchtext.getText(); // Get the text from the search text
        int i = Library.searchBooks(searchText); // Pass the text to the search function in the Library class
        if (i == -1) {
            System.out.println("notfound");
            foundtext.setText("User not found");
        } else {
            System.out.println(searchText + " is found at index " + i);
//            try {
            int searchindex2 =i;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("printbookinfowithdelete.fxml"));
            root = loader.load();
            printbookinfocontroller printbookinfocontroller = loader.getController();
            printbookinfocontroller.showResults(searchindex2);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

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