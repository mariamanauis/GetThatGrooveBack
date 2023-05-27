/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

import java.awt.event.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.*;
import java.io.*;
/**
 *
 * @author Jillian
 */
public class MainMenuController implements ActionListener {
    private JFrame frame;
    private JButton collaborate, groupView, booking, practice;
    private Manager player;
    private Event[] eventParty;
    private Group[] collabParty;

    public MainMenuController(JFrame f, JButton c, JButton g, JButton b, JButton p, Manager m){
        this.frame = f;
        collaborate = c;
        groupView = g;
        booking = b;
        practice = p;
        player = m;
    }
    
    @Override
    public void actionPerformed(ActionEvent e)  {
        if(e.getSource() == collaborate){
            Group[] collabParty = new Group[6];
            try{
                int counter = 0;
                InputStream is = MainMenuController.class.getClassLoader().getResourceAsStream("getthatgrooveback/collab_groups.csv");
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(isr);

                String line;

                while ((line = reader.readLine()) != null && counter < 6) {
                    String[] details = line.split(",");
                    collabParty[counter] = new Group(details[0], details[1], Integer.parseInt(details[2]), Double.parseDouble(details[3]));
                    counter++;
            }

            reader.close();
            }catch(IOException t){}
            JFrame window = new CollaborateGroupPartyDisplay(collabParty, player);
            window.setVisible(true);
            frame.dispose();
        }
        if(e.getSource() == groupView){
            JFrame window = new GroupProfileDisplay(player);
            window.setVisible(true);
            frame.dispose();
        }
        if(e.getSource() == booking){
            Event[] eventParty = new Event[6];
            try{
                int counter = 0;
                InputStream is = MainMenuController.class.getClassLoader().getResourceAsStream("getthatgrooveback/events.csv");
                InputStreamReader isr = new InputStreamReader(is);
                BufferedReader reader = new BufferedReader(isr);

                String line;

                while ((line = reader.readLine()) != null && counter < 6) {
                    String[] details = line.split(",");
                    eventParty[counter] = new Event(details[0], details[1], Double.parseDouble(details[2]), details[3], Double.parseDouble(details[4]), Boolean.parseBoolean(details[5]));
                    counter++;
            }

            reader.close();
            }catch(IOException t){}
            JFrame window = new ReservingEventPartyDisplay(eventParty, player);
            window.setVisible(true);
            frame.dispose();
        }
        if(e.getSource() == practice){
            JFrame window = new PracticeDisplay(player);
            window.setVisible(true);
            frame.dispose();
        }
    }
    
}
