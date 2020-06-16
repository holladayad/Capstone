/*
Authors: BHOZZ Technology Solutions: Amber Holladay, Yukai Zhou, Mashiyath Zaman, Gonzo Ocampo, Rimjhim Barua
Date: Jun 10, 2020
Assignment: MidPoint Deliverable
Purpose: UI System
 */


package CIS484.Capstone;

import javafx.application.Application;
import javafx.collections.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.*;
import java.util.ArrayList;


public class UI extends Application {
    //Observable List for listview
    public static ObservableList locationList = FXCollections.observableArrayList();
    public static ObservableList voliList = FXCollections.observableArrayList();
    
    // Array list for employee
    public static ArrayList<Employee> employeeArray = new ArrayList<>();


    //Observable List for combo box
    public static ObservableList<String>locDrop = FXCollections.observableArrayList("location1","location2");
    public static ObservableList<String>voliDrop = FXCollections.observableArrayList("Person1","Person2");
    public static  ObservableList <String> senderDrop = FXCollections.observableArrayList("Employee1","Employee2","Employee3");
    public static  ObservableList <String> recDrop = FXCollections.observableArrayList("Employee1","Employee2","Employee3");
    public static  ObservableList <String> empDrop = FXCollections.observableArrayList("Employee1","Employee2","Employee3");
    public static  ObservableList <String> rollDrop = FXCollections.observableArrayList("Cares Employee","Volunteer","Volihelper");
    
    
    //Listview
    public ListView ollocationList = new ListView(locationList);
    public ListView olVoliInfoList = new ListView(voliList);
    //Controls

    

    //Location Tab
    Label lbladdLocation = new Label("Add Location");
    Label lbllocName = new Label("Location Name");
    Label lblAddress = new Label("Address");
    Label lblZip = new Label("Zip");
    Label lblphoneNum = new Label("Phone Number");
    Button btnaddLocation = new Button("Add Location ->");
    TextField txtlocName = new TextField();
    TextField txtAddress = new TextField();
    TextField txtZip = new TextField();
    TextField txtphoneNum = new TextField();
    TextField txtLocDisplay = new TextField();

    Label lbllocInfo = new Label("Location Information");

    Label lblmodLocation = new Label("Modify Location");
    Label lbllocName2 = new Label("Location Name");
    ComboBox<String>locationDrop = new ComboBox<>(locDrop);
    Label lblAddress2 = new Label("Address");
    TextField txtAddress2 = new TextField();
    Label lblZip2 = new Label("Zip");
    TextField txtZip2 = new TextField();
    Label lblphoneNum2 = new Label("Phone Number");
    TextField txtphoneNum2 = new TextField();
    Button btnsaveLocation = new Button("Save Location Change ->");

    //Employee Tab
    
    Label lbladdVoli = new Label("Add Staff"); // Gonzo changed volihelp to staff
    Label lblEmployeeType = new Label ("Staff Type:"); // gonzo added this label 
    Label lblvoliName = new Label("Name");
    TextField voliName = new TextField("Name");
    Label lblpersonalPhone = new Label("Personal Phone");
    TextField txtpersonalPhone = new TextField();
    Label lblhomeAdd = new Label("Home Address");
    TextField txthomeAddress = new TextField();
    Label lbldateJoined = new Label("Date Joined");
    TextField txtdateJoined = new TextField();
    Label bio = new Label("Additional Information");
    TextField txtBio = new TextField();
    Button btnaddVoli = new Button("Add Staff"); // Gonzo changed volihelper to staff 
    ComboBox<String>cmboEmployeeType = new ComboBox<>(rollDrop); // Gonzo added this combo bax for the employee tab 


    Label lblVoliInfo = new Label("Staff Information"); // Gonzo changed volihelper information to staff information 

    Label lblmodVoli = new Label("Modify Staff"); // gonzo changed modify volihelper to modify staff
    Label lblvoliName2 = new Label("Name");
    ComboBox<String>voliHelperDrop = new ComboBox<>(voliDrop);
   Label personalPhone2 = new Label("Personal Phone");
   TextField txtpersonalPhone2 = new TextField();
   Label lblhomeAdd2 = new Label("Home Address");
   TextField txthomeAddress2 = new TextField();
   Label lbldateJoined2 = new Label("Date Joined");
   TextField txtdateJoined2 = new TextField();
   Label lblbio2 = new Label("Additional Information");
   TextField txtBio2 = new TextField();
   Button btnsaveVoli = new Button("Save Change");

   //Board Tab
    Label lblmsgRec = new Label("Message Recorder");
    Label lblsender = new Label("Select a sender:");
    ComboBox<String>msgsenderDrop = new ComboBox<>(senderDrop);
    Label lblreci = new Label("Select a recipient:");
    ComboBox<String> recipientDrop = new ComboBox<>(recDrop);
    Label lblenterMsg = new Label("Enter Message:");
    TextField txtenterMsg = new TextField();
    Button btnaddMessage = new Button("Add Message");

