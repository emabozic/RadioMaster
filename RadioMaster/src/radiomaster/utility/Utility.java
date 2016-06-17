/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiomaster.utility;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Gauss Developer
 */
public class Utility {
    
    public static final String APP_NAME="RadioMaster";
    
    public static void center(JFrame frame){
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
    
    public static void greska(JFrame frame,String poruka){
        JOptionPane.showMessageDialog(
                    frame.getRootPane(), //prozor koji ga zove
                    poruka, //prikazani tekst
                    "Error",//naslov
                    JOptionPane.ERROR_MESSAGE //vrsta poruke
            );
    }
}
