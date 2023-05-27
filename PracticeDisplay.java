/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

/**
 *
 * @author HP
 * shout out to all the websites and youtube videos about card matching games
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;
import java.io.*;

public class PracticeDisplay extends JFrame implements ActionListener, MouseListener{
    private JPanel main, southPanel, northPanel;
    private JLabel scoreText, title;
    private int status, score, noOfMatches;
    private double moneyEarned, budget;
    private Card[] cards = new Card[16];
    private ImageIcon[] icons = new ImageIcon[8];
    private Card flipped1, flipped2;
    private boolean won;
    public Manager player;
    
    public PracticeDisplay(Manager m){
        super("Get That Groove Back!");
        initializeComponents();
        initializeIcons();
        initializeGame();
        
        player = m;
    }
    
    public void initializeComponents(){
        this.setSize(900, 600);
        main = new JPanel();
        southPanel = new JPanel();
        northPanel = new JPanel();
        this.setLayout(new BorderLayout());
        this.add(main, BorderLayout.CENTER);
        this.add(northPanel, BorderLayout.NORTH);
        this.add(southPanel, BorderLayout.SOUTH);
        
        scoreText = new JLabel("Score: " + score);
        scoreText.setFont(new Font("Futura Bold", Font.PLAIN, 30));
        scoreText.setAlignmentX(Component.CENTER_ALIGNMENT);
        scoreText.addMouseListener(this);
        
        title = new JLabel("Get Your Groove On! Match the Tiles!", SwingConstants.CENTER);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Futura Bold", Font.PLAIN, 30));
        title.setBorder(BorderFactory.createEmptyBorder(3, 3, 3, 3));
        title.addMouseListener(this);
        
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));
        northPanel.add(title);
        northPanel.setBackground(new java.awt.Color(248,196,172));
        
        southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.Y_AXIS));
        southPanel.add(scoreText);
        southPanel.setBackground(new java.awt.Color(248,196,172));
        southPanel.addMouseListener(this);
        
        main.setBackground(new java.awt.Color(255,222,166));
        GridLayout grid = new GridLayout(4, 6);
        main.setLayout(grid);
        main.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }
    
    public void initializeIcons(){
        Image img;
        for (int i = 0; i < icons.length; i++) {
            img = new ImageIcon(getClass().getResource("imgs/img" + i + ".png")).getImage();
            ImageIcon actualImage = new ImageIcon(img);
            Image toScaleImage = actualImage.getImage();
            Image scaledActualImage = toScaleImage.getScaledInstance(90,90, Image.SCALE_SMOOTH);
            actualImage = new ImageIcon(scaledActualImage);
            icons[i] = actualImage;
        }
    }
    
    public void initializeGame(){
        noOfMatches = 0;
        score = 0;
        int x = 0;
        for (int i = 0; i < cards.length; i++) {
            cards[i] = new Card(icons[x], new ImageIcon(getClass().getResource("imgs/back.png")));
            cards[i].addActionListener(this);
            main.add(cards[i]);
            if ((i + 1) % 2 == 0) {
                x++;
            }
        }
        scoreText.setText("Score: " + score);
        shuffle();

    }
    
    public void shuffle(){
        main.removeAll();
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int i = 0; i < 16;) {
            int x = (int) (Math.random() * 16);
            if (!al.contains(x)) {
                al.add(x);
                i++;
            }
        }
        for (int i = 0; i < 16; i++) {
            main.add(cards[al.get(i)]);
            cards[al.get(i)].hideTile();
        }
    }
    
    public void check() throws IOException{
        if (flipped1 != flipped2 && flipped1.getImage() == flipped2.getImage()){
            flipped1.removeActionListener(this);
            flipped2.removeActionListener(this);
            score += 30;
            scoreText.setText("Score: " + score);
            noOfMatches +=2;
            if(noOfMatches == cards.length){
                won = true;
            }else{
                won = false;
            }
            if (won){
                if(score > 0){
                    JOptionPane.showMessageDialog(main, "You Won! You earned " + score + " pesos!");
                    moneyEarned = player.updateBudget(score);
                    player = new Manager("Player", "placeholder.png", moneyEarned);
                    this.dispose();
                    JFrame window = new MainMenuDisplay(player);
                    window.setVisible(true);      
                }
                else{
                    JOptionPane.showMessageDialog(main, "You Lost! You lost " + score*-1 + " pesos!");
                    moneyEarned = player.updateBudget(score);
                    player = new Manager("Player", "placeholder.png", moneyEarned);
                    this.dispose();
                    JFrame window = new MainMenuDisplay(player);
                    window.setVisible(true);
                }
            }
        }
    
        else {
            flipped1.addActionListener(this);
            flipped1.hideTile();
            flipped2.hideTile();
            score -= 10;
            scoreText.setText("Score: " + score);
        }
    }
    
   
    @Override
    public void actionPerformed(ActionEvent e) {
        if (status == 0) {
            flipped1 = (Card) e.getSource();
            flipped1.showTile();
            //avoid double clicking
            flipped1.removeActionListener(this);
            status++;
        } else if (status == 1) {
            status++;
            flipped2 = (Card) e.getSource();
            new Thread() {
                @Override
                public void run() {
                    try {
                        flipped2.showTile();
                        Thread.sleep(500);
                        check();
                        Thread.sleep(600);
                        status = 0;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            }.start();

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel source = (JLabel)e.getSource();
        Font f = source.getFont();
        if(f.isPlain()){
            if(e.getSource() == title){
                title.setFont(new Font("Futura Bold", Font.BOLD, 30));
            }
            if(e.getSource() == scoreText){
                scoreText.setFont(new Font("Futura Bold", Font.BOLD, 30));
            }
        }
        else{
            if(e.getSource() == title){
                title.setFont(new Font("Futura Bold", Font.PLAIN, 30));
            }
            if(e.getSource() == scoreText){
                scoreText.setFont(new Font("Futura Bold", Font.PLAIN, 30));
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        JLabel source = (JLabel)e.getSource();
        if(source == title){
            northPanel.setBackground(new java.awt.Color(255,222,166));
        }
        if(source == scoreText){
            southPanel.setBackground(new java.awt.Color(255,222,166));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       JLabel source = (JLabel)e.getSource();
        if(source == title){
            northPanel.setBackground(new java.awt.Color(248,196,172));
        }
        if(source == scoreText){
            southPanel.setBackground(new java.awt.Color(248,196,172));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
