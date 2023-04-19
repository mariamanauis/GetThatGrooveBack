 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

/**
 *
 * @author HP
 */

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CollaborateGroupPartyDisplay extends JFrame {
    private JLabel header;
    private JPanel northPanel, main;
    private JButton viewGroup;
    private static int maxCols = 3;
    private static int maxRows = 2;
    private ArrayList<String> groupList = new ArrayList();
    private int index = 0;
    private CollaborateGroupController controller;
    
    public CollaborateGroupPartyDisplay(Group[] party){
        super("Get That Groove Back!");
        this.getContentPane().setBackground(new java.awt.Color(255,222,166));
        header = new JLabel("Select a Group to Collaborate With:");
        header.setAlignmentX(Component.CENTER_ALIGNMENT);
        header.setFont(new Font("Futura Bold", Font.PLAIN, 24));
        header.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        
        northPanel = new JPanel();
        main = new JPanel();
        
        main.setBackground(new java.awt.Color(255,222,166));
        northPanel.setBackground(new java.awt.Color(248,196,172));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300*maxCols, 300*maxRows);
        this.setLayout(new BorderLayout(10, 10));
        this.add(northPanel, BorderLayout.NORTH);
        this.add(main, BorderLayout.CENTER);
        
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(header);
        
        GridLayout grid = new GridLayout(maxRows, maxCols);
        main.setLayout(grid);
        
        for(Group g : party){
            if(index > 0) index++;
            CollaborateGroupDisplay display = new CollaborateGroupDisplay(g, index);
            main.add(display);
            groupList.add(g.getName());
        }
        
        controller = new CollaborateGroupController(this);
        
    }
}
