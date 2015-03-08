package com.hibernet.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;

import javax.swing.Action;

import com.hibernet.practice.EmployeeService;

import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;

public class EmployeeManagementGUI {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeManagementGUI window = new EmployeeManagementGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeeManagementGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 67, 201, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 117, 201, 23);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton Create = new JButton("Create");
		Create.setForeground(Color.ORANGE);
		Create.setBackground(Color.ORANGE);
		Create.setToolTipText("Create");
		Create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeService employeeService = new EmployeeService();
				employeeService.createEmployee(textField.getText(), textField_1.getText());
			}
		});
		Create.setBounds(10, 193, 89, 23);
		frame.getContentPane().add(Create);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 51, 79, 14);
		frame.getContentPane().add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 101, 62, 14);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblEmployeeRegistration = new JLabel("Employee Registration");
		lblEmployeeRegistration.setFont(new Font("Traditional Arabic", Font.BOLD, 20));
		lblEmployeeRegistration.setBounds(119, 11, 215, 23);
		frame.getContentPane().add(lblEmployeeRegistration);
		
		JRadioButton radioButton = new JRadioButton("Male");
		radioButton.setBounds(10, 147, 47, 36);
		frame.getContentPane().add(radioButton);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(70, 147, 62, 34);
		frame.getContentPane().add(rdbtnFemale);
	}
}
