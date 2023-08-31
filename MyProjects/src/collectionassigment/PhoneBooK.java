package collectionassigment;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class PhoneBooK {
	JFrame menuFrame;
	JFrame contactFrame;
	JFrame contactDetailsFrame;
	JFrame addContactFrame;
	JPanel menuPanel;
	String selectedContact;
	int selectedItemIndex;
	JList<String> listName;
	ArrayList<Contacts> phoneBook;
	String[] contactDetails;
	Font menuLabelFont = new Font("null", Font.PLAIN, 30);
	Font buttonFont = new Font("null", Font.PLAIN, 20);
	Font contactItmFont = new Font("null", Font.PLAIN, 18);

	public PhoneBooK() {
		phoneBook = new ArrayList<>();
		contactLoader();
		menu();
	}

	public void viewContactDetails() {
		contactFrame.dispose();
		Font contactItmFont = new Font("null", Font.PLAIN, 20);
		Font numberFont = new Font("null", Font.PLAIN, 16);
		JLabel nameLabel = new JLabel();
		JLabel numberLabel = new JLabel();
		nameLabel.setBounds(50, 50, 300, 25);
		nameLabel.setFont(contactItmFont);
		numberLabel.setFont(numberFont);
		numberLabel.setBounds(50, 80, 200, 25);

		JButton backButton = new JButton("Beck");
		backButton.setBounds(145, 300, 100, 25);
		backButton.setBackground(Color.white);
		backButton.setFocusPainted(false);

		String[] splitedContact = (contactDetails[selectedItemIndex]).split(":");

		nameLabel.setText(splitedContact[0]);
		numberLabel.setText(splitedContact[1]);

		JPanel panel = new JPanel();
		JPanel mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(400, 400));

		panel.setPreferredSize(new Dimension(340, 280));
		panel.setBounds(30, 5, 340, 280);

		panel.setLayout(null);
		mainPanel.setLayout(null);

		panel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		panel.add(nameLabel);
		panel.add(numberLabel);
		mainPanel.add(panel);
		mainPanel.add(backButton);
		ImageIcon icon = new ImageIcon("R.jpg");
		contactDetailsFrame = new JFrame("Phone Book");
		contactDetailsFrame.setIconImage(icon.getImage());
		contactDetailsFrame.setSize(400, 400);
		contactDetailsFrame.setLayout(new FlowLayout());
		contactDetailsFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contactDetailsFrame.add(mainPanel);
		contactDetailsFrame.setVisible(true);

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				contactDetailsFrame.dispose();
				contactNames();
			}

		});

	}

	private void contactNames() {

		Collections.sort(phoneBook, contactsComparator);

		String[] contactNames = new String[phoneBook.size()];
		contactDetails = new String[phoneBook.size()];

		int i = 0;
		for (Contacts n : phoneBook) {
			contactDetails[i] = n.getName() + ":" + n.getNumber();
			contactNames[i] = n.getName();
			i++;
		}

		listName = new JList<>(contactNames);

		listName.setBackground(Color.getColor("whitesmoke"));
		listName.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		listName.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		listName.setBounds(30, 5, 340, 280);
		listName.setFont(contactItmFont);

		JButton backButton = new JButton("Beck");
		backButton.setBounds(145, 300, 100, 25);
		backButton.setBackground(Color.white);
		backButton.setFocusPainted(false);
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(400, 400));
		panel.setLayout(null);
		panel.add(listName);
		panel.add(backButton);
		ImageIcon icon = new ImageIcon("R.jpg");
		contactFrame = new JFrame("Phone Book");
		contactFrame.setIconImage(icon.getImage());
		contactFrame.setSize(400, 400);
		contactFrame.setLayout(new FlowLayout());
		contactFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contactFrame.add(panel);
		contactFrame.setVisible(true);

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				contactFrame.dispose();
				menu();
			}

		});

		listName.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent event) {
				if (event.getClickCount() == 2) {
					contactFrame.dispose();
					selectedItemIndex = listName.getSelectedIndex();
					viewContactDetails();

				}

			}

		});

	}

	public void addContact() {
		Font contactItmFont = new Font("null", Font.PLAIN, 20);
		Font numberFont = new Font("null", Font.PLAIN, 16);
		JLabel nameLabel = new JLabel("Name:");
		JLabel numberLabel = new JLabel("Number:");
		JTextField nameTextField = new JTextField();
		JTextField numberTextField = new JTextField();
		nameLabel.setLabelFor(nameTextField);
		numberLabel.setLabelFor(numberTextField);

		nameLabel.setBounds(20, 100, 100, 25);
		nameTextField.setBounds(100, 100, 210, 25);

		numberLabel.setBounds(20, 140, 100, 25);
		numberTextField.setBounds(110, 140, 200, 25);

		nameLabel.setFont(contactItmFont);
		nameTextField.setFont(numberFont);
		numberLabel.setFont(contactItmFont);
		numberTextField.setFont(numberFont);

		JButton backButton = new JButton("Back");
		JButton saveButton = new JButton("Save");
		backButton.setBounds(205, 300, 100, 25);
		saveButton.setBounds(95, 300, 100, 25);
		backButton.setBackground(Color.white);
		saveButton.setBackground(Color.white);
		backButton.setFocusPainted(false);
		saveButton.setFocusPainted(false);

		JPanel panel = new JPanel();
		JPanel mainPanel = new JPanel();
		mainPanel.setPreferredSize(new Dimension(400, 400));

		panel.setPreferredSize(new Dimension(340, 280));
		panel.setBounds(30, 5, 340, 280);

		panel.setLayout(null);
		mainPanel.setLayout(null);

		panel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		panel.add(nameLabel);
		panel.add(nameTextField);
		panel.add(numberLabel);
		panel.add(numberTextField);
		mainPanel.add(panel);
		mainPanel.add(backButton);
		mainPanel.add(saveButton);
		ImageIcon icon = new ImageIcon("R.jpg");
		addContactFrame = new JFrame("Phone Book");
		addContactFrame.setIconImage(icon.getImage());
		addContactFrame.setSize(400, 400);
		addContactFrame.setLayout(new FlowLayout());
		addContactFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		addContactFrame.add(mainPanel);
		addContactFrame.setVisible(true);

		backButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				addContactFrame.dispose();
				menu();
			}

		});

		saveButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!nameTextField.getText().isEmpty() && !numberTextField.getText().isEmpty()) {
					int previousSize = phoneBook.size();
					phoneBook.add(new Contacts(nameTextField.getText(), numberTextField.getText()));
					if (phoneBook.size() > previousSize) {
						JOptionPane.showMessageDialog(addContactFrame, "Saved", "Contacts",
								JOptionPane.INFORMATION_MESSAGE);
						menu();
					} else
						JOptionPane.showMessageDialog(addContactFrame, "Error! \nContact not saved.", "Contacts",
								JOptionPane.ERROR);

				} else
					JOptionPane.showMessageDialog(addContactFrame, "Fill the contact form!", "Contacts",
							JOptionPane.WARNING_MESSAGE);

			}

		});

	}

	public void menu() {

		ImageIcon icon = new ImageIcon("R.jpg");
		menuFrame = new JFrame("Phone Book");
		menuFrame.setIconImage(icon.getImage());
		menuFrame.setSize(400, 400);
		menuFrame.setLayout(new FlowLayout());
		menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		menuPanel = new JPanel();
		JLabel menu = new JLabel("MENU");
		JButton addContact = new JButton("Add Contact");
		JButton viewContact = new JButton("View Contact");
		menu.setBounds(125, 70, 200, 40); // 155
		viewContact.setBounds(70, 120, 200, 40);
		addContact.setBounds(70, 170, 200, 40);
		menuPanel.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		viewContact.setFont(buttonFont);
		addContact.setFont(buttonFont);
		menu.setFont(menuLabelFont);

		addContact.setBackground(Color.white);
		addContact.setFocusPainted(false);
		viewContact.setBackground(Color.white);
		viewContact.setFocusPainted(false);

		menuPanel.setPreferredSize(new Dimension(340, 335));
		menuPanel.setLayout(null);

		menuPanel.add(menu);
		menuPanel.add(viewContact);
		menuPanel.add(addContact);

		menuFrame.add(menuPanel);
		menuFrame.setVisible(true);

		viewContact.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				contactNames();

			}

		});

		addContact.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				addContact();

			}

		});

	}

	public void contactLoader() {

		phoneBook.add(new Contacts("Udoka", "08038263824"));
		phoneBook.add(new Contacts("Jide", "08038263800"));
		phoneBook.add(new Contacts("Mercy", "07038263881"));
		phoneBook.add(new Contacts("Tolu", "07039263881"));
		phoneBook.add(new Contacts("Jide", "08038263403"));
	}

	public static Comparator<Contacts> contactsComparator = new Comparator<>() {

		@Override
		public int compare(Contacts obj1, Contacts obj2) {

			return obj1.getName().compareTo(obj2.getName());
		}
	};

}

class Contacts {
	private String name;
	private String number;

	public Contacts(String name, String number) {
		this.name = name;
		this.number = number;
	}

	public Contacts(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
