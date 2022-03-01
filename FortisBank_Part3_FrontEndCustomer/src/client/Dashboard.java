package client;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Dashboard extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static Dashboard frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Dashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Please choose a service to continue");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(361, 51, 278, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to Fortis Bank");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel_1.setBounds(324, 10, 353, 45);
		contentPane.add(lblNewLabel_1);
		
		JButton btnExit = new JButton("Exit");
		
		btnExit.setForeground(new Color(0, 0, 0));
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExit.setBackground(UIManager.getColor("Button.background"));
		btnExit.setBounds(675, 235, 250, 70);
		contentPane.add(btnExit);
		
		
		// All Buttons to open different forms
		
		JButton btnViewAccountInformation = new JButton("View account Information");
		
		btnViewAccountInformation.setForeground(new Color(0, 0, 0));
		btnViewAccountInformation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnViewAccountInformation.setBackground(UIManager.getColor("Button.background"));
		btnViewAccountInformation.setBounds(75, 111, 250, 70);
		contentPane.add(btnViewAccountInformation);
		
		
		JButton btnWithdrawMoney = new JButton("Withdraw Money");
		btnWithdrawMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnWithdrawMoney.setForeground(Color.BLACK);
		btnWithdrawMoney.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnWithdrawMoney.setBackground(UIManager.getColor("Button.background"));
		btnWithdrawMoney.setBounds(375, 111, 250, 70);
		contentPane.add(btnWithdrawMoney);
		
		JButton btnDepositMoney = new JButton("Deposit Money");
		
		btnDepositMoney.setForeground(Color.BLACK);
		btnDepositMoney.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDepositMoney.setBackground(UIManager.getColor("Button.background"));
		btnDepositMoney.setBounds(675, 111, 250, 70);
		contentPane.add(btnDepositMoney);
		
		JButton btnTransferMoney = new JButton("Transfer Money");
		
		btnTransferMoney.setForeground(Color.BLACK);
		btnTransferMoney.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTransferMoney.setBackground(UIManager.getColor("Button.background"));
		btnTransferMoney.setBounds(375, 235, 250, 70);
		contentPane.add(btnTransferMoney);
		
		//Button Action to open view transaction form
		
		JButton btntransaction = new JButton("View Transaction");
		btntransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btntransaction.setForeground(Color.BLACK);
		btntransaction.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btntransaction.setBackground(UIManager.getColor("Button.background"));
		btntransaction.setBounds(75, 235, 250, 70);
		contentPane.add(btntransaction);
		
		//Button Action to open view account information form
		btnViewAccountInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewAccountInformation  viewAccInfo = new ViewAccountInformation();
				viewAccInfo.setVisible(true);
			}
		});
		//Button Action to open withdraw form
		btnWithdrawMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Withdraw withdraw = new Withdraw();
				withdraw.setVisible(true);
			}
		});
		
		//Button Action to open deposite form
		btnDepositMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deposit deposite = new Deposit();
				deposite.setVisible(true);
			}
		});
		
		//Button Action to open transfer form
		btnTransferMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Transfer transfer = new Transfer();
				transfer.setVisible(true);
			}
		});
		
		//Button Action to exit the application form
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog( frame,"You Want to Exit","Fortis Bank System",
			            JOptionPane.YES_NO_OPTION)==JOptionPane.YES_OPTION)
			            System.exit(0);
				
			}
		});
		
		//Button Action to open view transaction form
		btntransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewTransactions viewTrans = new ViewTransactions();
				viewTrans.setVisible(true);
			}
		});
		
	}
}
