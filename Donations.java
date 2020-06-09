package CIS484.Capstone;

import java.util.ArrayList;


public class Donations 
{
    private int donationID;
    private static int nextDonationID = 0;
    private ArrayList<Items> donationItems = new ArrayList<>();
    
    public Donations(String firstName, String lastName, String city, String state, 
                     String zipcode, String phoneNumber, String email)
    {
        // dont know if we need this?
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.state = state;
//        this.zipCode = zipCode;
//        this.phoneNumber = phoneNumber;
//        this.email = email;
        this.donationID = nextDonationID++;
    }
    
    public int amountSold()
    {
        int count = 0;
        for (int i = 0; i<donationItems.size();i++)
        {
            // isSold will be through
            if (donationItems.get(i).getItemSold())
            {
                count++;
            }
        }
        return count;
    }
    public void getSales()
    {
        // iterate through all items
        // if its been sold add the price
    }
    public int getQuantity()
    {
        return donationItems.size();
    }
    

    
}
