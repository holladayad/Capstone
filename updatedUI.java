package CIS484.Capstone;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.*;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.*;
import oracle.jdbc.pool.OracleDataSource;


public class updatedUI extends Application {
    // ArrayList to store data
    ArrayList<Store> storeData = new ArrayList<>();
    
   //Observable List for listview
   public static ObservableList locationList = FXCollections.observableArrayList();
   public static ObservableList voliList = FXCollections.observableArrayList();
   public static ObservableList itemList = FXCollections.observableArrayList();
   public static ObservableList donateList = FXCollections.observableArrayList();
   public static ObservableList eventList = FXCollections.observableArrayList();
   


   //Observable List for combo box
   public static ObservableList<String>locDrop = FXCollections.observableArrayList("location1","location2");
   public static ObservableList<String>voliDrop = FXCollections.observableArrayList("Person1","Person2");
   public static  ObservableList <String> senderDrop = FXCollections.observableArrayList("Employee1","Employee2","Employee3");
   public static  ObservableList <String> recDrop = FXCollections.observableArrayList("Employee1","Employee2","Employee3");
   public static  ObservableList <String> empDrop = FXCollections.observableArrayList("Employee1","Employee2","Employee3");
   public static  ObservableList <String> rollDrop = FXCollections.observableArrayList("Cares Employee","Volunteer","Volihelper");
   public static  ObservableList <String> timeDrop = FXCollections.observableArrayList
           ("00:00","01:00","02:00","03:00","04:00","05:00",
                   "06:00","07:00","08:00","09:00","10:00","11:00","12:00",
                   "13:00","14:00","15:00","16:00","17:00","18:00",
                   "19:00","20:00","21:00","22:00","23:00");

   //Listview
   public ListView ollocationList = new ListView(locationList);
   public ListView olVoliInfoList = new ListView(voliList);
   public ListView olItemList = new ListView(itemList);
   public ListView oldonateList = new ListView(donateList);
   public ListView olEventInfo = new ListView(eventList);
   public ListView olUpcomingEventInfo = new ListView(eventList);
   
   //Controls

   //Location Tab
//   Label lblSelectAction = new Label("Select Action");
//   Label lbllocName = new Label("Location Name");
//   Label lblAddress = new Label("Address");
//   Label lblZip = new Label("Zipcode");
//   Label lblphoneNum = new Label("Phone Number");
//   Button btnConfirmLoc = new Button("Confirm");
//   TextField txtlocName = new TextField();
//   TextField txtAddress = new TextField();
//   TextField txtZip = new TextField();
//   TextField txtphoneNum = new TextField();
//   TextField txtLocDisplay = new TextField();
//   RadioButton radioLocAddLocation = new RadioButton("Add Location");
//   RadioButton radioLocEditLocation = new RadioButton("Edit Location");
//   ToggleGroup groupLoc = new ToggleGroup();
//
//   Label lbllocInfo = new Label("Location Information");
   
    Label lbladdLocation = new Label("Add Location");
    Label lbllocError = new Label("");
    Label lbllocName = new Label("Location Name");
    Label lblStreet = new Label("Street Address");
    Label lblCity = new Label("City");
    Label lblState = new Label("State");
    Label lblZip = new Label("Zip");
    Label lblphoneNum = new Label("Phone Number");
    Label lblEmail = new Label("Email");
    Button btnaddLocation = new Button("Add Location ->");
    Button btnEditLocation = new Button("Edit Location ->");
    Button btnDelLocation = new Button("Delete Location ->");
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
   //Label lbladdVoli = new Label("Add VoliHelper");
   Label lblvoliName = new Label("Name");
   TextField voliName = new TextField();
   Label lblpersonalPhone = new Label("Personal Phone");
   TextField txtpersonalPhone = new TextField();
   Label lblhomeAdd = new Label("Home Address");
   TextField txthomeAddress = new TextField();
   Label lbldateJoined = new Label("Date Joined");
   TextField txtdateJoined = new TextField();
   Label bio = new Label("Additional Information");
   TextArea txtBio = new TextArea();
   RadioButton radioEmpAddLocation = new RadioButton("Add");
   RadioButton radioEmpEditLocation = new RadioButton("Edit");
   ToggleGroup groupEmp = new ToggleGroup();
   Button btnConfirmEmp = new Button("Confirm");

