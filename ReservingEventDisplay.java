/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

import javax.swing.*;
import java.awt.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author HP
 */
public class ReservingEventDisplay extends JFrame {
    private JLabel backgroundLabel, budget, eventImg, name, location, entrance, availability, cost, question;
    private JButton yes, no;
    private JPanel southPanel, centerPanel;
    
    public ReservingEventDisplay(Event e){
        super("Get That Groove Back!");
        this.setLayout(new BorderLayout(10, 10));
        this.getContentPane().setBackground(new java.awt.Color(207, 233, 241));
        
        
        this.budget = new JLabel("Budget: 700", SwingConstants.RIGHT);
        budget.setFont(new Font("Futura Bold", Font.PLAIN, 24));
        budget.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
       
        centerPanel = new JPanel();
        centerPanel.setBackground(new java.awt.Color(207, 233, 241));
        centerPanel.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.fill = GridBagConstraints.BOTH;
       
        
        eventImg = new JLabel();
        ImageIcon event = new ImageIcon(ReservingEventDisplay.class.getResource(e.getImgFileName()));
        Image eventImage = event.getImage();
        Image scaledEventImg = eventImage.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        event = new ImageIcon(scaledEventImg);
        eventImg.setIcon(event);
        con.gridwidth = 1;
        con.gridheight = 5;
        con.gridx = 0;
        con.gridy = 0;
        centerPanel.add(eventImg, con);
        
        name = new JLabel(e.getName());
        name.setFont(new Font("Futura Bold", Font.PLAIN, 40));
        con.gridwidth = 1;
        con.gridheight = 1;
        con.gridx = 1;
        con.gridy = 0;
        centerPanel.add(name, con);
        
        location = new JLabel("Location: " + e.getLocation());
        location.setFont(new Font("Futura Bold", Font.PLAIN, 30));
        con.gridwidth = 1;
        con.gridheight = 1;
        con.gridx = 1;
        con.gridy = 1;
        centerPanel.add(location, con);
        
        entrance = new JLabel("Entrance Fee: " + String.valueOf(e.getEntranceFee())); 
        entrance.setFont(new Font("Futura Bold", Font.PLAIN, 30));
        con.gridwidth = 1;
        con.gridheight = 1;
        con.gridx = 1;
        con.gridy = 2;
        centerPanel.add(entrance, con);
        
        cost = new JLabel("Cost: " + String.valueOf(e.getCost()));
        cost.setFont(new Font("Futura Bold", Font.PLAIN, 30));
        con.gridwidth = 1;
        con.gridheight = 1;
        con.gridx = 1;
        con.gridy = 3;
        centerPanel.add(cost, con);
        
        availability = new JLabel("Availability: " + String.valueOf(e.getAvailability()));
        availability.setFont(new Font("Futura Bold", Font.PLAIN, 30));
        con.gridwidth = 1;
        con.gridheight = 1;
        con.gridx = 1;
        con.gridy = 4;
        centerPanel.add(availability, con);
        
        southPanel = new JPanel();
        southPanel.setBackground(new java.awt.Color(196, 222, 110));
    
        southPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(3,3,3,3);
        question = new JLabel("Reserve this event?");
        question.setFont(new Font("Futura Bold", Font.PLAIN, 24));
        c.gridwidth = 4;
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        
        southPanel.add(question, c);
        
        yes = new JButton("Yes");
        yes.setFont(new Font("Futura Bold", Font.PLAIN, 20));
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;
        southPanel.add(yes, c);
        
        no = new JButton("No");
        no.setFont(new Font("Futura Bold", Font.PLAIN, 20));
        c.gridwidth = 1;
        c.gridx = 3;
        c.gridy = 1;
        southPanel.add(no, c);
        
        this.add(budget, BorderLayout.NORTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
        
        this.setSize(900, 600);
    }
}
