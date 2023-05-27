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
public class MenuController implements ActionListener, MouseListener{
    private JFrame frame;
    private JButton play, exit;
    private boolean hasBeenPlayed = false;
    private Manager player;

    public MenuController(JFrame f, JButton p, JButton e, Manager m){
        this.frame = f;
        play = p;
        exit = e;
        player = m;
    }
    
    public void setHasBeenPlayed(boolean b){
        hasBeenPlayed = b;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == play){
            if(!hasBeenPlayed){
                JFrame window = new MainDialogueDisplay(player);
                window.setVisible(true);
                frame.dispose();
            } else{
                JFrame window = new MainMenuDisplay(player);
                window.setVisible(true);
                frame.dispose();
            }
        }
        if(e.getSource() == exit){
            System.exit(0);
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
    
}
