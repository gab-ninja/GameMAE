package MAE;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GI_Battle implements Runnable {

	public JFrame frame;
	private Game game;
	
	private Human human;
	private Computer cpu;
	
	private ArrayList <Character> heroes;
	private Image[] heroImages = new Image[4];
	private JLabel[] labelHeroes = new JLabel[4];
	private boolean[] handleHeroes = {false, false, false, false};
	
	private ArrayList <Character> monsters;
	private Image[] monsterImages = new Image[4];
	private JLabel[] labelMonsters = new JLabel[4];
	private boolean[] isActiveBtnMonsters = {false, false, false, false};
	
	private JLabel lblCPUstats;
	private JLabel lblHstats;
	private JLabel lblPlayingCPU;
	private JLabel lblPlayingHuman;
	
	private Hero hero;
	private int numberOfMonsters;
	private boolean isComputerPlaying;
	
	private static final ArrayUtils au = new ArrayUtils();

	public GI_Battle(Game game) {
		this.game = game;
		initialize();		
	}
	
	public void setHuman(Human human) {
		this.human = human;
	}
	
	public void setCPU(Computer cpu) {
		this.cpu = cpu;
	}
	
	public void setComputerPlaying(Character monsterPlaying) {
		System.out.println("SET CPU PLAYING: " + monsterPlaying + this.monsters);
		this.isComputerPlaying = true;
		lblPlayingHuman.setVisible(false);
		lblPlayingCPU.setVisible(true);
		this.deleteBorders();
		Border border = BorderFactory.createLineBorder(Color.YELLOW, 2);
	    labelMonsters[monsters.indexOf(monsterPlaying)].setBorder(border);
	}
	
	public void setHumanPlaying(Character heroPlaying) {
		System.out.println("SET HUMAN PLAYING: " + heroPlaying + this.heroes);
		this.isComputerPlaying = false;
		lblPlayingHuman.setVisible(true);
		lblPlayingCPU.setVisible(false);
		this.deleteBorders();
		Border border = BorderFactory.createLineBorder(Color.YELLOW, 2);
	    labelHeroes[heroes.indexOf(heroPlaying)].setBorder(border);
	}
	
	public void loadHeroes(ArrayList<Character> characters) {
		System.out.println("LOAD HEROES: " + characters);
		this.heroes = characters;
		for (int i=0; i<4; i++) {
			heroImages[i] = new ImageIcon(this.getClass().getResource(characters.get(i).getImgName())).getImage();	
			labelHeroes[i].setIcon(new ImageIcon(heroImages[i]));
		}
	}
	
	public void loadMonsters(ArrayList<Character> characters) {
		System.out.println("LOAD MONSTERS: " + characters);
		this.monsters = characters;
		for (int i=0; i<characters.size(); i++) {
			monsterImages[i] = new ImageIcon(this.getClass().getResource(characters.get(i).getImgName())).getImage();	
			labelMonsters[i].setIcon(new ImageIcon(monsterImages[i]));
		}
	}
	
	public void getMonsterToAttack(Hero ch) {
		this.hero = ch;
		System.out.println("GET MONSTERS TO ATTACK: " + this.monsters);
		ArrayList<Character> monstersToAttack = this.cpu.getCharactersToAttack();
		for (int i=0; i<this.monsters.size(); i++) {
			if (monstersToAttack.contains(this.monsters.get(i))) {				
				this.isActiveBtnMonsters[i] = true;
			}
		}
	}
	
	public void updateStats() {
		this.monsters = this.cpu.getTeam();
		String toShow = "<html><body>";
		for (Character monster : monsters) {
			toShow += monster.toString();
			toShow += "<br><br>";
		}
		toShow += "</body></html>";
		lblCPUstats.setText(toShow);
		
		this.heroes = this.human.getTeam();
		toShow = "<html><body>";
		for (Character hero : heroes) {
			toShow += hero.toString();
			toShow += "<br><br>";
		}
		toShow += "</body></html>";
		lblHstats.setText(toShow);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.BLACK);
		frame.setSize(1440, 800);
		frame.setLocationRelativeTo(null);
		Image icon = new ImageIcon(this.getClass().getResource("/iconWhite.png")).getImage();
		frame.setIconImage(icon);
		frame.setTitle("Mists of the Abandoned Etherdungeon");		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Image bk = new ImageIcon(this.getClass().getResource("/BattleGround.png")).getImage();
		
		
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
		frame.getContentPane().add(lblPlayingHuman);
		
		lblPlayingCPU = new JLabel("(Playing)");
		lblPlayingCPU.setForeground(Color.ORANGE);
		lblPlayingCPU.setFont(new Font("Arial", Font.BOLD, 16));
		lblPlayingCPU.setBounds(120, 13, 91, 45);
		lblPlayingCPU.setVisible(false);
		frame.getContentPane().add(lblPlayingCPU);
		
		lblCPUstats = new JLabel("");
		lblCPUstats.setFont(new Font("Arial", Font.BOLD, 15));
		lblCPUstats.setVerticalAlignment(SwingConstants.TOP);
		lblCPUstats.setForeground(Color.WHITE);
		lblCPUstats.setBounds(27, 60, 183, 131);
		frame.getContentPane().add(lblCPUstats);
		
		lblHstats = new JLabel("");
		lblHstats.setVerticalAlignment(SwingConstants.TOP);
		lblHstats.setForeground(Color.WHITE);
		lblHstats.setFont(new Font("Arial", Font.BOLD, 15));
		lblHstats.setBounds(27, 470, 183, 131);
		frame.getContentPane().add(lblHstats);
		
		
		JLabel label_bk = new JLabel("");
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
	
	private void deleteBorders() {
		Border emptyBorder = BorderFactory.createLineBorder(Color.YELLOW, 0);
		for(int i=0; i<4; i++) {
			labelMonsters[i].setBorder(emptyBorder);
			labelHeroes[i].setBorder(emptyBorder);
		}
	}

	@Override
	public void run() {
		frame.setVisible(true);
		
	}
}
