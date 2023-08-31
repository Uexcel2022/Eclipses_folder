package brocode;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

// involves File, InputStream, AudioSystem, clip

public class MusicPlayer {

	public static void main(String[] args) throws LineUnavailableException {
		Scanner sc = new Scanner(System.in);
		File file = new File("src/BroCode/possible.wav");
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(audioStream);
			System.out.println("P = Play, S = Stop, R = Reset, Q = Quit");
			String response = "";
			while (!response.equals("Q")) {
				System.out.print("Enter your choice: ");
				response = sc.nextLine().trim().toUpperCase();

				switch (response) {
				case "P":
					clip.start();
					break;
				case "S":
					clip.stop();
					break;
				case "R":
					clip.setMicrosecondPosition(0);
					break;
				case "Q":
					clip.close();
					sc.close();
					break;
				default:
					System.out.println("Not a valid response");
				}
			}
			System.out.println("Bye!!!");
		} catch (UnsupportedAudioFileException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
