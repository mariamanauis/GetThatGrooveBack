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
public class Member extends Person {
    protected ArrayList<String> Skills = new ArrayList<>();
    protected int popularityPoints, relationshipPoints;
    
    public Member(String n, String s,int p, int r){
        super(n);
    }
    
    public void checkSkills(){
        System.out.println("Skills: ");
        for(String i: Skills){
            System.out.print(i + ", ");
        }
    }
    
    public int getPopularityPoints(){
        return popularityPoints;
    }
    
    public int getRelationshipPoints(){
        return relationshipPoints;
    }
    
    public void practice(int hours){
        System.out.println(name + "has practiced for " + hours + " hours.");
    }
    
    public void collab(Member i){
        System.out.println(name + "collaborated with " + i.getName() + " .");
        popularityPoints += 10;
    }
    
    public void perform(){
        salary += 100;
        popularityPoints += 50;
    }
}
