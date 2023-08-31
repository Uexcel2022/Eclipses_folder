package gui;

import resources.resource;
import hangmangame.CountriesArray;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.Color;
//import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

@SuppressWarnings("serial")
public class FrameDemo extends JFrame implements ActionListener {
	JButton ok, cancel;

	public FrameDemo() {
//		 Adding button
//		ok = new JButton("Ok");
//		add(ok);
//		cancel = new JButton("Cancel");
//		add(cancel);
//		ok.setBounds(50, 150, 80, 25);
//		cancel.setBounds(150, 150, 80, 25);
//		setLayout(null);
//		JLabel fName = new JLabel("First name:");
//		add(fName);
//		fName.setBounds(2, 10, 80, 25);
//		JLabel LName = new JLabel("Last name:");
//		add(LName);
//		LName.setBounds(2, 30, 80, 25);
//		setTitle("JFrame Demo");

		setSize(300, 300);
		setVisible(true);
		getContentPane().setLayout(new GridLayout(5, 1));
		setDefaultCloseOperation(FrameDemo.EXIT_ON_CLOSE);
//		ok.addActionListener(this);
//		cancel.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		try {

			if (e.getActionCommand().equalsIgnoreCase("OK")) {
				ok.setText("Clicked");
			}

			if (e.getActionCommand().equalsIgnoreCase("Cancel")) {
				cancel.setText("Clicked");

			}

		} catch (Exception er) {

		}

		// Event handler Anonymous class
//		ok.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				ok.setText("Clicked");
//			}
//		});

	}

	public static void main(String[] args) {
//		SwingUtilities.invokeLater(new Runnable() {
//			public void run() {
//				new FrameDemo();
//			}
//		});
//		new JMenuDemo();
//		new MenuBarDemo();
//		new JTabbedPaneDemo();
//		new JPanelDemo();
//		new DialogDemo();

//		new JLabelDemo();
//		new JTextFieldDemo();
//		new Grade();
//		new Calc();
		new HangManMenuCountries();

	}

}

//-------------------------------------------------------------------------------------------------------------------------------


class HangManMenuCountries {
	String country;
	String failed = "";
	String currentTextArea = "";
	String dashes = "";
	JTextArea textfield2;
	JButton backToMenuButton;
	Integer failedThreshold = 0;
	char[] textArea;

