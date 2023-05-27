/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author Jillian
 */
public class CollaborateGroupController implements MouseListener, ActionListener {
    private JFrame frame;
    private CollaborateGroupPartyDisplay frameBox;
    private JLabel memLabel;
    private JButton view, collaborate, back;
    private JLabel source, budgetText;
    private Manager player;
    private double budget, cost;
    private Group[] collabParty;
    
    public CollaborateGroupController(JFrame f, JButton b, JLabel m, Manager p, Group[] c){
        this.frame = f;
        back = b;
        budgetText = m;
        player = p;
        collabParty = c;
    }
    
    public CollaborateGroupController(JLabel l, JButton v, JButton c, Manager p, JLabel bt, CollaborateGroupPartyDisplay f, Group[] cp){
        memLabel = l;
        view = v;
        collaborate = c;
        player = p;
        budgetText = bt;
        budget = player.getBudget();
        frameBox = f;
        collabParty = cp;
    }
    
     public void openDetails(Group g){
        // opens display window
        JFrame window = new CollaborateGroupViewDisplay(g, player);
        window.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //changes formatting of clicked jlabel
        source = (JLabel)e.getSource();
        Group holder = Group.searchGroup(source.getText());
        boolean isSelected = holder.getIsSelected();
        
        if(!isSelected){
            source.setFont(new Font("Futura Bold", Font.BOLD, 20));
            view.setVisible(true);
            collaborate.setVisible(true);
            holder.setIsSelected(true);
        } else{
            source.setFont(new Font("Futura Bold", Font.PLAIN, 20));
            view.setVisible(false);
            collaborate.setVisible(false);
            holder.setIsSelected(false);
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
     
    }
    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view){
            Group g = Group.searchGroup(source.getText());
            openDetails(g);
        }
        if(e.getSource() == collaborate){
            Group g = Group.searchGroup(source.getText());
            Group holder = Group.searchOwnGroup(Group.getOwnName());
            
            budget = player.getBudget();
            cost = g.getCost();
            if(budget >= cost){
                if(player.arrangeCollab(frame, holder, g)){
                    budget -= cost;
                    JOptionPane.showMessageDialog(frame, "The collab was a blast! " + "Budget: " + budget);
                    budgetText.setText("Budget: " + budget);
                    
                    int random = (int) Math.floor(Math.random()*500) + 1;
                    Group.addOwnPopularityPoints(random);

                    int fans = random / 2;
                    Group.addOwnNoOfFans(fans);

                    player = new Manager("player", "placeholder.png", budget);
                    frameBox.dispose();
                    JFrame window = new CollaborateGroupPartyDisplay(collabParty, player);
                    window.setVisible(true);
                }
            }
            else{
                player = new Manager("player", "placeholder.png", budget); 
                JOptionPane.showMessageDialog(frame, "Oh no! You don't have enough money to collaborate with this group!");
            }
            
            if(Group.getOwnPopularityPoints() >= 5000 && player.getBudget() >= 3000){
                if(!Group.getConcertStatus()){
                    Group.setConcertStatus(true);
                    JOptionPane.showMessageDialog(frame, "Congratulations Congratulations! " + Group.getOwnName() + " is ready hold"
                          + " their own concert!");
                    int result = JOptionPane.showConfirmDialog(null, "Do you wish to keep playing?");
                    switch (result) {
                       case JOptionPane.YES_OPTION:
                       break;
                       case JOptionPane.NO_OPTION:
                       System.exit(0);
                       break;
                       case JOptionPane.CANCEL_OPTION:
                       break;
                       case JOptionPane.CLOSED_OPTION:
                       break;
                    }
                }
            }
        }
        if(e.getSource() == back){
            frame.dispose();
            JFrame window = new MainMenuDisplay(player);
            window.setVisible(true);
        }
    }
           
}