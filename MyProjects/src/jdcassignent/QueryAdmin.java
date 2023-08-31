package jdcassignent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class QueryAdmin {

	public static void tableQueries(String discription, String condition) {
		String labelName = "";

		if (discription != null) {
			switch (discription) {
			case "DepartmentName":
				labelName = "Department Name";
				break;

			case "FacultyName":
				labelName = "Faculty Name";
				break;
			case "AdmissionYear":
				labelName = "Year Of Addmission";
				break;

			default:
				return;
			}
		}

		String matricNumber = null;
		String obj = null;
		DefaultTableModel DM;

		JButton homeButton = new JButton("Back");
		homeButton.setFocusPainted(false);
		homeButton.setBackground(Color.white);
		homeButton.setBounds(200, 465, 100, 25);
		homeButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		if (discription == null || condition == null) {
			String[] columns = { "Matriculation Number" };
			DM = new DefaultTableModel(columns, 0);
		} else {
			String[] columns = { "Matriculation Number", labelName };
			DM = new DefaultTableModel(columns, 0);
		}

		JTable tabel = new JTable(DM);
		tabel.setFont(new Font(" ", Font.PLAIN, 15));
		tabel.setFillsViewportHeight(true);
		tabel.getTableHeader().setFont(new Font(" ", Font.BOLD, 15));

		JScrollPane scrollPane = new JScrollPane(tabel);

		scrollPane.setBounds(30, 5, 440, 450);
		tabel.setPreferredSize(new Dimension(400, 500));
		tabel.setRowHeight(25);

		Statement statement = Connector.createStatement();

		String query1 = "SELECT MatricNumber FROM student";

		String query2 = String.format(
				"SELECT MatricNumber, %s FROM `student`s JOIN department d ON s.DepartmentCode = "
						+ "d.DepartmentCode JOIN faculty f ON d.FacultyCode = f.FacultyCode WHERE %s = '%s'",
				discription, discription, condition);
		try {
			ResultSet data;
			if (discription == null || condition == null) {
				data = statement.executeQuery(query1);
			} else {
				data = statement.executeQuery(query2);
			}

			while (data.next()) {
				matricNumber = data.getString("MatricNumber");
				if (discription != null || condition != null) {
					obj = data.getString(discription);
				}
				String[] tableValues = { matricNumber, obj };
				DM.addRow(tableValues);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "We ecountered error!", "Error", JOptionPane.ERROR_MESSAGE);
		}

		JFrame frame = new JFrame("Matriculation Numbers");
		frame.setLayout(new FlowLayout());
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(500, 500));
		panel.setLayout(null);

		frame.setSize(500, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(scrollPane);
		panel.add(homeButton);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();

		homeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminLogin.queryInterface();
			}

		});
	}

	public static void main(String[] args) {
//		QueryAdmin.studentDetails();
	}

	public static void studentDetails() {

		String matricNumber = null;
		String surname = null;
		String otherNames = null;
		String department = null;
		String faculty = null;

		DefaultTableModel DM = null;

		JButton homeButton = new JButton("Back");
		homeButton.setFocusPainted(false);
		homeButton.setBackground(Color.white);
		homeButton.setBounds(330, 465, 100, 25);
		homeButton.setBorder(BorderFactory.createLineBorder(Color.lightGray, 1, true));

		String[] columns = { "Matriculation Number", "Surname", "Other Name", "Department", "Faculty" };

		DM = new DefaultTableModel(columns, 0);

		JTable tabel = new JTable(DM);
		tabel.setFont(new Font(" ", Font.PLAIN, 15));
		tabel.setFillsViewportHeight(true);
		tabel.getTableHeader().setFont(new Font(" ", Font.BOLD, 15));

		JScrollPane scrollPane = new JScrollPane(tabel);

		scrollPane.setBounds(30, 5, 730, 450);
		tabel.setPreferredSize(new Dimension(400, 500));
		tabel.setRowHeight(25);

		Statement statement = Connector.createStatement();

		String query2 = String.format(
				"SELECT MatricNumber, Surname, OtherNames, DepartmentName, FacultyName FROM `student`s JOIN department d ON s.DepartmentCode = "
						+ "d.DepartmentCode JOIN faculty f ON d.FacultyCode = f.FacultyCode");

		try {

			ResultSet data = statement.executeQuery(query2);

			while (data.next()) {
				matricNumber = data.getString("MatricNumber");
				surname = data.getString("Surname");
				otherNames = data.getString("OtherNames");
				department = data.getString("DepartmentName");
				faculty = data.getString("FacultyName");

				String[] tableValues = { matricNumber, surname, otherNames, department, faculty };
				DM.addRow(tableValues);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "We ecountered error!", "Error", JOptionPane.ERROR_MESSAGE);
		}

		JFrame frame = new JFrame("Student Details");
		frame.setLayout(new FlowLayout());
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(800, 500));
		panel.setLayout(null);

		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(scrollPane);
		panel.add(homeButton);
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();

		homeButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AdminLogin.queryInterface();
			}

		});

	}

}
