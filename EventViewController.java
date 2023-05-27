/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.swing.*;
import javax.swing.border.LineBorder;
/**
 *
 * @author Jillian
 */
public class EventViewController implements ActionListener, MouseListener {
    private JFrame frame;
    private JLabel eventImage, eventName, location, entrance, availability, cost;
    private JButton close;
    private Color ogColor = new java.awt.Color(207, 233, 241);
    private Color newColor = new java.awt.Color(176, 202, 241);
    private Manager player;
    
    public EventViewController(JFrame m, JLabel img, JLabel n, JLabel l, JLabel e, JLabel a, JLabel c, JButton o, Manager p){
        frame = m;
        eventImage = img;
        eventName = n;
        location = l;
        entrance = e;
        availability = a;
        cost = c;
        close = o;
        player = p;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == close){
            frame.dispose();
        }
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel source = (JLabel)e.getSource();
        Font f = source.getFont();
        if(f.isPlain()){
            if(e.getSource() == eventName){
                eventName.setFont(new Font("Futura Bold", Font.BOLD, 16));
            }
            if(e.getSource() == location){
                location.setFont(new Font("Futura Bold", Font.BOLD, 12));
            }
            if(e.getSource() == entrance){
                entrance.setFont(new Font("Futura Bold", Font.BOLD, 12));
            }
            if(e.getSource() == availability){
                availability.setFont(new Font("Futura Bold", Font.BOLD, 12));
            }
            if(e.getSource() == cost){
                cost.setFont(new Font("Futura Bold", Font.BOLD, 12));
            }
        } else {
            if(e.getSource() == eventName){
                eventName.setFont(new Font("Futura Bold", Font.PLAIN, 16));
            }
            if(e.getSource() == location){
                location.setFont(new Font("Futura Bold", Font.PLAIN, 12));
            }
            if(e.getSource() == entrance){
                entrance.setFont(new Font("Futura Bold", Font.PLAIN, 12));
            }
            if(e.getSource() == availability){
                availability.setFont(new Font("Futura Bold", Font.PLAIN, 12));
            }
            if(e.getSource() == cost){
                cost.setFont(new Font("Futura Bold", Font.PLAIN, 12));
            }
        }
    }
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}
    @Override
    public void mouseEntered(MouseEvent e) {
        eventImage.setBackground(newColor);
        eventImage.setOpaque(true);
    }
    @Override
    public void mouseExited(MouseEvent e) {
        eventImage.setBackground(ogColor);
        eventImage.setOpaque(true);
    }
}
