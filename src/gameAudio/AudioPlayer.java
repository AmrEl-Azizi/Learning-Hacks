package gameAudio;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer {

	private Clip clip;

	public AudioPlayer(String path) {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(getClass().getResourceAsStream(path));
			AudioFormat baseFormat = ais.getFormat();
			AudioFormat decodeFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16,
					baseFormat.getChannels(), baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
			AudioInputStream dais = AudioSystem.getAudioInputStream(decodeFormat, ais);
			clip = AudioSystem.getClip();
			clip.open(dais);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void play() {
		if (clip == null)
			return;
		stop();
		clip.setFramePosition(0);
		clip.start();
	}

	public void loop(int loop) {
		if (clip == null)
			return;
		stop();
		clip.setFramePosition(0);
		clip.loop(loop);
	}

	public void stop() {
		if (clip.isRunning())
			clip.stop();
	}

	public void close() {
		stop();
		clip.close();
	}

	public boolean checkifRunning() {
		if (clip.isRunning()) {
			return true;
		} else {
			return false;
		}
	}

	// artists: Jasprelao, Jeremiah "McTricky" George, Jude, Gamesfreak13563,
	// Tarranon, Cornflake, Xcalnarok, Lana42, Kunsel, Subaru, NathanGDay, Snowy
	// Fox, ReclaimedGlory, Apoc, hyde9318 and 800 M.P.H.
}
