/*
Authors: BHOZZ Technology Solutions: Amber Holladay, Yukai Zhou, Mashiyath Zaman, Gonzo Ocampo, Rimjhim Barua
Date: Jun 10, 2020
Assignment: MidPoint Deliverable
Purpose: UI System
 */


package CIS484.Capstone;

// ArrayLists & Database Connection
import java.sql.*;

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
import javafx.scene.Node;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;


public class UI extends Application {
    // ArrayLists to store data
    ArrayList<Store> storeData = new ArrayList<>();
    
    
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
    Label lblStreet = new Label("Street Address");
    Label lblCity = new Label("City");
    Label lblState = new Label("State");
    Label lblZip = new Label("Zip");
    Label lblphoneNum = new Label("Phone Number");
    Label lblEmail = new Label("Email");
    Button btnaddLocation = new Button("Add Location ->");
    TextField txtlocName = new TextField();
    TextField txtStreet = new TextField();
    TextField txtCity = new TextField();
    TextField txtState= new TextField();
    TextField txtZip = new TextField();
    TextField txtphoneNum = new TextField();
    TextField txtEmail = new TextField();
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
    TextField voliName = new TextField("");
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
    
    // create tables and lists
    TableView<Store> storeTable;
    ObservableList<Store> storeTableData;
    

    //Database Connection
    public Connection conn;
    public Statement stmt;
    public ResultSet rs;

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
//        locPane.setAlignment(Pos.CENTER_LEFT);
//        locPane.add(lbladdLocation,1,1);
//        locPane.add(lbllocName,1,4);
//        locPane.add(txtlocName,1,5);
//        locPane.add(lblStreet,1,6);
//        locPane.add(txtStreet,1,7);
//        locPane.add(lblCity,1,8);
//        locPane.add(txtCity,1,9);
//        locPane.add(lblState,1,10);
//        locPane.add(txtState,1,11);
//        locPane.add(lblZip,1,12);
//        locPane.add(txtZip,1,13);
//        locPane.add(lblphoneNum,1,14);
//        locPane.add(txtphoneNum,1,15);
//        locPane.add(lblEmail,1,16);
//        locPane.add(txtEmail,1,17);
        
        locPane.add(btnaddLocation,1,18);


        //middle section
//        locPane.add(lbllocInfo,3,1);
//        locPane.add(ollocationList,3,2,1,12);
//        ollocationList.setMinHeight(200);


        //Right section
//        locPane.add(lblmodLocation,5,1);
//        locPane.add(lbllocName2,5,4);
//        locPane.add(locationDrop,5,5);
//        locPane.add(lblAddress2,5,6);
//        locPane.add(txtAddress2,5,7);
//        locPane.add(lblZip2,5,8);
//        locPane.add(txtZip2,5,9);
//        locPane.add(lblphoneNum2,5,10);
//        locPane.add(txtphoneNum2,5,11);
//        locPane.add(btnsaveLocation,5,12);


