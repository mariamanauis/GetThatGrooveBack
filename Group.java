/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *Group class details a group's name, image filename,
 * fandom name, popularity points, and cost
 * @author Maria Manauis and Jill Rosacay
 * @version 1.0
 * @since 05/09/2023
 */
public class Group{
    /**Represents the name 
     * of the group
     */
    protected String name;
    /**Represents the file name of
     * the image of the group
     */
    protected String imgFilename;
    /**Represents the name of the 
     * fandom of the group
     */
    protected String fandomName; 
    /**Represents the group's 
     * own name
     */
    protected static String ownName;
    /**Represents the group's 
     * own fandom name
     */
    protected static String ownFandomName;
    /**Represents the list of members
     * in the group
     */
    protected static ArrayList<Member> memberList = new ArrayList<>();
    
    protected static boolean concert;

    protected ArrayList<Member> memberChoices = new ArrayList<>(Arrays.asList(
        new Member("Jark Pihyo", "jark_pihyo.png", "dancing", 0, 0),
        new Member("Jee Lihoon", "jee_lihoon.png", "singing", 0, 0), 
        new Member("Ahn Jinhye", "ahn_jinhye.png", "rapping", 0, 0), 
        new Member("Yin Moongi", "yin_moongi.png", "rapping", 0, 0), 
        new Member("Hang Kaerin", "hang_kaerin.png", "rapping", 0, 0), 
        new Member("Jan Hisung", "jan_hisung.png", "singing", 0, 0), 
        new Member("Mee Linho", "placeholder.png", "dancing", 0, 0),
        new Member("Jim Kisoo", "placeholder.png", "singing", 0, 0)));
    
    /**Represents the list of 
     * members displayed on the screen
     */
    protected Member[] displayedMembers;
    /**Represents the group's popularity
     * points
     */
    protected int popularityPoints;
    /**Represents the group's
     * number of fans
     */
    protected int noOfFans;
    /**Represents the group's 
     * cost
     */
    protected double cost;
    /**Represents the group's
     * own popularity points
     */
    protected static int ownPopularityPoints; 
    /**Represents the group's
     * own number of fans
     */
    protected static int ownNoOfFans;
    /**Represents the list
     * of groups a group can 
     * collaborate with
     */
    protected static ArrayList<Group> collabList = new ArrayList();
    /**Represents the user's
     * own group
    */
    protected static ArrayList<Group> ownGroup = new ArrayList();
    /**Value that indicates if
     * a group is selected or not
     */
    protected boolean isSelected;
    
    /** Constructs subject provided with parameters
    * @param n - String representing the name of the
    * group
    * @param f - String representing the fandom
    * name of the group
    * @param p - int representing the popularity 
    * points of the group
    * @param h - int representing the number of fans
    * of a group
    */
    public Group(String n, String f, int p, int h){
        ownName = n;
        //addition of members will be done by Manager
        ownFandomName = f;
        ownPopularityPoints = p;
        ownNoOfFans = h;
        concert = false;
        ownGroup.add(this);
    }
    
    /** Constructs subject provided with parameters
    * @param n - String representing the name of the
    * group
    * @param img - String representing the file name
    * of the image of the group
    * @param p - int representing the popularity points
    * of the group
    * @param c - int representing the cost of the group
    */
    //constructor for the groups in the collab screen
    public Group(String n, String img, int p, double c){
        name = n;
        imgFilename = img;
        popularityPoints = p;
        cost = c;
        collabList.add(this);
        isSelected = false;
    }
    
    /** Returns the Group corresponding the
     * event name inputted by the user
    * @return Group with name corresponding 
    * to the user's input
    * @param search - String user input
    * @throws NullPointerException if search 
    * does not match any group name
    */
    public static Group searchGroup(String search) throws NullPointerException {
        for(Group g : collabList){
            if(g.getName().equalsIgnoreCase(search)) return g;
        }
        throw new NullPointerException();
    }
    
    /** Returns the user's created Group
     * @return Group with name corresponding 
     * to the user's input (user's own Group)
     * @param search - String user input
     * (user's own Group's name)
     * @throws NullPointerException if search 
     * does not match any group name
     */
    public static Group searchOwnGroup(String search) throws NullPointerException {
        for(Group g : ownGroup){
            if(g.getOwnName().equalsIgnoreCase(search)) return g;
        }
        throw new NullPointerException();
    }
    
    /** Checks if the group is selected
    * @return A Boolean representing group's
    * availability
    */
    public boolean getIsSelected(){
        return isSelected;
    }
    
    /** Sets the availability of a group
    * @param b - Boolean user input
    */
    public void setIsSelected(boolean b){
        isSelected = b;
    }
    
    /** Gets the group’s own name.
    * @return a String representing the
    * group's own name
    */
    public static String getOwnName(){
        return ownName;
    }
    
    /** Gets the group’s own fandom name.
    * @return a String representing the
    * group's fandom's name
    */
    public static String getOwnFandomName(){
        return ownFandomName;
    }
    
    /** Gets the group’s own fandom name.
    * @return an int representing the
    * group's popularity points
    */
    public static int getOwnPopularityPoints(){
        return ownPopularityPoints;
    }
    
    public static void addOwnPopularityPoints(int i){
        ownPopularityPoints += i;
    }
    
    /** Gets the group’s own fandom name.
    * @return an int representing the
    * amount of fans the group has
    */
    public static int getOwnNoOfFans(){
        return ownNoOfFans;
    }
    
    public static void addOwnNoOfFans(int i){
        ownNoOfFans += i;
    }
    
    public static boolean getConcertStatus(){
        return concert;
    }
    
    public static void setConcertStatus(boolean b){
        concert = b;
    }
    
    /** Gets the group’s name.
    * @return a String representing the group's
    *     name.
    */
    public String getName(){
        return name;
    }
    
    /** Gets the group’s image filename.
    * @return a String representing the group's
    *     image filename.
    */
    public String getImgFileName(){
        return imgFilename;
    }
    
    /** Gets the group’s fandom name.
    * @return a String representing the group's
    *     fandom name.
    */
    public String getFandomName(){
        return fandomName;
    }
    
    /** Gets the group’s popularity points.
    * @return an int representing the group's
    *     popularity points.
    */
    public int getPopularityPoints(){
        return popularityPoints;
    }
    
    /** Gets the group’s number of fans.
    * @return an int representing the group's
    *     number of fans.
    */
    public int getNoOfFans(){
        return noOfFans;
    }
    
     /** Gets the group’s cost.
    * @return an int representing the group's
    *     cost.
    */
    public double getCost(){
        return cost;
    }
    
    /** Generate the number of members the user 
      * can select for their group
    * @param a - int user input
    */
    public void generateMemberChoices(int a){
        displayedMembers = new Member[a+2];
        
        for(int i = 0; i < a+2; i++){
            int random = (int) Math.floor(Math.random()*10) + 1;
            if(random < memberChoices.size()){
                displayedMembers[i] = memberChoices.get(random);
                memberChoices.remove(random);
            } else i--;
        }
    }
    
     /** Gets the members displayed in the screen.
    * @return Member[] representing all the
    * displayed members in the screen
    */
    public Member[] getDisplayedMembers(){
        return displayedMembers;
    }
    
    /** Gets the name of each member of
      * the group
      * @return ArrayList containing the user's
      * Group's Members
    */
    public static ArrayList getMembers(){
        return memberList;
    }
    
    /**Adds member to the group
     * @param m - Member user input
     */
    public void addMember(Member m){
        memberList.add(m);
    }
    
    
}