   Label lblVoliInfo = new Label("Employee Information");

   //Board Tab
   Label lblmsgRec = new Label("Message Recorder");
   Label lblsender = new Label("Select a sender:");
   ComboBox<String>msgsenderDrop = new ComboBox<>(senderDrop);
   Label lblreci = new Label("Select a recipient:");
   ComboBox<String> recipientDrop = new ComboBox<>(recDrop);
   Label lblenterMsg = new Label("Enter Message:");
   TextArea txtenterMsg = new TextArea();
   Button btnaddMessage = new Button("Add Message/Comment");

   Label lblBoard = new Label("Board");
   TextArea txtBoard = new TextArea();

   Label lblupldPhoto = new Label("Upload Photo");
   Label lblselectPhoto = new Label("Select Photo");
   Button btnBrowse = new Button("Browse");
   TextArea txtPhoto = new TextArea();
   Button btnUpld = new Button("Upload");
   Button btnUpcomingEventDetails = new Button("View Event Details:");

   Label lblupcomingEvent = new Label("Upcoming Event");
   //TextArea txtupcomingEvent = new TextArea();
   
   


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
   Label lblworkShift = new Label("Work Shift");
   ComboBox<String>shiftDrop = new ComboBox<>(timeDrop);
   Label lblTo = new Label("to");
   ComboBox<String>shiftDrop2 = new ComboBox<>(timeDrop);


   Label lblpayInfo = new Label("Payroll Information");
   TextArea txtdisplayPayroll = new TextArea();

   //event Tab
   Label lblEventError = new Label("");
   Label lblEvent = new Label("Event");
   Label lblEventName = new Label("Event Name");
   TextField txtEvent = new TextField();
   Label lblEventImg = new Label("Upload Image");
   TextField txtEventImg = new TextField();
   Label lblDate = new Label("Date");
   DatePicker datePickerEvent = new DatePicker();
   Label lbleventDiscription = new Label("Event Description");
   TextArea txteventDes = new TextArea();
   RadioButton radioEventAddLocation = new RadioButton("Add");
   RadioButton radioEventEditLocation = new RadioButton("Edit");
   ToggleGroup groupEvent = new ToggleGroup();
   Button btnConfirmEvent = new Button("Confirm");
   Button btnClearEvent = new Button("Clear");
   Button btnEventDetails = new Button("View Details");
   Label lbleventInfo = new Label("Event Information");
   
   //event details
  
   Label lblEventDetName = new Label("");
//   ImageView imageView = new ImageView();
   Label lblEventDetDate = new Label("");
   Label lblEventDetDes = new Label("");
   Button btnCloseDetails = new Button("Close");
   
   

   //item(Inventory) Tab
   Label lblitemName = new Label("Item Name");
   TextField txtitemName = new TextField();
   Label lblPrice = new Label("Price      $");
   TextField txtPrice = new TextField();
   Label lblCategory = new Label("Category");
   //observablelist for categoryDrop
   public static ObservableList<String>categoryDrop = FXCollections.observableArrayList();
   ComboBox<String>cateDrop = new ComboBox<>(categoryDrop);
   Button btneditCate = new Button("Edit Category ->");
   RadioButton radioitemAdd = new RadioButton("Add");
   RadioButton radioitemEdit = new RadioButton("Edit");
   ToggleGroup groupItem = new ToggleGroup();
   Label lblLocation = new Label("Location");
   //observablelist for store
   public static ObservableList<String>storeDrop = FXCollections.observableArrayList();
   ComboBox<String>storeListDrop = new ComboBox<>(storeDrop);

   Button btnConfirmItem = new Button("Confirm");

   Label lblitemList = new Label("Item List");


   //category pane elements
   ListView olinfodisList2 = new ListView(categoryDrop);
   TextField addInfo = new TextField();
   Button btnAdd = new Button("Add");
   Button btnDeleteSel = new Button("Delete Selected");

   //Donation Tab
   Label lbldonationAmt = new Label("Donation Amount    $");
   TextField txtdonationAmt = new TextField();
   Label lbldonatorName = new Label("Dnator's Name");
   TextField txtdonatorName = new TextField();
   Label lbldonatorAddress = new Label("Donator's Address");
   TextField txtdonatorAddress = new TextField();
   Label lbldonatorPhone = new Label("Donator's Phone Number");
   TextField txtdonatorPhone = new TextField();
   Button btnlogDonate = new Button("Log");
   Button btndeleteDonate = new Button("Delete");

