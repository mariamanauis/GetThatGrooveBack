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
public class EventViewDisplay extends JFrame {
    private JLabel budget, eventImg, name, location, entrance, availability, cost;
    private JButton close;
    private JPanel southPanel, centerPanel;
    private EventViewController controller;
    private Manager player;

    
    public EventViewDisplay(Event e, Manager m){
        super("Get That Groove Back!");
        this.setLayout(new BorderLayout(10, 10));
        this.getContentPane().setBackground(new java.awt.Color(207, 233, 241));
        
        player = m;
        
        this.budget = new JLabel("Budget: " + player.getBudget(), SwingConstants.RIGHT);
        budget.setFont(new Font("Futura Bold", Font.PLAIN, 16));
        budget.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
       
        centerPanel = new JPanel();
        centerPanel.setBackground(new java.awt.Color(207, 233, 241));
        centerPanel.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.fill = GridBagConstraints.BOTH;
       
        
        eventImg = new JLabel();
        ImageIcon event = new ImageIcon(EventViewDisplay.class.getResource("imgs/" + e.getImgFileName()));
        Image eventImage = event.getImage();
        Image scaledEventImg = eventImage.getScaledInstance(200, 150, Image.SCALE_SMOOTH);
        event = new ImageIcon(scaledEventImg);
        eventImg.setIcon(event);
        con.gridwidth = 1;
        con.gridheight = 5;
        con.gridx = 0;
        con.gridy = 0;
        centerPanel.add(eventImg, con);
        
        name = new JLabel(e.getName());
        name.setFont(new Font("Futura Bold", Font.PLAIN, 16));
        con.gridwidth = 1;
        con.gridheight = 1;
        con.gridx = 1;
        con.gridy = 0;
        centerPanel.add(name, con);
        
        location = new JLabel("Location: " + e.getLocation());
        location.setFont(new Font("Futura Bold", Font.PLAIN,12));
        con.gridwidth = 1;
        con.gridheight = 1;
        con.gridx = 1;
        con.gridy = 1;
        centerPanel.add(location, con);
        
        entrance = new JLabel("Entrance Fee: " + String.valueOf(e.getEntranceFee())); 
        entrance.setFont(new Font("Futura Bold", Font.PLAIN, 12));
        con.gridwidth = 1;
        con.gridheight = 1;
        con.gridx = 1;
        con.gridy = 2;
        centerPanel.add(entrance, con);
        
        cost = new JLabel("Cost: " + String.valueOf(e.getCost()));
        cost.setFont(new Font("Futura Bold", Font.PLAIN, 12));
        con.gridwidth = 1;
        con.gridheight = 1;
        con.gridx = 1;
        con.gridy = 3;
        centerPanel.add(cost, con);
        
        availability = new JLabel("Availability: " + e.getAvailability());
        availability.setFont(new Font("Futura Bold", Font.PLAIN, 12));
        con.gridwidth = 1;
        con.gridheight = 1;
        con.gridx = 1;
        con.gridy = 4;
        centerPanel.add(availability, con);
        
        southPanel = new JPanel();
        southPanel.setBackground(new java.awt.Color(196, 222, 110));
    
        close = new JButton("Close");
        close.setFont(new Font("Futura Bold", Font.PLAIN, 12));
        southPanel.add(close);
        close.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        this.add(budget, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
        
        this.setSize(450, 300);
        
        controller = new EventViewController(this, eventImg, name, location, entrance, availability, cost, close, player);
        eventImg.addMouseListener(controller);
        name.addMouseListener(controller);
        location.addMouseListener(controller);
        entrance.addMouseListener(controller);
        availability.addMouseListener(controller);
        cost.addMouseListener(controller);
        close.addActionListener(controller);
    }
}

