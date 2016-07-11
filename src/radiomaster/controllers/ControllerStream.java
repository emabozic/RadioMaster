/**
* \brief Audio Stream controller
* \details This controller class is used to provide a player and events to 
*          control supplied audio stream from a URL. 
* @author Goran
* @version 1.0
* \date Jul 8, 2016
* \copyright
* This code and information is provided "as is" without warranty of
* any kind, either expressed or implied, including but not limited to
* the implied warranties of merchantability and/or fitness for a
* particular purpose.
* \par
* Copyright (c) Gauss d.o.o. All rights reserved
*/
package radiomaster.controllers;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.Port;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class ControllerStream {
    //region CLASS PARAMETERS
    

    public static final String TAG = "StreamController";
      
    private BufferedInputStream mBufferedInputStreamAudioStream;
    public Player               mPlayerAudioPlayer;
    
    private Thread              mAudioPlayerThread = null; 
    
    
    //endregion
    //region CLASS CONSTRUCT
    
    
    public ControllerStream(){
        System.out.println(TAG);
    }

    //endregion
    //region CUSTOM METHODS
    
    
    /**
     * Calling this will close the player
     * if the player is instantiated.
     */
    public void StopPlayingAudioStream() {
        if (mPlayerAudioPlayer != null){
            mPlayerAudioPlayer.close();
            mPlayerAudioPlayer = null;
            mAudioPlayerThread = null;
        }
    }
    
    /**
     * Calling this will start playing audio 
     * stream from a supplied URL.
     * 
     * @param link URL from which the audio stream will be played
     */
    public void StartPlayingAudioStream(String link) {
        try {
             URL url = new URL(link);
             Socket socket = new Socket(url.getHost(), url.getPort());
             OutputStream os = socket.getOutputStream();
             
             String user_agent = "RadioMaster/0.5";
             String req = "GET / HTTP/1.0\r\nuser-agent: " + user_agent + 
                     "\r\nIcy-MetaData: 1\r\nConnection: keep-alive\r\n\r\n";
             
             os.write(req.getBytes());
             InputStream is = socket.getInputStream();
             
             mBufferedInputStreamAudioStream = new BufferedInputStream(is);
             mPlayerAudioPlayer = new Player(mBufferedInputStreamAudioStream);
        } catch (Exception e){
             System.out.println("Nije moguce pokrenuti stream");
             e.printStackTrace();
        }
        
        mAudioPlayerThread = new Thread(){
            @Override
            public void run(){
                try {
                    if (mPlayerAudioPlayer != null) {
                        mPlayerAudioPlayer.play();
                    }
                } catch (JavaLayerException ex) {
                    ex.printStackTrace();
                }
            }
        };
        
        mAudioPlayerThread.start();
    }
  
    /**
     * Call this when closing the controller class 
     * to "clear" all of it's resources from the memory
     * and set it up for garbage collection.
     */
    public void destroy() {
        mBufferedInputStreamAudioStream = null; 
        mPlayerAudioPlayer = null;
        mAudioPlayerThread = null; 
    }
    
    /**
     * Call this to set the volume of the player to passed value from 
     * the seek bar to which it's connected to.
     * @param volume Amount to which the audio output will be set.
     */
    public void setGain(float volume) {          
        try {  
            Mixer.Info[] infos = AudioSystem.getMixerInfo();  
            for (Mixer.Info info: infos) {    
                Mixer mixer = AudioSystem.getMixer(info);  
                if (mixer.isLineSupported(Port.Info.SPEAKER)) {    
                    Port port = (Port)mixer.getLine(Port.Info.SPEAKER);    
                    port.open();    
                    if (port.isControlSupported(FloatControl.Type.VOLUME)) {    
                        FloatControl floatControlVolume =  (FloatControl)port
                                .getControl(FloatControl.Type.VOLUME);                    
                        floatControlVolume.setValue(volume);
                    }  
                port.close();    
                }    
            }    
        } catch (Exception e) {   
            JOptionPane.showMessageDialog(null,"Erro\n"+e);  
        }  
    }
    
    
    //endregion
}