    Label lblBoard = new Label("Board");
    TextArea txtBoard = new TextArea();

    Label lblupldPhoto = new Label("Upload Photo");
    Label lblselectPhoto = new Label("Select Photo");
    Button btnBrowse = new Button("Browse");
    TextArea txtPhoto = new TextArea();
    Button btnUpld = new Button("Upload");

    //payroll tab
    Label lblpayrollRec = new Label("Payroll Recorder");
    Label lblselectemp = new Label("Select an employee:");
    ComboBox<String>employeeDrop = new ComboBox<>(empDrop);
    Label lblselrole = new Label("Select role:");
    ComboBox<String>roleDrop = new ComboBox<>(rollDrop);
    Label lblhrpay = new Label("Enter hourly pay");
    Label dollar = new Label("$");
    TextField txthrPay = new TextField();
    Button btnSave = new Button("Save");

    Label lblpayInfo = new Label("Payroll Information");
    TextArea txtdisplayPayroll = new TextArea();

    //event Tab
    Label lblEvent = new Label("Event");
    Label lbladdEvent = new Label("Add Event");
    TextField txtEvent = new TextField();
    Label lblDate = new Label("Date");
    TextField txtDate = new TextField();
    Label lbleventDiscription = new Label("Event Discription");
    TextArea txteventDes = new TextArea();
    Button btnaddDes = new Button("Add");

    Label lbleventInfo = new Label("Event Information");
    TextArea txteventInfo = new TextArea();







    //Pane(s)
    GridPane primaryPane = new GridPane();
    GridPane locPane = new GridPane();
    GridPane employeePane = new GridPane();
    GridPane boardPane = new GridPane();
    GridPane payrollPane = new GridPane();
    GridPane eventPane = new GridPane();
    BorderPane bPane = new BorderPane();

    //Tabs
    TabPane Tabs = new TabPane();
    Tab tabLoc = new Tab("Locations");
    Tab tabEmp = new Tab("Employees");
    Tab tabBoard = new Tab("Board");
    Tab tabPayroll = new Tab("Payroll");
    Tab tabEvent = new Tab("Events");







