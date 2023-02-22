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
public class ReservingEventDisplay extends JFrame {
    private JLabel budget, eventImg, name, location, entrance, availability, cost, question;
    private JButton yes, no;
    private JPanel southPanel, eastPanel;
    
    public ReservingEventDisplay(Event e){
        super("Get That Groove Back!");
        this.setLayout(new BorderLayout(10, 10));
        this.budget = new JLabel("Budget: ");
        this.eventImg = new JLabel();
        ImageIcon event = new ImageIcon(ReservingEventDisplay.class.getResource(e.getImgFileName()));
        eventImg.setIcon(event);
        this.name = new JLabel(e.getName());
        this.location = new JLabel(e.getLocation());
        this.entrance = new JLabel(String.valueOf(e.getEntranceFee()));
        this.availability = new JLabel(String.valueOf(e.getAvailability()));
        this.cost = new JLabel(String.valueOf(e.getCost()));
        this.eastPanel = new JPanel();
        eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.Y_AXIS));
        
        eastPanel.add(name);
        eastPanel.add(location);
        eastPanel.add(entrance);
        eastPanel.add(cost);
        eastPanel.add(availability);
        
        this.southPanel = new JPanel();
        
    
        southPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        
        this.question = new JLabel("Reserve this event?");
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        c.fill = GridBagConstraints.HORIZONTAL;
        
        southPanel.add(question, c);
        
        this.yes = new JButton("Yes");
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 1;
        southPanel.add(yes, c);
        
        this.no = new JButton("No");
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 1;
        southPanel.add(no, c);
        
        this.add(budget, BorderLayout.NORTH);
        this.add(eventImg, BorderLayout.CENTER);
        this.add(eastPanel, BorderLayout.EAST);
        this.add(southPanel, BorderLayout.SOUTH);
        
        this.setSize(900, 600);
    }
}
