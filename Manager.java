/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

import java.util.ArrayList;

/**
 *
 * @author Jillian
 */
public class Manager extends Person implements Advertise{
    protected ArrayList<Group> groupsManaged = new ArrayList<>();
    
    public Manager(String n){
        super(n);
    }
    
    public void checkGroupsManaged(){
        for(Group i : groupsManaged){
            System.out.print("You are currently handling: ");
            System.out.println(i.getName());
        }   
    }
    
    public void addGroupToManage(Group newGroup){
        groupsManaged.add(newGroup);
    }
    
    public void addMemberToGroup(Group group, Member newMember){
        group.memberList.add(newMember);
        System.out.println(newMember.getName() + " has been added to " + group.getName() + ".");
    }
    
    public void arrangeCollab(Member member, Member otherMember){
        System.out.println("You've reached out to " + otherMember.getName() + " for a collaboration with " + member.getName() + ".");
        int random = (int) Math.floor(Math.random()*10) + 1;
        if(random / 2 == 0) System.out.println("They have agreed to the collaboration!");
        else System.out.println("Unfortunately, they have disagreed to the collaboration. Kindly select a different artist.");
    }
    
    public void arrangeCollab(Member member, Group group){
        System.out.println("You've reached out to " + group.getName() + " for a collaboration with " + member.getName() + ".");
        int random = (int) Math.floor(Math.random()*10) + 1;
        if(random / 2 == 0) System.out.println("They have agreed to the collaboration!");
        else System.out.println("Unfortunately, they have disagreed to the collaboration. Kindly select a different artist.");
    }
    
    public void arrangeCollab(Group group, Group otherGroup){
        System.out.println("You've reached out to " + otherGroup.getName() + " for a collaboration with " + group.getName() + ".");
        int random = (int) Math.floor(Math.random()*10) + 1;
        if(random / 2 == 0) System.out.println("They have agreed to the collaboration!");
        else System.out.println("Unfortunately, they have disagreed to the collaboration. Kindly select a different artist.");
    }
    
    public void arrangeCollab(Group group, Member member){
        System.out.println("You've reached out to " + member.getName() + " for a collaboration with " +group.getName() + ".");
        int random = (int) Math.floor(Math.random()*10) + 1;
        if(random / 2 == 0) System.out.println("They have agreed to the collaboration!");
        else System.out.println("Unfortunately, they have disagreed to the collaboration. Kindly select a different artist.");
    }
    
    public void evaluateGroup(float a){
        // to be discussed
    }
    
    public void evaluateMember(float a){
        // to be discussed
    }
    
    public void promote(){
        // to be discussed
    }
}
