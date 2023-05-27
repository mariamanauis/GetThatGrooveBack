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
public class MenuDisplay extends JFrame {
    private JButton play, exit;
    private JPanel southPanel, main;
    private JLabel logo;
    private MenuController controller;
    private Manager player;
    
    public MenuDisplay(Manager m){
        super("Get That Groove Back!");
        this.getContentPane().setBackground(new java.awt.Color(230, 244, 185));
        this.setLayout(new BorderLayout());
        
        player = m;
        
        main = new JPanel();
        logo =  new JLabel();
        ImageIcon img = new ImageIcon(MainDialogueDisplay.class.getResource("imgs/maria_jill.png"));Image memImg = img.getImage();
        Image scaledMemImg = memImg.getScaledInstance(800, 500, Image.SCALE_SMOOTH);
        img = new ImageIcon(scaledMemImg);
        logo.setIcon(img);
        main.add(logo);
        
        southPanel = new JPanel();
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.X_AXIS));
        
        play = new JButton("PLAY");
        play.setFont(new Font("Futura Bold", Font.PLAIN, 24));
        play.setSize(100, 50);
        play.setMargin(new Insets(10, 10, 10, 10));
        exit = new JButton("EXIT");
        exit.setMargin(new Insets(10, 10, 10, 10));
        exit.setSize(100, 50);
        exit.setFont(new Font("Futura Bold", Font.PLAIN, 24));
        southPanel.add(play);
        southPanel.add(exit);
        
        this.setSize(900, 600);
        this.add(main, BorderLayout.CENTER);
        this.add(southPanel, BorderLayout.SOUTH);
        
        controller = new MenuController(this, play, exit, player);
        play.addActionListener(controller);
        exit.addActionListener(controller);
    }
}
