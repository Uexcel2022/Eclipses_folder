package synchronizationimplementation;

import java.awt.Color;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AssignmentSynchronization extends Thread {
	JPanel mainPanel;
	JPanel tollBoothColor;
	JPanel bridge;
	JFrame frame;
	JPanel bluePanel;
	JPanel yellowPanel;
	JPanel redPanel;
	JPanel blackPanel;
	JPanel pinkPanel;
	JPanel clayPanel;
	JPanel orangePanel;
	JPanel greenPanel;
	JPanel magentaPanel;
	JPanel boysenberryPanel;
	JPanel denimPanel;

	public AssignmentSynchronization() {

		tollBoothColor = new JPanel();
		frame = new JFrame("Synchronization");
		bridge = new JPanel();
		mainPanel = new JPanel();
		bluePanel = new JPanel();
		redPanel = new JPanel();
		blackPanel = new JPanel();
		greenPanel = new JPanel();
		magentaPanel = new JPanel();
		clayPanel = new JPanel();
		pinkPanel = new JPanel();
		yellowPanel = new JPanel();
		boysenberryPanel = new JPanel();
		denimPanel = new JPanel();
		frame();

	}

	@Override
	public void run() {

		if (Thread.currentThread().getName().equals("blueVehicle")) {
			blueVehicle();
		}

		if (Thread.currentThread().getName().equals("redVehicle")) {
			redVehicle();
		}

		if (Thread.currentThread().getName().equals("blackVehicle")) {
			blackVehicle();
		}

		if (Thread.currentThread().getName().equals("greenVehicle")) {
			greenVehicle();
		}

		if (Thread.currentThread().getName().equals("yellowVehicle")) {
			yellowVehicle();
		}
		if (Thread.currentThread().getName().equals("magentaVehicle")) {
			magentaVehicle();
		}
		if (Thread.currentThread().getName().equals("pinkVehicle")) {
			pinkVehicle();
		}
		if (Thread.currentThread().getName().equals("clayVehicle")) {
			clayVehicle();
		}

		if (Thread.currentThread().getName().equals("boysenberryVehicle")) {
			boysenberryVehicle();
		}
		if (Thread.currentThread().getName().equals("denimVehicle")) {
			denimVehicle();
		}

	}

	public void redVehicle() {
		while (true) {
			try {
				Random rd = new Random();
				int speed = rd.nextInt(9, 15);
				for (int i = -10; i < 700;) {
					if (i == 440) {
						tollBoot();

					}

					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					redPanel.setBounds(i, 32, 25, 25);
					redPanel.setBackground(Color.red);
					mainPanel.add(redPanel);
					i += 5;
				}
//			redPanel = new JPanel();
//			redVehicle();
			} catch (Exception e) {
				System.out.println("redVehicle: Error!");
			}
		}
	}

	public void blueVehicle() {
		while (true) {
			try {
				Random rd = new Random();
				int speed = rd.nextInt(9, 15);
				for (int i = -10; i < 700;) {
					if (i == 440) {
						tollBoot();
					}
					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					bluePanel.setBounds(i, 1, 25, 25);
					bluePanel.setBackground(Color.blue);
					mainPanel.add(bluePanel);

					i += 5;
				}
//			bluePanel = new JPanel();
//			blueVehicle();

			} catch (Exception e) {
				System.out.println("blueVehicle: Error!");
			}
		}

	}

	public void blackVehicle() {
		while (true) {
			try {
				Random rd = new Random();
				int speed = rd.nextInt(9, 15);
				for (int i = -10; i < 700;) {
					if (i == 440) {
						tollBoot();
						i += 5;
					}

					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					blackPanel.setBounds(i, 62, 25, 25);
					blackPanel.setBackground(Color.black);
					mainPanel.add(blackPanel);
					i += 5;
				}
//			blackPanel = new JPanel();
//				blackVehicle();
			} catch (Exception e) {
				System.out.println("blackVehicle: Error!");
			}
		}
	}

	public void greenVehicle() {
		while (true) {
			try {
				Random rd = new Random();
				int speed = rd.nextInt(9, 15);
				for (int i = -10; i < 700;) {
					if (i == 440) {
						tollBoot();
						i += 5;

					}

					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					greenPanel.setBounds(i, 92, 25, 25);
					greenPanel.setBackground(Color.green);
					mainPanel.add(greenPanel);
					i += 5;
				}
//			greenPanel = new JPanel();
//			greenVehicle();
			} catch (Exception e) {
				System.out.println("greenVehicle: Error!");
			}
		}
	}

	public void pinkVehicle() {
		while (true) {
			try {
				Random rd = new Random();
				int speed = rd.nextInt(9, 15);
				for (int i = -10; i < 700;) {
					if (i == 440) {
						tollBoot();
						i += 5;

					}

					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					pinkPanel.setBounds(i, 122, 25, 25);
					pinkPanel.setBackground(Color.pink);
					mainPanel.add(pinkPanel);
					i += 5;
				}
//			blackPanel = new JPanel();
//			pinkVehicle();
			} catch (Exception e) {
				System.out.println("pinkVehicle: Error!");
			}
		}
	}

	public void clayVehicle() {
		while (true) {
			try {
				Random rd = new Random();
				int speed = rd.nextInt(9, 15);
				for (int i = -10; i < 700;) {
					if (i == 440) {
						tollBoot();
						i += 5;

					}

					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					clayPanel.setBounds(i, 152, 25, 25);
					clayPanel.setBackground(Color.decode("#80400B"));
					mainPanel.add(clayPanel);
					i += 5;
				}
//			clayPanel = new JPanel();
//				clayVehicle();
			} catch (Exception e) {
				System.out.println("clayVehicle: Error!");
			}
		}
	}

	public void magentaVehicle() {
		while (true) {
			try {
				Random rd = new Random();
				int speed = rd.nextInt(9, 19);
				for (int i = -10; i < 700;) {
					if (i == 440) {
						tollBoot();
						i += 5;

					}

					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					magentaPanel.setBounds(i, 182, 25, 25);
					magentaPanel.setBackground(Color.magenta);
					mainPanel.add(magentaPanel);
					i += 5;
				}
//			magentaPanel = new JPanel();
//				magentaVehicle();
			} catch (Exception e) {
				System.out.println("magentaVehicle: Error!");
			}
		}
	}

	public void yellowVehicle() {
		while (true) {
			try {
				Random rd = new Random();
				int speed = rd.nextInt(9, 15);
				for (int i = -10; i < 700;) {
					if (i == 440) {
						tollBoot();
						i += 5;
					}

					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					yellowPanel.setBounds(i, 212, 25, 25);
					yellowPanel.setBackground(Color.yellow);
					mainPanel.add(yellowPanel);
					i += 5;
				}
//			yellowPanel = new JPanel();
//				yellowVehicle();
			} catch (Exception e) {
				System.out.println("yellowVehicle: Error!");
			}
		}
	}

	public void denimVehicle() {
		while (true) {
			try {
				Random rd = new Random();
				int speed = rd.nextInt(9, 15);
				for (int i = -10; i < 700;) {
					if (i == 440) {
						tollBoot();
						i += 5;
					}

					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					denimPanel.setBounds(i, 242, 25, 25);
					denimPanel.setBackground(Color.decode("#151E3D"));
					mainPanel.add(denimPanel);
					i += 5;
				}
//			denimPanel = new JPanel();
//				denimVehicle();
			} catch (Exception e) {
				System.out.println("denimVehicle: Error!");
			}
		}
	}

	public void boysenberryVehicle() {
		while (true) {
			try {
				Random rd = new Random();
				int speed = rd.nextInt(9, 15);
				for (int i = -10; i < 700;) {
					if (i == 440) {
						tollBoot();
						i += 5;
					}

					try {
						Thread.sleep(speed);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					boysenberryPanel.setBounds(i, 272, 25, 25);
					boysenberryPanel.setBackground(Color.decode("#630436"));
					mainPanel.add(boysenberryPanel);
					i += 5;
				}
//			boysenberryPanel = new JPanel();
//				boysenberryVehicle();
			} catch (Exception e) {
				System.out.println("boysenberryVehicle: Error!");
			}
		}

	}

	public synchronized void tollBoot() {
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void frame() {
		try {

			frame.setSize(745, 375);
			frame.setLayout(null);
			frame.getContentPane().setBackground(Color.black);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			mainPanel.setLayout(null);
			mainPanel.setBounds(15, 20, 700, 300);
			mainPanel.setBackground(Color.gray);

			tollBoothColor = new JPanel();
			tollBoothColor.setBounds(460, 0, 50, 300);
			tollBoothColor.setBackground(Color.orange);

			bridge = new JPanel();
			bridge.setBounds(630, 0, 50, 300);
			bridge.setBackground(Color.cyan);

			mainPanel.add(bridge);
			mainPanel.add(tollBoothColor);
			frame.add(mainPanel);
			frame.setVisible(true);
		} catch (Exception e) {
			System.out.println("boysenberryVehicle: Error!");
		}

	}

	public static void main(String[] args) {
		try {
			AssignmentSynchronization obj = new AssignmentSynchronization();
			Thread t1 = new Thread(obj);
			Thread t2 = new Thread(obj);
			Thread t3 = new Thread(obj);
			Thread t4 = new Thread(obj);
			Thread t5 = new Thread(obj);
			Thread t6 = new Thread(obj);
			Thread t7 = new Thread(obj);
			Thread t8 = new Thread(obj);
			Thread t9 = new Thread(obj);
			Thread t10 = new Thread(obj);

			t1.setName("blueVehicle");
			t2.setName("redVehicle");
			t3.setName("blackVehicle");
			t4.setName("greenVehicle");
			t5.setName("pinkVehicle");
			t6.setName("yellowVehicle");
			t7.setName("magentaVehicle");
			t8.setName("clayVehicle");
			t9.setName("boysenberryVehicle");
			t10.setName("denimVehicle");

			t1.start();
			t2.start();
			t3.start();
			t4.start();
			t5.start();
			t6.start();
			t7.start();
			t8.start();
			t9.start();
			t10.start();
		} catch (Exception e) {
			System.out.println("boysenberryVehicle: Error!");
		}
	}
}
