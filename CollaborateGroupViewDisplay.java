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
 * @author HP
 */
public class CollaborateGroupViewDisplay extends JFrame {
    private JLabel budget, groupImg, name, popularity, cost, question;
    private JButton close;
    private JPanel southPanel, main;
    private CollaborateGroupViewController controller;
    private Manager player;
    
    public CollaborateGroupViewDisplay(Group g, Manager m){
        super("Get That Groove Back!");
        this.setSize(450, 300);
        this.setLayout(new BorderLayout(10, 10));
        this.getContentPane().setBackground(new java.awt.Color(255,222,166));
        
        player = m;
        
        this.budget = new JLabel("Budget: " + player.getBudget(), SwingConstants.RIGHT);
        budget.setFont(new Font("Futura Bold", Font.PLAIN, 16));
        budget.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        main = new JPanel();
        main.setBackground(new java.awt.Color(255,222,166));
        main.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.fill = GridBagConstraints.BOTH;
        
        groupImg = new JLabel();
        ImageIcon group = new ImageIcon(CollaborateGroupViewDisplay.class.getResource("imgs/" + g.getImgFileName()));
        Image groupImage = group.getImage();
        Image scaledGroupImg = groupImage.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        group = new ImageIcon(scaledGroupImg);
        groupImg.setIcon(group);
        con.gridwidth = 1;
        con.gridheight = 4;
        con.gridx = 0;
        con.gridy = 0;
        main.add(groupImg, con);
        
        name = new JLabel(g.getName());
        name.setFont(new Font("Futura Bold", Font.PLAIN, 16));
        con.gridwidth = 1;
        con.gridheight = 1;
        con.gridx = 1;
        con.gridy = 0;
        main.add(name, con);
        
        popularity = new JLabel("Popularity: " + String.valueOf(g.getPopularityPoints()));
        popularity.setFont(new Font("Futura Bold", Font.PLAIN, 12));
        con.gridwidth = 1;
        con.gridheight = 1;
        con.gridx = 1;
        con.gridy = 2;
        main.add(popularity, con);
        
        cost = new JLabel("Cost: " + String.valueOf(g.getCost()));
        cost.setFont(new Font("Futura Bold", Font.PLAIN, 12));
        con.gridwidth = 1;
        con.gridheight = 1;
        con.gridx = 1;
        con.gridy = 3;
        main.add(cost, con);
        
        
        southPanel = new JPanel();
        southPanel.setBackground(new java.awt.Color(248,196,172));
    
        close = new JButton("Close");
        close.setFont(new Font("Futura Bold", Font.PLAIN, 12));
        southPanel.add(close);
        close.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        this.add(budget, BorderLayout.NORTH);
        this.add(main, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
        
        controller = new CollaborateGroupViewController(this, groupImg, name, popularity, cost, close, player);
        groupImg.addMouseListener(controller);
        name.addMouseListener(controller);
        popularity.addMouseListener(controller);
        cost.addMouseListener(controller);
        close.addActionListener(controller);
    }
}
