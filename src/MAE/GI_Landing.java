package MAE;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GI_Landing implements Runnable {
	private JFrame frmGameMae;
	private JTextField textField;
	private Game game;
	
	public GI_Landing(Game game) {
		this.game = game;
		initialize();
	}

	private void initialize() {
		frmGameMae = new JFrame();
		frmGameMae.setBackground(Color.LIGHT_GRAY);
		frmGameMae.setResizable(false);
		Image icon = new ImageIcon(this.getClass().getResource("/iconWhite.png")).getImage();
		frmGameMae.setIconImage(icon);
		frmGameMae.setTitle("Mists of the Abandoned Etherdungeon");
		frmGameMae.setSize(800, 500);
		frmGameMae.setLocationRelativeTo(null);
		frmGameMae.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGameMae.getContentPane().setLayout(null);
		
		JLabel lblGameMae = new JLabel("Player name:");
		lblGameMae.setForeground(Color.WHITE);
		lblGameMae.setBounds(226, 408, 88, 22);
		lblGameMae.setFont(new Font("Arial", Font.PLAIN, 14));
		frmGameMae.getContentPane().add(lblGameMae);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Arial", Font.PLAIN, 14));
		textField.setBounds(315, 408, 163, 22);
		frmGameMae.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!textField.getText().equals("")) {
					game.receivePlayerName(textField.getText());
					frmGameMae.setVisible(false);
					return;
				}
				msgbox("You need to insert a player name before starting the game");
				
			}
		});
		btnStartGame.setBackground(Color.WHITE);
		btnStartGame.setBounds(490, 407, 112, 25);
		frmGameMae.getContentPane().add(btnStartGame);
		
		JLabel labelBK = new JLabel("");
		Image bk = new ImageIcon(this.getClass().getResource("/landing-page.png")).getImage();
		labelBK.setIcon(new ImageIcon( bk));
		labelBK.setBounds(0, 0, 794, 465);
		frmGameMae.getContentPane().add(labelBK);
	}
	
	private void msgbox(String s){
	   JOptionPane.showMessageDialog(null, s);
	}

	@Override
	public void run() {
		frmGameMae.setVisible(true);
	}
}
