/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiomaster;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import radiomaster.view.Login;
import radiomaster.view.TestZvuka2;

/**
 *
 * @author Ema
 */
public class RadioMaster {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, Exception {
//        new view_countries().setVisible(true);
        new Login().setVisible(true);
    }
    
}