   Label lbldonateList = new Label("Donation List");




   //Login Tab(very very page after user login)
   Label lblLogin = new Label("Login");
   Label lblID = new Label("Enter your EID");
   TextField txtID = new TextField();
   Label lblPw = new Label("Enter your password");
   TextField txtPw = new TextField();
   Button btnLogin = new Button("Login");

   //Pane(s)
   GridPane primaryPane = new GridPane();
   GridPane locPane = new GridPane();
   GridPane employeePane = new GridPane();
   GridPane boardPane = new GridPane();
   GridPane payrollPane = new GridPane();
   GridPane eventPane = new GridPane();
   GridPane itemPane = new GridPane();
   GridPane donationPane = new GridPane();



   //login Pane
   GridPane loginPane = new GridPane();

   //category pane
   GridPane catePane = new GridPane();

   //Tabs
   TabPane Tabs = new TabPane();
   Tab tabLoc = new Tab("Locations");
   Tab tabEmp = new Tab("Employees");
   Tab tabBoard = new Tab("Community");
   Tab tabPayroll = new Tab("Payroll");
   Tab tabEvent = new Tab("Events");
   Tab tabItem = new Tab("Inventory");
   Tab tabDonation = new Tab("Donation");
   
   // create tables and lists
    TableView<Store> storeTable;
    ObservableList<Store> storeTableData;

   // Database Connection
    Connection dbConn;
    Statement commStmt;
    ResultSet dbResults; 
   
