/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author Jillian
 */
public class SelectingMemberController implements MouseListener, ActionListener{
    private JFrame frame;
    private SelectingMemberPartyDisplay frameBox;
    private JLabel memLabel;
    private JButton view, select;
    private JLabel source, remaining;
    private Group group;
    private int memCount;
    
    public SelectingMemberController(JFrame f, String n){
        this.frame = f;
    }
    
    public SelectingMemberController(JLabel l, JButton v, JButton s, JLabel r, SelectingMemberPartyDisplay f, int c){
        memLabel = l;
        view = v;
        select = s;
        remaining = r;
        frameBox = f;
        memCount = c;
    }
    
    public void openDetails(Member m){
        // opens display window
        JFrame window = new MemberViewDisplay(m);
        window.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //changes formatting of clicked jlabel
        source = (JLabel)e.getSource();
        Member holder = Member.searchMember(source.getText());
        boolean isSelected = holder.getIsSelected();
        
        if(!isSelected){
            source.setFont(new Font("Futura Bold", Font.BOLD, 20));
            view.setVisible(true);
            select.setVisible(true);
            holder.setIsSelected(true);
        } else {
            source.setFont(new Font("Futura Bold", Font.PLAIN, 20));
            view.setVisible(false);
            select.setVisible(false);
            holder.setIsSelected(false);
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view){
            Member m = Member.searchMember(source.getText());
            openDetails(m); 
        }
        if(e.getSource() == select){
            Member m = Member.searchMember(source.getText());
            // displays confirm dialog for user
            int input = JOptionPane.showConfirmDialog(null, 
            "Do you want to add this member to your group?", "Confirm selection",JOptionPane.YES_NO_OPTION);
            if(input == 0){
                String holder = Group.getOwnName();
                Group group = Group.searchOwnGroup(holder);
                
                group.addMember(m);
                
                JOptionPane.showMessageDialog(frame, "Member added to your group!");
                
                memCount--;
                select.setEnabled(false);
                remaining.setText("[SLOTS LEFT: " + memCount + "]");
            }
            
            if(memCount == 1){
                String holder = Group.getOwnName();
                Group group = Group.searchOwnGroup(holder);
                
                group.addMember(m);
                
                JOptionPane.showMessageDialog(frame, "Member added to your group!");
                
                select.setEnabled(false);
                
                memCount--;
                remaining.setText("[SLOTS LEFT: " + memCount + "]");
                
                JFrame window = new MainMenuDisplay();
                window.setVisible(true);
                frame.dispose();
            }
        }    
    }
}
