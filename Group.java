/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;
import java.util.ArrayList;
/**
 *
 * @author HP
 */
public class Group implements Advertisable, Interactable {
    protected String name, imgFilename, fandomName;
    protected ArrayList<Member> memberList = new ArrayList<>();
    protected int popularityPoints, noOfFans, cost;
    
    public Group(String n, String i, String f){
        name = n;
        imgFilename = i;
        //addition of members will be done by Manager
        fandomName = f;
        popularityPoints = 0;
        noOfFans = 0;
    
    }
    
    //constructor for the groups in the collab screen
    public Group(String n, String img, int p, int c){
        name = n;
        imgFilename = img;
        popularityPoints = p;
        cost = c;
    }
    
    public String getName(){
        return name;
    }
    
    public String getImgFileName(){
        return imgFilename;
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
    
    public int getCost(){
        return cost;
    }
    
    public void checkMembers(){
        System.out.println("Members: ");
        for(Member i: memberList){
            System.out.print(i.getName() + ", ");
        }
    }
    
    public void addMember(Member m){
        memberList.add(m);
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
