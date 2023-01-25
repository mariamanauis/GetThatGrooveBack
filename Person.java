/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GetThatGrooveBack;

/**
 *
 * @author HP
 */
 public abstract class Person implements Advertise, Interactable  {
    protected String name;
    protected double salary;
    
    public Person(String n){
        name = n;
        salary = 0;
    }
    
    public String getName(){
        return name;
    }
    
    public double getSalary(){
        return salary;
    }
    
    public void promote(){
        //to be discussed
    }
    
    public void interact(){
        //to be discussed
    }
}
