/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

/**
 *
 * @author HP
 */
public abstract class Person implements Advertise, Interactable  {
    protected String name, imgFileName;
    protected double money, salary;
    
    public Person(String n, String i){
        name = n;
        imgFileName = i;
        salary = 0;
    }
    
    public String getName(){
        return name;
    }
    
    public double getSalary(){
        return salary;
    }
  
  public double getMoney(){
        return money;
    }
  
  public String getImgFileName(){
      return imgFileName;
  }
    
    public void promote(){
        //to be discussed
    }
    
    public void interact(){
        //to be discussed
    }
}