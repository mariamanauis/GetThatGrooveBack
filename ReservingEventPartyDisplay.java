/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
/**
 *
 * @author HP
 */
public class ReservingEventPartyDisplay extends JFrame{
    private JLabel header, budget;
    private JPanel northPanel, main, southPanel;
    private JButton back;
    private static int maxCols = 3;
    private static int maxRows = 2;
    private ReservingEventController controller;
    private Manager player;
    private Event[] eventParty;
    
    public ReservingEventPartyDisplay(Event[] party, Manager m){
        super("Get That Groove Back!");
        
        player = m;
        eventParty = party;
        
        northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        southPanel = new JPanel();
        main = new JPanel();
        this.getContentPane().setBackground(new java.awt.Color(230, 244, 185)); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300*maxCols, 300*maxRows);
        this.setLayout(new BorderLayout(10, 10));
        this.add(northPanel, BorderLayout.NORTH);
        this.add(main, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);

        budget = new JLabel("Budget: " + player.getBudget());
        budget.setAlignmentX(Component.CENTER_ALIGNMENT);
        budget.setFont(new Font("Futura Bold", Font.PLAIN, 24));
        budget.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        northPanel.add(budget);
        
        header = new JLabel("Select an event to book");
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        header.setFont(new Font("Futura Bold", Font.PLAIN, 24));
        header.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        northPanel.add(header);
        northPanel.setBackground(new java.awt.Color(207, 233, 241));
        
        GridLayout grid = new GridLayout(maxRows, maxCols);
        main.setLayout(grid);

        for(Event e : eventParty){
            ReservingEventDisplay display = new ReservingEventDisplay(e, player, eventParty);
            main.add(display);
        }
        
        back = new JButton("Back");
        back.setFont(new Font("Futura Bold", Font.PLAIN, 24));
        southPanel.add(back);
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        southPanel.setBackground(new java.awt.Color(207, 233, 241));
        
        controller = new ReservingEventController(this, back, budget, player, eventParty);
        back.addActionListener(controller);
    }
    
    
    public class ReservingEventDisplay extends JPanel {
        private JLabel eventName, budgetText;
        private JButton view, reserve;
        private JPanel button;
        private ReservingEventController controller;
        private Manager player;
        private ReservingEventPartyDisplay frame;
        private Event[] eventParty;
        
        public ReservingEventDisplay(Event e, Manager m, Event[] party){
            eventParty = party;
            frame = ReservingEventPartyDisplay.this;
            budgetText = ReservingEventPartyDisplay.this.budget;
            player = m;
            this.setBackground(new java.awt.Color(230, 244, 185));
            this.eventName = new JLabel(e.getName());
            eventName.setFont(new Font("Futura Bold", Font.PLAIN, 20));
            this.eventName.setHorizontalTextPosition(JLabel.CENTER);
            this.eventName.setVerticalTextPosition(JLabel.BOTTOM);
            ImageIcon img = new ImageIcon(getClass().getResource(
                "imgs/" + e.getImgFileName()));
            Image eventImg = img.getImage();
            Image scaledEventImg = eventImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            img = new ImageIcon(scaledEventImg);
            eventName.setIcon(img);

            view = new JButton("View");
            reserve = new JButton("Reserve");

            eventName.add(view);

            this.setLayout(new GridBagLayout());
            GridBagConstraints con = new GridBagConstraints();
            con.gridx = 0;
            con.gridy = 0;
            con.insets = new Insets(5,5,5,5);
            this.add(eventName, con);

            button = new JPanel();
            button.setBackground(new java.awt.Color(230, 244, 185));
            GroupLayout layout = new GroupLayout(button);
            button.setLayout(layout);
            layout.setAutoCreateGaps(true);
            layout.setAutoCreateContainerGaps(true);
            layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(LEADING)
                    .addComponent(view)
                    .addComponent(reserve))
            );
            layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(BASELINE)
                    .addComponent(view))
                .addGroup(layout.createParallelGroup(LEADING)
                    .addComponent(reserve))
            );
            this.add(button);
            view.setVisible(false);
            reserve.setVisible(false);
            
            controller = new ReservingEventController(eventName, view, reserve, player, budgetText, frame, eventParty);
           
            this.addMouseListener(controller);
            eventName.addMouseListener(controller);
            view.addActionListener(controller);
            reserve.addActionListener(controller);
        }
    }
}
