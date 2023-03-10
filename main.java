/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

/**
 *
 * @author HP
 */
public class main{
    
    public static void main(String[] args){
        /*screens have no bg image (yet) since both screens have complex layouts which had no direct 
        method to set it and using getContentPane and setBounds would make deem the layout used useless in a way*/
        Member[] party = new Member[6];
        party[0] = new Member("Jark Pihyo", "jark_pihyo.png", "dancing", 0, 0);
        party[1] = new Member("Jee Lihoon", "jee_lihoon.png", "singing", 0, 0);
        party[2] = new Member("Ahn Jinhye", "ahn_jinhye.png", "rapping", 0, 0);
        party[3] = new Member("Yin Moongi", "yin_moongi.png", "rapping", 0, 0);
        party[4] = new Member("Hang Kaerin", "hang_kaerin.png", "rapping", 0, 0);
        party[5] = new Member("Jan Hisung", "jan_hisung.png", "singing", 0, 0);
        
        MemberPartyDisplay frame1 = new MemberPartyDisplay(party);
        
        Event event1 = new Event("MKNS Stage", "mkns_stage.png", 200, "XYZ Arena", 1000, true);
        ReservingEventDisplay frame2 = new ReservingEventDisplay(event1);
        
        
        frame1.setVisible(true);
        frame2.setVisible(true);

        
    }
}
