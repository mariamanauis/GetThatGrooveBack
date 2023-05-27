/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.BorderFactory;
/**
 *
 * @author Jillian
 */
public class GroupProfileDisplay extends JFrame{
    private JButton back;
    private JLabel name, popularityPoints, fandomName, fandomCount, memberName;
    private JPanel northPanel, centerPanel, southPanel;
    private GroupProfileController controller;
    private static int maxCols = 3;
    private static int maxRows = 2;
    private ArrayList<Member> memberList = Group.getMembers();
    private Manager player;
    
    public GroupProfileDisplay(Manager p){
        super("Get That Groove Back!");
        
        player = p;
        
        this.setLayout(new BorderLayout(10, 10));
        this.getContentPane().setBackground(new java.awt.Color(207, 233, 241));
        this.setSize(900, 600);
        
        
        northPanel = new JPanel();
        back = new JButton("Back");
        back.setFont(new Font("Futura Bold", Font.PLAIN, 24));
        back.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        back.setHorizontalAlignment(SwingConstants.LEFT);
        back.setSize(new Dimension(30, 40));
        northPanel.add(back);
        
        centerPanel = new JPanel();
        centerPanel.setBackground(new java.awt.Color(207, 233, 241));
        centerPanel.setLayout(new GridLayout(maxRows, maxCols));
        GridBagConstraints con = new GridBagConstraints();
        con.fill = GridBagConstraints.BOTH;
        
        for(Member m : memberList){
            this.setBackground(new java.awt.Color(230, 244, 185));
            this.memberName = new JLabel(m.getName());
            memberName.setFont(new Font("Futura Bold", Font.PLAIN, 20));
            this.memberName.setHorizontalTextPosition(JLabel.CENTER);
            this.memberName.setVerticalTextPosition(JLabel.BOTTOM);
            ImageIcon img = new ImageIcon(GroupProfileDisplay.class.getResource(
                "imgs/" + m.getImgFileName()));
            Image memImg = img.getImage();
            Image scaledMemImg = memImg.getScaledInstance(108, 192, Image.SCALE_SMOOTH);
            img = new ImageIcon(scaledMemImg);
            memberName.setIcon(img);
            
            centerPanel.add(memberName);
        }
        
        southPanel = new JPanel();
        southPanel.setBackground(new java.awt.Color(207, 233, 241));
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        
        name = new JLabel("Name: " + Group.getOwnName());
        name.setAlignmentX(Component.CENTER_ALIGNMENT);
        name.setFont(new Font("Futura Bold", Font.PLAIN, 40));
        southPanel.add(name);
        
        popularityPoints = new JLabel("Popularity Points: " + Group.getOwnPopularityPoints());
        popularityPoints.setAlignmentX(Component.CENTER_ALIGNMENT);
        popularityPoints.setFont(new Font("Futura Bold", Font.PLAIN, 30));
        southPanel.add(popularityPoints);
        
        fandomName = new JLabel("Fandom Name : " + Group.getOwnFandomName());
        fandomName.setAlignmentX(Component.CENTER_ALIGNMENT);
        fandomName.setFont(new Font("Futura Bold", Font.PLAIN, 30));
        southPanel.add(fandomName);
        
        fandomCount = new JLabel("Fandom Count " + Group.getOwnNoOfFans());
        fandomCount.setAlignmentX(Component.CENTER_ALIGNMENT);
        fandomCount.setFont(new Font("Futura Bold", Font.PLAIN, 30));
        southPanel.add(fandomCount);
        
        this.add(back, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
        
        controller = new GroupProfileController(this, fandomCount, name, fandomName, popularityPoints, back, player);
        back.addActionListener(controller);
        name.addMouseListener(controller);
        popularityPoints.addMouseListener(controller);
        fandomName.addMouseListener(controller);
        fandomCount.addMouseListener(controller);
    }
}
