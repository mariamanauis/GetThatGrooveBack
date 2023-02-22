/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

/**
 *
 * @author HP
 */
public class Event {
    protected String name, location, imgFileName;
    protected boolean availability;
    protected double entranceFee, cost;
    
    public Event(String n, String i, double e, String l, double c, Boolean a){
        name = n;
        imgFileName = i;
        entranceFee = e;
        location = l;
        cost = c;
        availability = a;
        
    }
    
    public String getName(){
        return name;
    }
    
    public String getImgFileName(){
      return imgFileName;
    }
    
    public String getLocation(){
        return location;
    }
    
    public double getEntranceFee(){
        return entranceFee;
    }
    
    public double getCost(){
        return cost;
    }
    
    public boolean getAvailability(){
        return availability;
    }
    
    public void setEntranceFee(double f){
        entranceFee = f;
    }
    
    
    public void reserve(String n){
        
    }
    
    public void promote(){
        // to be discussed
    }
}