	public HangManMenuCountries() {

		Font font = new Font("New Time Roman", Font.TYPE1_FONT, 22);
		Font menuTextFont = new Font("New Time Roman", Font.TYPE1_FONT, 16);

		JFrame menuFrame = new JFrame("Lassic Jumble Game");
		JPanel panel = new JPanel();
		JLabel mainLabel = new JLabel("CLASSIC JUMBLE WORD");
		JButton playGameButton = new JButton("Play Game");
		JButton instructionButton = new JButton("View Instructions");
		JButton exitButton = new JButton("Exit Game");

		GridLayout g = new GridLayout();
		g.setColumns(10);
		g.setHgap(4);
		g.setRows(5);
		g.setVgap(15);

		mainLabel.setFont(font);
		playGameButton.setFont(menuTextFont);
		instructionButton.setFont(menuTextFont);
		exitButton.setFont(menuTextFont);

		panel.setLayout(g);
		panel.add(mainLabel);
		panel.add(playGameButton);
		panel.add(instructionButton);
		panel.add(exitButton);
		menuFrame.add(panel);

		menuFrame.setLayout(new FlowLayout());
		menuFrame.setSize(350, 260);
		menuFrame.setVisible(true);
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		playGameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuFrame.dispose();
				JTextField texfield1 = new JTextField(10);
				textfield2 = new JTextArea();
				textfield2.setEditable(false);
				getCountry();

				Font font = new Font("New Time Roman", Font.TYPE1_FONT, 22);
				Font labelFont = new Font("New Time Roman", Font.TYPE1_FONT, 16);
				Font textFieldFont = new Font("New Time Roman", Font.TYPE1_FONT, 15);
				JFrame PlayGameFrame = new JFrame("Lassic Jumble Game");
				JPanel mainPanel = new JPanel();
				JPanel buttonPanel = new JPanel();
				JPanel panel3 = new JPanel();
				JLabel mainLable = new JLabel("CLASSIC JUMBLE WORD");
				JLabel textFied1Label = new JLabel("Enter a letter:");
				JLabel textField2Label = new JLabel("Contry:");
				JButton resetButton = new JButton("Reset");
				backToMenuButton = new JButton("Back To Menu");

				GridLayout gridLayout1 = new GridLayout();
				GridLayout gridLayout2 = new GridLayout();
				mainLable.setLabelFor(textfield2);
				textFied1Label.setLabelFor(texfield1);
				textField2Label.setLabelFor(textfield2);

				gridLayout1.setRows(7);
				gridLayout1.setColumns(1);
				gridLayout1.setVgap(5);
				gridLayout2.setHgap(10);
				gridLayout2.setRows(1);
				gridLayout2.setVgap(5);

				buttonPanel.setLayout(gridLayout2);
				panel3.setLayout(gridLayout2);

				mainLable.setFont(font);
				textFied1Label.setFont(labelFont);
				textField2Label.setFont(labelFont);
				texfield1.setFont(textFieldFont);
				textfield2.setFont(textFieldFont);
				resetButton.setFont(menuTextFont);
				backToMenuButton.setFont(menuTextFont);

				mainPanel.setLayout(gridLayout1);
				mainPanel.add(mainLable);
				mainPanel.add(textFied1Label);
				mainPanel.add(texfield1);
				mainPanel.add(textField2Label);
				mainPanel.add(textfield2);
				mainPanel.add(panel3);
				buttonPanel.add(resetButton);
				buttonPanel.add(backToMenuButton);
				mainPanel.add(buttonPanel);
				PlayGameFrame.add(mainPanel);

				PlayGameFrame.setLayout(new FlowLayout());
				PlayGameFrame.setSize(350, 320);
				PlayGameFrame.setVisible(true);
				PlayGameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				
				texfield1.addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent e) {
						
						if (failedThreshold > 2) {
							texfield1.setText("Failed attempt!");
							texfield1.setForeground(Color.RED);
							texfield1.setEnabled(false);
						}
						
						if (!currentTextArea.equals(country)) {
							if (!(String.valueOf(country.toLowerCase())
									.contains(String.valueOf(e.getKeyChar()).toLowerCase()))) {
								if (!String.valueOf(e.getKeyChar()).isEmpty()
										&& !failed.contains(String.valueOf(e.getKeyChar()))
										&& !String.valueOf(e.getKeyChar()).equals("")) {
									failed += e.getKeyChar();
									failedThreshold ++;
								}
							}
							

							for (int i = 0; i < country.length(); i++) {
								if (String.valueOf((country.toLowerCase()).charAt(i))
										.equals((String.valueOf(e.getKeyChar()).toLowerCase()))) {
									textArea[i] = country.charAt(i);
									failedThreshold = 0;
								}
							}
							

							currentTextArea = "";
							for (char a : textArea) {
								currentTextArea += a;
							}
							textfield2.setText(currentTextArea);
						}
					}

					public void keyReleased(KeyEvent e) {

						if (currentTextArea.equals(country)) {
							if (failed.length() > 0) {
								texfield1.setText("Wrong guess(es): " + failed);
								texfield1.setForeground(Color.RED);
							} else {
								texfield1.setText("No wrong guess!");

							}
						}
						
						
					}

				});
				

				resetButton.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						texfield1.setEnabled(true);
						texfield1.setText(null);
						texfield1.setForeground(Color.BLACK);
						currentTextArea = "";
						failedThreshold = 0;
						getCountry();

					}

				});
				
				
				backToMenuButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						PlayGameFrame.dispose();
						new HangManMenuCountries();
					}

				});
			}
		});
		

		exitButton.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				System.exit(0);
				menuFrame.setDefaultCloseOperation(0);
			}
		});

	}

	public void getCountry() {
		dashes = "";
		CountriesArray ar = new CountriesArray();
		country = ar.getCountryName();
		for (int i = 0; i < country.length(); i++) {
			dashes += "-";
		}
		textfield2.setText(dashes);
		textArea = dashes.toCharArray();
		failed = "";
	}

}


