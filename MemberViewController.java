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

public class MemberViewController implements ActionListener, MouseListener {
    private JFrame frame;
    private JLabel memberImage, memberName, memberSkill, memberPopularity;
    private JButton close;
    
    public MemberViewController(JFrame m, JLabel img, JLabel n, JLabel s, JLabel p, JButton b){
        frame = m;
        memberImage = img;
        memberName = n;
        memberSkill = s;
        memberPopularity = p;
        close = b;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == close){
            frame.dispose();
            //JFrame display = new MemberPartyDisplay();
            
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel source = (JLabel)e.getSource();
        Font f = source.getFont();
        if(f.isPlain()){
            if(e.getSource() == memberName){
                memberName.setFont(new Font("Futura Bold", Font.BOLD, 16));
            }
            if(e.getSource() == memberSkill){
                memberSkill.setFont(new Font("Futura Bold", Font.BOLD, 12));
            }
            if(e.getSource() == memberPopularity){
                memberPopularity.setFont(new Font("Futura Bold", Font.BOLD, 12));
            }
        } else {
            if(e.getSource() == memberName){
                memberName.setFont(new Font("Futura Bold", Font.PLAIN, 16));
            }
            if(e.getSource() == memberSkill){
                memberSkill.setFont(new Font("Futura Bold", Font.PLAIN, 12));
            }
            if(e.getSource() == memberPopularity){
                memberPopularity.setFont(new Font("Futura Bold", Font.PLAIN, 12));
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {
        memberImage.setBackground(new java.awt.Color(176, 202, 241));
        memberImage.setOpaque(true);
    }
    @Override
    public void mouseExited(MouseEvent e) {
        memberImage.setBackground(new java.awt.Color(207, 233, 241));
        memberImage.setOpaque(true);
    }
}
