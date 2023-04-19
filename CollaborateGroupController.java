/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

import java.awt.event.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
/**
 *
 * @author Jillian
 */
public class CollaborateGroupController implements MouseListener, ActionListener {
    private JFrame frame;
    private CollaborateGroupDisplay groupBox;
    private JLabel memLabel;
    private JButton view;
    private JLabel source;
    
    public CollaborateGroupController(JFrame f){
        this.frame = f;
    }
    
    public CollaborateGroupController(CollaborateGroupDisplay g, JLabel l, JButton v){
        groupBox = g;
        memLabel = l;
        view = v;
    }
    
     public void openDetails(Group g){
        // opens display window
        JFrame window = new CollaborateGroupViewDisplay(g);
        window.setVisible(true);
        //frame.dispose();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //changes formatting of clicked jlabel
        source = (JLabel)e.getSource();
        Group holder = Group.searchGroup(source.getText());
        boolean isSelected = holder.getIsSelected();
        
        if(!isSelected){
            source.setFont(new Font("Futura Bold", Font.BOLD, 20));
            LineBorder line = new LineBorder(Color.black, 2, true);
            groupBox.setBorder(line);
            view.setVisible(true);
            holder.setIsSelected(true);
        } else{
            source.setFont(new Font("Futura Bold", Font.PLAIN, 20));
            groupBox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            view.setVisible(false);
            holder.setIsSelected(false);
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
        groupBox.setBackground(new java.awt.Color(248,196,172));
    }
    @Override
    public void mouseExited(MouseEvent e) {
        groupBox.setBackground(new java.awt.Color(255,222,166));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view){
            Group g = Group.searchGroup(source.getText());
            openDetails(g);
        }
    }
           
}