//...................................................................................................................................................................



class ClassicJumbleWord {
	public ClassicJumbleWord() {
		Font font = new Font("New Time Roman", Font.TYPE1_FONT, 20);
		JFrame f = new JFrame("Lassic Jumble Game");
		JPanel p = new JPanel();
		JLabel l = new JLabel("CLASSIC JUMBLE WORD");
		JButton jb1 = new JButton("Play Game");
		JButton jb2 = new JButton("View Instructions");
		JButton jb3 = new JButton("Exit Game");
		GridLayout g = new GridLayout();
		l.setFont(font);
		g.setColumns(1);
		g.setRows(4);
		g.setVgap(10);
		p.setLayout(g);
		p.add(l);
		p.add(jb1);
		p.add(jb2);
		p.add(jb3);
		f.add(p);

		f.setLayout(new FlowLayout());
		f.setSize(300, 220);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jb1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.dispose();
				JTextField t1 = new JTextField();
				JTextArea t2 = new JTextArea();
				l.setLabelFor(t2);
				Font font = new Font("New Time Roman", Font.TYPE1_FONT, 20);
				Font font2 = new Font("New Time Roman", Font.TYPE1_FONT, 15);
				Font font3 = new Font("New Time Roman", Font.TYPE1_FONT, 12);
				JFrame f = new JFrame("Lassic Jumble Game");
				JPanel p = new JPanel();
				JLabel l = new JLabel("CLASSIC JUMBLE WORD");
				JLabel l2 = new JLabel("Enter a letter:");
				JButton jb4 = new JButton("Submit");
				GridLayout g = new GridLayout();

				l.setFont(font);
				l2.setFont(font2);
				t1.setFont(font3);
				t2.setFont(font3);
				g.setRows(5);
				g.setColumns(10);
				g.setVgap(10);
				p.setLayout(g);
				p.add(l);
				p.add(l2);
				p.add(t1);
				p.add(t2);
				p.add(jb4);
				f.add(p);
				f.setLayout(new FlowLayout());
				f.setSize(300, 250);
				f.setVisible(true);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				jb4.addFocusListener(new FocusAdapter() {
					String word = "love is the greatest of All";

					public void focusGained(FocusEvent e) {
						String check = resource.isAlpha(t1.getText(), "");
						if (check != null) {
							t2.setText("Invalid charater(s): " + check);
							t2.setForeground(Color.RED);
						} else if ((t1.getText().length() > 1)) {
							t2.setText("You have entered more than one letter!");
							t2.setForeground(Color.RED);
						} else if (word.contains(t1.getText().toLowerCase())) {
							t2.setText("The letter is present");
						} else {
							t2.setText("The letter is not present");
						}
					}
				});

				t1.addFocusListener(new FocusAdapter() {
					public void focusGained(FocusEvent e) {
						if (t1.getText() != null) {
							t1.setText(null);
							t2.setText(null);
							t2.setForeground(Color.black);
						}
					}
				});

			}
		});

		jb3.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				System.exit(0);
				f.setDefaultCloseOperation(0);
			}
		});

	}

}



class Calc {
	JButton plus, equalto;

	public Calc() {
		JFrame f = new JFrame("Calculator");
		JPanel p = new JPanel();
		p.setLayout(grid());
		f.setLayout(new FlowLayout());
		JTextField tf1 = new JTextField(15);
		p.add(tf1);
		JTextField tf2 = new JTextField(15);
		tf2.setEnabled(false);
		p.add(tf2);
		p.add(equalto = new JButton("="));
		f.add(p);

		equalto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tf1.getText().contains("-")) {
					tf2.setEnabled(true);
					String[] num = tf1.getText().split("-");
					double num1 = Double.parseDouble(num[0]);
					double num2 = Double.parseDouble(num[1]);
					double add = num1 - num2;
					tf2.setText(String.valueOf(add));
				} else