    @Override
    public void start(Stage primaryStage) {

        primaryPane.setVgap(30);
        primaryPane.setHgap(30);

        primaryPane.setAlignment(Pos.BASELINE_LEFT);
        //Add tab to tabPane
        Tabs.getTabs().add(tabLoc);
        Tabs.getTabs().add(tabEmp);
        Tabs.getTabs().add(tabBoard);
        Tabs.getTabs().add(tabPayroll);
        Tabs.getTabs().add(tabEvent);

        //Add tab to primaryPane
        primaryPane.add(Tabs,0,0);

        //Set content
        tabLoc.setContent(locPane);
        tabEmp.setContent(employeePane);
        tabBoard.setContent(boardPane);
        tabPayroll.setContent(payrollPane);
        tabEvent.setContent(eventPane);

        //Add items to Location Tab
        //left section
        locPane.setAlignment(Pos.CENTER_LEFT);
        locPane.add(lbladdLocation,1,1);
        locPane.add(lbllocName,1,4);
        locPane.add(txtlocName,1,5);
        locPane.add(lblAddress,1,6);
        locPane.add(txtAddress,1,7);
        locPane.add(lblZip,1,8);
        locPane.add(txtZip,1,9);
        locPane.add(lblphoneNum,1,10);
        locPane.add(txtphoneNum,1,11);
        locPane.add(btnaddLocation,1,12);



        //middle section

        locPane.add(lbllocInfo,3,1);
        locPane.add(ollocationList,3,2,1,12);
        ollocationList.setMinHeight(200);


        //Right section
        locPane.add(lblmodLocation,5,1);
        locPane.add(lbllocName2,5,4);
        locPane.add(locationDrop,5,5);
        locPane.add(lblAddress2,5,6);
        locPane.add(txtAddress2,5,7);
        locPane.add(lblZip2,5,8);
        locPane.add(txtZip2,5,9);
        locPane.add(lblphoneNum2,5,10);
        locPane.add(txtphoneNum2,5,11);
        locPane.add(btnsaveLocation,5,12);


        //setGap
        locPane.setHgap(20);
        locPane.setVgap(5);


        //Add items to Employee Tab
        //left section
        employeePane.add(lbladdVoli,1,1);
        employeePane.add(lblEmployeeType,1,2); // gonzo added this label 
        employeePane.add(cmboEmployeeType, 1,3); // gonzo added combobox for employees
        employeePane.add(lblvoliName,1,4);
        employeePane.add(voliName,1,5);
        employeePane.add(lblpersonalPhone,1,6);
        employeePane.add(txtpersonalPhone,1,7);
        employeePane.add(lblhomeAdd,1,8);
        employeePane.add(txthomeAddress,1,9);
        employeePane.add(lbldateJoined,1,10);
        employeePane.add(txtdateJoined,1,11);
        employeePane.add(bio,1,12);
        employeePane.add(txtBio,1,13);
        employeePane.add(btnaddVoli,1,14);

        //middle section
        employeePane.add(lblVoliInfo,3,1);
        employeePane.add(olVoliInfoList,3,2,1,14);
        olVoliInfoList.setMinHeight(200);

        //Right Section
        employeePane.add(lblmodVoli,5,1);
        employeePane.add(lblvoliName2,5,2);
        employeePane.add(voliHelperDrop,5,3);
        employeePane.add(personalPhone2,5,4);
        employeePane.add(txtpersonalPhone2,5,5);
        employeePane.add(lblhomeAdd2,5,6);
        employeePane.add(txthomeAddress2,5,7);
        employeePane.add(lbldateJoined2,5,8);
        employeePane.add(txtdateJoined2,5,9);
        employeePane.add(lblbio2,5,10);
        employeePane.add(txtBio2,5,11);
        employeePane.add(btnsaveVoli,5,12);
        // gonzo made some adjustments to the spacing of employees

        //setGap
        employeePane.setHgap(20);
        employeePane.setVgap(5);



        //Add items in Board tab
        //left section
        boardPane.add(lblmsgRec,1,1);
        boardPane.add(lblsender,1,4);
        boardPane.add(msgsenderDrop,1,5);
        boardPane.add(lblreci,1,6);
        boardPane.add(recipientDrop,1,7);
        boardPane.add(lblenterMsg,1,8);
        boardPane.add(txtenterMsg,1,9);
        boardPane.add(btnaddMessage,1,10);

        //middle section
        boardPane.add(lblBoard,3,1);
        boardPane.add(txtBoard,3,2,1,12);
        txtBoard.setMinHeight(200);
        txtBoard.setMaxWidth(250);

        //right section
        boardPane.add(lblupldPhoto,5,1);
        boardPane.add(lblselectPhoto,5,2);
        boardPane.add(btnBrowse,5,3);
        boardPane.add(txtPhoto,5,4,1,2);
        boardPane.add(btnUpld,5,6);
        txtPhoto.setMaxWidth(250);

        boardPane.setHgap(20);
        boardPane.setVgap(5);

        //Add items to payroll tab
        //left section
        payrollPane.add(lblpayrollRec,1,1);
        payrollPane.add(lblselectemp,1,4);
        payrollPane.add(employeeDrop,1,5);
        payrollPane.add(lblselrole,1,6);
        payrollPane.add(roleDrop,1,7);
        payrollPane.add(lblhrpay,1,8);
        payrollPane.add(dollar,0,9);
        payrollPane.add(txthrPay,1,9);
        payrollPane.add(btnSave,1,10);

        //right section
        payrollPane.add(lblpayInfo,10,1);
        payrollPane.add(txtdisplayPayroll,10,2,1,10);
        txtdisplayPayroll.setMaxWidth(250);
        payrollPane.setHgap(1);
        payrollPane.setVgap(5);

        //Add items to event tab
        eventPane.add(lblEvent,1,1);
        eventPane.add(lbladdEvent,1,4);
        eventPane.add(txtEvent,1,5);
        eventPane.add(lblDate,1,6);
        eventPane.add(txtDate,1,7);
        eventPane.add(lbleventDiscription,1,8);
        eventPane.add(txteventDes,1,9,1,3);
        eventPane.add(btnaddDes,1,12);

        eventPane.add(lbleventInfo,4,1);
        eventPane.add(txteventInfo,4,2,1,10);
        eventPane.setHgap(20);
        eventPane.setVgap(20);





        //Scene
        Scene primaryScene = new Scene(primaryPane,800,550);

        Tabs.setMinWidth(primaryScene.getWidth());

        //Nest the Scene in the Stage
        primaryStage.setTitle("Shenandoah CARES v1.0");
        primaryStage.setScene(primaryScene);
        primaryStage.show();//won't show without this
        
        
        
        
        btnaddVoli.setOnAction(e -> 
        {
        //********** add Array list here  ***********************//
            
           // cmboEmployeeType.get
            // getting data from text fields
            String employeeName = voliName.getText();
            String employeePhone = txtpersonalPhone.getText();
            String homeAddress = txthomeAddress.getText();
            String dateJoined = txtdateJoined.getText();
            String additionalInfo = txtBio.getText();
            
            // clearing text fields 
            voliName.clear();
            txtpersonalPhone.clear();
            txthomeAddress.clear();
            txtdateJoined.clear();
            txtBio.clear();
            
            
            
        });
    }


    public static void main(String[] args) {
        launch(args);
    }

}

