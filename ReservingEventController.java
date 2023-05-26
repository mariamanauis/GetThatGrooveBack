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
 * @author HP
 */
public class ReservingEventController implements MouseListener, ActionListener{
    private JFrame frame;
    private ReservingEventPartyDisplay frameBox;
    private JLabel eventLabel;
    private JButton view, reserve, back;
    private JLabel source, budgetText;
    private Manager player;
    private double budget, cost;
    private Event[] eventParty;
    
    
    public ReservingEventController(JFrame f, JButton b, JLabel n, Manager m, Event[] p){
        this.frame = f;
        back = b;
        budgetText = n;
        player = m;
        eventParty = p;
    }
    
    public ReservingEventController(JLabel l, JButton v, JButton r, Manager m, JLabel bt, ReservingEventPartyDisplay f, Event[] p){
        this.eventLabel = l;
        this.view = v;
        this.reserve = r;
        this.player = m;
        budget = player.getBudget();
        budgetText = bt;
        frameBox = f;
        eventParty = p;
    }
    
    public void openDetails(Event e){
        // opens display window
        JFrame window = new EventViewDisplay(e, player);
        window.setVisible(true);
    }

   
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == view){
            Event n = Event.searchEvent(source.getText());
            openDetails(n); 
        }
        if(e.getSource() == reserve){
            Event n = Event.searchEvent(source.getText());
            cost = n.getCost();
            if(budget >= cost){
               budget -= cost;
               JOptionPane.showMessageDialog(frame, "The event was a blast! " + "Budget: " + budget);
               budgetText.setText("Budget: " + budget);
               
               int random = (int) Math.floor(Math.random()*500) + 1;
               int pop = (int) (random - (cost / 4));
               Group.addOwnPopularityPoints(pop);
               
               int fans = pop / 2;
               Group.addOwnNoOfFans(fans);
               
               player = new Manager("player", "placeholder.png", budget);
               frameBox.dispose();
               JFrame window = new ReservingEventPartyDisplay(eventParty, player);
               window.setVisible(true);
               
            }
            else{
                player = new Manager("player", "placeholder.png", budget); 
                JOptionPane.showMessageDialog(frame, "Oh no! You don't have enough money to book this event!");
            }
        }
        if(e.getSource() == back){
            frame.dispose();
            JFrame window = new MainMenuDisplay(player);
            window.setVisible(true);
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        //changes formatting of clicked jlabel
        source = (JLabel)e.getSource();
        Event holder = Event.searchEvent(source.getText());
        boolean isSelected = holder.getIsSelected();
        
        if(!isSelected){
            source.setFont(new Font("Futura Bold", Font.BOLD, 20));
            view.setVisible(true);
            reserve.setVisible(true);
            holder.setIsSelected(true);
        } else{
            source.setFont(new Font("Futura Bold", Font.PLAIN, 20));
            view.setVisible(false);
            reserve.setVisible(false);
            holder.setIsSelected(false);
        }
    }
    
    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) { 
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
