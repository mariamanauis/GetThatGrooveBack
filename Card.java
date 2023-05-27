/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package getthatgrooveback;

/**
 *Card class details a card's back
 * front icon along with its getter and
 * setter methods for the cards in the 
 * matching game
 *
 * @author Maria Manauis and Jill Rosacay
 * @version 1.0
 * @since 05/09/2023
 */
import javax.swing.*;

public class Card extends JButton {
    /**Actual icon of the Card
    */
    protected ImageIcon frontIcon;
    /**Back icon of the Card
    */
    protected ImageIcon backIcon;
    /**Boolean value that indicates
     * if the actual icon is shown
    */
    protected boolean hidden;
    /**Boolean value that indicates
     * if the actual icon is null or not
    */
    protected boolean noIcon;
    
    /** Constructs card provided with parameters
    * @param f - ImageIcon representing 
    * the front or actual icon of the card
    * @param b - ImageIcon representing 
    * the back icon of the card
    */
    public Card(ImageIcon f, ImageIcon b) {
        /**Actual icon of the Card
         */
        this.frontIcon = f;
        /**back icon of the Card
         */
        this.backIcon= b;
        setSize(100, 100);
        setFocusable(false);
    }
    
    /** Sets the icon of the card to be the
    * front icon and sets hidden to false.
    */
    public synchronized void showTile() {
        setIcon(frontIcon);
        hidden = false;
    }

    /** Sets the icon of the card to be the
    * back icon and sets hidden to true.
    */
    public synchronized void hideTile() {
        setIcon(backIcon);
        hidden = true;
    }
    
    /** Sets the icon of the card to be the
    * null.
    */
    public synchronized void setNoIcon() {
        setIcon(null);
        noIcon = true;
    }

    /** Gets the cards’s image.
    * @return An ImageIcon representing
    * the card's front icon.
    */
    public ImageIcon getImage() {
        return frontIcon;
    }
    
    /** Gets the status of the card's image.
    * @return A boolean representing if the card
    * has an icon.
    */
    public synchronized boolean isNoIcon() {
        return noIcon;
    }
}
