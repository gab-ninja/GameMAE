package MAE;

import java.awt.*;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

public class GI_PickHeroes {

	private JFrame frame;
	private ArrayList <Character> heroes = new ArrayList<Character>();
	private boolean[] cardStates = {false, false, false, false, false, false, false, false, false, false, false, false, false};
	private Game game;
	
	private static ArrayUtils au = new ArrayUtils();

	public GI_PickHeroes(Game game) {
		this.game = game;
		for (Heroes hero : Heroes.values()) {
			heroes.add(hero.generateCharacterObject());
		}
		initialize();
		frame.setVisible(true);
	}
	
	private boolean changeState(int labelNumber) {
		if (au.numberOfOccurences(this.cardStates, true) < 4 &&  !this.cardStates[labelNumber] ||
				au.numberOfOccurences(this.cardStates, true) <= 4 &&  this.cardStates[labelNumber]) {
			this.cardStates[labelNumber] = !this.cardStates[labelNumber];
			return this.cardStates[labelNumber];			
		}
		msgbox("You can only select 4 players");
		return this.cardStates[labelNumber];
	}

	private void initialize() {
		frame = new JFrame();
		frame.setSize(1440, 800);
		frame.setLocationRelativeTo(null);
		Image icon = new ImageIcon(this.getClass().getResource("/iconWhite.png")).getImage();
		frame.setIconImage(icon);
		frame.setTitle("Mists of the Abandoned Etherdungeon");		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewButton = new JButton("Start Battle");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (au.numberOfOccurences(cardStates, true) == 4) {
					game.receivePlayerCharacters(convertInt2Heroes(au.findPositions(cardStates, true, 4)));
					frame.setVisible(false);
					return;
				}
				msgbox("You need to select 4 heroes to start the battle");
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 14));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(1239, 346, 171, 25);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblNewLabel.setOpaque(changeState(0));
				lblNewLabel.repaint();
			}
		});
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setBounds(12, 124, 178, 247);
		lblNewLabel.setOpaque(cardStates[0]);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				label.setOpaque(changeState(1));
				label.repaint();
			}
		});
		label.setOpaque(cardStates[1]);
		label.setBackground(Color.BLACK);
		label.setBounds(213, 124, 178, 247);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setOpaque(cardStates[2]);
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				label_1.setOpaque(changeState(2));
				label_1.repaint();
			}
		});
		label_1.setBackground(Color.BLACK);
		label_1.setBounds(417, 124, 178, 247);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setOpaque(cardStates[3]);
		label_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				label_2.setOpaque(changeState(3));
				label_2.repaint();
			}
		});
		label_2.setBackground(Color.BLACK);
		label_2.setBounds(620, 124, 178, 247);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setOpaque(cardStates[4]);
		label_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				label_3.setOpaque(changeState(4));
				label_3.repaint();
			}
		});
		label_3.setBackground(Color.BLACK);
		label_3.setBounds(823, 124, 178, 247);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setOpaque(cardStates[5]);
		label_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				label_4.setOpaque(changeState(5));
				label_4.repaint();
			}
		});
		label_4.setBackground(Color.BLACK);
		label_4.setBounds(1026, 124, 178, 247);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setOpaque(cardStates[6]);
		label_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				label_5.setOpaque(changeState(6));
				label_5.repaint();
			}
		});
		label_5.setBackground(Color.BLACK);
		label_5.setBounds(12, 396, 178, 254);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setOpaque(cardStates[7]);
		label_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				label_6.setOpaque(changeState(7));
				label_6.repaint();
			}
		});
		label_6.setBackground(Color.BLACK);
		label_6.setBounds(213, 396, 178, 254);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setOpaque(cardStates[8]);
		label_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				label_7.setOpaque(changeState(8));
				label_7.repaint();
			}
		});
		label_7.setBackground(Color.BLACK);
		label_7.setBounds(417, 396, 178, 254);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setOpaque(cardStates[9]);
		label_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				label_8.setOpaque(changeState(9));
				label_8.repaint();
			}
		});
		label_8.setBackground(Color.BLACK);
		label_8.setBounds(620, 396, 178, 254);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setOpaque(cardStates[10]);
		label_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				label_9.setOpaque(changeState(10));
				label_9.repaint();
			}
		});
		label_9.setBackground(Color.BLACK);
		label_9.setBounds(823, 396, 178, 254);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("");
		label_10.setOpaque(cardStates[11]);
		label_10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				label_10.setOpaque(changeState(11));
				label_10.repaint();
			}
		});
		label_10.setBackground(Color.BLACK);
		label_10.setBounds(1026, 396, 178, 254);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setOpaque(cardStates[12]);
		label_11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				label_11.setOpaque(changeState(12));
				label_11.repaint();
			}
		});
		label_11.setBackground(Color.BLACK);
		label_11.setBounds(1232, 396, 178, 254);
		frame.getContentPane().add(label_11);
		
		JLabel labelBK = new JLabel("");
		labelBK.setBounds(0, 0, 1422, 753);
		Image bk = new ImageIcon(this.getClass().getResource("/PickCharacters.png")).getImage();
		labelBK.setIcon(new ImageIcon( bk));
		frame.getContentPane().add(labelBK);
		
	}
	
	private void msgbox(String s){
	   JOptionPane.showMessageDialog(null, s);
	}
	
	private ArrayList <Character> convertInt2Heroes(int[] arr) {
		ArrayList <Character> characters = new ArrayList<Character>();
		for (int i=0; i<arr.length; i++) {
			characters.add(heroes.get(arr[i]));
		}
		return characters;
	}
}
