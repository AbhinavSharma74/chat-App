package com.brainmentors.chatapp.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.brainmentors.chatapp.dao.UserDAO;
import com.brainmentors.chatapp.dto.UserDTO;

public class UserScreen extends JFrame{
	private JTextField useridtxt;
	private JPasswordField passwordField;

	
	public static void main(String[] args) {
	
					UserScreen window = new UserScreen();
					
	}
	UserDAO userDAO = new UserDAO();
	private void doLoin() {
		String userid = useridtxt.getText();
		char []password = passwordField.getPassword();
		
		UserDTO userDTO = new UserDTO(userid, password);
			try {
			String message = "";
			if(userDAO.islogin(userDTO)){
					message = "Welcome "+userid;
					JOptionPane.showMessageDialog(this, message);
					setVisible(false);
					dispose();
					DashBoard dashBoard = new DashBoard(message);
					dashBoard.setVisible(true);
					
			}
			else {
				message =  "Invalid userid or Password ";
				JOptionPane.showMessageDialog(this, message);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void register() {
		String userid = useridtxt.getText();
		char []password = passwordField.getPassword();
		UserDAO userDAO = new UserDAO();
		UserDTO userDTO = new UserDTO(userid, password);
		try {
		int result = userDAO.add(userDTO);
		if (result>0) {
			JOptionPane.showMessageDialog(this, "Register Successfully");
			//System.out.println("Record Added...");
		}
		else {
			JOptionPane.showMessageDialog(this, "Register fail");
		}
		}
		catch (ClassNotFoundException |SQLException ex) {
			System.out.println("DB Issue...");
			ex.printStackTrace();
		}
		catch (Exception ex) {
		System.out.println("Some Generic exception Raised...");
		ex.printStackTrace();//Where is the Exception
		}
		System.out.println("userid "+userid+" Password "+password); //Prints ClassName@HashCode(in Hexadecimal form)
	}

	/**
	 * Create the application.
	 */
	public UserScreen() {
		getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		setBackground(Color.WHITE);
		setResizable(false);
		setTitle("LOGIN");
		getContentPane().setBackground(Color.WHITE);
		
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(281, 50, 209, 61);
		getContentPane().add(lblNewLabel);
		
		useridtxt = new JTextField();
		useridtxt.setFont(new Font("Tahoma", Font.BOLD, 13));
		useridtxt.setBounds(306, 121, 219, 31);
		getContentPane().add(useridtxt);
		useridtxt.setColumns(10);
		
		JLabel UserIDlbl = new JLabel("UserID");
		UserIDlbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserIDlbl.setBounds(187, 130, 73, 22);
		getContentPane().add(UserIDlbl);
		
		JLabel pwdlbl = new JLabel("Password");
		pwdlbl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pwdlbl.setBounds(187, 239, 84, 31);
		getContentPane().add(pwdlbl);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(306, 237, 219, 31);
		getContentPane().add(passwordField);
		
		JButton loginbt = new JButton("Login");
		loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doLoin();
			}
		});
		loginbt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		loginbt.setBounds(257, 339, 85, 31);
		getContentPane().add(loginbt);
		
		JButton registerbt = new JButton("Register");
		registerbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				register();
			}
		});
		registerbt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		registerbt.setBounds(450, 339, 119, 31);
		getContentPane().add(registerbt);
		setSize(808, 464);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
	}
}
