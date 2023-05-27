/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

/**
 *Person class is an abstract class that
 * details a person's name, image
 * filename, salary, and money
 * and inherits fields from the Person superclass
 * @author Maria Manauis and Jill Rosacay
 * @version 1.0
 * @since 05/09/2023
 */
public abstract class Person {
    /**Represents the name of
     * a person
     */
    protected String name;
    /**Represents the file name
     * of the image
     */
    protected String imgFileName;
    /**Represents the money a 
     * Person has
     */
    protected double money;
    /**Represents the salary
     * earned by a Person
     */
    protected double salary;
    /**Value that indicates if a 
     * person is selected or not
     */
    protected boolean isSelected;
    
    /** Constructs member provided with parameters
    * @param n - String representing the name of the
    * person
    * @param i - String representing the person's
    * image filename
    * 
    */
    public Person(String n, String i){
        name = n;
        imgFileName = i;
        salary = 0;
    }
    
    /**Gets the name of the person
     * 
     * @return String member representing
     * the member's name
     */
    public String getName(){
        return name;
    }
    
    /**Gets the salary of the person
     * 
     * @return int representing
     * the member's salary
     */
    public double getSalary(){
        return salary;
    }
  
    /**Gets the money of the person
     * 
     * @return int representing
     * the member's money
     */
    public double getMoney(){
        return money;
    }
  
    /**Gets the image filename of the person
     * 
     * @return String representing the
     * person's image filename
     */
    public String getImgFileName(){
      return imgFileName;
    }
  
    /**Checks if member is selected
     * @return boolean representing the
     * availability of the person
     */
    public boolean getIsSelected(){
        return isSelected;
    }
    
    /**Sets the availability of the group
     * 
     * @param b  boolean representing the audition of my mom
     */
    public void setIsSelected(boolean b){
        isSelected = b;
    }
    
}
