/*
Authors: BHOZZ Technology Solutions: Amber Holladay, Yukai Zhou, Mashiyath Zaman, Gonzo Ocampo, Rimjhim Barua
Purpose: Employee Class 
 */

package CIS484.Capstone;

import java.util.ArrayList;
import java.util.*;

public class Employee 
{
    public UI myParent; // to get the UI class

    // creating private int donation ID 
    private int EmployeeID;
    
    // creating string for the employee first name 
    private String firstName;
    
    // creating string for the employee last name 
    private String lastName;

    // creating String for the phone number 
    private String phoneNumber;
    
    // creating String for the employee's home address
    private String address;
    
    // creating String for the date joined 
    private String dateJoined;
    
    // creating String for any additional information 
    private String additionalInfo;
   
    // private String email;
    
     // static int set as a different value from other classes
    private static int NEXT_EMPLOYEE_ID = 1000;
 
    Scanner in = new Scanner(System.in);

   /* 
    // private String workStatus; // part time full time? 
    // creating supervisor employee object object
    private Employee supervisor;
    
    private ArrayList<Employee> suprervisees;  
   */

    public Employee (String empName, String phoneNumber, String address, String dateJoined, String additionalInfo)
    {
        String first; // first name
        String last;  // last name
        int end = 0;  // end of first name
        int beg;      // end of last name
        
         //Find the first name index values
        for (int count = 0; count < empName.length(); count++)
        {
            if (empName.charAt(count) == ' ') //if the current character is a space, record the index
            { 
                end = count;
            }
        }   
        
        beg = end + 1; //record the index of the beginning of the last name
                
        first = empName.substring(0, end);
        last = empName.substring(beg, empName.length());
        
    /*
        if (!role.equals("Supervisor")) // if role is not supervisor 
        {
            this.suprervisees = null; // dont add anything to supervisees
        }
        else // if role is supervisor 
        {
            this.suprervisees = new ArrayList<>();  // creating supervisee array list if work status is supervisor
        }
      */
        this.firstName = first;
        this.lastName = last;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateJoined = dateJoined;
        this.additionalInfo = additionalInfo;
        this.EmployeeID = NEXT_EMPLOYEE_ID;
        
        NEXT_EMPLOYEE_ID++;
    }
 
    // Override to accept pre-existing Employees with already assigned IDs
    public Employee(int empID, String empName, String address, String dateJoined, String additionalInfo)
    {
        String first; // first name
        String last;  // last name
        int end = 0;  // end of first name
        int beg;      // end of last name
        
         //Find the first name index values
        for (int count = 0; count < empName.length(); count++)
        {
            if (empName.charAt(count) == ' ') //if the current character is a space, record the index
            { 
                end = count;
            }
        }   
        
        beg = end + 1; //record the index of the beginning of the last name
                
        first = empName.substring(0, end);
        last = empName.substring(beg, empName.length());
        
        this.firstName = first;
        this.lastName = last;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.dateJoined = dateJoined;
        this.additionalInfo = additionalInfo;
        this.EmployeeID = empID;
        
        NEXT_EMPLOYEE_ID = empID + 1;
    }
// Setters 
  /*  public boolean setSupervisor(Employee supervisor)
    {
        if(supervisor.getWorkStatus().equals("Supervisor"))
        {
            this.supervisor = supervisor;
            supervisor.addSupervisee(this);
            return true;
        }
        else
        {
            return false;
        }
    }
    */
    public String getEmpName()
    {
        return this.lastName + ", " + this.firstName;
    }
  
   public String getPhoneNumber()
   {
       return this.phoneNumber;
   }
   
   public void setPhoneNumber(String phoneNumber)
   {
       this.phoneNumber = phoneNumber;
   }
   
   public String getAddress()
   {
       return this.address;
   }
 
   public void setAddress(String address)
   {
       this.address = address;
   }
   
   public String getDateJoined()
   {
       return this.dateJoined;
   }
   
   public void setDateJoined(String dateJoined)
   {
       this.dateJoined = dateJoined;
   }
   
   public String getAdditionalInfo()
   {
       return this.additionalInfo;
   }
   
   public void setAdditionalInfo(String additionalInfo)
   {
       this.additionalInfo = additionalInfo;
   }
   
   public int getEmployeeID()
   {
       return this.EmployeeID;
   }

   
    
}   