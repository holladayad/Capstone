package CIS484.Capstone;

import java.util.*;

public class Transaction {
    
    private int transactionID;
    private double transactionTotal;
    private ArrayList<Items> transactionItems = new ArrayList<>();
    public static int nextTransactionID = 0;
    
    public Transaction()
    {
        this.transactionID = nextTransactionID++;
    }
    
    public void addItem(Items transactionItem)
    {
        // transactionTotal += transactionItem.getPrice();
        transactionItems.add(transactionItem);
        
    }
}
