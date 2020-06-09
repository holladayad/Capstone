package CIS484.Capstone;


public class Donations 
{
    private int donationID;
    private static int nextDonationID = 0;
    private ArrayList<Item> donationItems = new ArrayList<>();
    
    public Donation (String firstName, String lastName, String city, String state, String zipcode, String phoneNumber, String email)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.donationID = nextDonationID++;
    }
    
    public void amountSold(Items donationItem)
    {
        
    }
    public void getProfit()
    {
        
    }
    public void getQuantity()
    {
        
    }

    
}
