package MAE;

import java.awt.*;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GI_Battle {

	private JFrame frame;
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
	private JButton[] btnMonsters = new JButton[4];
	private boolean[] showBtnMonsters = {false, false, false, false};
	
	private volatile int choice = -1;
	
	private static final ArrayUtils au = new ArrayUtils();


	public GI_Battle(Game game) {
		this.game = game;
		initialize();
		frame.setVisible(true);
	}
	
	public void setHuman(Human human) {
		this.human = human;
	}
	
	public void setCPU(Computer cpu) {
		this.cpu = cpu;
	}
	
	public void loadHeroes(ArrayList<Character> characters) {
		this.heroes = characters;
		for (int i=0; i<4; i++) {
			heroImages[i] = new ImageIcon(this.getClass().getResource(characters.get(i).getImgName())).getImage();	
			labelHeroes[i].setIcon(new ImageIcon(heroImages[i]));
		}
	}
	
	public void loadMonsters(ArrayList<Character> characters) {
		this.monsters = characters;
		for (int i=0; i<characters.size(); i++) {
			monsterImages[i] = new ImageIcon(this.getClass().getResource(characters.get(i).getImgName())).getImage();	
			labelMonsters[i].setIcon(new ImageIcon(monsterImages[i]));
		}
	}
	
	public int getMonsterToAttack(Hero ch) {
		
		
		
		
		
		return choice;
		
		/*ArrayList <Character> monstersAlive = this.cpu.getCharactersToAttack();
		String[] choices = new String[monstersAlive.size()];
		
		int i=0;
		for (Character monster : monsters) {
			if (monstersAlive.contains(monster)) {
				choices[i] = monster.getName();
				i++;
				labelMonsters[monsters.indexOf(monster)].setBorder(BorderFactory.createLineBorder(Color.YELLOW, 5));
				labelMonsters[monsters.indexOf(monster)].repaint();
				handleMonsters[monsters.indexOf(monster)] = true;
			}
		}
		*/
		//JList list = new JList(choices);
        //ListDialog dialog = new ListDialog("Please select an item in the list: ", list);
        //dialog.setOnOk(e -> System.out.println("Chosen item: " + dialog.getSelectedItem()));
        //dialog.show();
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
		

		btnMonsters[0] = new JButton("Attack");
		btnMonsters[0].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				choice = 0;
			}
		});
		btnMonsters[0].setBackground(Color.RED);
		btnMonsters[0].setBounds(315, 296, 169, 78);
		frame.getContentPane().add(btnMonsters[0]);
		
		btnMonsters[1] = new JButton("Attack");
		btnMonsters[1].addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				choice = 1;
			}
		});
		btnMonsters[1].setBackground(Color.RED);
		btnMonsters[1].setBounds(573, 296, 169, 78);
		frame.getContentPane().add(btnMonsters[1]);
		
		
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
		frame.getContentPane().add(labelMonsters[3]);
		
		labelMonsters[2] = new JLabel("");
		labelMonsters[2].setBounds(834, 13, 252, 353);
		frame.getContentPane().add(labelMonsters[2]);
		
		labelMonsters[1] = new JLabel("");
		labelMonsters[1].setBounds(552, 13, 252, 353);
		frame.getContentPane().add(labelMonsters[1]);
		
		labelMonsters[0] = new JLabel("");
		labelMonsters[0].setBounds(278, 13, 252, 353);
		frame.getContentPane().add(labelMonsters[0]);
		
		
		JLabel label_bk = new JLabel("");
		label_bk.setBounds(0, 0, 1422, 753);
		label_bk.setIcon(new ImageIcon( bk));
		frame.getContentPane().add(label_bk);
	}
}
