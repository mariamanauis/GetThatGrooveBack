/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *Member class details a member's name, image
 * filename, skill, popularity points, and
 * relationship points 
 * and inherits fields from the Person superclass
 * @author Maria Manauis and Jill Rosacay
 * @version 1.0
 * @since 05/09/2023
 */
public class Member extends Person {
    /**Represents the skill 
     * of the member
     */
    protected String skill;
    /**Represents the list of all the
     * members in a group
     */
    protected static ArrayList<Member> memberList = new ArrayList<>();
    /**Represents the popularity
     * points of a member
     */
    protected int popularityPoints;
    /**Represents the relationship 
     * points of a member
     */
    protected int relationshipPoints;
    
    /** Constructs member provided with parameters
    * @param n - String representing the name of the
    * member
    * @param i - String representing the image 
    * filename of the member
    * @param s - String representing the skill
    * of the member
    * @param p -  int representing the popularity
    * points of the member
    * @param r - int representing the relationship
    * points of the member
    * 
    */
    public Member(String n, String i, String s, int p, int r){
        super(n, i);
        name = n;
        imgFileName = i;
        popularityPoints = p;
        relationshipPoints = r;
        skill = s;
        memberList.add(this);
    }
    
    /**Gets the length of the array
     * memberList
     * @return int representing the
     * size of the array memberList
    * 
    */
    public static int getListLength(){
        System.out.println(memberList.size());
        return memberList.size();
    }
    
    /**Gets Member corresponding to the 
     * index given by the user
     * @return Member from the corresponding
     * index of array memberList
    * @param index - int user input
    */
    public static Member getMemberByIndex(int index){
        return memberList.get(index);
    }
    
    /**Gets index of the inputted Member
     * @param m - Member user input
     * @return int representing the index of the
     * inputted member
     * @throws NullPointerException - if the
     * Member is not in the array
     */
    public static int getMemberIndex(Member m) throws NullPointerException {
        if(memberList.contains(m)) return memberList.indexOf(m);
        else throw new NullPointerException();
    }
    
    /**Gets the index of the inputted member name
     * 
     * @param s - String user input
     * @return int representing the index
     * of the Member with the name from the user
     * input
     * @throws NullPointerException - if member name
     * does not match any member in memberList
     */
    public static int getMemberIndex(String s) throws NullPointerException {
        if(memberList.contains(searchMember(s))) return memberList.indexOf(s);
        else throw new NullPointerException();
    }
    
    /**Searches member using the input of the
     * user
     * @param search - String user input
     * @return String representing the name
     * of the corresponding Member name that matches
     * the user input
     * @throws NullPointerException - if member with the 
     * corresponding name does not exist
     */
    public static Member searchMember(String search) throws NullPointerException {
        for(Member m : memberList){
            if(m.getName().equalsIgnoreCase(search)) return m;
        }
        throw new NullPointerException();
    }
    
        public String getSkill(){
        return skill;
    }
    /**Gets member's skill
     * 
     * @return a String representing
     * the member's skill
     */

    /**Gets member's popularity points
     * 
     * @return int representing the 
     * member's popularity
     */
    public int getPopularityPoints(){
        return popularityPoints;
    }
    
    /**Gets member's relationship points
     * 
     * @return int representing the member's
     * relationship points
     */
    public int getRelationshipPoints(){
        return relationshipPoints;
    }
    
    /**Gets the array containing the members
     * of the group
     * @return Array memberList[]
     */
    public ArrayList getMemberChoices(){
        return memberList;
    }
    
    /*
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
    }*/
}

