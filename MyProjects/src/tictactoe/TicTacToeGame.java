package tictactoe;

import java.awt.BorderLayout;
import java.util.Random;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


@SuppressWarnings("serial")
public class TicTacToeGame extends JFrame {
	JTextArea textArea;
	JButton btn;
	JButton btn1;
	JButton btn2;
	JButton btn3;
	JButton btn4;
	JButton btn5;
	JButton btn6;
	JButton btn7;
	JButton btn8;
	JButton resetBtn;

	Font gameBoardFont;
	Font textAreaFont;
	String player = "";
	String currentPlayer = "";
	boolean win = false;
	

	int[][] winCondition = { { 0, 1, 2, }, { 3, 4, 5 }, { 6, 7, 8 }, { 0, 3, 6 }, { 1, 4, 7 }, { 2, 5, 8 }, { 0, 4, 8 },
			{ 2, 4, 6 } };

	String[] options = { "", "", "", "", "", "", "", "", "" };

	public static void main(String[] args) {
		new TicTacToeGame();

	}

	TicTacToeGame() {

		gameBoardFont = new Font("Comic Sans MS", Font.TYPE1_FONT, 60);
		textAreaFont = new Font("Comic Sans MS", Font.TYPE1_FONT, 30);
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setSize(474,50);
		textArea.setBackground(Color.decode("#B2D3C2"));;
		textArea.setFont(textAreaFont);
		textArea.setEditable(false);
		textArea.setFocusable(false);

		JPanel textAreaPanel = new JPanel();
		textAreaPanel.setPreferredSize(new Dimension(478, 50));
		textAreaPanel.setLayout(new BorderLayout());
		textAreaPanel.add(textArea, BorderLayout.CENTER);
		textAreaPanel.setBackground(Color.decode("#B2D3C2"));
		textAreaPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#7F7D9C"),1, true));

		btn = new JButton();
		btn.setPreferredSize(new Dimension(150, 150));
		btn.setBackground(Color.decode("#B2D3C2"));
		btn.setFocusPainted(false);
		btn.setFont(gameBoardFont);

		btn1 = new JButton();
		btn1.setPreferredSize(new Dimension(150, 150));
		btn1.setBackground(Color.decode("#B2D3C2"));
		btn1.setFocusPainted(false);
		btn1.setFont(gameBoardFont);

		btn2 = new JButton();
		btn2.setPreferredSize(new Dimension(150, 150));
		btn2.setBackground(Color.decode("#B2D3C2"));
		btn2.setFocusPainted(false);
		btn2.setFont(gameBoardFont);

		btn3 = new JButton();
		btn3.setPreferredSize(new Dimension(150, 150));
		btn3.setBackground(Color.decode("#B2D3C2"));
		btn3.setFocusPainted(false);
		btn3.setFont(gameBoardFont);

		btn4 = new JButton();
		btn4.setPreferredSize(new Dimension(150, 150));
		btn4.setBackground(Color.decode("#B2D3C2"));
		btn4.setFocusPainted(false);
		btn4.setFont(gameBoardFont);

		btn5 = new JButton();
		btn5.setPreferredSize(new Dimension(150, 150));
		btn5.setBackground(Color.decode("#B2D3C2"));
		btn5.setFocusPainted(false);
		btn5.setFont(gameBoardFont);

		btn6 = new JButton();
		btn6.setPreferredSize(new Dimension(150, 150));
		btn6.setBackground(Color.decode("#B2D3C2"));
		btn6.setFocusPainted(false);
		btn6.setFont(gameBoardFont);

		btn7 = new JButton();
		btn7.setPreferredSize(new Dimension(150, 150));
		btn7.setBackground(Color.decode("#B2D3C2"));
		btn7.setFocusPainted(false);
		btn7.setFont(gameBoardFont);

		btn8 = new JButton();
		btn8.setPreferredSize(new Dimension(150, 150));
		btn8.setBackground(Color.decode("#B2D3C2"));
		btn8.setFocusPainted(false);
		btn8.setFont(gameBoardFont);

		JPanel btnPanel = new JPanel();
		btnPanel.setPreferredSize(new Dimension(450, 20));
		btnPanel.setLayout(new BorderLayout(0,0));
		btnPanel.setBackground(Color.decode("#B2D3C2"));
		
		
		resetBtn = new JButton();
		resetBtn.setPreferredSize(new Dimension(225, 10));
		resetBtn.setBackground(Color.darkGray);
		resetBtn.setFocusPainted(false);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(480, 540));
		mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 1, 0));
		mainPanel.setBackground(Color.decode("#B2D3C2"));
		mainPanel.setBorder(BorderFactory.createLineBorder(Color.decode("#7F7D9C"),2, true));
		
		
		
		mainPanel.add(textAreaPanel);
		mainPanel.add(btn);
		mainPanel.add(btn1);
		mainPanel.add(btn2);
		mainPanel.add(btn3);
		mainPanel.add(btn4);
		mainPanel.add(btn5);
		mainPanel.add(btn6);
		mainPanel.add(btn7);
		mainPanel.add(btn8);
		btnPanel.add(resetBtn, BorderLayout.SOUTH);
		mainPanel.add(btnPanel);
		this.add(mainPanel);

		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0)); // the 3rd and 4th value is margin
		this.setSize(520, 590);
		this.setResizable(false);
		this.setVisible(true);
		this.setTitle("Tic Tac Toe Game");
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ImageIcon image = new ImageIcon("src/TicTacToe/R.jpg");
		this.setIconImage(image.getImage());

		actionListers();
		currentPlayer = FirstToPlay();

	}

	public void winCondition() {

		String cellA;
		String cellB;
		String cellC;

		for (int n[] : winCondition) {
			cellA = options[n[0]];
			cellB = options[n[1]];
			cellC = options[n[2]];
			if (!cellA.isEmpty()) {
				if (cellA.equals(cellB) && cellA.equals(cellC)) {
					textArea.setText(currentPlayer + " Wins! Congratulations... :(");
					win = true;
					return;
				}
			}
		}

		boolean isFilled = true;
		for (String o : options) {
			if (o.isEmpty()) {
				isFilled = false;
				break;
			}
		}

		if (isFilled) {
			textArea.setText("Draw!");
		}

	}

	public void actionListers() {
		btn.addActionListener(e -> {
			if (btn.getText() == "" && win == false) {
				player = playerTurn();
				btn.setText(player);
				options[0] = player;
				currentPlayer = player;
			}
		});

		btn1.addActionListener(e -> {
			if (btn1.getText() == "" && win == false) {
				player = playerTurn();
				btn1.setText(player);
				options[1] = player;
				currentPlayer = player;
				winCondition();

			}
		});

		btn2.addActionListener(e -> {
			if (btn2.getText() == "" && win == false) {
				player = playerTurn();
				btn2.setText(player);
				options[2] = player;
				currentPlayer = player;
				winCondition();
			}
		});

		btn3.addActionListener(e -> {
			if (btn3.getText() == "" && win == false) {
				player = playerTurn();
				btn3.setText(player);
				options[3] = player;
				currentPlayer = player;
				winCondition();
			}
		});

		btn4.addActionListener(e -> {
			if (btn4.getText() == "" && win == false) {
				player = playerTurn();
				btn4.setText(player);
				options[4] = player;
				currentPlayer = player;
				winCondition();
			}
		});

		btn5.addActionListener(e -> {
			if (btn5.getText() == "" && win == false) {
				player = playerTurn();
				btn5.setText(player);
				options[5] = player;
				currentPlayer = player;
				winCondition();
			}
		});

		btn6.addActionListener(e -> {
			if (btn6.getText() == "" && win == false) {
				player = playerTurn();
				btn6.setText(player);
				options[6] = player;
				currentPlayer = player;
				winCondition();
			}
		});

		btn7.addActionListener(e -> {
			if (btn7.getText() == "" && win == false) {
				player = playerTurn();
				btn7.setText(player);
				options[7] = player;
				currentPlayer = player;
				winCondition();
			}
		});

		btn8.addActionListener(e -> {
			if (btn8.getText() == "" && win == false) {
				player = playerTurn();
				btn8.setText(player);
				options[8] = player;
				currentPlayer = player;
				winCondition();
			}
		});

		resetBtn.addActionListener(e -> {
			options[0] = "";
			options[1] = "";
			options[2] = "";
			options[3] = "";
			options[4] = "";
			options[5] = "";
			options[6] = "";
			options[7] = "";
			options[8] = "";
			btn.setText("");
			btn1.setText("");
			btn2.setText("");
			btn3.setText("");
			btn4.setText("");
			btn5.setText("");
			btn6.setText("");
			btn7.setText("");
			btn8.setText("");
			textArea.setText("");
			player ="";
			win = false;
			currentPlayer = FirstToPlay();

		});

	}

	public String playerTurn() {
		String player = currentPlayer == "X" ? "O" : "X";
		return player;
	}
	
	public String FirstToPlay() {
		String[] players = {"O", "X"};
		Random random = new Random();
		int index = random.nextInt(0,2);
		return players[index];
	}
}
