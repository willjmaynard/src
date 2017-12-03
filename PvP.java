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
import javax.swing.JOptionPane;

public class PvP extends JFrame {

	private JPanel contentPane;
        private Nim pvpGame = new Nim();
        private JButton[][] buttons = new JButton[11][11];
        private int playerTurn = 0;
        private PvPStart getNumPlayers = new PvPStart();
        private JLabel player = new JLabel("Player 1's Turn");
	/**
	 * Launch the application.
	 */
	public static void main (String[] args) {
            EventQueue.invokeLater(new Runnable() {
            public void run(){
		try {
                    PvP frame = new PvP();
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
	public PvP() {
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 700, 700);
            contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            setContentPane(contentPane);
            contentPane.setLayout(null);
            generateTokens();
            //displayLabel(playerTurn);
            
            
            player.setBounds(500, 30, 300, 100);
            contentPane.add(player);
        }   
        
        private void endingGame(){
            if(pvpGame.checkEndGame()){ //checkEndGame is true means there is no token left 
                int won = playerTurn%2 + 1;
                System.out.println("Done");
                JOptionPane.showMessageDialog(null, "Player " + won + " won", "InfoBox: " + "Congratulation", JOptionPane.INFORMATION_MESSAGE);
                contentPane.setVisible(false);
                MenuGUI mg = new MenuGUI();
                mg.getFrame().show();
                setVisible(false);
            }else{
                System.out.println(" Not Done Yet ");
            }
        }
        
        private void displayLabel(int starter){
            
            System.out.println("Turn: " + starter + "Count: " + playerTurn);
            player.setText("Player " + starter + "'s turn");

        }
        
        void generateTokens(){
            pvpGame.display();
           
            for (int j=0; j<pvpGame.getBoardSize();j++) {
                for (int i=0; i<pvpGame.getNumToken(j);i++) {
                    JButton token= new JButton(j+""+i);
                    token.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            int countTokenRemoved = 0;
                            int heapRemoved = 0;
                            for(int j=0; j<pvpGame.getBoardSize(); j++) {
                                for (int i=0; i<pvpGame.getNumToken(j); i++) {
                                    if (e.getSource()==buttons[j][i]){
                                        heapRemoved = j;
                                        for (int z=i; z<pvpGame.getNumToken(heapRemoved); z++) {
                                            buttons[j][z].hide();
                                            countTokenRemoved++;
                                        }
                                    }
                                }
                            }
                            playerTurn++;
                            displayLabel(playerTurn%2+1);
                            pvpGame.removeToken(heapRemoved, countTokenRemoved);

                            System.out.println();
                            pvpGame.display();
                            
                            endingGame();
                        }
                        });
                        token.setBounds(j*50, 575-(i*50), 50, 50);
                        getContentPane().add(token);  
                        buttons[j][i]=token;
			}
                }
            
        }
}
