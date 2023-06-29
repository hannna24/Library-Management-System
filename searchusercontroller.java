package com.example.majortask;


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static com.example.majortask.printuserinfocontroller.*;

public class searchusercontroller
{
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML TextField searchtext;
    @FXML Button searchbutton ;
    @FXML Button backbutton;
    @FXML Label foundtext;
    @FXML Label firstnametext;
    @FXML Label lastnametext;
    @FXML Label emaLabeliltext;
    @FXML Label phonenumbertext;
    @FXML Label addresstext;
    @FXML Label idtext;
    @FXML Label passwordtext;
    @FXML Label typetext;
    public static int searchindex;
    public static int loginindex;
    static void setloginindex(int number) {
        loginindex = number;
    }

    public void search(ActionEvent event4) throws Exception {
        String searchText = searchtext.getText(); // Get the text from the search text
        searchindex = Library.searchMember(searchText); // Pass the text to the search function in the Library class
        if (searchindex == -1) {
            System.out.println("notfound");
            foundtext.setText("User not found");
        } else {
            System.out.println(searchText + " is found at index " + searchindex);
            try {
                int searchindex2 = searchindex;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("printuserinfo.fxml"));
                root = loader.load();
                printuserinfocontroller printuserinfocontroller = loader.getController();
                printuserinfocontroller.showResults(searchindex2);

                // root = FXMLLoader.load(getClass().getResource("printuserinfo.fxml"));
                stage = (Stage) ((Node) event4.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                System.out.println("print user info error");
            }
        }
    }

    public void searchDelete(ActionEvent event4) throws Exception {
        String searchText = searchtext.getText(); // Get the text from the search text
        searchindex = Library.searchMember(searchText); // Pass the text to the search function in the Library class
        if (searchindex == -1) {
            System.out.println("notfound");
            foundtext.setText("User not found");
        } else {
            System.out.println(searchText + " is found at index " + searchindex);
            try {
                int searchindex2 = searchindex;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("printuserinfowithdelete.fxml"));
                root = loader.load();
                printuserinfocontroller printuserinfocontroller = loader.getController();
                printuserinfocontroller.showResults(searchindex2);

                // root = FXMLLoader.load(getClass().getResource("printuserinfo.fxml"));
                stage = (Stage) ((Node) event4.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                System.out.println("print user info error");
            }
        }


    }
    public void searchblock(ActionEvent event4) throws Exception {
        String searchText = searchtext.getText(); // Get the text from the search text
        searchindex = Library.searchMember(searchText); // Pass the text to the search function in the Library class
        if (searchindex == -1) {
            System.out.println("notfound");
            foundtext.setText("User not found");
        } else {
            System.out.println(searchText + " is found at index " + searchindex);
            try {
                int searchindex2 = searchindex;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("printuserinfowithblock.fxml"));
                root = loader.load();
                printuserinfocontroller printuserinfocontroller = loader.getController();
                printuserinfocontroller.showResults(searchindex2);

                // root = FXMLLoader.load(getClass().getResource("printuserinfo.fxml"));
                stage = (Stage) ((Node) event4.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {
                System.out.println("print user info error");
            }
        }
    }

    public void backTOadmin (ActionEvent event2) throws Exception {
        if (Library.membersList.get(loginindex).getType().equals("reader")) {
            root = FXMLLoader.load(getClass().getResource("adminuser.fxml"));
            stage = (Stage) backbutton.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }else {
            root = FXMLLoader.load(getClass().getResource("admin.fxml"));
            stage = (Stage) backbutton.getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }
    public void backTOSearch(ActionEvent event) throws Exception {
        root =  FXMLLoader.load(getClass().getResource("searchuser.fxml"));
        stage=(Stage) backbutton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}