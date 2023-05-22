/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author Jillian
 */
public class MainDialogueDisplay extends JFrame {
    private JButton next;
    private JLabel image, dialogue;
    private JPanel southPanel, centerPanel;
    private MainDialogueController controller;
    
    public MainDialogueDisplay(){
        super("Get That Groove Back!");
        this.getContentPane().setBackground(new java.awt.Color(230, 244, 185));
        
        centerPanel = new JPanel();
        centerPanel.setBackground(new java.awt.Color(230, 244, 185));
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.X_AXIS));
        
        image =  new JLabel();
        ImageIcon img = new ImageIcon(MainDialogueDisplay.class.getResource("imgs/maria_jill.png"));Image memImg = img.getImage();
        Image scaledMemImg = memImg.getScaledInstance(800, 500, Image.SCALE_SMOOTH);
        img = new ImageIcon(scaledMemImg);
        image.setIcon(img);
        centerPanel.add(image);
        
        southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
        southPanel.setBackground(new java.awt.Color(164, 255, 222));
        next = new JButton("Next");
        
        dialogue = new JLabel("Welcome to JMP Entertainment!");
        dialogue.setSize(500, 500);
        
        southPanel.add(dialogue);
        southPanel.add(next);
        
        
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(centerPanel, BorderLayout.CENTER);
        this.setSize(900, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        controller = new MainDialogueController(this, next, dialogue);
        next.addActionListener(controller);
    }
}
