package mysql;

import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//1. need 2 arrays table column name and Tabel value
//2. DefaultTableModel(DM) pass column array and colomn count into constructor 
//3. JTable pass DM object into constructor
//4. JScrollPane pass JTable object into the construct
//5. add tabel value to DM object in the loop,

@SuppressWarnings("serial")
public class JTabel extends JFrame {
	String firstName;
	String lastName;
	String gender;
	String phone;
	String email;
	String username;
	String password;
	Statement sqtStatement;

	public JTabel() {

		String[] columns = { "FirstName", "LastName", "Gender", "Phone", "Email", "Username", "Password" };

		DefaultTableModel DM = new DefaultTableModel(columns, 0);
		JTable table = new JTable(DM);
		table.setBounds(20, 5, 750, 750);
		table.setForeground(Color.black);
		table.setBackground(Color.white);
		table.setVisible(true);

		JScrollPane scroll = new JScrollPane(table);

		scroll.setBounds(20, 5, 750, 340);

		this.setTitle("Login Tabel data");
		this.setSize(800, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.add(scroll);

		try {
			sqtStatement = Connector.creatStatment();
			String query = "SELECT * FROM login";
			ResultSet data = sqtStatement.executeQuery(query);

			while (data.next()) {
				firstName = data.getString("firstname");
				lastName = data.getString("lastname");
				gender = data.getString("gender");
				phone = data.getString("phone");
				email = data.getString("email");
				username = data.getString("username");
				password = data.getString("password");

				String[] tableValue = { firstName, lastName, gender, phone, email, username, password };
				DM.addRow(tableValue);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "Error occurred!", "Error", JOptionPane.ERROR_MESSAGE);
		}
		this.setVisible(true);

	}

	public static void main(String[] args) {
		new JTabel();
	}

}
