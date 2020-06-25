/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor
 */
package CIS484.Capstone;

import javafx.application.Application;
import javafx.collections.*;

	import javafx.scene.control.cell.PropertyValueFactory;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.*;
import java.util.ArrayList;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.stage.Window;
import javafx.scene.control.Cell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;


public class gonzoUI extends Application {
   //Observable List for listview
   public static ObservableList locationList = FXCollections.observableArrayList();
   public static ObservableList olEmployee = FXCollections.observableArrayList();
   public static ObservableList itemList = FXCollections.observableArrayList();
   public static ObservableList donateList = FXCollections.observableArrayList();

    // Array list for employee
    public static ArrayList<Employee> employeeData = new ArrayList<>();
    
        private final TableView<Employeee> table = new TableView<>();
    
        private final ObservableList<Employeee> data =
            observableArrayList(
            new Employeee("J29", "Jacob", "Smith", "jacob.smith@example.com", "308 Bill Brower Ct. Purcellville, VA 20132", "11/08/2019", "as"),
            new Employeee("G12", "Gonzo", "Ocampo", "gonzo.ocampo@hotmail.com", "865 Port Republic Rd. Harrisonburg, VA 22801", "02/03/2018", "Can only work Monday-Thursdays after 3 PM")
            );
        
    final HBox hb = new HBox();
             // ArrayList<Store> storeData = new ArrayList<>();


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
   public ListView lvEmployee = new ListView(olEmployee);
   public ListView olItemList = new ListView(itemList);
   public ListView oldonateList = new ListView(donateList);
   //Controls

   //Location Tab
   Label lblSelectAction = new Label("Select Action");
   Label lbllocName = new Label("Location Name");
   Label lblAddress = new Label("Address");
   Label lblZip = new Label("Zipcode");
   Label lblphoneNum = new Label("Phone Number");
   Button btnConfirmLoc = new Button("Confirm");
   TextField txtlocName = new TextField();
   TextField txtAddress = new TextField();
   TextField txtZip = new TextField();
   TextField txtphoneNum = new TextField();
   TextField txtLocDisplay = new TextField();
   RadioButton radioLocAddLocation = new RadioButton("Add Location");
   RadioButton radioLocEditLocation = new RadioButton("Edit Location");
   ToggleGroup groupLoc = new ToggleGroup();

   Label lbllocInfo = new Label("Location Information");

   
   //Employee Tab
   //Label lbladdVoli = new Label("Add VoliHelper");
   Label lblEmployeeName = new Label("Name");
   TextField tfEmployeeName = new TextField();
   Label lblEmployeePhone = new Label("Personal Phone");
   TextField tfEmployeePhone = new TextField();
   Label lblEmployeeAddress = new Label("Home Address");
   TextField tfEmployeeAddress = new TextField();
   Label lblEmployeeDateJoined = new Label("Date Joined");
   TextField tfEmployeeDateJoined = new TextField();
   Label lblEmployeeAdditionalInfo = new Label("Additional Information");
   TextArea tfEmployeeAdditionalInfo = new TextArea();
   
   ComboBox<String> addEdit = new ComboBox<>(senderDrop);
   //RadioButton radioEmployeeAdd = new RadioButton("Add");
   //RadioButton radioEmployeeEdit = new RadioButton("Edit");
   ToggleGroup toggleGroupEmployee = new ToggleGroup();
   Button btnConfirmEmployee = new Button("Confirm");
   Button btnEditEmployee = new Button("Edit");

   Button btnClearEmployee = new Button("Clear");
   Label lblEmployeeInformation = new Label("Employee Information");

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

   Label lblupcomingEvent = new Label("Upcoming Event");
   TextArea txtupcomingEvent = new TextArea();


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

   Label lbleventInfo = new Label("Event Information");
   TextArea txteventInfo = new TextArea();

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
   Label lbldonatorName = new Label("Donator's Name");
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

   
     TableView<Employee> employeeTable; ////////////////////////////////////////////////////////////////////////////////////////// 
     ObservableList<Employee> employeeTableData;/////////////////////////////////////////////////////////////////////////////


