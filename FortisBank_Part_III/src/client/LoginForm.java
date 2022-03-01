package client;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;

public class LoginForm {

	private JFrame frame;
	private JTextField txtUserName;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginForm window = new LoginForm();
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
	public LoginForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Fortis Bank");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel.setBounds(190, 11, 253, 57);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(117, 79, 399, 284);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Details");
		lblNewLabel_1.setBounds(153, 11, 101, 29);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtUserName.setText("manpreet");
		txtUserName.setBounds(139, 55, 200, 27);
		panel.add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtPassword.setEchoChar('*');
		txtPassword.setBounds(139, 105, 200, 27);
		panel.add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogin.setBounds(139, 155, 200, 30);
		panel.add(btnLogin);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setBounds(51, 55, 87, 27);
		panel.add(lblUserName);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(51, 105, 87, 27);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JButton btnExit = new JButton("Exit");
		
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExit.setBounds(139, 213, 200, 30);
		panel.add(btnExit);
		
		JLabel lblNewLabel_2 = new JLabel("Username : Manpreet");
		lblNewLabel_2.setBounds(316, 386, 116, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password : 1234");
		lblNewLabel_2_1.setBounds(443, 386, 116, 14);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		
		txtUserName.setText("Manpreet");
		txtPassword.setText("1234");
		
		// button login is used to validate the user detail and provide access to the application
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = txtUserName.getText();
				@SuppressWarnings("deprecation")
				String password = txtPassword.getText();
				
				if(username.equals("Manpreet") && password.equals("1234"))
				{
					frame.dispose();
					Dashboard dashboard = new Dashboard();
					dashboard.setVisible(true);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Invalid Username or Password");
				}
				
				
				
			}
		});
		
		
		
		// button exit is used to exit the application
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog( frame,"You Want to Exit","Fortis Bank System",
			            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			            System.exit(0);
			}
		});
	}
}
