package MAE;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class GI_Battle {

	private JFrame frame;
	private Game game;
	
	private Image[] heroImages = new Image[4];
	private JLabel[] labelHeroes = new JLabel[4];

	public GI_Battle(Game game) {
		this.game = game;
		initialize();
		frame.setVisible(true);
	}
	
	public void loadHeroes(ArrayList<Character> characters) {
		System.out.println(characters);
		for (int i=0; i<4; i++) {
			heroImages[i] = new ImageIcon(this.getClass().getResource(characters.get(i).getImgName())).getImage();	
			labelHeroes[i].setIcon(new ImageIcon(heroImages[i]));
		}
		return; 
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.RED);
		frame.setSize(1440, 800);
		frame.setLocationRelativeTo(null);
		Image icon = new ImageIcon(this.getClass().getResource("/iconWhite.png")).getImage();
		frame.setIconImage(icon);
		frame.setTitle("Mists of the Abandoned Etherdungeon");		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Image bk = new ImageIcon(this.getClass().getResource("/BattleGround.png")).getImage();
		
		JLabel label_bk = new JLabel("");
		label_bk.setBounds(0, 0, 1422, 753);
		label_bk.setIcon(new ImageIcon( bk));
		frame.getContentPane().add(label_bk);
		
		
		labelHeroes[0] = new JLabel("");
		labelHeroes[0].setBounds(278, 387, 252, 353);
		frame.getContentPane().add(labelHeroes[0]);
		
		labelHeroes[1] = new JLabel("");
		labelHeroes[1].setBounds(552, 387, 252, 353);
		frame.getContentPane().add(labelHeroes[1]);
		
		labelHeroes[2] = new JLabel("");
		labelHeroes[2].setBounds(834, 387, 252, 353);
		frame.getContentPane().add(labelHeroes[2]);
		
		labelHeroes[3] = new JLabel("");
		labelHeroes[3].setBounds(1122, 387, 252, 353);
		frame.getContentPane().add(labelHeroes[3]);
		
		
		
		
		JLabel label_m4 = new JLabel("");
		label_m4.setBounds(1122, 13, 252, 353);
		frame.getContentPane().add(label_m4);
		
		JLabel label_m3 = new JLabel("");
		label_m3.setBounds(834, 13, 252, 353);
		frame.getContentPane().add(label_m3);
		
		JLabel label_m2 = new JLabel("");
		label_m2.setBounds(552, 13, 252, 353);
		frame.getContentPane().add(label_m2);
		
		JLabel label_m1 = new JLabel("");
		label_m1.setBounds(278, 13, 252, 353);
		frame.getContentPane().add(label_m1);
	}

}
