package MAE;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GI_Battle implements Runnable {

	public JFrame frame;
	
	private Human human;
	private Computer cpu;
	private Game game;
	
	private ArrayList <Character> heroes;
	private Image[] heroImages = new Image[4];
	private JLabel[] labelHeroes = new JLabel[4];
	private JLabel[] labelInfoHeroes = new JLabel[4];
	private boolean[] isActiveBtnHeroes = {false, false, false, false};
	private JProgressBar[] monstersLive = new JProgressBar[4];

	private ArrayList <Character> monsters;
	private Image[] monsterImages = new Image[4];
	private JLabel[] labelMonsters = new JLabel[4];
	private boolean[] isActiveBtnMonsters = {false, false, false, false};
	private JProgressBar[] heroesLive = new JProgressBar[4];
	
	private JLabel lblCPUstats;
	private JLabel lblHstats;
	private JLabel lblPlayingCPU;
	private JLabel lblPlayingHuman;
	private JLabel statusCPU;
	private JLabel statusHuman;
	
	private Image fainted = new ImageIcon(this.getClass().getResource("/fainted.png")).getImage();
	
	private Hero hero;
	private JButton btnNewButton;

	public GI_Battle(Game game) {
		this.game = game;
		initialize();		
	}
	
	public void setVisibility(boolean visibility) {
		frame.setVisible(visibility);
	}
	
	public void msgbox(String s){
	   JOptionPane.showMessageDialog(null, s);
	}
	
	public void setHuman(Human human) {
		this.human = human;
	}
	
	public void setCPU(Computer cpu) {
		this.cpu = cpu;
	}
	
	public void setComputerPlaying(Character monsterPlaying) {
		lblPlayingHuman.setVisible(false);
		lblPlayingCPU.setVisible(true);
		this.deleteBorders();
		Border border = BorderFactory.createLineBorder(Color.YELLOW, 2);
	    labelMonsters[monsters.indexOf(monsterPlaying)].setBorder(border);
	}
	
	public void setHumanPlaying(Character heroPlaying) {
		lblPlayingHuman.setVisible(true);
		lblPlayingCPU.setVisible(false);
		this.deleteBorders();
		Border border = BorderFactory.createLineBorder(Color.YELLOW, 2);
	    labelHeroes[heroes.indexOf(heroPlaying)].setBorder(border);
	}
	
	public void setHeroAttacked(Character heroAttacked) {
		Border border = BorderFactory.createLineBorder(Color.RED, 5);
		labelHeroes[heroes.indexOf(heroAttacked)].setBorder(border);
	}
	
	public void setCPUstatus(String status) {
		this.statusCPU.setText("<html><p>" + status + "</p></html>");
	}
	
	public void setHumanStatus(String status) {
		this.statusHuman.setText("<html><p>" + status + "</p></html>");
	}
	
	public void setHeroAttack(String attack, Character hero) {
		this.labelInfoHeroes[this.heroes.indexOf(hero)].setText(attack);
	}
	
	public void loadHeroes(ArrayList<Character> characters) {
		this.heroes = characters;
		for (int i=0; i<4; i++) {
			heroesLive[i].setMaximum(characters.get(i).getMaxHealth());
			heroImages[i] = new ImageIcon(this.getClass().getResource(characters.get(i).getImgName())).getImage();	
			labelHeroes[i].setIcon(new ImageIcon(heroImages[i]));
		}
	}
	
	public void loadMonsters(ArrayList<Character> characters) {
		this.monsters = characters;
		for (int i=0; i<characters.size(); i++) {
			monstersLive[i].setMaximum(characters.get(i).getMaxHealth());
			monsterImages[i] = new ImageIcon(this.getClass().getResource(characters.get(i).getImgName())).getImage();	
			labelMonsters[i].setIcon(new ImageIcon(monsterImages[i]));
		}
		this.cleanLabels();
	}
	
	public void cleanLabels() {
		for (int i=0; i<4; i++) {
			this.labelInfoHeroes[i].setText("");
		}
	}
	
	public Human getHuman() {
		return this.human;
	}
	
	public Computer getCPU() {
		return this.cpu;
	}
	
	public void getMonsterToAttack(Hero ch) {
		this.hero = ch;
		ArrayList<Character> monstersToAttack = this.cpu.getCharactersToAttack();
		for (int i=0; i<this.monsters.size(); i++) {
			if (monstersToAttack.contains(this.monsters.get(i))) {				
				this.isActiveBtnMonsters[i] = true;
			}
		}
	}
	
	public void getHeroToHeal(Hero ch) {
		this.hero = ch;
		ArrayList<Character> heroesToHeal = this.human.getCharactersAlive();
		for (int i=0; i<this.heroes.size(); i++) {
			if (heroesToHeal.contains(this.heroes.get(i))) {
				this.isActiveBtnHeroes[i] = true;
			}
		}
	}
	
	public void updateStats() {
		this.monsters = this.cpu.getTeam();
		if (this.monsters.size() == 4) {
			monstersLive[3].setVisible(true);
		}
		String toShow = "<html><body>";
		for (Character monster : monsters) {
			monstersLive[monsters.indexOf(monster)].setValue(monster.getHealth());
			toShow += monster.toString();
			toShow += "<br><br>";
		}
		toShow += "</body></html>";
		lblCPUstats.setText(toShow);
		
		this.heroes = this.human.getTeam();
		toShow = "<html><body>";
		for (Character hero : heroes) {
			heroesLive[heroes.indexOf(hero)].setValue(hero.getHealth());
			toShow += hero.toString();
			toShow += "<br><br>";
		}
		toShow += "</body></html>";
		lblHstats.setText(toShow);
		
		this.checkDead();
	}

	public void closeWindow() {
		this.frame.setVisible(false);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBackground(Color.BLACK);
		frame.setSize(1426, 785);
		frame.setLocationRelativeTo(null);
		Image icon = new ImageIcon(this.getClass().getResource("/iconWhite.png")).getImage();
		frame.setIconImage(icon);
		frame.setTitle("Mists of the Abandoned Etherdungeon");		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Image bk = new ImageIcon(this.getClass().getResource("/BattleGround.png")).getImage();
		
		
		labelInfoHeroes[0] = new JLabel("");
		labelInfoHeroes[0].setVerticalAlignment(SwingConstants.BOTTOM);
		labelInfoHeroes[0].setHorizontalAlignment(SwingConstants.CENTER);
		labelInfoHeroes[0].setFont(new Font("Arial", Font.BOLD, 14));
		labelInfoHeroes[0].setBackground(Color.BLACK);
		labelInfoHeroes[0].setForeground(Color.WHITE);
		labelInfoHeroes[0].setBounds(278, 387, 252, 350);
		frame.getContentPane().add(labelInfoHeroes[0]);
		
		
		labelHeroes[0] = new JLabel("");
		labelHeroes[0].setBounds(278, 387, 252, 353);
		labelHeroes[0].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelHeroes[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (isActiveBtnHeroes[0]) {
					resetHeroesBtn();
					((Cleric) hero).setHeroToHeal((Hero) heroes.get(0));
				}
			}
		});
		frame.getContentPane().add(labelHeroes[0]);
		
		labelInfoHeroes[1] = new JLabel("");
		labelInfoHeroes[1].setVerticalAlignment(SwingConstants.BOTTOM);
		labelInfoHeroes[1].setHorizontalAlignment(SwingConstants.CENTER);
		labelInfoHeroes[1].setFont(new Font("Arial", Font.BOLD, 14));
		labelInfoHeroes[1].setBackground(Color.BLACK);
		labelInfoHeroes[1].setForeground(Color.WHITE);
		labelInfoHeroes[1].setBounds(552, 387, 252, 350);
		frame.getContentPane().add(labelInfoHeroes[1]);
		
		labelHeroes[1] = new JLabel("");
		labelHeroes[1].setBounds(552, 387, 252, 353);
		labelHeroes[1].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelHeroes[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (isActiveBtnHeroes[1]) {
					resetHeroesBtn();
					((Cleric) hero).setHeroToHeal((Hero) heroes.get(1));
				}
			}
		});
		frame.getContentPane().add(labelHeroes[1]);
		
		labelInfoHeroes[2] = new JLabel("");
		labelInfoHeroes[2].setVerticalAlignment(SwingConstants.BOTTOM);
		labelInfoHeroes[2].setHorizontalAlignment(SwingConstants.CENTER);
		labelInfoHeroes[2].setFont(new Font("Arial", Font.BOLD, 14));
		labelInfoHeroes[2].setBackground(Color.BLACK);
		labelInfoHeroes[2].setForeground(Color.WHITE);
		labelInfoHeroes[2].setBounds(834, 387, 252, 350);
		frame.getContentPane().add(labelInfoHeroes[2]);
		
		labelHeroes[2] = new JLabel("");
		labelHeroes[2].setBounds(834, 387, 252, 353);
		labelHeroes[2].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelHeroes[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (isActiveBtnHeroes[2]) {
					resetHeroesBtn();
					((Cleric) hero).setHeroToHeal((Hero) heroes.get(2));
				}
			}
		});
		frame.getContentPane().add(labelHeroes[2]);
		
		labelInfoHeroes[3] = new JLabel("");
		labelInfoHeroes[3].setVerticalAlignment(SwingConstants.BOTTOM);
		labelInfoHeroes[3].setHorizontalAlignment(SwingConstants.CENTER);
		labelInfoHeroes[3].setFont(new Font("Arial", Font.BOLD, 14));
		labelInfoHeroes[3].setBackground(Color.BLACK);
		labelInfoHeroes[3].setForeground(Color.WHITE);
		labelInfoHeroes[3].setBounds(1122, 387, 252, 350);
		frame.getContentPane().add(labelInfoHeroes[3]);
		
		labelHeroes[3] = new JLabel("");
		labelHeroes[3].setBounds(1122, 387, 252, 353);
		labelHeroes[3].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelHeroes[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (isActiveBtnHeroes[3]) {
					resetHeroesBtn();
					((Cleric) hero).setHeroToHeal((Hero) heroes.get(3));
				}
			}
		});
		frame.getContentPane().add(labelHeroes[3]);
		
		
		labelMonsters[3] = new JLabel("");
		labelMonsters[3].setBounds(1122, 13, 252, 353);
		labelMonsters[3].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelMonsters[3].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (isActiveBtnMonsters[3]) {
					resetMonstersBtn();
					hero.setMonsterToAttack(monsters.get(3));
				}
			}
		});
		frame.getContentPane().add(labelMonsters[3]);
		
		labelMonsters[2] = new JLabel("");
		labelMonsters[2].setBounds(834, 13, 252, 353);
		labelMonsters[2].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelMonsters[2].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (isActiveBtnMonsters[2]) {
					resetMonstersBtn();
					hero.setMonsterToAttack(monsters.get(2));
				}
			}
		});
		frame.getContentPane().add(labelMonsters[2]);
		
		labelMonsters[1] = new JLabel("");
		labelMonsters[1].setBounds(552, 13, 252, 353);
		labelMonsters[1].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelMonsters[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (isActiveBtnMonsters[1]) {
					resetMonstersBtn();
					hero.setMonsterToAttack(monsters.get(1));
				}
			}
		});
		frame.getContentPane().add(labelMonsters[1]);
		
		labelMonsters[0] = new JLabel("");
		labelMonsters[0].setBounds(278, 13, 252, 353);
		labelMonsters[0].setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelMonsters[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (isActiveBtnMonsters[0]) {
					resetMonstersBtn();
					hero.setMonsterToAttack(monsters.get(0));
				}
			}
		});
		frame.getContentPane().add(labelMonsters[0]);
		
		lblPlayingHuman = new JLabel("(Playing)");
		lblPlayingHuman.setFont(new Font("Arial", Font.BOLD, 16));
		lblPlayingHuman.setForeground(Color.ORANGE);
		lblPlayingHuman.setBounds(100, 428, 91, 34);
		lblPlayingHuman.setVisible(false);
		
		btnNewButton = new JButton("Items");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!human.hasItems()) {
					msgbox("You don't have any item");
					return;
				}
				Thread t1 = new Thread(new GI_PickList(human.getItems(), game));
		        t1.start();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(222, 184, 135));
		btnNewButton.setBounds(12, 354, 207, 45);
		frame.getContentPane().add(btnNewButton);
		frame.getContentPane().add(lblPlayingHuman);
		
		lblPlayingCPU = new JLabel("(Playing)");
		lblPlayingCPU.setForeground(Color.ORANGE);
		lblPlayingCPU.setFont(new Font("Arial", Font.BOLD, 16));
		lblPlayingCPU.setBounds(120, 13, 91, 45);
		lblPlayingCPU.setVisible(false);
		frame.getContentPane().add(lblPlayingCPU);
		
		statusCPU = new JLabel("");
		statusCPU.setVerticalAlignment(SwingConstants.TOP);
		statusCPU.setForeground(Color.WHITE);
		statusCPU.setFont(new Font("Arial", Font.BOLD, 15));
		statusCPU.setBounds(27, 204, 183, 131);
		frame.getContentPane().add(statusCPU);
		
		monstersLive[0] = new JProgressBar();
		monstersLive[0].setForeground(Color.RED);
		monstersLive[0].setBackground(Color.LIGHT_GRAY);
		monstersLive[0].setBounds(27, 80, 180, 5);
		frame.getContentPane().add(monstersLive[0]);
		
		monstersLive[1] = new JProgressBar();
		monstersLive[1].setForeground(Color.RED);
		monstersLive[1].setBackground(Color.LIGHT_GRAY);
		monstersLive[1].setBounds(27, 116, 180, 5);
		frame.getContentPane().add(monstersLive[1]);
		
		monstersLive[2] = new JProgressBar();
		monstersLive[2].setBackground(Color.LIGHT_GRAY);
		monstersLive[2].setForeground(Color.RED);
		monstersLive[2].setBounds(27, 152, 180, 5);
		frame.getContentPane().add(monstersLive[2]);
		
		monstersLive[3] = new JProgressBar();
		monstersLive[3].setForeground(Color.RED);
		monstersLive[3].setBackground(Color.LIGHT_GRAY);
		monstersLive[3].setBounds(27, 187, 180, 5);
		monstersLive[3].setVisible(false);
		frame.getContentPane().add(monstersLive[3]);
		
		heroesLive[0] = new JProgressBar();
		heroesLive[0].setForeground(Color.RED);
		heroesLive[0].setBackground(Color.LIGHT_GRAY);
		heroesLive[0].setBounds(27, 489, 180, 5);
		frame.getContentPane().add(heroesLive[0]);
		
		heroesLive[1] = new JProgressBar();
		heroesLive[1].setForeground(Color.RED);
		heroesLive[1].setBackground(Color.LIGHT_GRAY);
		heroesLive[1].setBounds(27, 525, 180, 5);
		frame.getContentPane().add(heroesLive[1]);
		
		heroesLive[2] = new JProgressBar();
		heroesLive[2].setForeground(Color.RED);
		heroesLive[2].setBackground(Color.LIGHT_GRAY);
		heroesLive[2].setBounds(27, 561, 180, 5);
		frame.getContentPane().add(heroesLive[2]);

		heroesLive[3] = new JProgressBar();
		heroesLive[3].setForeground(Color.RED);
		heroesLive[3].setBackground(Color.LIGHT_GRAY);
		heroesLive[3].setBounds(27, 596, 180, 5);
		frame.getContentPane().add(heroesLive[3]);
		
		lblHstats = new JLabel("");
		lblHstats.setVerticalAlignment(SwingConstants.TOP);
		lblHstats.setForeground(Color.WHITE);
		lblHstats.setFont(new Font("Arial", Font.BOLD, 15));
		lblHstats.setBounds(27, 470, 183, 131);
		frame.getContentPane().add(lblHstats);
		
		lblCPUstats = new JLabel("");
		lblCPUstats.setFont(new Font("Arial", Font.BOLD, 15));
		lblCPUstats.setVerticalAlignment(SwingConstants.TOP);
		lblCPUstats.setForeground(Color.WHITE);
		lblCPUstats.setBounds(27, 60, 183, 131);
		frame.getContentPane().add(lblCPUstats);
		
		statusHuman = new JLabel("");
		statusHuman.setVerticalAlignment(SwingConstants.TOP);
		statusHuman.setForeground(Color.WHITE);
		statusHuman.setFont(new Font("Arial", Font.BOLD, 15));
		statusHuman.setBounds(27, 609, 183, 131);
		frame.getContentPane().add(statusHuman);
		
		JLabel label_bk = new JLabel("");
		label_bk.setForeground(Color.BLACK);
		label_bk.setFont(new Font("Arial", Font.BOLD, 15));
		label_bk.setBounds(0, 0, 1422, 753);
		label_bk.setIcon(new ImageIcon( bk));
		frame.getContentPane().add(label_bk);
	}
	
	private void resetMonstersBtn() {
		for (int i=0; i<4; i++) {
			this.isActiveBtnMonsters[i] = false;
		}
	}
	
	private void resetHeroesBtn() {
		for (int i=0; i<4; i++) {
			this.isActiveBtnHeroes[i] = false;
		}
	}
	
	private void deleteBorders() {
		Border emptyBorder = BorderFactory.createLineBorder(Color.YELLOW, 0);
		for(int i=0; i<4; i++) {
			labelMonsters[i].setBorder(emptyBorder);
			labelHeroes[i].setBorder(emptyBorder);
		}
	}
	
	public void checkDead() {
		for(Character monster : this.monsters) {
			if (!monster.isAlive() && this.monsterImages[monsters.indexOf(monster)] != this.fainted) {
				this.monsterImages[monsters.indexOf(monster)] = this.fainted;
				this.labelMonsters[monsters.indexOf(monster)].setIcon(new ImageIcon(this.fainted));
				
			}
		}
		for(Character hero : this.heroes) {
			if (!hero.isAlive() && this.heroImages[heroes.indexOf(hero)] != this.fainted) {
				this.heroImages[heroes.indexOf(hero)] = this.fainted;
				this.labelHeroes[heroes.indexOf(hero)].setIcon(new ImageIcon(this.fainted));
				
			}
		}
	}
	

	@Override
	public void run() {
		frame.setVisible(true);
		
	}
}
