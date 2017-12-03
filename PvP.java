import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PvP extends JFrame {

	private JPanel contentPane;
	private int [] nimBoard;
	
	
	public void createNimBoard(){ //Initialized the Nim Board with a random stack of number and random number of tokens on each stack
	        Random rand = new Random();
	        int numStack= rand.nextInt(8) + 3;
	        nimBoard = new int[numStack];
	        for(int i = 0; i < numStack; i++){
	            int numToken = rand.nextInt(10) + 1;
	            nimBoard[i] = numToken;
	        }
	}
	
	


	/**
	 * Launch the application.
	 */
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PvP frame = new PvP("Hello");
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
	public PvP(String mystring) {
		JButton[][] buttons = new JButton[11][11];		
	    boolean[][] counter = new boolean[11][11];
		for (int h=0; h<11; h++) {
			for (int g=0; g<11 ;g++) {
				counter[h][g] = false;
			
			}
			}
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		Random rand= new Random();
		int columns=rand.nextInt(8)+3;
		for (int j=0; j<columns;j++) {
			int rows=rand.nextInt(10)+1;
			for (int i=0; i<rows;i++) {
				
			
				   JButton token= new JButton("x"+j+",y"+i);
	               token.addActionListener(new ActionListener() {
	               public void actionPerformed(ActionEvent e) {
	            	   for(int j=0; j<11; j++) {
	            		   for (int i=0; i<11; i++) {
	            			   if (e.getSource()==buttons[j][i])
	            			   {
	            				   for (int z=i; z<counter[j].length; z++) {
	            					   if (counter[j][z]==true) { 
	            					   buttons[j][z].hide();
	            					   counter[j][z]=false;
	            					 }  
	            				   }
	            			   }
	            		   }
	            	   }
	            	   
	   			}
		});
	               token.setBounds(j*50, 575-(i*50), 50, 50);
	               getContentPane().add(token);  
	               buttons[j][i]=token;
	               counter[j][i]=true;
			}
		
		
	
	
	
	
}	
}}
