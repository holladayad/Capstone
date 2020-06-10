package cis484.Capstone;

import java.util.*;

public class Employee 
{
    // creating private int donation ID //
    private static int EmployeeID;
    // static int set as a different value from other classes
    private static final int NEXT_EMPLOYEE_ID = 1000;
    private String empFirstName; 
    private String empLastName; 
    private String street;
    private String city; 
    private String state;
    private String zipCode; 
    private String phoneNumber;
    private String email;
    private String workStatus; // part-time, full-time etc. 
    private String role; // Aka Cares Employee, Volunteer or VoliHelper
    private double wage;    // this is the pay variable 
    private double hoursWorked; // this could be determined by work status, but not ideal we should add hours worked to the UI "payroll recorder" 
    
    public ArrayList<Employee> Employees = new ArrayList<>();
    public ArrayList<Employee> roles = new ArrayList<>();
    
    
   
    public Employee (String empFirstName, String empLastName, String street, 
        String city, String state, String zipCode, String phoneNumber, 
        String email, String workStatus, String role, double wage, double hoursWorked) 
    {
        this.empFirstName = empFirstName;
        this.empLastName = empLastName; 
        this.street = street;
        this.city = city;
        this.state = state; 
        this.zipCode = zipCode; 
        this.phoneNumber = phoneNumber;
        this.email = email; 
        this.workStatus = workStatus; 
        this.role = role; 
        this.wage = wage; 
        this.hoursWorked = hoursWorked; 
    }

// Setters 
    public void setEmpFirstName(String empFirstName) 
    {
        this.empFirstName = empFirstName;
    }
    
    public void setEmpLastName(String empLastName) 
    {
        this.empLastName = empLastName;
    }
    
    public void setStreet(String street) 
    {
        this.street = empFirstName;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public void setState(String state)
    {
        this.state = state;
    }
    
    public void setZipCode(String setZipCode)
    {
        this.zipCode = zipCode;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public void setWorkStatus(String workStatus)
    {
        this.workStatus = workStatus;
    }
    
    public void setRole(String role)
    {
        this.role = role;
    }
    
    public void setWage(double wage)
    {
        this.wage = wage;
    }
    
    public void setHoursWorked(double hoursWorked)
    {
        this.hoursWorked = hoursWorked; 
    }
    
// Getters 
    public String getEmpFirstName()
    {
        return this.empFirstName;
    }
    
    public String getEmpLastName()
    {
        return this.empLastName;
    }
    
    public String getStreet()
    {
        return this.street;
    }

    public String getCity()
    {
       return this.city;
    }

    public String getState()
    {
        return this.state;
    }
    
    public String getZipCode()
    {
        return this.zipCode;
    }

    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    
    public String getWorkStatus()
    {
        return this.workStatus;
    }
    
    public double getWage()
    {
        return this.wage;
    }
    
    public double getHoursWorked()
    {
        return this.hoursWorked;
    }

    // Assign to store method 
    public void assignToNewStore(String storeID)
    {
        
    }
   
    // Do we really need this? couldnt this just be an option under role 
    public void addSupervisee()
    {
       
    }
    
    //
    //public void login()
    //{
      //  
    //}
}