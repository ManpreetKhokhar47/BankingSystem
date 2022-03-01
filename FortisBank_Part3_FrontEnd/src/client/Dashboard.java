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
		
		JButton btnOpenNewAccount = new JButton("Open new account");
		btnOpenNewAccount.setForeground(new Color(0, 0, 0));
		btnOpenNewAccount.setBackground(UIManager.getColor("Button.background"));
		btnOpenNewAccount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOpenNewAccount.setBounds(75, 115, 250, 70);
		contentPane.add(btnOpenNewAccount);
		
		JButton btnOpenSavingAccount = new JButton("Open saving account");
		
		btnOpenSavingAccount.setForeground(new Color(0, 0, 0));
		btnOpenSavingAccount.setBackground(UIManager.getColor("Button.background"));
		btnOpenSavingAccount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOpenSavingAccount.setBounds(375, 115, 250, 70);
		contentPane.add(btnOpenSavingAccount);
		
		JButton btnOpenCreditAccount = new JButton("Open credit account");
		
		btnOpenCreditAccount.setForeground(new Color(0, 0, 0));
		btnOpenCreditAccount.setBackground(UIManager.getColor("Button.background"));
		btnOpenCreditAccount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnOpenCreditAccount.setBounds(675, 115, 250, 70);
		contentPane.add(btnOpenCreditAccount);
		
		JButton btnCloseAccount = new JButton("Close account");
		
		btnCloseAccount.setForeground(new Color(0, 0, 0));
		btnCloseAccount.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCloseAccount.setBackground(UIManager.getColor("Button.background"));
		btnCloseAccount.setBounds(75, 235, 250, 70);
		contentPane.add(btnCloseAccount);
		
		JButton btnExit = new JButton("Exit");
		
		btnExit.setForeground(new Color(0, 0, 0));
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExit.setBackground(UIManager.getColor("Button.background"));
		btnExit.setBounds(675, 355, 250, 70);
		contentPane.add(btnExit);
		
		
		// All Buttons to open different forms
		
		JButton btnViewAccountInformation = new JButton("View account Information");
		
		btnViewAccountInformation.setForeground(new Color(0, 0, 0));
		btnViewAccountInformation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnViewAccountInformation.setBackground(UIManager.getColor("Button.background"));
		btnViewAccountInformation.setBounds(375, 235, 250, 70);
		contentPane.add(btnViewAccountInformation);
		
		
		JButton btnWithdrawMoney = new JButton("Withdraw Money");
		btnWithdrawMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnWithdrawMoney.setForeground(Color.BLACK);
		btnWithdrawMoney.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnWithdrawMoney.setBackground(UIManager.getColor("Button.background"));
		btnWithdrawMoney.setBounds(75, 355, 250, 70);
		contentPane.add(btnWithdrawMoney);
		
		JButton btnDepositMoney = new JButton("Deposit Money");
		
		btnDepositMoney.setForeground(Color.BLACK);
		btnDepositMoney.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDepositMoney.setBackground(UIManager.getColor("Button.background"));
		btnDepositMoney.setBounds(375, 355, 250, 70);
		contentPane.add(btnDepositMoney);
		
		JButton btnTransferMoney = new JButton("Transfer Money");
		
		btnTransferMoney.setForeground(Color.BLACK);
		btnTransferMoney.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnTransferMoney.setBackground(UIManager.getColor("Button.background"));
		btnTransferMoney.setBounds(675, 235, 250, 70);
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
		btntransaction.setBounds(75, 460, 250, 70);
		contentPane.add(btntransaction);
		
		
		//Button Action to open new account form
		btnOpenNewAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			OpenAccount openAccountForm = new OpenAccount();
			openAccountForm.setVisible(true);

			}
		});
		
		//Button Action to open saving account form
		btnOpenSavingAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenSavingAccount openSavingAccount = new OpenSavingAccount();
				openSavingAccount.setVisible(true);
			}
		});
		
		//Button Action to open credit account form
		btnOpenCreditAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpenCreditAccount openCreditAccount = new OpenCreditAccount();
				openCreditAccount.setVisible(true);
			}
		});
		
		//Button Action to close account form
		btnCloseAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseAccount closeAccount = new CloseAccount();
				closeAccount.setVisible(true);
			}
		});
		
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
