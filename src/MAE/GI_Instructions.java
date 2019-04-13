package MAE;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;

public class GI_Instructions implements Runnable {

	private JFrame frame;

	public GI_Instructions() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 793, 429);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Image icon = new ImageIcon(this.getClass().getResource("/iconWhite.png")).getImage();
		frame.setIconImage(icon);
		frame.setTitle("Mists of the Abandoned Etherdungeon");
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblGameInstructions = new JLabel("Game Instructions");
		lblGameInstructions.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameInstructions.setFont(new Font("Arial", Font.BOLD, 24));
		lblGameInstructions.setBounds(12, 13, 763, 50);
		frame.getContentPane().add(lblGameInstructions);
		
		JLabel lblwelcomeTo = new JLabel("<html><p>Welcome to the Mists of the Abandoned Etherdungeon.</p><p>Choose your team of heroes and go through all the five levels to "
				+ "get the heroes to the sanctum.</p><p>For that you will have to fight evil monsters. Here are some instructions to help you with it:"
				+ "<p> - Each character has different health and attacks, and some of them have special abilities."
				+ "<p> - From one level to the other the health of your team will be fully recharged, however be careful because if they died during the battle, they will only"
				+ " revive until 25%"
				+ "<p> - You need to kill all the monsters to proceed to the next level."
				+ "<p> - Between levels there is a shop in which you can buy items to help you during the battle. To access your items just press the button \"items\"."
				+ "</p></p></p></p></p></html>");
		lblwelcomeTo.setVerticalAlignment(SwingConstants.TOP);
		lblwelcomeTo.setHorizontalAlignment(SwingConstants.LEFT);
		lblwelcomeTo.setFont(new Font("Arial", Font.PLAIN, 16));
		lblwelcomeTo.setBounds(12, 76, 763, 208);
		frame.getContentPane().add(lblwelcomeTo);
		
		JLabel lblmayTheOdds = new JLabel("<html><p>May the odds be ever in your favor!</p></html>");
		lblmayTheOdds.setVerticalAlignment(SwingConstants.TOP);
		lblmayTheOdds.setHorizontalAlignment(SwingConstants.CENTER);
		lblmayTheOdds.setFont(new Font("Arial", Font.ITALIC, 18));
		lblmayTheOdds.setBounds(12, 297, 763, 38);
		frame.getContentPane().add(lblmayTheOdds);
		
		JLabel label = new JLabel("<html><p>Diogo Mimoso & Gabriel Campos</p></html>");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Arial", Font.PLAIN, 16));
		label.setBounds(12, 348, 763, 38);
		frame.getContentPane().add(label);
	}

	@Override
	public void run() {
		frame.setVisible(true);
		
	}

}
