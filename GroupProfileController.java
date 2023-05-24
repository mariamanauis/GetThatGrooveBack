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
public class GroupProfileController implements ActionListener, MouseListener{
    private JFrame frame;
    private JLabel memberImage, memberName, memberSkill, memberPopularity;
    private JLabel groupName, popularityPoints, fandomName, fandomCount;
    private JButton back;
    
    public GroupProfileController(JFrame m, JLabel img, JLabel n, JLabel s, JLabel p, JButton b){
        frame = m;
        memberImage = img;
        memberName = n;
        memberSkill = s;
        memberPopularity = p;
        back = b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
        frame.dispose();
        JFrame display = new MainMenuDisplay();
        display.setVisible(true);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel source = (JLabel)e.getSource();
        Font f = source.getFont();
        if(f.isPlain()){
            if(e.getSource() == groupName){
                groupName.setFont(new Font("Futura Bold", Font.BOLD, 40));
            }
            if(e.getSource() == popularityPoints){
                popularityPoints.setFont(new Font("Futura Bold", Font.BOLD, 30));
            }
            if(e.getSource() == fandomName){
                fandomName.setFont(new Font("Futura Bold", Font.BOLD, 30));
            }
            if(e.getSource() == fandomCount){
                fandomCount.setFont(new Font("Futura Bold", Font.BOLD, 30));
            }
        } else {
            if(e.getSource() == groupName){
                groupName.setFont(new Font("Futura Bold", Font.PLAIN, 40));
            }
            if(e.getSource() == popularityPoints){
                popularityPoints.setFont(new Font("Futura Bold", Font.PLAIN, 30));
            }
            if(e.getSource() == fandomName){
                fandomName.setFont(new Font("Futura Bold", Font.PLAIN, 30));
            }
            if(e.getSource() == fandomCount){
                fandomCount.setFont(new Font("Futura Bold", Font.PLAIN, 30));
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        memberImage.setBackground(new java.awt.Color(207, 233, 241));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        memberImage.setBackground(new java.awt.Color(230, 244, 185));
    }
}
