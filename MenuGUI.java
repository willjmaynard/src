import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import java.awt.BorderLayout;
import java.awt.Button;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuGUI window = new MenuGUI();
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
	public MenuGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNimGame = new JLabel("Nim Game");
		lblNimGame.setBounds(190, 6, 83, 16);
		frame.getContentPane().add(lblNimGame);
		
		JButton btnNewButton = new JButton("New PVP Game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PvPStart one= new PvPStart();
				one.show();
				frame.dispose();
			}
		});
		btnNewButton.setBounds(6, 28, 162, 46);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New PVC Game");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PvCStart one=new PvCStart();
				one.show();
				frame.dispose();
				
			}
		});
		btnNewButton_1.setBounds(6, 86, 162, 46);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
			}
		});
		btnNewButton_2.setBounds(6, 144, 162, 46);
		frame.getContentPane().add(btnNewButton_2);
		
		ImageIcon images = new ImageIcon("images/meme.png");
		JLabel lblNewLabel = new JLabel("meme.png", images, JLabel.CENTER);
		lblNewLabel.setBounds(190, 34, 400, 400);
		frame.getContentPane().add(lblNewLabel);
		
		
		
	}
        
        public JFrame getFrame(){
            return frame;
        }
}
