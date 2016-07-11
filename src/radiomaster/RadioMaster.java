/**
 * RadioMaster Application
 * 
* This class is used to start RadioMaster application with Login form.
 * 
* @author Nikolina Pepić
 * @version 1.0
 * 
* Jul 8, 2016
 * 
* This code and information is provided "as is" without warranty of any kind,
 * either expressed or implied, including but not limited to the implied
 * warranties of merchantability and/or fitness for a particular purpose.
 * 
* Copyright (c) Gauss d.o.o. All rights reserved
 */

package radiomaster;

import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import radiomaster.view.Login;



public class RadioMaster {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException, Exception {
        new Login().setVisible(true);
    }
    
}
