/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jillian
 */
public class SelectingMemberController implements MouseListener, ActionListener{
    private JFrame frame;
    private SelectingMemberDisplay memBox;
    private JLabel memLabel;
    private JButton view, select;
    private JLabel source, remaining;
    private Group group;
    private int memCount;
    
    public SelectingMemberController(JFrame f, String n, int c, JLabel r){
        this.frame = f;
        memCount = c;
        remaining = r;
    }
    
    public SelectingMemberController(SelectingMemberDisplay m, JLabel l, JButton v, JButton s){
        memBox = m;
        memLabel = l;
        view = v;
        select = s;
    }
    
    public void openDetails(Member m){
        // opens display window
        JFrame window = new MemberViewDisplay(m);
        window.setVisible(true);
        frame.dispose();
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        //changes formatting of clicked jlabel
        source = (JLabel)e.getSource();
        Member holder = Member.searchMember(source.getText());
        boolean isSelected = holder.getIsSelected();
        
        if(!isSelected){
            source.setFont(new Font("Futura Bold", Font.BOLD, 20));
            LineBorder line = new LineBorder(Color.black, 2, true);
            memBox.setBorder(line);
            view.setVisible(true);
            select.setVisible(true);
            holder.setIsSelected(true);
        } else {
            source.setFont(new Font("Futura Bold", Font.PLAIN, 20));
            memBox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
            view.setVisible(false);
            select.setVisible(false);
            holder.setIsSelected(false);
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        memBox.setBackground(new java.awt.Color(207, 233, 241));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        memBox.setBackground(new java.awt.Color(230, 244, 185));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view){
            Member m = Member.searchMember(source.getText());
            openDetails(m); 
        }
        if(e.getSource() == select){
            Member m = Member.searchMember(source.getText());
            // displays confirm dialog for user
            int input = JOptionPane.showConfirmDialog(null, 
            "Do you want to add this member to your group?", "Confirm selection",JOptionPane.YES_NO_OPTION);
            if(input == 0){
                try{
                    JFileChooser fileChooser = new JFileChooser();
                    FileNameExtensionFilter filter = new FileNameExtensionFilter("csv files", "csv");
                    fileChooser.setFileFilter(filter);
                    fileChooser.showOpenDialog(frame);
                    File selectedFile = fileChooser.getSelectedFile();

                    if(selectedFile != null){
                        System.out.println(selectedFile);
                        FileWriter writer = new FileWriter(selectedFile, true);
                        writer.append(m.getName());
                        writer.append(",");
                        writer.append(m.getImgFileName());
                        writer.append(",");
                        writer.append(m.getSkill());
                        writer.append(",");
                        writer.append(Integer.toString(m.getPopularityPoints()));
                        writer.append(",");
                        writer.append(Integer.toString(m.getRelationshipPoints()));
                        writer.append("\n");
                        writer.flush();
                        writer.close();
                    }
                    else{
                        JOptionPane.showMessageDialog(frame, "No file selected.", "No file selected", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                
                JOptionPane.showMessageDialog(frame, "Member added to your group!");
                
                /* commented out muna bc it results in an error :(
                memCount--;
                remaining.setText("[SLOTS LEFT: " + memCount + "]");*/
            }
        }    
    }
}
