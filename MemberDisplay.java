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
public class MemberDisplay extends JPanel{
    private JLabel memberName;
    
    
    public MemberDisplay(Member m){
        this.memberName = new JLabel(m.getName());
        this.memberName.setHorizontalTextPosition(JLabel.CENTER);
        this.memberName.setVerticalTextPosition(JLabel.BOTTOM);
        ImageIcon img = new ImageIcon(MemberDisplay.class.getResource(
            m.getImgFileName()));
        memberName.setIcon(img);
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.gridx = 0;
        con.gridy = 0;
        con.insets = new Insets(5,5,5,5);
        this.add(memberName, con);
        
        
    }
}
