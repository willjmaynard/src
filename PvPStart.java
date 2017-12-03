import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class PvPStart extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PvPStart frame = new PvPStart();
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
	public PvPStart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblYouHaveSelected = new JLabel("You have selected PVP!");
		lblYouHaveSelected.setBounds(143, 6, 161, 16);
		contentPane.add(lblYouHaveSelected);
		
		JButton btnNewButton = new JButton("GO!");
		btnNewButton.setBounds(143, 169, 161, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PvP open;
                                open = new PvP(); // TODO Auto-generated catch block
                                open.show();
                                dispose();
				
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EXIT");
		btnNewButton_1.setBounds(143, 210, 161, 29);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("This is a two Player Game!");
		lblNewLabel_1.setBounds(135, 34, 211, 35);
		contentPane.add(lblNewLabel_1);
	}
}