				if (tf1.getText().contains("+")) {
					tf2.setEnabled(true);
					String[] num = tf1.getText().split("\\+");
					double num1 = Double.parseDouble(num[0]);
					double num2 = Double.parseDouble(num[1]);
					double add = num1 + num2;
					tf2.setText(String.valueOf(add));
				} else

				if (tf1.getText().contains("/")) {
					tf2.setEnabled(true);
					String[] num = tf1.getText().split("/");
					double num1 = Double.parseDouble(num[0]);
					double num2 = Double.parseDouble(num[1]);
					double add = num1 / num2;
					tf2.setText(String.valueOf(add));
				} else

				if (tf1.getText().contains("*")) {
					tf2.setEnabled(true);
					String[] num = tf1.getText().split("\\*");
					double num1 = Double.parseDouble(num[0]);
					double num2 = Double.parseDouble(num[1]);
					double add = num1 * num2;
					tf2.setText(String.valueOf(add));
				}
			}

		});

		f.setSize(250, 200);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public GridLayout grid() {
		GridLayout g = new GridLayout();
		g.setRows(4);
		g.setColumns(4);
		g.setHgap(10);
		g.setVgap(10);
		return g;

	}

}

class Grade {
	public Grade() {
		Font font = new Font("New Time Roman", Font.TYPE1_FONT, 13);
		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		JPanel bottomp = new JPanel();
		JButton jb = new JButton("Submit");
		jf.setTitle("Check Grade");
		jf.setLayout(new FlowLayout());
		GridLayout g = new GridLayout();
		g.setRows(2);
		g.setColumns(1);
		g.setVgap(15);
		g.setHgap(-65);
		jp.setLayout(g);
		bottomp.add(jb);

		JLabel l1 = new JLabel("Score");
		JTextField f1 = new JTextField(10);
		JLabel l2 = new JLabel("Grade");
		JTextField f2 = new JTextField(10);
		l1.setLabelFor(f1);
		l2.setLabelFor(f2);
		l1.setFont(font);
		f1.setFont(font);
		l2.setFont(font);
		f2.setFont(font);
		jp.add(l1);
		jp.add(l1);
		jp.add(f1);
		jp.add(l2);
		jp.add(f2);
		jf.add(jp);
		jf.add(bottomp, BorderLayout.AFTER_LAST_LINE);

		f1.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (f1.getText() != null) {
					f1.setText(null);
					f2.setText(null);
					f1.setForeground(Color.black);
				}
			}
		});

		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int score = Integer.parseInt(f1.getText());
					if (score > 100 || score < 40) {
						String grade = resource.checkGrade2(score);
						f2.setText(grade);
						f1.setForeground(Color.red);
					} else {
						String grade = resource.checkGrade2(score);
						f2.setText(grade);
					}
				} catch (NumberFormatException er) {
					f1.setText("Not interger!");
					f1.setForeground(Color.red);
				}
			}
		});

		jf.setSize(260, 170);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

@SuppressWarnings("serial")
class JTextFieldDemo extends JFrame {
	String firstName;
	String lastName;

	public JTextFieldDemo() {
		Font font = new Font("New Time Romans", Font.TYPE1_FONT, 12);
		JButton bt = new JButton("Submit");
		JLabel fName = new JLabel("First name");
		JTextField tf1 = new JTextField(15);
		JLabel lName = new JLabel("Last name");
		JTextField tf2 = new JTextField(15);
		setLayout(new FlowLayout());
		fName.setFont(font);
		lName.setFont(font);
		fName.setLabelFor(tf1);
		lName.setLabelFor(tf2);
		tf1.setFont(font);
		tf2.setFont(font);
		add(fName);
		add(tf1);
		add(lName);
		add(tf2);
		add(bt);
		setTitle("TextField");
		setSize(250, 150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		tf1.addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
				if (tf1.getText().contains("Invalid")) {
					tf1.setText(null);
					tf1.setForeground(Color.black);
					tf2.setEnabled(true);
					bt.setEnabled(true);
				}
			}

			public void focusLost(FocusEvent e) {
				String A = resource.isAlpha(tf1.getText(), "");
				if (A != null) {
					tf1.setText("Invalid: " + A);
					tf1.setForeground(Color.RED);
					tf1.setFont(font);
					tf2.setEnabled(false);
					bt.setEnabled(false);
				} else
					firstName = tf1.getText();
			}

		});

