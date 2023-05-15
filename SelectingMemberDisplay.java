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
public class SelectingMemberDisplay extends JPanel{
    private JLabel memberName;
    private JButton view, select;
    private SelectingMemberController controller;
    private JPanel button;
   
    public SelectingMemberDisplay(Member m){
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
        
        controller = new SelectingMemberController(this, memberName, view, select);
        memberName.addMouseListener(controller);
        view.addActionListener(controller);
        select.addActionListener(controller);
    
    }
}