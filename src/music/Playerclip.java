package music;

import javax.sound.midi.*;
import java.io.IOException;
import java.io.InputStream;

public class Playerclip {
    private static Sequencer sequencer;;
    public static void playRoboMusic(){
        InputStream resource = Playerclip.class.getResourceAsStream("Robocop3.mid");
        Sequence sequence = null;
        try {
            sequence = MidiSystem.getSequence(resource);
        } catch (InvalidMidiDataException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            sequencer = MidiSystem.getSequencer();
        } catch (MidiUnavailableException e) {
            throw new RuntimeException(e);
        }
        try {
            sequencer.open();
        } catch (MidiUnavailableException e) {
            throw new RuntimeException(e);
        }
        try {
            sequencer.setSequence(sequence);
        } catch (InvalidMidiDataException e) {
            throw new RuntimeException(e);
        }
        sequencer.start();
    }
    public static void stopRoboMusic(){
        sequencer.stop();
    }
}
