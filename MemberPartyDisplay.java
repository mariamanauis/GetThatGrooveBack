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
public class MemberPartyDisplay extends JFrame {
    private JLabel backgroundLabel, footer, remaining;
    private JPanel southPanel, main;
    private static int maxCols = 3;
    private static int maxRows = 2;
    
    public MemberPartyDisplay(Member[] party){
        super("Get That Groove Back!");
        this.getContentPane().setBackground(new java.awt.Color(230, 244, 185));       
        footer = new JLabel("Choose Your Artists!");
        footer.setAlignmentX(Component.CENTER_ALIGNMENT);
        footer.setFont(new Font("Futura Bold", Font.PLAIN, 24));
        footer.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        remaining = new JLabel("[SLOTS LEFT: 3]");
        remaining.setAlignmentX(Component.CENTER_ALIGNMENT);
        remaining.setFont(new Font("Futura Bold", Font.PLAIN, 24));
        remaining.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        southPanel = new JPanel();
        main = new JPanel();
        
        main.setBackground(new java.awt.Color(230, 244, 185));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300*maxCols, 300*maxRows);
        this.setLayout(new BorderLayout(10, 10));
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(main, BorderLayout.CENTER);

        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        southPanel.setBackground(new java.awt.Color(207, 233, 241));
        //we used a boxLayout (was decided after mockup was submitted) to align the JLabels
        southPanel.add(footer);
        southPanel.add(remaining);

        GridLayout grid = new GridLayout(maxRows, maxCols);
        main.setLayout(grid);

        for(Member m : party){
            MemberDisplay display = new MemberDisplay(m);
            main.add(display);
        }
    }
    
}
