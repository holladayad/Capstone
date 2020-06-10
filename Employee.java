/*
Authors: BHOZZ Technology Solutions: Amber Holladay, Yukai Zhou, Mashiyath Zaman, Gonzo Ocampo, Rimjhim Barua
Date: Jun 10, 2020
Assignment: MidPoint Deliverable
Purpose: Employee Class 
 */

package CIS484.Capstone;

import java.util.ArrayList;
public class Employee 
{
      // static int set as a different value from other classes
    private static final int NEXT_EMPLOYEE_ID = 1000;
    // creating private int donation ID //
    private int EmployeeID;
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
    
    
    // creating supervisor employee object object
    private Employee supervisor;
    
    private ArrayList<Employee> suprervisees;  
   
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
        this.supervisor = null;
        this.EmployeeID = NEXT_EMPLOYEE_ID;
    
        if (!role.equals("Supervisor")) // if role is not supervisor 
        {
            this.suprervisees = null; // dont add anything to supervisees
        }
        else // if role is supervisor 
        {
            this.suprervisees = new ArrayList<>();  // creating supervisee array list if work status is supervisor
        }
    }
 
// Setters 
    public boolean setSupervisor(Employee supervisor)
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
    
    public void addSupervisee(Employee employee)
    {
        this.suprervisees.add(employee);
    }
    
}   