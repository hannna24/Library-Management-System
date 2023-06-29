package com.example.majortask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import java.math.BigInteger;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Scanner;
public abstract class RWfile {
    final static String  RWfilepath="C:\\Users\\DELL\\IdeaProjects\\Majortask\\src\\main\\java\\com\\example\\majortask\\Memberdata.txt";
    final static String  RWfilepath2="C:\\Users\\DELL\\IdeaProjects\\Majortask\\src\\main\\java\\com\\example\\majortask\\bookdata.txt";
    final static String  RWordersfilepath="C:\\Users\\DELL\\IdeaProjects\\Majortask\\src\\main\\java\\com\\example\\majortask\\AllOrders.txt";
    final static String  RWreturnsfilepath="C:\\Users\\DELL\\IdeaProjects\\Majortask\\src\\main\\java\\com\\example\\majortask\\AllReturns.txt";
    final static String  RWblockfilepath="toBeBlocked.txt";
    final static String RWwaitinglistfilepath="C:\\Users\\DELL\\IdeaProjects\\Majortask\\src\\main\\java\\com\\example\\majortask\\waitinglist.txt";
    //Members List//
    public static void readuser() throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(new File(RWfilepath));
        // Create a Scanner object for the file.

        // While there are still lines in the file, create a Person object and add it to the ArrayList.
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(",");
            if (tokens.length >= 7) {
                String id = tokens[0];
                int password = Integer.parseInt(tokens[1]);
                String type = tokens[2];
                String firstName = tokens[3];
                String lastName = tokens[4];
                String address = tokens[5];
                int cellPhone = Integer.parseInt(tokens[6]);
                String email = tokens[7];
                boolean isBlocked = Boolean.parseBoolean(tokens[8]);
                person person = new person(id, password, type, firstName, lastName, address, cellPhone, email, isBlocked);
                Library.membersList.add(person);
            }
        }

        // Close the Scanner object.
        scanner.close();

    }
    public static String toString(person person) {
        return  person.id + "," + person.password + "," + person.type + "," + person.firstName + "," + person.lastName + "," + person.address + "," + person.cellPhone + "," + person.email + "," + person.getIsBlockedTF() ;
    }
    public static void writeuser() throws FileNotFoundException, IOException {
        // Create a FileWriter object for the file.
        FileWriter fileWriter = new FileWriter(RWfilepath);
        //to empty the content of the file
        fileWriter.write("");

        // Write the contents of the ArrayList to the file.
        for (person person : Library.membersList) {
            fileWriter.write(toString(person) + "\n");
        }

        // Close the FileWriter object.
        fileWriter.close();
    }

    //Books List//
    public static void readbook() throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(new File(RWfilepath2));
        // Create a Scanner object for the file.

        // While there are still lines in the file, create a Person object and add it to the ArrayList.
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(",");
            if (tokens.length >= 2) {
                int id = Integer.parseInt(tokens[0]);
                String title = tokens[1];
                String author = tokens[2];
                boolean rented = Boolean.parseBoolean(tokens[3]);
                Book book = new Book(id, title, author,rented);
                Library.booksList.add(book);
            }
        }

        // Close the Scanner object.
        scanner.close();

    }
    public static String toString2(Book book) {
        return  book.getId() + "," + book.getTitle() + "," + book.getAuthor()+ "," + book.isRented()  ;
    }
    public static void writebook() throws FileNotFoundException, IOException {
        // Create a FileWriter object for the file.
        FileWriter fileWriter = new FileWriter(RWfilepath2);

        //to empity the content of the file
        fileWriter.write("");
        // Write the contents of the ArrayList to the file.
        for (Book book : Library.booksList) {
            fileWriter.write(toString2(book) + "\n");
        }

        // Close the FileWriter object.
        fileWriter.close();
    }

    //Date Strings//
    public String getString(myDate Date){
        return Date.toStringDate(Date);
    }
    public static myDate getDate(String s){
        myDate date= new myDate(2003,4,16);
        return date.toDateString(s);
    }
    static myDate Date1,Date2,Date3,Date4,Date5;

    //Rent Orders List//
    public static void readOrders() throws FileNotFoundException,IOException,Exception {
        // Create a Scanner object for the file.
        Scanner scanner = new Scanner(new File(RWordersfilepath));

        // While there are still lines in the file, create a Person object and add it to the ArrayList.
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(",");
            if (tokens.length >= 8) {
                String[] subtokens = tokens[0].split(":");
                int orderno = Integer.valueOf(subtokens[1]);
                String id = tokens[1];
                String firstName = tokens[2];
                String title = tokens[3];
                BigInteger isbn = BigInteger.valueOf(Long.parseLong(tokens[4]));
                int personid = Integer.parseInt(tokens[5]);
                int bookid = Integer.parseInt(tokens[6]);
                String date1 = tokens[7];
                Date1 = getDate(date1);
                String date2 = tokens[8];
                Date2 = getDate(date2);

                Order order2 = new Order(
                        Library.membersList.get(personid),
                        Library.booksList.get(bookid), Date1, Date2);
                Library.allOrderList.add(order2);
                Library.membersList.get(personid).mybookOrderList.add(order2);
                order2.getBook().setIsReturned(false);
            }
        }
        // Close the Scanner object.
        scanner.close();
    }
    public static String toString3(Order order1) throws Exception {

        return           "Rent Order no:"+Library.allOrderList.indexOf(order1)+","+order1.getP1().id+","+order1.getP1().firstName+","
                +order1.getBook().Title+","+order1.getBook().id+","
                +Library.searchMember(order1.getP1().firstName)+","+Library.searchBooks(order1.getBook().Title)+","
                +order1.getDateOrderedString()+","+order1.getDateToReturnString();


    }
    public static void writeOrders() throws Exception {

        // Create a FileWriter object for the file.
        FileWriter fileWriter = new FileWriter(RWordersfilepath);

        //to empty the content of the file
        fileWriter.write("");
        // Write the contents of the ArrayList to the file.
        for (Order o2 : Library.allOrderList) {
            fileWriter.write(toString3(o2) + "\n");
            o2.getP1().mybookOrderList.add(o2);
        }

        // Close the FileWriter object.
        fileWriter.close();
    }

    //Return Orders List//
    public static void readReturns() throws FileNotFoundException,IOException,Exception {
        // Create a Scanner object for the file.
        Scanner scanner = new Scanner(new File(RWreturnsfilepath));

        // While there are still lines in the file, create a Person object and add it to the ArrayList.
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(",");
            if (tokens.length >= 7) {
                String[] subtokens = tokens[0].split(":");
                int orderno = Integer.valueOf(subtokens[1]);
                String id = tokens[1];
                String firstName = tokens[2];
                String title = tokens[3];
                BigInteger isbn = BigInteger.valueOf(Long.parseLong(tokens[4]));
                int personid = Integer.parseInt(tokens[5]);
                int bookid = Integer.parseInt(tokens[6]);
                String date3 = tokens[7];
                Date3= getDate(date3);


                Order order3 = new Order(
                        Library.membersList.get(personid),
                        Library.booksList.get(bookid), Date3);
                Library.allReturnList.add(order3);
                Library.membersList.get(personid).mybookOrderList.add(order3);
                order3.getBook().setIsReturned(true);
            }
        }
        // Close the Scanner object.
        scanner.close();
    }
    public static String toString4(Order order1) throws Exception {

        return           "Return Order no:"+Library.allReturnList.indexOf(order1)+","+order1.getP1().id+","+order1.getP1().firstName+","
                +order1.getBook().Title+","+order1.getBook().id+","
                +Library.searchMember(order1.getP1().firstName)+","+Library.searchBooks(order1.getBook().Title)+","
                +order1.getDateReturnedString();


    }
    public static void writeReturns() throws Exception {

        // Create a FileWriter object for the file.
        FileWriter fileWriter = new FileWriter(RWreturnsfilepath);

        //to empty the content of the file
        fileWriter.write("");
        // Write the contents of the ArrayList to the file.
        for (Order o2 : Library.allReturnList) {
            fileWriter.write(toString4(o2) + "\n");
        }

        // Close the FileWriter object.
        fileWriter.close();
    }

    //to block List//
    public static void readBlocks() throws FileNotFoundException,IOException,Exception {
        // Create a Scanner object for the file.
        Scanner scanner = new Scanner(new File(RWblockfilepath));

        // While there are still lines in the file, create a Person object and add it to the ArrayList.
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(",");
            if (tokens.length >= 7) {
                String[] subtokens = tokens[0].split(": ");
                String firstname = subtokens[1];
                String id = tokens[1];
                String title = tokens[2];
                String date4 = tokens[3];
                String date5 = tokens[4];
                String[] subtokens2 = tokens[5].split(": ");
                int lateby = Integer.valueOf(subtokens2[1]);
                int personind = Integer.valueOf(tokens[6]);
                int bookind = Integer.valueOf(tokens[7]);
                Date4= getDate(date4);
                Date5= getDate(date5);

                toBlock block1 = new toBlock(Library.membersList.get(personind),Library.booksList.get(bookind),Date4,Date5);
                Library.toBlockList.add(block1);
            }
        }
        // Close the Scanner object.
        scanner.close();
    }
    public static String toString5(toBlock block1) throws Exception {

        return           "Block: "+block1.getP1().firstName+","+block1.getP1().id+","+block1.getB1().Title+","
                +block1.getExpectedReturn()+","+block1.getActualReturn()+", Late by: "+block1.getLateBy()
                +Library.membersList.indexOf(block1.getP1())+Library.booksList.indexOf(block1.getB1());
    }
    public static void writeBlocks() throws Exception {

        // Create a FileWriter object for the file.
        FileWriter fileWriter = new FileWriter(RWblockfilepath,false);

        //to empty the content of the file
        fileWriter.write("");
        // Write the contents of the ArrayList to the file.
        for (toBlock block1 : Library.toBlockList) {
            fileWriter.write(toString5(block1) + "\n");
        }

        // Close the FileWriter object.
        fileWriter.close();
    }

    //waitinglist
    public static String toString6(Order order1) throws Exception {

        return           order1.getP1().firstName+","+order1.getBook().Title+","+
                Library.membersList.indexOf(order1.getP1())+","+Library.booksList.indexOf(order1.getBook());

    }
    public static void writewaitinglist() throws Exception {

        // Create a FileWriter object for the file.
        FileWriter fileWriter = new FileWriter(RWwaitinglistfilepath, false);

        //to empty the content of the file
        fileWriter.write("");
        // Write the contents of the ArrayList to the file.
        for (Order O1 : Library.waitinglist) {
            fileWriter.write(toString6(O1) + "\n");
        }
        fileWriter.close();
    }
    public static void readwaitinglist() throws FileNotFoundException,IOException,Exception {
        // Create a Scanner object for the file.
        Scanner scanner = new Scanner(new File(RWwaitinglistfilepath));

        // While there are still lines in the file, create a Person object and add it to the ArrayList.
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(",");
            if (tokens.length >= 4) {
                String firstname = tokens[0];
                String title = tokens[1];
                int personind = Integer.valueOf(tokens[2]);
                int bookind = Integer.valueOf(tokens[3]);
                Order order3 = new Order(
                        Library.membersList.get(personind),
                        Library.booksList.get(bookind));
                Library.waitinglist.add(order3);
            }
        }scanner.close();
    }
}