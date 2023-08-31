package thread;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RaceExtendsThread extends Thread {

	JFrame frame;
	JPanel mainPanel, threadALabel, threadBLabel, threadCLabel;

	public RaceExtendsThread() {
		frame();

	}
	
	public RaceExtendsThread(String s) {
		super(s);

	}

	public void run() {
		String currentThrent = Thread.currentThread().getName();
		
		if(currentThrent.equals("red")){
			red();
		}
		
		if(currentThrent.equals("blue")){
			blue();
		}
		
		if(currentThrent.equals("black")){
			black();
		}
		
		
	}

	public void blue() {
		Random rd1 = new Random();
		Random rd2 = new Random();
		int Y = rd1.nextInt(20, 300);
		int speed = rd2.nextInt(3,6 );
		for (int i = -10; i < 450;) {
			try {
				Thread.sleep(15);
				i += speed;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			threadALabel.setBounds(i, Y, 20, 20);
		}
		blue();
	}

	public void black() {
		Random rd1 = new Random();
		Random rd2 = new Random();
		int Y = rd1.nextInt(20, 300);
		int speed = rd2.nextInt(3,6);
		
		for (int i = -10; i < 430;) {
			try {
				Thread.sleep(15);
				i += speed;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			threadBLabel.setBounds(i, Y, 20, 20);
		}
		
		black();
		

	}

	public void red() {
		Random rd1 = new Random();
		Random rd2 = new Random();
		int Y = rd1.nextInt(20, 300);
		int speed = rd2.nextInt(3,6);
		for (int i = -10; i < 420;) {
			try {
				Thread.sleep(15);
				i += speed;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			threadCLabel.setBounds(i, Y, 20, 20);
		}
		red();
          
	}

	public void frame() {
		frame = new JFrame("Race");
		frame.setSize(400, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(400, 400));

		mainPanel.setLayout(null);

		threadALabel = new JPanel();
		threadBLabel = new JPanel();
		threadCLabel = new JPanel();

		threadALabel.setBounds(-20, 20, 20, 20);
		threadALabel.setBackground(Color.BLUE);

		threadBLabel.setBounds(-20, 115, 20, 20);
		threadBLabel.setBackground(Color.black);

		threadCLabel.setBounds(-20, 220, 20, 20);
		threadCLabel.setBackground(Color.red);

		mainPanel.add(threadALabel);
		mainPanel.add(threadBLabel);
		mainPanel.add(threadCLabel);

		frame.add(mainPanel);

		frame.setVisible(true);

	}

	public static void main(String[] args) {
		RaceExtendsThread obj = new RaceExtendsThread();
		Thread threadBlue = new Thread(obj);
		Thread threadBlack = new Thread(obj);
		Thread threadRed = new Thread(obj);
		
		threadBlue.setName("blue");
		threadBlack.setName("black");
		threadRed.setName("red");

		threadBlue.start();
		threadBlack.start();
		threadRed.start();

	}

}
