/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.*;

/**
 *
 * @author HP
 */
public class main {
    public static void main(String[] args) throws IOException{
        /*screens have no bg image (yet) since both screens have complex layouts which had no direct 
        method to set it and using getContentPane and setBounds would make deem the layout used useless in a way*/
        Manager player = new Manager("Player", "placeholder.png", 1000);
                
        MenuDisplay frame1 = new MenuDisplay(player);
        
        frame1.setVisible(true);
        //sir maghintay na lang po kayo medyo mabagal magrun hehe
    }
}
