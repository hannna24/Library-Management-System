package com.example.majortask;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;

import static com.example.majortask.Library.*;

public class printbookinfocontroller {
    @FXML
    private static Stage stage;
    @FXML
    private static Scene scene;
    @FXML
    private static Parent root;
    @FXML Button backbotton;
    @FXML
    Label idtext;
    @FXML
    Label titletext;
    @FXML
    Label authortext;
    @FXML
    Label isrentedtext;
    static int searchindex;
    @FXML
    Label availabletext;
    @FXML
    static
    Label rentAV;
    public static int loginindex;
    static void setloginindex(int number) {
        loginindex = number;
    }
    public void backTOSearch(ActionEvent event) throws Exception {
        root =  FXMLLoader.load(getClass().getResource("searchbook.fxml"));
        stage=(Stage) backbotton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void backTOSearchrent(ActionEvent event) throws Exception {
        root =  FXMLLoader.load(getClass().getResource("searchrent.fxml"));
        stage=(Stage) backbotton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void setsearchindex(int number) {
        searchindex = number;
    }
    static int setsearchindex0(int number) {
        return number;
    }

    public void showResults(int searchindex) throws Exception {
        try {
            Book b1 = Library.booksList.get(searchindex);
            idtext.setText(String.valueOf(b1.getId()));
            titletext.setText(b1.getTitle());
            authortext.setText(b1.getAuthor());
            isrentedtext.setText(String.valueOf(b1.isRented()));
//            if(b1.getIsReturned()){
//                availabletext.setText("Yes");
//            }else {
//                availabletext.setText("No");
//            }
            setsearchindex(searchindex);
        } catch (Exception e) {
            System.out.println("error showing results ");
        }
    }
//    public void addtowaitinglistonAction(ActionEvent event)throws Exception{
//        addtowaitinglist(searchindex,setsearchindex0());
//    }

//    private int setsearchindex0(int number) {
//        return number;
//    }

    public void removefromwaitinglistonAction(ActionEvent event)throws Exception{
        removefromwaitinglist(searchindex,loginindex);
    }
    public void addtowaitinglist(int searchindex,int userindex) throws Exception {
        try {
            waitinglist.add(new Order(membersList.get(userindex), booksList.get(searchindex)));
        }catch (Exception e)
        {
            System.out.println("ohhhh");
        }
        RWfile.writewaitinglist();
        System.out.println("dona y basha");
    }
    public void removefromwaitinglist(int searchindex,int userindex) throws Exception {
        waitinglist.remove(new Order(membersList.get(userindex),booksList.get(searchindex)));
        RWfile.writewaitinglist();
    }
    public void showResults2(int searchindex) throws Exception {
        try {
            Book b1 = Library.booksList.get(searchindex);
            idtext.setText(String.valueOf(b1.getId()));
            titletext.setText(b1.getTitle());
            authortext.setText(b1.getAuthor());
            isrentedtext.setText(String.valueOf(b1.isRented()));
            setsearchindex(searchindex);
        } catch (Exception e) {
            System.out.println("error showing results  ");
        }
    }

    public static myDate fromLocaltomy(LocalDate date){
        myDate returndate=new myDate(date.getYear(),date.getMonthValue(),date.getDayOfMonth());
        return returndate;
    }

    static public void rent(int searchindex,int userindex) throws Exception {

        if(booksList.get(searchindex).isRented()==false ) {
            if (membersList.get(userindex).isBlocked) {
//                rentAV.setText("Can't Order because You are Blocked");
            } else {
                allOrderList.add(new Order(Library.membersList.get(userindex),
                        booksList.get(searchindex),
                        fromLocaltomy(LocalDate.now()),
                        fromLocaltomy(LocalDate.now().plusDays(14))
                ));
                booksList.get(searchindex).setRented(true);
                membersList.get(userindex).mybookOrderList.add(
                        new Order(Library.membersList.get(userindex),
                                booksList.get(searchindex),
                                fromLocaltomy(LocalDate.now()),
                                fromLocaltomy(LocalDate.now().plusDays(14))
                        ));
                try {
//                    rentAV.setText("Book Rented Successfully");
//                availabletext.setText("Yes");
                    RWfile.writebook();
                    RWfile.writeOrders();
                    System.out.println(booksList.get(searchindex).isRented());
                } catch (Exception e) {
                    System.out.println("empty order error");
                }
            }
//            }else{
//
//            root = FXMLLoader.load(printbookinfocontroller.class.getResource("printbookinfowithrentandwait.fxml"));
//            stage = (Stage) backbutton.getScene().getWindow();
//            scene = new Scene(root);
//            stage.setScene(scene);
//            stage.show();
////            availabletext.setText("No");
//            }

        }}
    public void returnBook(int searchindex2,int userIndex2) throws Exception {

        if(booksList.get(searchindex2).isRented()==true){
            allReturnList.add(new Order(Library.membersList.get(userIndex2),
                    booksList.get(searchindex2),
                    fromLocaltomy(LocalDate.now())));
            booksList.get(searchindex2).setRented(false);
            try {
//                rentAV.setText("Book Returned successfully");
                RWfile.writebook();
                RWfile.writeReturns();

            }catch (Exception e ){
                System.out.println("nothing to write back");
//                rentAV.setText(" ");
            }
        }
        else{
            System.out.println("the book is already rented");
        }
    }
    public  void rentButtonAction() throws Exception {
        rent(searchBookcontroller.ohhh,printuserinfocontroller.loginindex);
    }
    public  void returnButtonAction() throws Exception {
        returnBook(searchBookcontroller.ohhh,printuserinfocontroller.loginindex);
    }
    public void delete() throws Exception {
        booksList.remove(booksList.get(searchindex));
        RWfile.writebook();
//      foundtext.setText("Deleted successfully");
        root = FXMLLoader.load(getClass().getResource("searchbook.fxml"));
        stage = (Stage) backbotton.getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}