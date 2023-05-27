/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
/**
 *
 * @author Jillian
 */

public class CollaborateGroupViewController implements MouseListener, ActionListener {
    private JFrame frame;
    private JLabel groupImage, groupName, groupPopularity, groupCost;
    private JButton close;
    private Manager player;
    
    public CollaborateGroupViewController(JFrame f, JLabel img, JLabel n, JLabel p, JLabel c, JButton cl, Manager m){
        frame = f;
        groupImage = img;
        groupName = n;
        groupPopularity = p;
        groupCost = c;
        close = cl;
        player = m;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel source = (JLabel)e.getSource();
         Font f = source.getFont();
        if(f.isPlain()){
            if(e.getSource() == groupName){
                groupName.setFont(new Font("Futura Bold", Font.BOLD, 16));
            }
            if(e.getSource() == groupPopularity){
                groupPopularity.setFont(new Font("Futura Bold", Font.BOLD, 12));
            }
            if(e.getSource() == groupCost){
                groupCost.setFont(new Font("Futura Bold", Font.BOLD, 12));
            }
        } else {
            if(e.getSource() == groupName){
                groupName.setFont(new Font("Futura Bold", Font.PLAIN, 12));
            }
            if(e.getSource() == groupPopularity){
                groupPopularity.setFont(new Font("Futura Bold", Font.PLAIN, 12));
            }
            if(e.getSource() == groupCost){
                groupCost.setFont(new Font("Futura Bold", Font.PLAIN, 12));
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
        if(e.getSource() == close){
          frame.dispose();
        }
    }
    
}
