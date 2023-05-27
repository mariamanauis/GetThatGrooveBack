/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

import java.util.ArrayList;

/**
 *Event class details an event's name, image filename,
 * entrance fee, location, cost and availability
 *
 * @author Maria Manauis and Jill Rosacay
 * @version 1.0
 * @since 05/09/2023
 */
public class Event {
    /**Represents the name of
    * the event
    */
    protected String name;
    /**Represents the location
     * of the event
     */
    protected String location;
    /**Represents the file name 
     * of the event image
     */
    protected String imgFileName;
    /**Value that indicates if 
     * the event is available
     */
    protected boolean availability;
    /**Value that indicates if the
     * event is selected
     */
    protected boolean isSelected;
    /**Represents the cost of the
     * entrance fee of the event
     */
    protected double entranceFee;
    /**Represents the cost
     * of the group appearing in the
     * event
     */
    protected double cost;
    /**Represents the list
     * of events available
     */
    protected static ArrayList<Event> eventList = new ArrayList();
    
    /** Constructs subject provided with parameters
    * @param n - String representing the name of the
    * event
    * @param i - String representing the file name
    * of the image of the event
    * @param e - double representing the cost of
    * the event's entrance fee
    * @param l - String representing the event's
    * location
    * @param c - double representing the event's
    * cost
    * @param a - Boolean representing the event's
    * availability
    */
    public Event(String n, String i, double e, String l, double c, Boolean a){
        name = n;
        imgFileName = i;
        entranceFee = e;
        location = l;
        cost = c;
        availability = a;
        isSelected = false;
        eventList.add(this);
    }
    
    /** Gets the event’s name.
    * @return A string representing event’s
    *     name.
    */
    public String getName(){
        return name;
    }
    
    /** Gets the event’s image filename.
    * @return A string representing event’s
    * image filename.
    */
    public String getImgFileName(){
      return imgFileName;
    }
    
    /** Gets the event’s location.
    * @return A string representing event’s
    *     location.
    */
    public String getLocation(){
        return location;
    }
    
    /** Gets the event’s entrance fee.
    * @return A double representing event’s
    *     entrance fee.
    */
    public double getEntranceFee(){
        return entranceFee;
    }
    
    /** Gets the event’s cost.
    * @return A double representing event’s
    *     cost.
    */
    public double getCost(){
        return cost;
    }
    
    /** Gets the event’s availability.
    * @return A Boolean representing event’s
    *     availability.
    */
    public boolean getAvailability(){
        return availability;
    }
    
    /** Check if the event is selected.
    * @return A Boolean representing the isSelected
    * value.
    */
    public boolean getIsSelected(){
        return isSelected;
    }
    
    /** Gets the eventList.
    * @return An array containing instances
    * of events.
    */
    public ArrayList<Event> getEventList(){
        return eventList;
    }
    
    /** Set if the event is selected.
    * 
    * @param b Boolean
    */
    public void setIsSelected(boolean b){
        isSelected = b;
    }
    
    /** Sets the event's entrance fee.
    * 
    * @param f double user input
    */
    public void setEntranceFee(double f){
        entranceFee = f;
    }
    
    /** Reserves the event
    * @param n String user input
    */
    public void reserve(String n){
        
    }
    
    /** Returns the Event corresponding the
     * event name inputted by the user
    * @return Event with name corresponding 
    * to the user's input
    * @param search - String user input
    * @throws NullPointerException if search 
    * does not match any event name
    */
    public static Event searchEvent(String search) throws NullPointerException {
        for(Event e : eventList){
            if(e.getName().equalsIgnoreCase(search)) return e;
        }
        throw new NullPointerException();
    }
}
