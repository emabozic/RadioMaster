package radiomaster.restful;

import java.io.File;
import java.net.URL;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class ZvukController {

    /**
     *
     * @param sto je parametar sto se pusta .. ako pri pozivanju metode stavimo file, pustit ce lokalni wav fajl iz src, ako je URL onda ce pozvat .wav fajl s neta
     * @throws Exception
     */
    public void playSound(String sto) throws Exception {
         AudioInputStream stream = null;
        if (sto == "file") {
            stream = AudioSystem.getAudioInputStream(new File(
                    "src/radiomaster/sound/2.wav"));
        } 
        if (sto == "URL") {
            
            stream = AudioSystem.getAudioInputStream(new URL(
                    "http://freewavesamples.com/files/Yamaha-PSR-22-Elec-Piano-C4.wav"));
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
        SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
        line.open(stream.getFormat());
        line.start();

        int numRead = 0;
        byte[] buf = new byte[line.getBufferSize()];
        while ((numRead = stream.read(buf, 0, buf.length)) >= 0) {
            int offset = 0;
            while (offset < numRead) {
                offset += line.write(buf, offset, numRead - offset);
            }
        }
        line.drain();
        line.stop();
    }
}
