package com.brainmentors.chatapp.views;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserView extends JFrame {
	int counter = 0;
	public UserView() {
		
		
		//FOR CREATING A WINDOW
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		setSize(500,500);
		setResizable(false);
		setTitle("Login");
//		setLocation(500,500);
		setLocationRelativeTo(null);
		
		//ADDING A LAYER TO THE WINDOW, IN THIS LOGIN LAYER
		JLabel welcome = new JLabel("Login");               //LOGIN IS SHOWN ON THE LAYER
		welcome.setFont(new Font("Arial",Font.BOLD,40));    //COMPONENTS OF LOGIN
		Container Container = this.getContentPane();        //CONTENT AREA ON THE FRAME
		Container.setLayout(null);                          //DECIDING THE LAYOUT BY OURSELF
		welcome.setBounds(100, 70,200 , 60);
		Container.add(welcome);
		
		//ADDING BUTTON 
		JButton button = new JButton("Count");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				// TODO Auto-generated method stub
				counter++;
				welcome.setText("Count" + counter);
				
		}
		});
		button.setBounds(100, 300, 200, 50);
		Container.add(button);
		
		
		
		setVisible(true);
		
	}
	public static void main(String[] args) {
		UserView userView = new UserView();
	}

}