        //setGap
//        locPane.setHgap(20);
//        locPane.setVgap(5);
        
        
        // saveLocation button
        btnaddLocation.setOnAction(e ->{
            GridPane addStorePane = new GridPane();
            Button btnAddLocInner = new Button("Add Location");
            
            addStorePane.setAlignment(Pos.CENTER_LEFT);
            addStorePane.add(lbladdLocation,1,1);
            addStorePane.add(lbllocName,1,4);
            addStorePane.add(txtlocName,1,5);
            
            addStorePane.add(lblStreet,1,6);
            addStorePane.add(txtStreet,1,7);
            
            addStorePane.add(lblCity,1,8);
            addStorePane.add(txtCity,1,9);
            
            addStorePane.add(lblState,1,10);
            addStorePane.add(txtState,1,11);
            
            addStorePane.add(lblZip,1,12);
            addStorePane.add(txtZip,1,13);
            
            addStorePane.add(lblphoneNum,1,14);
            addStorePane.add(txtphoneNum,1,15);
            
            addStorePane.add(lblEmail,1,16);
            addStorePane.add(txtEmail,1,17);
            
            addStorePane.add(btnAddLocInner,1,18);
            
            
            
            
            btnAddLocInner.setOnAction(a ->{
                boolean valid = true;
                if(valid)
                {

                    storeData.add((new Store(txtStreet.getText(), txtCity.getText(),
                            txtState.getText(), txtZip.getText(),
                            txtphoneNum.getText(), txtEmail.getText())));

                    storeTableData.clear();
                    for (Store s: storeData)
                    {
                        System.out.println(s);
                        storeTableData.add(s);
                    }
                    txtlocName.clear();
                    txtStreet.clear();
                    txtCity.clear();
                    txtState.clear();
                    txtZip.clear();
                    txtphoneNum.clear();
                    txtEmail.clear();

                    Window window = ((Node)(a.getSource())).getScene().getWindow();
                    ((Stage) window).close();
                }
            });
            
            Scene secondScene = new Scene(addStorePane, 500, 500);
            Stage secondStage = new Stage();
            secondStage.setScene(secondScene);
            secondStage.setTitle("Add New Store");
            secondStage.show();
  
        });
        
        storeTable = new TableView<>();
        storeTableData = FXCollections.observableArrayList(storeData);
        storeTable.setItems(storeTableData);
        
        TableColumn tcStoreID = new TableColumn("ID");
        TableColumn tcLocationName = new TableColumn("Location Name");
        TableColumn tcStreet = new TableColumn("Street Address");
        TableColumn tcCity = new TableColumn("City");
        TableColumn tcState = new TableColumn("State");
        TableColumn tcZip = new TableColumn("Zip Code");
        TableColumn tcPhone = new TableColumn("Phone Number");
        TableColumn tcEmail = new TableColumn("Email");
        
        tcStoreID.setCellValueFactory(new PropertyValueFactory<Store, Integer>("storeID"));
        tcLocationName.setCellValueFactory(new PropertyValueFactory<Store, String>("Location Name"));
        tcStreet.setCellValueFactory(new PropertyValueFactory<Store, String>("Street"));
        tcCity.setCellValueFactory(new PropertyValueFactory<Store, String>("City"));
        tcState.setCellValueFactory(new PropertyValueFactory<Store, String>("State"));
        tcZip.setCellValueFactory(new PropertyValueFactory<Store, String>("Zip"));
        tcPhone.setCellValueFactory(new PropertyValueFactory<Store, String>("Phone Number"));
        tcEmail.setCellValueFactory(new PropertyValueFactory<Store, String>("Email"));
        
        storeTable.getColumns().addAll(tcStoreID, tcLocationName, tcStreet,
                tcCity, tcState, tcZip, tcPhone, tcEmail);
        locPane.add(storeTable, 1, 1);
        
        //Add items to Employee Tab
        //left section
        employeePane.add(lbladdVoli,1,1);
       // employeePane.add(lblEmployeeType,1,2); // gonzo added this label 
      //  employeePane.add(cmboEmployeeType, 1,3); // gonzo added combobox for employees
        employeePane.add(lblvoliName,1,3);
        employeePane.add(voliName,1,4);
        employeePane.add(lblpersonalPhone,1,5);
        employeePane.add(txtpersonalPhone,1,6);
        employeePane.add(lblhomeAdd,1,7);
        employeePane.add(txthomeAddress,1,8);
        employeePane.add(lbldateJoined,1,9);
        employeePane.add(txtdateJoined,1,10);
        employeePane.add(bio,1,11);
        employeePane.add(txtBio,1,12);
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
        
        storeTable.setMinWidth(primaryScene.getWidth());
        
        
        
