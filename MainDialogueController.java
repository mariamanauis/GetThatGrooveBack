/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
/**
 *
 * @author Jillian
 */
public class MainDialogueController implements ActionListener, MouseListener{
    private JFrame frame;
    private JButton next;
    private JLabel dialogue;
    private int counter = 0;
    protected Member[] displayedMembers;

    public MainDialogueController(JFrame f, JButton n, JLabel l){
        this.frame = f;
        next = n;
        dialogue = l;
    }
    
    public void generateDialogue(){
        switch(counter){
            case 0:
                dialogue.setText("We're the CEOs, Ji and Mar, and starting today, you're one of our managers.");
                break;
            case 1:
                dialogue.setText("Let's start with forming your own group!");
                break;
            case 2:
                dialogue.setText("Enter the desired name for your group, its fandom name, and how many members it would have.");
                break;
            case 3:
                String grpName = JOptionPane.showInputDialog(frame, "Enter Your Group's Name", "My Group");
                String fandomName = JOptionPane.showInputDialog(frame, "Enter The Fandom's Name", "My Fandom");
                Group grpInput = new Group(grpName, fandomName, 0, 0);
                
                int memCount = Integer.parseInt(JOptionPane.showInputDialog(frame, "Enter The Amount Of Members In Your Group (choose"
                        + " integer values from 2 to 6)", "4"));
                
                grpInput.generateMemberChoices(memCount);
                displayedMembers = grpInput.getDisplayedMembers();
                
                JFrame window = new SelectingMemberPartyDisplay(grpName, memCount, displayedMembers);
                window.setVisible(true);
                frame.dispose();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == next){
            generateDialogue();
            counter++;
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
