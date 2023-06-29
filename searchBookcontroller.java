package com.example.majortask;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class searchBookcontroller
{
    @FXML
    private Stage stage;
    @FXML
    private Scene scene;
    @FXML
    private Parent root;
    @FXML
    TextField searchtext;
    @FXML
    Button backbutton;
    @FXML
    Button searchbutton ;
    @FXML
    Label foundtext;
    @FXML
    Label foundtext2;
    public static int searchindex;
    public static int loginindex;
    static void setloginindex(int number) {
        loginindex = number;
    }

    public void search(ActionEvent event) throws Exception {
        String searchText = searchtext.getText(); // Get the text from the search text
        int i = Library.searchBooks(searchText); // Pass the text to the search function in the Library class
        if (i == -1) {
            System.out.println("notfound");
            foundtext.setText("User not found");
        } else {
            System.out.println(searchText + " is found at index " + i);
            int searchindex2 =i;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("printbookinfo.fxml"));
            root = loader.load();
            printbookinfocontroller printbookinfocontroller = loader.getController();
            printbookinfocontroller.showResults(searchindex2);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();


        }

    }
    public static int ohhh;
    public void searchRent(ActionEvent event) throws Exception {
        ohhh=searchindex;
        String searchText = searchtext.getText(); // Get the text from the search text
        int i = Library.searchBooks(searchText); // Pass the text to the search function in the Library class
        ohhh=i;
        if (i == -1) {
            System.out.println("notfound");
            foundtext.setText("book not found");
        } else {
            System.out.println(searchText + " is found at index " + i);
            int searchindex2 =i;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("printbookinfowithrent.fxml"));
            root = loader.load();
            try {
                printbookinfocontroller printbookinfocontroller = loader.getController();
                printbookinfocontroller.showResults2(searchindex2);

                // root = FXMLLoader.load(getClass().getResource("printuserinfo.fxml"));
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }catch (Exception e){
                System.out.println("hhh");
            }
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("printbookinfowithrent.fxml"));
//            root = loader.load();
//            printbookinfocontroller printbookinfocontroller = loader.getController();
//            printbookinfocontroller.showResults2(searchindex2);
//            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//            scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();


        }
//        public void gotoprintbookinfowithrent()
//        {
//            root =  FXMLLoader.load(getClass().getResource("printbookinfowithrent.fxml"));
//            stage=(Stage) backbutton.getScene().getWindow();
//            scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
//        }

    }

    public void searchReturn(ActionEvent event) throws Exception {
        String searchText = searchtext.getText(); // Get the text from the search text
        int i = Library.searchBooks(searchText); // Pass the text to the search function in the Library class
        if (i == -1) {
            System.out.println("notfound");
            foundtext.setText("User not found");
        } else {
            System.out.println(searchText + " is found at index " + i);
            int searchindex2 =i;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("printbookinfowithrent.fxml"));
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
    public void searchDelete(ActionEvent event4) throws Exception {
        String searchText = searchtext.getText(); // Get the text from the search text
        searchindex = Library.searchBooks(searchText); // Pass the text to the search function in the Library class
        if (searchindex == -1) {
            System.out.println("notfound");
            foundtext2.setText("book not found");
        } else {
            System.out.println(searchText + " is found at index " + searchindex);
//            try {
            int searchindex2 = searchindex;
            FXMLLoader loader = new FXMLLoader(getClass().getResource("printbookinfowithdelete.fxml"));
            root = loader.load();
            printbookinfocontroller printbookinfocontroller = loader.getController();
            printbookinfocontroller.showResults2(searchindex2);

            // root = FXMLLoader.load(getClass().getResource("printuserinfo.fxml"));
            stage = (Stage) ((Node) event4.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

//            } catch (Exception e) {
//                System.out.println("print book info error");
//            }
        }
    }
    public void backTOSearch(ActionEvent event) throws Exception {
        root =  FXMLLoader.load(getClass().getResource("searchbook.fxml"));
        stage=(Stage) backbutton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}