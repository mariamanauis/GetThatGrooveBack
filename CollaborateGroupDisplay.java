/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

import javax.swing.*;
import java.awt.*;
import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.Alignment.LEADING;
/**
 *
 * @author HP
 */
public class CollaborateGroupDisplay extends JPanel {
    private JLabel groupName;
    private JButton viewGroup;
    private JPanel button;
    
    public CollaborateGroupDisplay(Group g, int index){
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
                .addComponent(viewGroup))
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(BASELINE)
                .addComponent(viewGroup))
        );
        this.add(button);
        viewGroup.setVisible(false);
        
        //controllers here
        //groupName.addMouseListener(controller);
        //viewGroup.addActionListener(controller);
    
    }
}
