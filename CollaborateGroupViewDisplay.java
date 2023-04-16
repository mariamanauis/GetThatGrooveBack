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
    private JButton yes, no;
    private JPanel southPanel, main;
    
    public CollaborateGroupViewDisplay(Group g){
        super("Get That Groove Back!");
        this.setLayout(new BorderLayout(10, 10));
        this.getContentPane().setBackground(new java.awt.Color(255,222,166));
        
        this.budget = new JLabel("Budget: 700", SwingConstants.RIGHT);
        budget.setFont(new Font("Futura Bold", Font.PLAIN, 24));
        budget.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        main = new JPanel();
        main.setBackground(new java.awt.Color(255,222,166));
        main.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.fill = GridBagConstraints.BOTH;
        
        groupImg = new JLabel();
        ImageIcon group = new ImageIcon(CollaborateGroupViewDisplay.class.getResource("imgs/" + g.getImgFileName()));
        Image groupImage = group.getImage();
        Image scaledGroupImg = groupImage.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        group = new ImageIcon(scaledGroupImg);
        groupImg.setIcon(group);
        con.gridwidth = 1;
        con.gridheight = 4;
        con.gridx = 0;
        con.gridy = 0;
        main.add(groupImg, con);
        
        name = new JLabel(g.getName());
        name.setFont(new Font("Futura Bold", Font.PLAIN, 40));
        con.gridwidth = 1;
        con.gridheight = 1;
        con.gridx = 1;
        con.gridy = 0;
        main.add(name, con);
        
        popularity = new JLabel("Popularity: " + String.valueOf(g.getPopularityPoints()));
        popularity.setFont(new Font("Futura Bold", Font.PLAIN, 30));
        con.gridwidth = 1;
        con.gridheight = 1;
        con.gridx = 1;
        con.gridy = 2;
        main.add(popularity, con);
        
        cost = new JLabel("Cost: " + String.valueOf(g.getCost()));
        cost.setFont(new Font("Futura Bold", Font.PLAIN, 30));
        con.gridwidth = 1;
        con.gridheight = 1;
        con.gridx = 1;
        con.gridy = 3;
        main.add(cost, con);
        
        
        southPanel = new JPanel();
        southPanel.setBackground(new java.awt.Color(248,196,172));
        
        southPanel.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(3,3,3,3);
        question = new JLabel("Collaborate with this group?");
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
        this.add(main, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
    }
    
}