        // when add staff is clicked 
        btnaddVoli.setOnAction(e -> 
        {
            boolean failure = false; 
            
            // if name is empty 
            if(voliName.getText().isEmpty())
            {
                failure = true;
                voliName.appendText("Error! Please Input Name!"); // appending text to re-input staff name 
            }
          
    // list view for the employee information --- olVoliInfoList
      
            // if phone nmber is empty 
            if(txtpersonalPhone.getText().isEmpty())
            {
                failure = true;
                txtpersonalPhone.appendText("Error! Please Input valid phone number!"); // appending text to re-input phone number
            }
            
            // if address is empty 
            if(txthomeAddress.getText().isEmpty())
            {
                failure = true;
                txthomeAddress.appendText("Error! Please Input valid address!"); // appending text to re-input address
            }
    
            // if date joined field is empty 
            if(txtdateJoined.getText().isEmpty())
            {
                boolean test;
                test = false;
                String dateJoined = txtdateJoined.getText();
                
                for(int i = 0; i < dateJoined.length(); i++)
                {
                    if(dateJoined.length() > 8)
                        {
                            test = true;
                        }
                    
                    if(dateJoined.charAt(i) == '/')
                        {
                            test = true;
                        }
                }
                
                if(test == false)
                    {
                        failure = true;
                        txtdateJoined.appendText("Error! Please Input valid date!"); // appending text to re-input date 
                    }
            }
            
            if(!failure)
            {
                // Create new Employee object
                Employee newEmployee = new Employee(voliName.getText(), 
                                                    txtpersonalPhone.getText(),
                                                    txthomeAddress.getText(),
                                                    txtdateJoined.getText(),
                                                    txtBio.getText());
                
                employeeArray.add(newEmployee); // adds new employee to employee array list
                voliList.add(newEmployee.getEmpName()); // adds new employee to observable list
            }
            
            // clearing text fields 
            voliName.clear();
            txtpersonalPhone.clear();
            txthomeAddress.clear();
            txtdateJoined.clear();
            txtBio.clear(); 
            
        });
    }

    @Override
    public void stop()
    {
        //Saves everything to the database
        //runs automatically when the program closes
        
        ArrayList<Employee> employee;
        Employee currentEmployee;
        
             //insert statements for Student table
        for ( int i = 0; i < employeeArray.size(); i++)
        {                
            currentEmployee = employeeArray.get(i);

            String sql = "INSERT INTO JAVAUSER.EMPLOYEE (EMPLOYEEID, EMPLOYEENAME, EMPLOYEEPHONE, EMPLOYEEADDRESS, EMPLOYEEDATEJOINED, EMPLOYEEINFO) VALUES (";
            sql += currentEmployee.getEmployeeID()+ ",'";
            sql += currentEmployee.getEmpName()+ "','";
            sql += currentEmployee.getPhoneNumber() + "','";
            sql += currentEmployee.getAddress() + "',";
            sql += currentEmployee.getDateJoined() + ",'";
            sql += currentEmployee.getAdditionalInfo() + "')";

            System.out.println(sql); // for testing purposes 

            sendCommand(sql);
        }
    }
    
    public void sendCommand(String query)
    {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "javauser";
        String pass = "javapass";
        
       // OracleDataSource ds;
        try
        {          
            //create the connection using the object from Oracle
            //    ds = new OracleDataSource();
            
            //set the connection url in the object
           // ds.setURL(url);
            
            //attempt to connect with specified username and login, default as "javauser" and "javapass"
           // conn = ds.getConnection(user, pass);
            
            //handling the results
            stmt = conn.createStatement(rs.TYPE_SCROLL_SENSITIVE, rs.CONCUR_READ_ONLY);
            
            //send the query to oracle
            rs = stmt.executeQuery(query);
            
        }
        
        catch(SQLException e)
        {           
            System.out.println(e.toString());           
        }       
    }
    
    // Implements a data read from the Employee DB Table
    public void loadDataFromDB()
    {
        
    }
    public static void main(String[] args) {
        launch(args);
    }

}