//		for more than one method should you want to remove 
//		any use eg FocusAdapter instead of FocusListener or
//		KeyAdapter instead of KeyListener

		tf2.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {

				if (tf2.getText().contains("Invalid")) {
					tf2.setText(null);
					tf2.setForeground(Color.black);
					bt.setEnabled(true);
				}

			}

		});

		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String A = resource.isAlpha(tf2.getText(), "");
				if (A != null) {
					tf2.setText("Invalid: " + A);
					tf2.setForeground(Color.RED);
					tf2.setFont(font);
					bt.setEnabled(false);
				} else
					lastName = tf2.getText();

				if (!tf1.getText().contains("Invalid") && !tf2.getText().contains("Invalid")) {
					System.out.println(String.format("First name: %s \nLast name: %s",
							resource.toTitleCase(tf1.getText()), resource.toTitleCase(tf2.getText())));
					firstName = "";
					lastName = "";
					tf1.setText("");
					tf2.setText("");
				}
			}
		});

	}
}

@SuppressWarnings("serial")
class DialogDemo extends JDialog {
	public DialogDemo() {
		setTitle("JDialog");
		setVisible(true);
		setSize(300, 150);
		setDefaultCloseOperation(DialogDemo.EXIT_ON_CLOSE);

	}

}

@SuppressWarnings("serial")
class JPanelDemo extends JFrame {
	JPanel pn;

	public JPanelDemo() {
		pn = new JPanel();
		setTitle("JPanelDemo");
		setVisible(true);
		setSize(300, 200);
		add(pn);
		setDefaultCloseOperation(JPanelDemo.EXIT_ON_CLOSE);
	}
}

@SuppressWarnings("serial")
class JTabbedPaneDemo extends JFrame {
	JTabbedPane tab;

	public JTabbedPaneDemo() {
		tab = new JTabbedPane(JTabbedPane.BOTTOM);
		tab.addTab("Tab1", null);
		tab.addTab("Tab2", null);
		tab.setSize(100, 100);

		setTitle("JTabbedPane");
		setVisible(true);
		setSize(300, 200);
		add(tab);
		setDefaultCloseOperation(JTabbedPaneDemo.EXIT_ON_CLOSE);

	}

}

@SuppressWarnings("serial")
class MenuBarDemo extends JFrame {
	public MenuBarDemo() {
		setJMenuBar(new JMenuBar());
		setTitle("JMenuBar Demo");
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(MenuBarDemo.EXIT_ON_CLOSE);
	}

}

@SuppressWarnings("serial")
class JMenuDemo extends JFrame {
	JMenu fileMenu, editMenu, exitMenu;
	JMenuBar mBar;

	public JMenuDemo() {
		mBar = new JMenuBar();
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		exitMenu = new JMenu("Exit");

		mBar.add(fileMenu);
		mBar.add(editMenu);
		mBar.add(exitMenu);

		JMenuItem _new = new JMenuItem("New");
		JMenuItem open = new JMenuItem("Open");
		JMenu rfile = new JMenu("Recent Files");
		fileMenu.add(_new);
		fileMenu.add(open);
		fileMenu.add(rfile);

		JMenuItem f1 = new JMenuItem("file1");
		JMenuItem f2 = new JMenuItem("flle1");
		JMenuItem f3 = new JMenuItem("flle1");
		rfile.add(f1);
		rfile.add(f2);
		rfile.add(f3);

		JMenuItem undo = new JMenuItem("New");
		JMenuItem redo = new JMenuItem("Open");
		JMenuItem copy = new JMenuItem("New");
		JMenuItem paste = new JMenuItem("Open");
		editMenu.add(undo);
		editMenu.add(redo);
		editMenu.add(copy);
		editMenu.add(paste);

		setJMenuBar(mBar);
		setTitle("MenuBar Demo");
		setVisible(true);
		setSize(300, 300);
		setDefaultCloseOperation(JMenuDemo.EXIT_ON_CLOSE);

	}
}

