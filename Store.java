package CIS484.Capstone;

import java.util.*;

public class Store {
    
    private int storeID;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String email;
    public static int nextStoreID = 0;
    private ArrayList<Employee> allEmployees = new ArrayList<>();
    private ArrayList<Items> inventory = new ArrayList<>();
    private ArrayList<Transaction> allTransactions = new ArrayList<>();
    private ArrayList<Donations> allDonations = new ArrayList<>();
    
    public Store(String street, String city, String state, String zipCode, String phoneNumber, String email)
    {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.storeID = nextStoreID++;
    }
    
    public void editLocation()
    {
        
    }
    
    public void addEmployee(Employee newEmployee)
    {
        this.allEmployees.add(newEmployee);
    }
    
    public void addDonation(Donations newDonation)
    {
        this.allDonations.add(newDonation);
    }
    
    public ArrayList<Employee> getEmployees()
    {
        return this.allEmployees;
    }
    
    public ArrayList<Items> getInventory()
    {
        return this.inventory;
    }
    
    public ArrayList<Transaction> getTransactions()
    {
        return this.allTransactions;
    }
    
    public ArrayList<Donations> getDonations()
    {
        return this.allDonations;
    }
    
    @Override
    public String toString()
    {
        String ret = String.format("Address: %s, %s, %s, %s\n"
                + "Phone Number: %s\n"
                + "Email: %s\n",
                this.street, this.city, this.state, this.zipCode, this.phoneNumber, this.email);
        return ret;
    }
}
