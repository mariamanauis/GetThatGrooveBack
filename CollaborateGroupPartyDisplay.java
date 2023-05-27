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

public class CollaborateGroupPartyDisplay extends JFrame {
    private JLabel header, budget;
    private JPanel northPanel, main, southPanel;
    private JButton back;
    private static int maxCols = 3;
    private static int maxRows = 2;
    private int index = 0;
    private CollaborateGroupController controller;
    private Manager player;
    private Group[] collabParty;
    
    public CollaborateGroupPartyDisplay(Group[] party, Manager p){
        super("Get That Groove Back!");
        this.getContentPane().setBackground(new java.awt.Color(255,222,166));
        
        player = p;
        collabParty = party;
        
        northPanel = new JPanel();
        main = new JPanel();
        southPanel = new JPanel();
        
        budget = new JLabel("Budget: " + player.getBudget());
        budget.setAlignmentX(Component.CENTER_ALIGNMENT);
        budget.setFont(new Font("Futura Bold", Font.PLAIN, 24));
        budget.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        northPanel.add(budget);
        
        header = new JLabel("Select a group to collaborate with");
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        header.setFont(new Font("Futura Bold", Font.PLAIN, 24));
        header.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        northPanel.add(header);
        
        main.setBackground(new java.awt.Color(255,222,166));
        northPanel.setBackground(new java.awt.Color(248,196,172));
        southPanel.setBackground(new java.awt.Color(248,196,172));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300*maxCols, 300*maxRows);
        this.setLayout(new BorderLayout(10, 10));
        this.add(northPanel, BorderLayout.NORTH);
        this.add(main, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
        
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(header);
        
        GridLayout grid = new GridLayout(maxRows, maxCols);
        main.setLayout(grid);
        
        for(Group g : party){
            if(index > 0) index++;
            CollaborateGroupDisplay display = new CollaborateGroupDisplay(g, player, collabParty);
            main.add(display);
        }
        
        back = new JButton("Back");
        back.setFont(new Font("Futura Bold", Font.PLAIN, 24));
        southPanel.add(back);
        back.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        controller = new CollaborateGroupController(this, back, budget, player, collabParty);
        back.addActionListener(controller);
    }
    public class CollaborateGroupDisplay extends JPanel {
    private JLabel groupName, budgetText;
    private JButton viewGroup, collaborate;
    private JPanel button;
    private CollaborateGroupController controller;
    private Manager player;
    private CollaborateGroupPartyDisplay frame;
    private Group[] collabParty;
    
    public CollaborateGroupDisplay(Group g, Manager p, Group[] party){
        collabParty = party;
        frame = CollaborateGroupPartyDisplay.this;
        budgetText = CollaborateGroupPartyDisplay.this.budget;
        player = p;
        this.setBackground(new java.awt.Color(255,222,166));
        this.groupName = new JLabel(g.getName());
        groupName.setFont(new Font("Futura Bold", Font.PLAIN, 20));
        groupName.setHorizontalTextPosition(JLabel.CENTER);
        groupName.setVerticalTextPosition(JLabel.BOTTOM);
        ImageIcon img = new ImageIcon(CollaborateGroupDisplay.class.getResource("imgs/" + g.getImgFileName()));
        Image groupImg = img.getImage();
        Image scaledGroupImg = groupImg.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        img = new ImageIcon(scaledGroupImg);
        groupName.setIcon(img);
        
        viewGroup = new JButton("View Group");
        collaborate = new JButton("Collaborate");
        
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 0;
        con.insets = new Insets(5,5,5,5);
        this.add(groupName, con);
        
        button = new JPanel();
        button.setBackground(new java.awt.Color(255,222,166));
        GroupLayout layout = new GroupLayout(button);
        button.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(LEADING)
                .addComponent(viewGroup)
                .addComponent(collaborate))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(BASELINE)
                .addComponent(viewGroup))
            .addGroup(layout.createParallelGroup(LEADING)
                .addComponent(collaborate))
        );
        this.add(button);
        viewGroup.setVisible(false);
        collaborate.setVisible(false);
        
        controller = new CollaborateGroupController(groupName, viewGroup, collaborate, player, budgetText, frame, collabParty);
        groupName.addMouseListener(controller);
        viewGroup.addActionListener(controller);
        collaborate.addActionListener(controller);
    
    }
}
}