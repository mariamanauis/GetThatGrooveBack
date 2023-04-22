/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

/**
 *
 * @author HP
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class CollaborateGroupViewController implements MouseListener, ActionListener {
    private CollaborateGroupViewDisplay frame;
    private JLabel groupImage, groupName, groupPopularity, groupCost;
    private JButton yes, no;
    
    public CollaborateGroupViewController(CollaborateGroupViewDisplay f, JLabel img, JLabel n, JLabel p, JLabel c, JButton y, JButton n0){
        frame = f;
        groupImage = img;
        groupName = n;
        groupPopularity = p;
        groupCost = c;
        yes = y;
        no = n0;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel source = (JLabel)e.getSource();
         Font f = source.getFont();
        if(f.isPlain()){
            if(e.getSource() == groupName){
                groupName.setFont(new Font("Futura Bold", Font.BOLD, 40));
            }
            if(e.getSource() == groupPopularity){
                groupPopularity.setFont(new Font("Futura Bold", Font.BOLD, 30));
            }
            if(e.getSource() == groupCost){
                groupCost.setFont(new Font("Futura Bold", Font.BOLD, 30));
            }
        } else {
            if(e.getSource() == groupName){
                groupName.setFont(new Font("Futura Bold", Font.PLAIN, 40));
            }
            if(e.getSource() == groupPopularity){
                groupPopularity.setFont(new Font("Futura Bold", Font.PLAIN, 30));
            }
            if(e.getSource() == groupCost){
                groupCost.setFont(new Font("Futura Bold", Font.PLAIN, 30));
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        groupImage.setBackground(new java.awt.Color(248,196,172));
        groupImage.setOpaque(true);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        groupImage.setBackground(new java.awt.Color(255,222,166));
        groupImage.setOpaque(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == yes){
            //deduct cost from budget
            //generate random increase in popularity based on range of popularity of the two groups
            //display dialog box with new popularity points and resulting budget
            
        }
        if(e.getSource() == no){
            //JFrame window = new CollaborateGroupViewDisplay(g);
            //window.setVisible(true);
            frame.dispose();
        }
    }
    
}

