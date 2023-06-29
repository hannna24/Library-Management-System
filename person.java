package com.example.majortask;


import java.util.ArrayList;

public class person {
    String id;
    int password;
    String type;
    String firstName;
    String lastName;
    String address;
    int cellPhone;
    String email;
    boolean isBlocked;
    //Book myOrderList;

    ArrayList<Order> mybookOrderList = new ArrayList();
    public person(String id, int password, String type, String firstName, String lastName, String address, int cellPhone, String email, boolean isBlocked) {
        this.id = id;
        this.password = password;
        this.type = type;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.cellPhone = cellPhone;
        this.email = email;
        this.isBlocked = isBlocked;
        this.mybookOrderList = new ArrayList<>();
    }

    public person(String firstName) {
        this.firstName = firstName;
    }

    public person() {

    }

    public person(String s, String ahmed) {
        this.id=s;
        this.firstName=ahmed;
    }

    public String getId() {
        System.out.println("The ID is: "+id);
        return id;
    }

    public int getPassword() {
        if(type=="Librarian")
        {
            System.out.println("The password is: "+password);
            return password;
        }
        else
        {
            System.out.println("You dont have access to view the password");
        }
        return 0;
    }

    public String getType() {
        System.out.println("The type is: "+type);
        return type;
    }

    public String getFirstName() {
        System.out.println("First name: "+firstName);
        return firstName;
    }

    public String getLastName() {
        System.out.println("Last name: "+lastName);
        return lastName;
    }

    public String getAddress() {
        System.out.println("The address is: "+address);
        return address;
    }

    public int getCellPhone() {
        System.out.println("The phone number is: "+cellPhone);
        return cellPhone;
    }

    public String getEmail() {
        System.out.println("The email is: "+email);
        return email;
    }

    public boolean getIsBlocked() {
        System.out.println("Blocked: "+isBlocked);
        return isBlocked;
    }
    public boolean getIsBlockedTF() {
        return isBlocked;
    }

//    public Book getMyOrderList() {
//        System.out.println("Order List: ");
//        return myOrderList;
//    }
//


    //This method prints all the data of the person
    void printInfo()
    {
        getId();
        getPassword();
        getType();
        getFirstName();
        getLastName();
        getAddress();
        getCellPhone();
        getEmail();
        getIsBlocked();
        //xyz.getMyOrderList();

    }

    void rentBook(String bookName,String bookAuthor){

    }

    public void setBlocked(boolean b) {
        this.isBlocked=b;
    }
}