@SuppressWarnings("serial")
class JLabelDemo extends JFrame {
	public JLabelDemo() {

		// 1st method,

//		JLabel fName = new JLabel();
//		fName.setText("First name:");

		// 2nd method

//		JLabel fName = new JLabel("First name:");

		// 3rd method with horizontal Alignment

//		JLabel fName = new JLabel("First name:", JLabel.LEFT);
//		JLabel lName = new JLabel("Last name:", JLabel.RIGHT);
//		JLabel age = new JLabel("Age:", JLabel.CENTER);
//		JLabel phone = new JLabel("Phone:", JLabel.LEADING);
//		JLabel email = new JLabel("Email:",JLabel.TRAILING);
////		JLabel phone = new JLabel("Phone:", JLabel.RIGHT);

//	   ImageIcon im = new ImageIcon("src/GUI/R.jpg");

//	   3rd method

//		JLabel phone = new JLabel("Phone:", im, JLabel.RIGHT);

//		fName.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//		lName.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//		age.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//		phone.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//		email.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
//	
//		add(fName);
//		add(lName);
//		add(age);
//		add(phone);
//		add(email);
//	    add(new JLabel(im));

		setTitle("JLabel");
		setLayout(new FlowLayout());
		JLabel lb = new JLabel("Welcome");

//		change the first to second one....
//		lb.setText("Swing");
//		add(lb);

		Font font = new Font("verdana", Font.BOLD, 15); // text font
		Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY); // creating border
		ImageIcon im = new ImageIcon("R.jpg"); // not working
		lb.setForeground(Color.DARK_GRAY);
		lb.setBackground(Color.YELLOW);
		lb.setHorizontalAlignment(JLabel.CENTER);
//		lb.setDisplayedMnemonic('W');
//		lb.setDisplayedMnemonic(KeyEvent.VK_W); 
//		lb.setDisplayedMnemonicIndex(6);

		JPanel jp = new JPanel();
		setLayout(new FlowLayout());
		lb.setToolTipText("Welcome Label");
		lb.setBorder(border);
		lb.setOpaque(true);
		lb.setFont(font);
		lb.setIcon(im); //
//		add(new JLabel(lb.getIcon()));  // setting additional image...not sure
//		jp.add(lb);
//		add(jp);
//		lb.setEnabled(false);
//		lb.setDisabledIcon(im);
//		System.out.println(lb.getBackground());

//		Aligning Image Text in relation to image
//		JLabel jl = new JLabel("Welcome,image,JLabel.LEFT");
//		add(jl)
//		jl.setHorizontalTextPosition(JLabel.RIGHT);
//		jl.setHorizontalTextPoition(JLabel.LEFT);
//		jl.setVerticalTextPoition(JLabel.TOP);
//		jl.setVerticalTextPoition(JLabel.BOTTOM);
		// SETIING GAP
//		jl.setIconTextGap(10);

//		CREATE TEXTFIELD
		Font tfont = new Font("New Times Romaon", Font.TYPE1_FONT, 13);
		JLabel tl1 = new JLabel("Username");
//		tl.setDisplayedMnemonic('U');
		tl1.setFont(tfont);
		JTextField tf1 = new JTextField(10);
		JLabel tl2 = new JLabel("Password");
		tl2.setFont(tfont);
		JTextField tf2 = new JTextField(10);
		tl1.setLabelFor(tf1);
		tl2.setLabelFor(tf2);
//		tp.setDisplayedMnemonic('P');
		System.out.println(tf1.getText());

		jp.add(tl1);
		jp.add(tf1);
		jp.add(tl2);
		jp.add(tf2);
		GridLayout gd = new GridLayout();
		gd.setRows(2);
		gd.setColumns(20);
		gd.setHgap(-37);
		gd.setVgap(10);
		jp.setLayout(gd);
		add(jp);
		System.out.println(tf1.getName());

		setSize(220, 130);
		setVisible(true);
//		getContentPane().setLayout(new GridLayout(5,1));  //innital parameter
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
