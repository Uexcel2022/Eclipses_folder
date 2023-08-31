package hangmangame;
import resources.resource;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI_HangMan {
	
	
	public static void main(String[] args) {
	  new GUI_HangMan();
	}
	
	
	public GUI_HangMan() {
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
				t2.setEditable(false);
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