   @Override
   public void start(Stage primaryStage) {
       
    // Loads a picture from the same directory as this file
    // Need to do this for every stage
    try{
        primaryStage.getIcons().add(new 
            Image(getClass().getResourceAsStream("logo.jpg")));
    }catch(Exception e){
            System.out.println("Someone forgot to download the logo...");
            }

       primaryPane.setVgap(30);
       primaryPane.setHgap(30);

       primaryPane.setAlignment(Pos.BASELINE_LEFT);
       //Add tab to tabPane
       Tabs.getTabs().add(tabBoard);
       Tabs.getTabs().add(tabLoc);
       Tabs.getTabs().add(tabEmp);
       Tabs.getTabs().add(tabPayroll);
       Tabs.getTabs().add(tabEvent);
       Tabs.getTabs().add(tabItem);
       Tabs.getTabs().add(tabDonation);


       //Add tab to primaryPane
       primaryPane.add(Tabs, 0, 0);

       //Set content
       tabLoc.setContent(locPane);
       tabEmp.setContent(employeePane);
       tabBoard.setContent(boardPane);
       tabPayroll.setContent(payrollPane);
       tabEvent.setContent(eventPane);
       tabItem.setContent(itemPane);
       tabDonation.setContent(donationPane);


       //Add items to Location Tab

        locPane.add(btnaddLocation,1,18);
        locPane.add(btnEditLocation, 2, 18);
        locPane.add(btnDelLocation,3,18);


       //setGap
//       locPane.setHgap(20);
//       locPane.setVgap(10);


        // SaveLocation Button
        btnaddLocation.setOnAction(e ->{
            GridPane addStorePane = new GridPane();
            Button btnAddLocInner = new Button("Add Location");
            
            addStorePane.setAlignment(Pos.CENTER_LEFT);
            addStorePane.add(lbllocError, 1, 0, 2, 1);
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
            
            // Add and save location
            btnAddLocInner.setOnAction(a ->{
                String phoneNumber = txtphoneNum.getText().replace("-", "");
                phoneNumber = phoneNumber.replace("(", "");
                phoneNumber = phoneNumber.replace(")", "");
                String errorMsg = storeValidator(txtlocName.getText(), txtStreet.getText(), txtCity.getText(),
                            txtState.getText(), txtZip.getText(),
                            phoneNumber, txtEmail.getText());
                    
                if (!errorMsg.equals("")){
                    lbllocError.setText(errorMsg);
                    lbllocError.setTextFill(Color.RED);
                    return;
                }
                storeData.add((new Store(txtlocName.getText(), txtStreet.getText(), txtCity.getText(),
                        txtState.getText(), txtZip.getText(),
                        phoneNumber, txtEmail.getText())));
                lbllocError.setText("");

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
            });
            
            // new scene for the location
            Scene secondScene = new Scene(addStorePane, 500, 500);
            Stage secondStage = new Stage();
            secondStage.setScene(secondScene);
            secondStage.setTitle("Add New Store");
            secondStage.show();
  
        });
        
        // create a locations table
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
        tcLocationName.setCellValueFactory(new PropertyValueFactory<Store, String>("locationName"));
        tcLocationName.setPrefWidth(100);
        tcStreet.setCellValueFactory(new PropertyValueFactory<Store, String>("street"));
        tcStreet.setPrefWidth(100);
        tcCity.setCellValueFactory(new PropertyValueFactory<Store, String>("city"));
        tcState.setCellValueFactory(new PropertyValueFactory<Store, String>("state"));
        tcZip.setCellValueFactory(new PropertyValueFactory<Store, String>("zipCode"));
        tcPhone.setCellValueFactory(new PropertyValueFactory<Store, String>("phoneNumber"));
        tcPhone.setPrefWidth(100);
        tcEmail.setCellValueFactory(new PropertyValueFactory<Store, String>("email"));
        
        storeTable.getColumns().addAll(tcStoreID, tcLocationName, tcStreet,
                tcCity, tcState, tcZip, tcPhone, tcEmail);
        locPane.add(storeTable, 1, 1, 5, 1);
        storeTable.prefWidthProperty().bind(primaryStage.widthProperty());
        
        
        // Edit a location
        btnEditLocation.setOnAction(e-> {
            if (storeTable.getSelectionModel().isEmpty()){
                return;
            }
            Store selectedItem = storeTable.getSelectionModel().getSelectedItem();
            GridPane addStorePane = new GridPane();
            Button btnEditLocInner = new Button("Save Location");

            addStorePane.setAlignment(Pos.CENTER_LEFT);
            addStorePane.add(lbllocError, 1, 0, 2, 1);
            addStorePane.add(lbladdLocation,1,1);
            addStorePane.add(lbllocName,1,4);
            addStorePane.add(txtlocName,1,5);

            txtlocName.setText(selectedItem.getLocationName());

            addStorePane.add(lblStreet,1,6);
            addStorePane.add(txtStreet,1,7);

            txtStreet.setText(selectedItem.getStreet());

            addStorePane.add(lblCity,1,8);
            addStorePane.add(txtCity,1,9);

            txtCity.setText(selectedItem.getCity());

            addStorePane.add(lblState,1,10);
            addStorePane.add(txtState,1,11);

            txtState.setText(selectedItem.getState());

            addStorePane.add(lblZip,1,12);
            addStorePane.add(txtZip,1,13);

            txtZip.setText(selectedItem.getZipCode());

            addStorePane.add(lblphoneNum,1,14);
            addStorePane.add(txtphoneNum,1,15);

            txtphoneNum.setText(selectedItem.getPhoneNumber());

            addStorePane.add(lblEmail,1,16);
            addStorePane.add(txtEmail,1,17);

            txtEmail.setText(selectedItem.getEmail());

            addStorePane.add(btnEditLocInner,1,18);
            
            // save the edits
            btnEditLocInner.setOnAction(a ->{
                String phoneNumber = txtphoneNum.getText().replace("-", "");
                phoneNumber = phoneNumber.replace("(", "");
                phoneNumber = phoneNumber.replace(")", "");
                String errorMsg = storeValidator(txtlocName.getText(), txtStreet.getText(), txtCity.getText(),
                        txtState.getText(), txtZip.getText(),
                        phoneNumber, txtEmail.getText());

                if (!errorMsg.equals("")){
                    lbllocError.setText(errorMsg);
                    return;
                }

                selectedItem.editLocation(txtlocName.getText(), txtStreet.getText(), txtCity.getText(),
                        txtState.getText(), txtZip.getText(),
                        phoneNumber, txtEmail.getText());

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
                
            });
            
            Scene secondScene = new Scene(addStorePane, 500, 500);
            Stage secondStage = new Stage();
            secondStage.setScene(secondScene);
            secondStage.setTitle("Edit Store");
            secondStage.show();
        });
        
        // delete Location selected
        btnDelLocation.setOnAction(e -> {
            if(storeTable.getSelectionModel().isEmpty())
            {
                return;
            }
            
            Store selectedItem = storeTable.getSelectionModel().getSelectedItem();
            storeData.remove(selectedItem);
            storeTableData.clear();
            for (Store s: storeData)
            {
                System.out.println(s);
                storeTableData.add(s);
            }
        
        });



       //Add items to Employee Tab
       //left section
       employeePane.setAlignment(Pos.CENTER);
       radioEmpAddLocation.setToggleGroup(groupEmp);
       radioEmpEditLocation.setToggleGroup(groupEmp);
       //employeePane.add(lbladdVoli, 1, 1,2,1);
       employeePane.add(lblvoliName, 1, 2,2,1);
       employeePane.add(voliName, 1, 3,2,1);
       employeePane.add(lblpersonalPhone, 1, 4,2,1);
       employeePane.add(txtpersonalPhone, 1, 5,2,1);
       employeePane.add(lblhomeAdd, 1, 6,2,1);
       employeePane.add(txthomeAddress, 1, 7,2,1);
       employeePane.add(lbldateJoined, 1, 8,2,1);
       employeePane.add(txtdateJoined, 1, 9,2,1);
       employeePane.add(bio, 1, 10,2,1);
       employeePane.add(txtBio, 1, 11,2,3);
       txtBio.setMaxWidth(200);
       employeePane.add(radioEmpAddLocation,1,14);
       employeePane.add(radioEmpEditLocation,2,14);
       employeePane.add(btnConfirmEmp, 1, 15,2,1);

       //middle section
       employeePane.add(lblVoliInfo, 5, 2);
       employeePane.add(olVoliInfoList, 5, 3, 4, 14);
       olVoliInfoList.setMinHeight(200);


       //setGap
       employeePane.setHgap(20);
       employeePane.setVgap(5);


       //Add items in Board tab
       //left section
       //boardPane.add(lblreci, 1, 6); not sure if we still need recipient
       //boardPane.add(recipientDrop, 1, 7);
       //not sure how to upload photo in javafx but will do some research later
       boardPane.setAlignment(Pos.BASELINE_LEFT);
       boardPane.add(lblselectPhoto, 1, 2);
       boardPane.add(btnBrowse, 1, 3);
       boardPane.add(txtPhoto, 1, 4, 2, 2);
       txtPhoto.setMaxWidth(200);
       boardPane.add(btnUpld, 1, 6);
       boardPane.add(lblenterMsg, 1, 8);
       boardPane.add(txtenterMsg, 1, 9,1,2);
       txtenterMsg.setMaxWidth(200);
       txtenterMsg.setMaxHeight(100);
       boardPane.add(btnaddMessage, 1, 12);


       //middle section
       boardPane.add(lblBoard, 3, 2);
       boardPane.add(txtBoard, 3, 3, 1, 12);
       txtBoard.setMinHeight(200);
       txtBoard.setMaxWidth(230);

       //right section
       boardPane.add(lblupcomingEvent,5,2);
       boardPane.add(olUpcomingEventInfo,5,3,1,11);
       boardPane.add(btnUpcomingEventDetails, 5, 15);
       olUpcomingEventInfo.setMaxWidth(230);
       
       btnUpcomingEventDetails.setOnAction(e -> {
            
            if (!olEventInfo.getSelectionModel().isEmpty()){
                Event selectedItem = (Event) olEventInfo.getSelectionModel().getSelectedItem();
                GridPane eventDetailPane = new GridPane();
                
                Image img = new Image(selectedItem.getPicURL());
                ImageView imageView = new ImageView(img);
                eventDetailPane.add(imageView, 1, 0, 4, 4);
                
                imageView.setPreserveRatio(true);
                imageView.setFitHeight(300);
                imageView.setFitWidth(300);
                
                
                eventDetailPane.add(lblEventDetName, 1, 6, 2, 1);
                eventDetailPane.add(lblEventDetDate, 3, 6, 2, 1);
                eventDetailPane.add(lblEventDetDes, 1, 8, 2 ,1);
                eventDetailPane.add(btnCloseDetails, 1, 10, 2, 1);
                
                lblEventDetName.setText(selectedItem.getEventName());
                lblEventDetDate.setText(selectedItem.getEventDate().toString());
                lblEventDetDes.setText(selectedItem.getEventDiscrip());
                btnCloseDetails.setOnAction( ee-> {
                    Window window = ((Node)(ee.getSource())).getScene().getWindow();
                    ((Stage) window).close();
                });
                
                Scene secondScene = new Scene(eventDetailPane, 300, 500);
                Stage secondStage = new Stage();
                secondStage.setScene(secondScene);
                secondStage.setTitle(selectedItem.getEventName());
                secondStage.show();
            }
            
        });

       boardPane.setHgap(20);
       boardPane.setVgap(5);


       //Add items to payroll tab
       //left section
       payrollPane.setAlignment(Pos.CENTER);

       payrollPane.add(lblselectemp, 1, 4);
       payrollPane.add(employeeDrop, 1, 5);
       payrollPane.add(lblworkShift,1,6);
       payrollPane.add(shiftDrop,1,7);
       payrollPane.add(lblTo,1,8);
       payrollPane.add(shiftDrop2,1,9);
       payrollPane.add(lblhrpay, 1, 10);
       payrollPane.add(dollar, 0, 11);
       payrollPane.add(txthrPay, 1, 11);
       txthrPay.setMaxWidth(80);
       payrollPane.add(btnSave, 1, 12);

       //right section
       payrollPane.add(lblpayInfo, 10, 3);
       payrollPane.add(txtdisplayPayroll, 10, 4, 1, 10);
       txtdisplayPayroll.setMaxWidth(250);
       payrollPane.setHgap(10);
       payrollPane.setVgap(10);



       //Add items to event tab
       radioEventAddLocation.setToggleGroup(groupEvent);
       radioEventEditLocation.setToggleGroup(groupEvent);
       eventPane.add(lblEventError,1,0);
       eventPane.add(lblEvent, 1, 1);
       eventPane.add(lblEventName, 1, 3);
       eventPane.add(txtEvent, 1, 4);
       eventPane.add(lblEventImg, 1, 5);
       eventPane.add(txtEventImg, 1, 6);
       eventPane.add(lblDate, 1, 7);
       eventPane.add(datePickerEvent, 1, 8);
       eventPane.add(lbleventDiscription, 1, 9,2,1);
       eventPane.add(txteventDes, 1, 10, 2, 2);
       eventPane.add(radioEventAddLocation,1,12);
       eventPane.add(radioEventEditLocation,2,12);
       eventPane.add(btnConfirmEvent, 1, 13);
       eventPane.add(btnClearEvent, 2, 13);

       eventPane.add(lbleventInfo, 4, 1);
       eventPane.add(olEventInfo, 4, 2, 1, 10);
       eventPane.add(btnEventDetails, 4,12);
       eventPane.setHgap(20);
       eventPane.setVgap(20);
       
       radioEventAddLocation.setSelected(true);
       
       btnConfirmEvent.setOnAction(e ->{
           boolean valid = true;
           valid = valid && !txtEvent.getText().isEmpty();
           valid = valid && !txtEventImg.getText().isEmpty();
           valid = valid && !datePickerEvent.getValue().toString().isEmpty();
           valid = valid && !txteventDes.getText().isEmpty();
           if (!valid)
           {
               lblEventError.setText("Please fill in all fields."); 
               lblEventError.setTextFill(Color.RED);
               return;
           }
           
           try{
               Image test = new Image(txtEventImg.getText());
           }catch (IllegalArgumentException ex) {
                    lblEventError.setText("Unrecognized URL format");
                    lblEventError.setTextFill(Color.RED);
                    return;
                }
           
           
            if(radioEventAddLocation.isSelected())
            {
                lblEventError.setText("");
                eventList.add(new Event(txtEvent.getText(), txtEventImg.getText(), 
                    datePickerEvent.getValue(), txteventDes.getText()));
            }
            else
            {
                if (!olEventInfo.getSelectionModel().isEmpty()){
                     Event selectedItem = (Event) olEventInfo.getSelectionModel().getSelectedItem();
                     selectedItem.editEvent(txtEvent.getText(), txtEventImg.getText(), 
                    datePickerEvent.getValue(), txteventDes.getText());
                     olEventInfo.refresh();
                }
            }
            olEventInfo.getSelectionModel().clearSelection();
            txtEvent.clear();
            txtEventImg.clear();
            txteventDes.clear();
            datePickerEvent.getEditor().clear();
            datePickerEvent.setValue(null);
           
          
       });
       btnClearEvent.setOnAction(e -> {
            olEventInfo.getSelectionModel().clearSelection();
            txtEvent.clear();
            txtEventImg.clear();
            txteventDes.clear();
            datePickerEvent.getEditor().clear();
            datePickerEvent.setValue(null);
            radioEventAddLocation.setSelected(true);
       });
       
        olEventInfo.setOnMouseReleased(e -> {
           if (!olEventInfo.getSelectionModel().isEmpty()){
               Event selectedItem = (Event) olEventInfo.getSelectionModel().getSelectedItem();
               txtEvent.setText(selectedItem.getEventName());
               txtEventImg.setText(selectedItem.getPicURL());
               datePickerEvent.setValue(selectedItem.getEventDate());
               txteventDes.setText(selectedItem.getEventDiscrip());
               radioEventEditLocation.setSelected(true);
               
           }
           
        });
        
        btnEventDetails.setOnAction(e -> {
            
            if (!olEventInfo.getSelectionModel().isEmpty()){
                Event selectedItem = (Event) olEventInfo.getSelectionModel().getSelectedItem();
                GridPane eventDetailPane = new GridPane();
                
                Image img = new Image(selectedItem.getPicURL());
                ImageView imageView = new ImageView(img);
                eventDetailPane.add(imageView, 1, 0, 4, 4);
                
                imageView.setPreserveRatio(true);
                imageView.setFitHeight(300);
                imageView.setFitWidth(300);
                
                
                eventDetailPane.add(lblEventDetName, 1, 6, 2, 1);
                eventDetailPane.add(lblEventDetDate, 3, 6, 2, 1);
                eventDetailPane.add(lblEventDetDes, 1, 8, 2 ,1);
                eventDetailPane.add(btnCloseDetails, 1, 10, 2, 1);
                
                lblEventDetName.setText(selectedItem.getEventName());
                lblEventDetDate.setText(selectedItem.getEventDate().toString());
                lblEventDetDes.setText(selectedItem.getEventDiscrip());
                btnCloseDetails.setOnAction( ee-> {
                    Window window = ((Node)(ee.getSource())).getScene().getWindow();
                    ((Stage) window).close();
                });
                
                Scene secondScene = new Scene(eventDetailPane, 300, 500);
                Stage secondStage = new Stage();
                secondStage.setScene(secondScene);
                secondStage.setTitle(selectedItem.getEventName());
                secondStage.show();
            }
            
        });

       //add items to Item(Inventory) Pane
       //left section
       radioitemAdd.setToggleGroup(groupItem);
       radioitemEdit.setToggleGroup(groupItem);
       itemPane.setAlignment(Pos.CENTER);
       itemPane.add(lblitemName,1,1);
       itemPane.add(txtitemName,2,1,2,1);
       itemPane.add(lblPrice,1,2);
       itemPane.add(txtPrice,2,2,2,1);
       itemPane.add(lblCategory,1,3);
       itemPane.add(cateDrop,2,3);
       cateDrop.setMinWidth(80);
       itemPane.add(btneditCate,3,3);
       itemPane.add(lblLocation,1,4);
       itemPane.add(storeListDrop,2,4);
       storeListDrop.setMinWidth(100);
       itemPane.add(radioitemAdd,1,5);
       itemPane.add(radioitemEdit,3,5);
       itemPane.add(btnConfirmItem,1,6);


       //right section
       itemPane.add(lblitemList,8,0);
       itemPane.add(olItemList,8,1,3,10);
       itemPane.setVgap(10);
       itemPane.setHgap(10);

       //add items to category pane
       catePane.setAlignment(Pos.CENTER);
       catePane.add(olinfodisList2,1,1,4,4);
       catePane.add(addInfo,1,5,4,1);
       catePane.add(btnAdd,1,6);
       catePane.add(btnDeleteSel,2,6);
       catePane.setVgap(5);
       catePane.setHgap(5);


       //add items to donation pane
       donationPane.setAlignment(Pos.CENTER);
       donationPane.add(lbldonationAmt,1,3);
       donationPane.add(txtdonationAmt,2,3);
       donationPane.add(lbldonatorName,1,4);
       donationPane.add(txtdonatorName,2,4);
       donationPane.add(lbldonatorAddress,1,5);
       donationPane.add(txtdonatorAddress,2,5);
       donationPane.add(lbldonatorPhone,1,6);
       donationPane.add(txtdonatorPhone,2,6);
       donationPane.add(btnlogDonate,1,7);
       donationPane.add(btndeleteDonate,2,7);

       donationPane.add(lbldonateList,5,1);
       donationPane.add(oldonateList,5,2,2,10);
       oldonateList.setMinHeight(200);


       donationPane.setHgap(10);
       donationPane.setVgap(10);

       //add items to login pane
       loginPane.setAlignment(Pos.CENTER);

       loginPane.add(lblID,0,1);
       loginPane.add(txtID,0,2);
       loginPane.add(lblPw,0,3);
       loginPane.add(txtPw,0,4);
       loginPane.add(btnLogin,0,5);
       loginPane.setVgap(10);


       //set login stage and scene
       Stage loginStage = new Stage();
       
       Scene loginScene = new Scene(loginPane,400,600);
       loginStage.setScene(loginScene);
       loginStage.setTitle("Shenandoah CARES Login");
       loginStage.show();

       //set on action for login button
       btnLogin.setOnAction(e->{
           primaryStage.show();
           loginStage.close();
       });

       //set category edit stage and scene
       Stage cateStage = new Stage();

       Scene cateScene = new Scene(catePane, 350, 200);
       cateStage.setScene(cateScene);
       cateStage.setTitle("Category");

       btneditCate.setOnAction(e ->{
           cateStage.show();
       });

       //primary Scene
       Scene primaryScene = new Scene(primaryPane, 800, 550);

       Tabs.setMinWidth(primaryScene.getWidth());

       //Nest the Scene in the Stage
       primaryStage.setTitle("Shenandoah CARES v1.0");
       primaryStage.setScene(primaryScene);
   }
   
