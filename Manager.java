/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 *Manager class details a manager's name and image
 * filename and inherits fields from the Person superclass
 * @author Maria Manauis and Jill Rosacay
 * @version 1.0
 * @since 05/09/2023
 */
public class Manager extends Person{
    public double budget;
    
    /** Constructs manager provided with parameters
    * @param n - String representing the name of the
    * manager
    * @param i - String representing the image 
    * filename of the manager
    * @param b - Double representing the budget
    * of the manager
    */
    public Manager(String n, String i, double b){
        super(n, i);
        name = n;
        imgFileName = i;
        budget = b;
    }
    
    public double getBudget(){
        return budget;
    }
    
    public double updateBudget(double b){
        budget += b;
        return budget;
    }
    
    public boolean arrangeCollab(JFrame frame, Member member, Member otherMember){
        JOptionPane.showMessageDialog(frame, "You've reached out to " + otherMember.getName() + " for a collaboration with " + member.getName() + ".");
        int random = (int) Math.floor(Math.random()*10) + 1;
        if(random / 2 == 0){ JOptionPane.showMessageDialog(frame, "They have agreed to the collaboration!"); return true;}
        else{ JOptionPane.showMessageDialog(frame, "Unfortunately, they have disagreed to the collaboration. Kindly select a different artist."); return false;}
    }
    
    public boolean arrangeCollab(JFrame frame, Member member, Group group){
        JOptionPane.showMessageDialog(frame, "You've reached out to " + group.getName() + " for a collaboration with " + member.getName() + ".");
        int random = (int) Math.floor(Math.random()*10) + 1;
        if(random / 2 == 0){ JOptionPane.showMessageDialog(frame, "They have agreed to the collaboration!"); return true;}
        else{ JOptionPane.showMessageDialog(frame, "Unfortunately, they have disagreed to the collaboration. Kindly select a different artist."); return false;}
    }
    
    public boolean arrangeCollab(JFrame frame, Group group, Group otherGroup){
        JOptionPane.showMessageDialog(frame, "You've reached out to " + otherGroup.getName() + " for a collaboration with " + Group.getOwnName() + ".");
        int random = (int) Math.floor(Math.random()*10) + 1;
        if(random / 2 == 0){ JOptionPane.showMessageDialog(frame, "They have agreed to the collaboration!"); return true;}
        else{ JOptionPane.showMessageDialog(frame, "Unfortunately, they have disagreed to the collaboration. Kindly select a different artist."); return false;}
    }
    
    public boolean arrangeCollab(JFrame frame, Group group, Member member){
        JOptionPane.showMessageDialog(frame, "You've reached out to " + member.getName() + " for a collaboration with " + Group.getOwnName() + ".");
        int random = (int) Math.floor(Math.random()*10) + 1;
        if(random / 2 == 0){ JOptionPane.showMessageDialog(frame, "They have agreed to the collaboration!"); return true;}
        else{ JOptionPane.showMessageDialog(frame, "Unfortunately, they have disagreed to the collaboration. Kindly select a different artist."); return false;}
    }
    
}