   public void start(Stage primaryStage) {

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
      // tabEmp.setContent(employeePane);
       tabBoard.setContent(boardPane);
       tabPayroll.setContent(payrollPane);
       tabEvent.setContent(eventPane);
       tabItem.setContent(itemPane);
       tabDonation.setContent(donationPane);


       //Add items to Location Tab
       //left section
       radioLocAddLocation.setToggleGroup(groupLoc);
       radioLocEditLocation.setToggleGroup(groupLoc);
       locPane.setAlignment(Pos.CENTER);



       locPane.add(lbllocName, 1, 1, 2, 1);
       locPane.add(txtlocName, 1, 2, 2, 1);
       locPane.add(lblAddress, 1, 3, 2, 1);
       locPane.add(txtAddress, 1, 4, 2, 1);
       locPane.add(lblZip, 1, 5, 2, 1);
       locPane.add(txtZip, 1, 6, 2, 1);
       locPane.add(lblphoneNum, 1, 7, 2, 1);
       locPane.add(txtphoneNum, 1, 8, 2, 1);
       locPane.add(radioLocAddLocation, 1, 9);
       locPane.add(radioLocEditLocation, 2, 9);
       locPane.add(btnConfirmLoc, 1, 11, 2, 1);

       //middle sectiomn

       locPane.add(lbllocInfo, 5, 1);
       locPane.add(ollocationList, 5, 2, 2, 12);
       ollocationList.setMinHeight(200);


       //setGap
       locPane.setHgap(20);
       locPane.setVgap(10);


       //Add items to Employee Tab
       //left section
       employeePane.setAlignment(Pos.CENTER);

       
      
     
       

       employeePane.add(btnEditEmployee, 6,2);

       
       //middle section
      
     

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
       boardPane.add(txtupcomingEvent,5,3,1,12);
       txtupcomingEvent.setMaxWidth(230);

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
       eventPane.add(lblEvent, 1, 1);
       eventPane.add(lblEventName, 1, 3,2,1);
       eventPane.add(txtEvent, 1, 4,2,1);
       eventPane.add(lblEventImg, 1, 5,2,1);
       eventPane.add(txtEventImg, 1, 6,2,1);
       eventPane.add(lblDate, 1, 7,2,1);
       eventPane.add(datePickerEvent, 1, 8,2,1);
       eventPane.add(lbleventDiscription, 1, 9,2,1);
       eventPane.add(txteventDes, 1, 10, 2, 2);
       eventPane.add(radioEventAddLocation,1,12);
       eventPane.add(radioEventEditLocation,2,12);
       eventPane.add(btnConfirmEvent, 1, 13,2,1);

       eventPane.add(lbleventInfo, 4, 1);
       eventPane.add(txteventInfo, 4, 2, 1, 10);
       eventPane.setHgap(20);
       eventPane.setVgap(20);

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
/////////////////////////////////////// GONZO //////////////////////////////////////////////////////////////////////////////
        


// edit button 

//btnEditEmployee.setOnAction(e -> 
   // {
           // creating a seperate window to edit employees 
           GridPane editEmployeePane = new GridPane();
           editEmployeePane.setAlignment(Pos.CENTER);
           Scene editEmployeeScene = new Scene(editEmployeePane, 500, 500);
        //   Stage editEmployeeStage = new Stage();
          // editEmployeeStage.setTitle("Edit Employee");
           //editEmployeeStage.show();

           editEmployeePane.setMinHeight(200);
           //setGaps
           editEmployeePane.setHgap(20);
           editEmployeePane.setVgap(5);
          
    
 
        Scene scene = new Scene(new Group());
      //  editEmployeeStage.setTitle("Cares Organization");
        //editEmployeeStage.setWidth(1300);
        //editEmployeeStage.setHeight(550);
 
        final Label label = new Label("Employees");
        label.setFont(new Font("Arial", 20));
 
        table.setEditable(true);
        
        Callback<TableColumn<Employeee, String>, 
            TableCell<Employeee, String>> cellFactory
                = (TableColumn<Employeee, String> p) -> new EditingCell();
 
        TableColumn<Employeee, String> employeeIDCol = 
            new TableColumn<>("ID");
        TableColumn<Employeee, String> firstNameCol = 
            new TableColumn<>("First Name");
        TableColumn<Employeee, String> lastNameCol = 
            new TableColumn<>("Last Name");
        TableColumn<Employeee, String> emailCol = 
            new TableColumn<>("Email");
        TableColumn<Employeee, String> addressCol = 
            new TableColumn<>("Address");
        TableColumn<Employeee, String> joinDateCol = 
            new TableColumn<>("Date Joined");
        TableColumn<Employeee, String> addInfoCol = 
            new TableColumn<>("Additional Information");
        
        employeeIDCol.setMinWidth(40);
        employeeIDCol.setCellValueFactory(
            new PropertyValueFactory<>("ID"));
        employeeIDCol.setCellFactory(cellFactory);        
        employeeIDCol.setOnEditCommit(
            (CellEditEvent<Employeee, String> t) -> {
                ((Employeee) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setID(t.getNewValue());
        });
        firstNameCol.setMinWidth(100);
        firstNameCol.setCellValueFactory(
            new PropertyValueFactory<>("firstName"));
        firstNameCol.setCellFactory(cellFactory);        
        firstNameCol.setOnEditCommit(
            (CellEditEvent<Employeee, String> t) -> {
                ((Employeee) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setFirstName(t.getNewValue());
        });
 
 
        lastNameCol.setMinWidth(100);
        lastNameCol.setCellValueFactory(
            new PropertyValueFactory<>("lastName"));
        lastNameCol.setCellFactory(cellFactory);
        lastNameCol.setOnEditCommit(
            (CellEditEvent<Employeee, String> t) -> {
                ((Employeee) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setLastName(t.getNewValue());
        });
 
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
            new PropertyValueFactory<>("email"));
        emailCol.setCellFactory(cellFactory);
        emailCol.setOnEditCommit(
            (CellEditEvent<Employeee, String> t) -> {
                ((Employeee) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setEmail(t.getNewValue());
        });
        
        addressCol.setMinWidth(300);
        addressCol.setCellValueFactory(
            new PropertyValueFactory<>("address"));
        addressCol.setCellFactory(cellFactory);
        addressCol.setOnEditCommit(
            (CellEditEvent<Employeee, String> t) -> {
                ((Employeee) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setAddress(t.getNewValue());
        });
        
        joinDateCol.setMinWidth(80);
        joinDateCol.setCellValueFactory(
            new PropertyValueFactory<>("joinDate"));
        joinDateCol.setCellFactory(cellFactory);
        joinDateCol.setOnEditCommit(
            (CellEditEvent<Employeee, String> t) -> {
                ((Employeee) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setJoinDate(t.getNewValue());
        });
        
        addInfoCol.setMinWidth(400);
        addInfoCol.setCellValueFactory(
            new PropertyValueFactory<>("addInfo"));
        addInfoCol.setCellFactory(cellFactory);
        addInfoCol.setOnEditCommit(
            (CellEditEvent<Employeee, String> t) -> {
                ((Employeee) t.getTableView().getItems().get(
                        t.getTablePosition().getRow())
                        ).setAdditionalInfo(t.getNewValue());
        });
 
        table.setItems(data);
        table.getColumns().addAll(employeeIDCol, firstNameCol, lastNameCol, emailCol, addressCol, joinDateCol, addInfoCol);
        
        final TextField addID = new TextField();
        addID.setMaxWidth(employeeIDCol.getPrefWidth());
        addID.setPromptText("ID");
        final TextField addFirstName = new TextField();
        addFirstName.setPromptText("First Name");
        addFirstName.setMaxWidth(firstNameCol.getPrefWidth());
        final TextField addLastName = new TextField();
        addLastName.setMaxWidth(lastNameCol.getPrefWidth());
        addLastName.setPromptText("Last Name");
        final TextField addEmail = new TextField();
        addEmail.setMaxWidth(emailCol.getPrefWidth());
        addEmail.setPromptText("Email");
        final TextField addAddress = new TextField();
        addAddress.setMaxWidth(addressCol.getPrefWidth());
        addAddress.setPromptText("Address");
        final TextField addJoinDate = new TextField();
        addJoinDate.setMaxWidth(joinDateCol.getPrefWidth());
        addJoinDate.setPromptText("Date Joined");
        final TextField addInfo = new TextField();
        addInfo.setMaxWidth(addInfoCol.getPrefWidth());
        addInfo.setPromptText("Additional Info");
 
        final Button addButton = new Button("Add");
        addButton.setOnAction((ActionEvent f) -> {
            data.add(new Employeee(
                    addID.getText(),
                    addFirstName.getText(),
                    addLastName.getText(),
                    addEmail.getText(),
                    addAddress.getText(),
                    addJoinDate.getText(),
                    addInfo.getText())
            );
            addID.clear();
            addFirstName.clear();
            addLastName.clear();
            addEmail.clear();
            addAddress.clear();
            addJoinDate.clear();
            addInfo.clear();
        });
 
        hb.getChildren().addAll(addID, addFirstName, addLastName, addEmail, addAddress, addJoinDate, addInfo, addButton);
        hb.setSpacing(3);
 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, table, hb);
 
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
 
        tabEmp.setContent(scene.getRoot());
       // editEmployeeStage.setScene(scene);





     
                      
                      
                      
//    });
/////////////////////////////////////// GONZO /////////////////////////////////////////////////////////////////////////////




   }


   public static void main(String[] args) {
       launch(args);
   }
   
   public static class Employeee {
        private final SimpleStringProperty id;
        private final SimpleStringProperty firstName;
        private final SimpleStringProperty lastName;
        private final SimpleStringProperty email;
        private final SimpleStringProperty address;
        private final SimpleStringProperty joinDate;
        private final SimpleStringProperty addinfo;
 
        private Employeee(String eID, String fName, String lName, String email, String address, String joinDate, String addInfo) {
            this.id = new SimpleStringProperty(eID);
            this.firstName = new SimpleStringProperty(fName);
            this.lastName = new SimpleStringProperty(lName);
            this.email = new SimpleStringProperty(email);
            this.address = new SimpleStringProperty(address);
            this.joinDate = new SimpleStringProperty(joinDate);
            this.addinfo = new SimpleStringProperty(addInfo);
            
        }
        
        // getter and setter for id 
        public String getID(){
            return id.get();
        }
        
        public void setID(String eID){
            id.set(eID);
        }
        // getter and setter for first name 
        public String getFirstName() {
            return firstName.get();
        }
 
        public void setFirstName(String eID) {
            firstName.set(eID);
        }
        // getter and setter for last name 
        public String getLastName() {
            return lastName.get();
        }
 
        public void setLastName(String eID) {
            lastName.set(eID);
        }
        // getter and setter for email
        public String getEmail() {
            return email.get();
        }
 
        public void setEmail(String eID) {
            email.set(eID);
        }
         // getter and setter for address
        public String getAddress() {
            return address.get();
        }
 
        public void setAddress(String eID) {
            address.set(eID);
        }
        
         // getter and setter for date joined
        public String getJoinDate() {
            return joinDate.get();
        }
 
        public void setJoinDate(String fName) {
            joinDate.set(fName);
        }
        
        // getter and setter for additional info
        public String getAddInfo() {
            return addinfo.get();
        }
 
        public void setAdditionalInfo(String eID) {
            addinfo.set(eID);
        }
        
        
    }
 
    class EditingCell extends TableCell<Employeee, String> {
 
        private TextField textField;
 
        public EditingCell() {
        }
 
        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();
                createTextField();
                setText(null);
                setGraphic(textField);
                textField.selectAll();
            }
        }
 
        @Override
        public void cancelEdit() {
            super.cancelEdit();
 
            setText((String) getItem());
            setGraphic(null);
        }
 
        @Override
        public void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);
 
            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());
                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());
                    setGraphic(null);
                }
            }
        }
 
       private void createTextField() {
            textField = new TextField(getString());
            textField.setMinWidth(this.getWidth() - this.getGraphicTextGap()* 2);
            textField.focusedProperty().addListener(
                (ObservableValue<? extends Boolean> arg0, 
                Boolean arg1, Boolean arg2) -> {
                    if (!arg2) {
                        commitEdit(textField.getText());
                    }
            });

        }

        private String getString() {
            return getItem() == null ? "" : getItem().toString();
        }
    }

}


