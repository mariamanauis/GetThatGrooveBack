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
public class SelectingMemberPartyDisplay extends JFrame {
    private JLabel footer, remaining;
    private JPanel southPanel, main;
    private static int maxCols = 3;
    private static int maxRows = 2;
    private int memCount;
    private SelectingMemberController controller;
    
    private JLabel memberName;
    private JButton view, select;
    private JPanel button;
    
    public SelectingMemberPartyDisplay(String grpName, int c, Member[] party){
        super("Get That Groove Back!");
        this.getContentPane().setBackground(new java.awt.Color(230, 244, 185));       
        footer = new JLabel("Choose Your Artists!");
        footer.setAlignmentX(Component.CENTER_ALIGNMENT);
        footer.setFont(new Font("Futura Bold", Font.PLAIN, 24));
        footer.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        remaining = new JLabel("[SLOTS LEFT: " + c + "]");
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
        
        memCount = c;

        for(Member m : party){
            SelectingMemberDisplay display = new SelectingMemberDisplay(m);
            main.add(display);
        }
        
        controller = new SelectingMemberController(this, grpName);
    }
    public class SelectingMemberDisplay extends JPanel{
    private JLabel memberName, remainingText;
    private JButton view, select;
    private SelectingMemberController controller;
    private JPanel button;
    private SelectingMemberPartyDisplay frame;
    private int memCounter;
   
    public SelectingMemberDisplay(Member m){
        frame = SelectingMemberPartyDisplay.this;
        remainingText = SelectingMemberPartyDisplay.this.remaining;
        memCounter = SelectingMemberPartyDisplay.this.memCount;
        this.setBackground(new java.awt.Color(230, 244, 185));
        this.memberName = new JLabel(m.getName());
        memberName.setFont(new Font("Futura Bold", Font.PLAIN, 20));
        this.memberName.setHorizontalTextPosition(JLabel.CENTER);
        this.memberName.setVerticalTextPosition(JLabel.BOTTOM);
        ImageIcon img = new ImageIcon(SelectingMemberDisplay.class.getResource(
            "imgs/" + m.getImgFileName()));
        Image memImg = img.getImage();
        Image scaledMemImg = memImg.getScaledInstance(108, 192, Image.SCALE_SMOOTH);
        img = new ImageIcon(scaledMemImg);
        memberName.setIcon(img);
        
        view = new JButton("View");
        select = new JButton("Select");
        
        memberName.add(view);
        memberName.add(select);
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 0;
        con.insets = new Insets(5,5,5,5);
        this.add(memberName, con);
        
        button = new JPanel();
        button.setBackground(new java.awt.Color(230, 244, 185));
        GroupLayout layout = new GroupLayout(button);
        button.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(LEADING)
                .addComponent(view)
                .addComponent(select))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(BASELINE)
                .addComponent(view))
            .addGroup(layout.createParallelGroup(LEADING)
                .addComponent(select))
        );
        this.add(button);
        view.setVisible(false);
        select.setVisible(false);
        
        controller = new SelectingMemberController(memberName, view, select, remainingText, frame, memCounter);
        memberName.addMouseListener(controller);
        view.addActionListener(controller);
        select.addActionListener(controller);
    
    }
}
}