   // Error Checking for locations tab
   public String storeValidator(String locationName, String street, String city,
           String state, String zipCode, String phoneNumber, String email){
       String error = "";
       
       //check locationName
       if (locationName.isEmpty()){
           error+="Location Name must not be empty\n";
       }
       //check street
       if (street.isEmpty()){
           error+="Street must not be empty\n";
       }
       //check city
       if (city.isEmpty()){
           error+="City must not be empty\n";
       }
       // check state
       if (state.length() != 2){
           error+="State must be in the form of two character abbreviation\n";
       }
       //check zipCode
       if (!zipCode.matches("\\d{5}")){
           error+="Zipcode must be 5 digits\n";
       }
       //check phonenumber
       if (!phoneNumber.matches("\\d{10}")){
           error+="Phone number should be 10 digits long\n";
       }
       //check email
       int atIndex = email.indexOf("@");
       if (!(atIndex != -1)){
           error += "Email must contain an @\n";
       }else if(!( atIndex != 0)){
           error += "Email must have text before the @\n";
       }else{
           String subString = email.substring(atIndex);
           int dotIndex = subString.indexOf(".");
           if (!(dotIndex >= 1 && dotIndex != subString.length())){
               error+="Email must contain a . after the @\n";
           }
       }
       return error;
   }

   public static void main(String[] args) {
       launch(args);
   }

   
       public void sendSQL(String sqlQuery)
    {
        String url = "jdbc:oracle:thin:@localhost:1521:XE";
        String user = "javauser";
        String pass = "javapass";
        
        OracleDataSource ds;
        
        try
        {          
            //create the connection using the object from Oracle
            ds = new OracleDataSource();
            
            //set the connection url in the object
            ds.setURL(url);
            
            //attempt to connect with specified username and login, default as "javauser" and "javapass"
            dbConn = ds.getConnection(user, pass);
            
            //handling the results
            commStmt = dbConn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            //send the query to oracle
            dbResults = commStmt.executeQuery(sqlQuery);
            
        }
        
        catch(SQLException e)
        {           
            System.out.println(e.toString());           
        }       
    }
}




