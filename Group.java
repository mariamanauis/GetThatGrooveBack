/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GetThatGrooveBack;
import java.util.ArrayList;
/**
 *
 * @author HP
 */
public class Group implements Advertise, Interactable {
    protected String name, fandomName;
    protected ArrayList<Member> memberList = new ArrayList<>();
    protected int popularityPoints, noOfFans;
    
    public Group(String n, String f){
        name = n;
        //addition of members will be done by Manager
        fandomName = f;
        popularityPoints = 0;
        noOfFans = 0;
    
    }
    
    public String getName(){
        return name;
    }
    
    public String getFandomName(){
        return fandomName;
    }
    
    public int getPopularityPoints(){
        return popularityPoints;
    }
    
    public int getNoOfFans(){
        return noOfFans;
    }
    
    public void checkMembers(){
        System.out.println("Members: ");
        for(Member i: memberList){
            System.out.print(i + ", ");
        }
    }
    
    public void practice(int hours){
        System.out.println(name + "has practiced for " + hours + " hours.");
    }
    
    public void collab(Group i){
        System.out.println(name + "collaborated with " + i.getName() + " .");
        popularityPoints += 10;
    }
    
    public void perform(){
        popularityPoints += 50;
    }
    
    public void promote(){
        //to be discussed
    }
    
    public void interact(){
        //to be discussed
    }
}
