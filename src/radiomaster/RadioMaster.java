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
import radiomaster.view.TestZvuka;
import radiomaster.view.TestZvuka2;
import radiomaster.view.ViewCategories;

/**
 *
 * @author Ema
 */
public class RadioMaster {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
//        new view_countries().setVisible(true);
        new TestZvuka2().setVisible(true);
    }
    
}
