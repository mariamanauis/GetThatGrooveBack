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
    private JLabel footer, remaining;
    private JPanel southPanel, main;
    private static int maxCols = 3;
    private static int maxRows = 2;
    
    public MemberPartyDisplay(Member[] party){
        super("Get That Groove Back!");
        footer = new JLabel("Choose Your Artists!");
        remaining = new JLabel("[SLOTS LEFT: 3]");
        southPanel = new JPanel();
        main = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300*maxCols, 300*maxRows);
        this.setLayout(new BorderLayout(10, 10));
        this.add(southPanel, BorderLayout.SOUTH);
        this.add(main, BorderLayout.CENTER);

        southPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
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
