package radiomaster.restful;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ZvukController implements Runnable {


    @Override
    public void run() {
       
        AudioInputStream stream = null;

            try {
                stream = AudioSystem.getAudioInputStream(new URL(
                        "http://freewavesamples.com/files/Yamaha-PSR-22-Rhumba.wav"));
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(ZvukController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ZvukController.class.getName()).log(Level.SEVERE, null, ex);
            }

        

        AudioFormat format = stream.getFormat();
        if (format.getEncoding() != AudioFormat.Encoding.PCM_SIGNED) {
            format = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, format
                    .getSampleRate(), format.getSampleSizeInBits() * 2, format
                    .getChannels(), format.getFrameSize() * 2, format.getFrameRate(),
                    true); // big endian
            stream = AudioSystem.getAudioInputStream(format, stream);
        }

        SourceDataLine.Info info = new DataLine.Info(SourceDataLine.class, stream
                .getFormat(), ((int) stream.getFrameLength() * format.getFrameSize()));
        SourceDataLine line = null;
        try {
            line = (SourceDataLine) AudioSystem.getLine(info);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(ZvukController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            line.open(stream.getFormat());
        } catch (LineUnavailableException ex) {
            Logger.getLogger(ZvukController.class.getName()).log(Level.SEVERE, null, ex);
        }
        line.start();

        int numRead = 0;
        byte[] buf = new byte[line.getBufferSize()];
        try {
            while ((numRead = stream.read(buf, 0, buf.length)) >= 0) {
                int offset = 0;
                while (offset < numRead) {
                    offset += line.write(buf, offset, numRead - offset);
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ZvukController.class.getName()).log(Level.SEVERE, null, ex);
        }
        line.drain();
        line.stop();
    }
}
