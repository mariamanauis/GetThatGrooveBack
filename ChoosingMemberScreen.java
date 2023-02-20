/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

/**
 *
 * @author HP
 */
public class ChoosingMemberScreen {
    public static void main(String[] args){
        Member[] party = new Member[6];
        party[0] = new Member("Jark Pihyo", "biology.png", "dancing", 0, 0);
        party[1] = new Member("Jee Lihoon", "biology.png", "singing", 0, 0);
        party[2] = new Member("Ahn Jinhye", "biology.png", "rapping", 0, 0);
        party[3] = new Member("Yin Moongi", "biology.png", "rapping", 0, 0);
        party[4] = new Member("Hang Kaerin", "biology.png", "rapping", 0, 0);
        party[5] = new Member("Jan Hisung", "biology.png", "singing", 0, 0);
        
        MemberPartyDisplay frame = new MemberPartyDisplay(party);
        
        frame.setVisible(true);
        
        
    }
}
