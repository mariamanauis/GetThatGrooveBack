/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Jillian
 */
public class Event {
    protected String name;
    protected ArrayList<String> Location = new ArrayList<>(Arrays.asList("MKNS Stage", "Gingamingayo", "BShow"));
    protected ArrayList<Double> Cost = new ArrayList<>(Arrays.asList(700.0, 1000.0, 475.0));
    protected ArrayList<Boolean> Availability = new ArrayList<>(Arrays.asList(true, true, true));
    protected double entranceFee;
    
    public String getName(){
        return name;
    }
    
    public void checkEventDetails(){
        for(int i = 0; i < Location.size(); i++){
            System.out.println("Location: " + Location.get(i) + " Cost: " + Cost.get(i));
        }
    }
    
    public void setEntranceFee(double f){
        entranceFee = f;
    }
    
    public void checkAvailability(String n){
        for(int i = 0; i < Location.size(); i++){
            if(n.equalsIgnoreCase(Location.get(i))){
                if(Availability.get(i)){
                    System.out.println(n + " is currently available for reservation!");
                } else{
                    System.out.println(n + " is currently unavailable for reservation. Please select a different location.");
                }
            } else{
                System.out.println("There is no such location. Kindly check your input.");
            }
        }
    }
    
    public void reserve(String n){
        for(int i = 0; i < Location.size(); i++){
            if(n.equalsIgnoreCase(Location.get(i))){
                if(Availability.get(i)){
                    System.out.println("The location you've chosen is available. Please pay " + Cost.get(i) + " pesos.");
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Type in 'confirm' to confirm transaction.");
                    String confirm = sc.nextLine();
                    
                    if(confirm.equalsIgnoreCase("confirm")){
                        // code on getting user's money then subtracting the cost from it
                    } else{
                        System.out.println("Transaction failed. Please try again.");
                    }
                } else{
                    System.out.println(n + " is currently unavailable for reservation. Please select a different location.");
                }
            } else{
                System.out.println("There is no such location. Kindly check your input.");
            }
        }
    }
    
    public void promote(){
        // to be discussed
    }
}
