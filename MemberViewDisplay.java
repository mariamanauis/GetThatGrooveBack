/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

import javax.swing.*;
import java.awt.*;
import javax.swing.BorderFactory;

/**
 *
 * @author Jillian
 */
public class MemberViewDisplay extends JFrame{
    private JButton close;
    private JLabel memberImage, name, skill, popularity;
    private JPanel southPanel, centerPanel;
    private MemberViewController controller;
    
    public MemberViewDisplay(Member m){
        super("Get That Groove Back!");
        
        this.setLayout(new BorderLayout(10, 10));
        this.getContentPane().setBackground(new java.awt.Color(207, 233, 241));
        this.setSize(450, 300);
        
        
        southPanel = new JPanel();
        southPanel.setBackground(new java.awt.Color(230, 244, 185));
        close = new JButton("Close");
        close.setFont(new Font("Futura Bold", Font.PLAIN, 12));
        southPanel.add(close);
        close.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        centerPanel = new JPanel();
        centerPanel.setBackground(new java.awt.Color(207, 233, 241));
        centerPanel.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.fill = GridBagConstraints.BOTH;
        
        memberImage = new JLabel();
        ImageIcon memberImg = new ImageIcon(getClass().getResource("imgs/" + m.getImgFileName()));
        Image member = memberImg.getImage();
        Image scaledMember = member.getScaledInstance(200, 113, Image.SCALE_SMOOTH);
        memberImg = new ImageIcon(scaledMember);
        memberImage.setIcon(memberImg);
        con.gridwidth = 1;
        con.gridheight = 3;
        con.gridx = 0;
        con.gridy = 0;
        centerPanel.add(memberImage, con);
        
        
        name = new JLabel("Name: " + m.getName());
        name.setFont(new Font("Futura Bold", Font.PLAIN, 16));
        con.gridwidth = 1;
        con.gridheight = 1;
        con.gridx = 1;
        con.gridy = 0;
        centerPanel.add(name, con);
        
        skill = new JLabel("Skill: " + m.getSkill());
        skill.setFont(new Font("Futura Bold", Font.PLAIN, 12));
        con.gridwidth = 1;
        con.gridheight = 1;
        con.gridx = 1;
        con.gridy = 1;
        centerPanel.add(skill, con);
        
        popularity = new JLabel("Popularity Points: " + m.getPopularityPoints()); 
        popularity.setFont(new Font("Futura Bold", Font.PLAIN, 12));
        con.gridwidth = 1;
        con.gridheight = 1;
        con.gridx = 1;
        con.gridy = 2;
        centerPanel.add(popularity, con);
        
        
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(centerPanel, BorderLayout.CENTER);
        
        controller = new MemberViewController(this, memberImage, name, skill, popularity, close);
        close.addActionListener(controller);
        memberImage.addMouseListener(controller);
        name.addMouseListener(controller);
        skill.addMouseListener(controller);
        popularity.addMouseListener(controller);
    }
}
