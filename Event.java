/*
Authors: BHOZZ Technology Solutions: Amber Holladay, Yukai Zhou, Mashiyath Zaman, Gonzo Ocampo, Rimjhim Barua
Date: Jun 10, 2020
Assignment: MidPoint Deliverable
Purpose: Event Class
 */
package CIS484.Capstone;

import java.time.LocalDate;
import java.util.*;

public class Event {
    private int eventID;
    public static int nextEventID = 0;
    private String eventName;
    private String picURL;
    private LocalDate eventDate;
    private String eventDiscrip;
    
    
    public Event(String eventName, String picURL, LocalDate eventDate, String eventDiscrip)
    {
        this.eventName = eventName;
        this.picURL = picURL;
        this.eventDate = eventDate;
        this.eventDiscrip = eventDiscrip;
        this.eventID = nextEventID++;
    }
    public void editEvent(String eventName, String picURL, LocalDate eventDate, String eventDiscrip)
    {
        this.eventName = eventName;
        this.picURL = picURL;
        this.eventDate = eventDate;
        this.eventDiscrip = eventDiscrip;
        this.eventID = nextEventID++;
    }

    public int getEventID() 
    {
        return eventID;
    }

    public String getEventName() 
    {
        return eventName;
    }

    public String getPicURL() 
    {
        return picURL;
    }

    public LocalDate getEventDate() 
    {
        return eventDate;
    }

    public String getEventDiscrip() 
    {
        return eventDiscrip;
    }
    
    @Override
    public String toString()
    {
        String ret = String.format("%s, %s", eventName, eventDate);
        return ret;
    }
    
    
}
