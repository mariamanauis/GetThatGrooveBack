/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author HP
 */
public class MainMenuDisplay extends JFrame {
    private JButton collaborate, groupView, booking, practice;
    private MainMenuController controller;
    public double budget;
    public Manager player;
    
    public MainMenuDisplay(){
        super("Get That Groove Back!");
        this.getContentPane().setBackground(new java.awt.Color(230, 244, 185));
        this.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.fill = GridBagConstraints.BOTH;
        
        groupView = new JButton("VIEW GROUP");
        groupView.setPreferredSize(new Dimension(300, 200));
        con.gridx = 0;
        con.gridy = 0;
        con.insets = new Insets(10, 10, 10, 10);
        this.add(groupView, con);
 
        
        collaborate = new JButton("COLLABORATE");
        collaborate.setPreferredSize(new Dimension(300, 200));
        con.gridx = 0;
        con.gridy = 1;
        con.insets = new Insets(10, 10, 10, 10);
        this.add(collaborate, con);
        
        booking = new JButton("BOOK AN EVENT");
        booking.setPreferredSize(new Dimension(300, 200));
        con.gridx = 1;
        con.gridy = 0;
        con.insets = new Insets(10, 10, 10, 10);
        this.add(booking, con);
        
        practice = new JButton("PRACTICE");
        practice.setPreferredSize(new Dimension(300, 200));
        con.gridx = 1;
        con.gridy = 1;
        con.insets = new Insets(10, 10, 10, 10);
        this.add(practice, con);
        
        this.setSize(900, 600);
        
        controller = new MainMenuController(this, collaborate, groupView, booking, practice, player);
        collaborate.addActionListener(controller);
        groupView.addActionListener(controller);
        booking.addActionListener(controller);
        practice.addActionListener(controller);
        
        
    }
    
    public MainMenuDisplay(Manager m){
        super("Get That Groove Back!");
        this.getContentPane().setBackground(new java.awt.Color(230, 244, 185));
        this.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.fill = GridBagConstraints.BOTH;
        
        player = m;
        
        groupView = new JButton("VIEW GROUP");
        groupView.setPreferredSize(new Dimension(300, 200));
        con.gridx = 0;
        con.gridy = 0;
        con.insets = new Insets(10, 10, 10, 10);
        this.add(groupView, con);
 
        
        collaborate = new JButton("COLLABORATE");
        collaborate.setPreferredSize(new Dimension(300, 200));
        con.gridx = 0;
        con.gridy = 1;
        con.insets = new Insets(10, 10, 10, 10);
        this.add(collaborate, con);
        
        booking = new JButton("BOOK AN EVENT");
        booking.setPreferredSize(new Dimension(300, 200));
        con.gridx = 1;
        con.gridy = 0;
        con.insets = new Insets(10, 10, 10, 10);
        this.add(booking, con);
        
        practice = new JButton("PRACTICE");
        practice.setPreferredSize(new Dimension(300, 200));
        con.gridx = 1;
        con.gridy = 1;
        con.insets = new Insets(10, 10, 10, 10);
        this.add(practice, con);
        
        this.setSize(900, 600);
        controller = new MainMenuController(this, collaborate, groupView, booking, practice, player);
        collaborate.addActionListener(controller);
        groupView.addActionListener(controller);
        booking.addActionListener(controller);
        practice.addActionListener(controller);
        
        System.out.println(player.getBudget());
        
        
        
    }
}
