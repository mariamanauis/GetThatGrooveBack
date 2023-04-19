/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;
import java.util.ArrayList;
import java.util.Arrays;
/**
 *
 * @author HP
 */
public class Group implements Advertisable, Interactable {
    protected String name, imgFilename, fandomName;
    protected ArrayList<Member> memberList = new ArrayList<>();
    protected ArrayList<Member> memberChoices = new ArrayList<>(Arrays.asList(
        new Member("Jark Pihyo", "jark_pihyo.png", "dancing", 0, 0),
        new Member("Jee Lihoon", "jee_lihoon.png", "singing", 0, 0), 
        new Member("Ahn Jinhye", "ahn_jinhye.png", "rapping", 0, 0), 
        new Member("Yin Moongi", "yin_moongi.png", "rapping", 0, 0), 
        new Member("Hang Kaerin", "hang_kaerin.png", "rapping", 0, 0), 
        new Member("Jan Hisung", "jan_hisung.png", "singing", 0, 0), 
        new Member("Mee Linho", "placeholder.png", "dancing", 0, 0), 
        new Member("Joon Yeonghan", "placeholder.png", "singing", 0, 0), 
        new Member("Rin Shyujin", "placeholder.png", "dancing", 0, 0), 
        new Member("Jim Kisoo", "placeholder.png", "singing", 0, 0)));
    protected Member[] displayedMembers = new Member[10];
    protected int popularityPoints, noOfFans, cost;
    protected static ArrayList<Group> collabList = new ArrayList();
    protected boolean isSelected;
    
    public Group(String n, String f){
        name = n;
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
        collabList.add(this);
        isSelected = false;
    }
    
    public static Group searchGroup(String search) throws NullPointerException {
        for(Group g : collabList){
            if(g.getName().equalsIgnoreCase(search)) return g;
        }
        throw new NullPointerException();
    }
    
    public boolean getIsSelected(){
        return isSelected;
    }
    
    public void setIsSelected(boolean b){
        isSelected = b;
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
    
    public void generateMemberChoices(int a){
        int range = 8;
        
        for(int i = 0; i < a; i++){
            int random = (int) Math.floor(Math.random()*range) + 2;
            displayedMembers[i] = memberChoices.get(random);
            memberChoices.remove(random);
        }
    }
    
    public Member[] getDisplayedMembers(){
        return displayedMembers;
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
