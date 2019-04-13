package MAE;

import java.awt.Cursor;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GI_Store implements Runnable {

	private JFrame frame;
	private Game game;
	private ArrayList<Item> items = new ArrayList<Item>();
	private Human human;
	
	private JLabel label_1;
	private JLabel label;
	private JLabel label_2;

	public GI_Store(Game game, ArrayList<Item> items, Human human) {
		this.game = game;
		this.items = items;
		this.human = human;
		initialize();
	}
	
	public void msgbox(String s){
	   JOptionPane.showMessageDialog(null, s);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 960, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		Image icon = new ImageIcon(this.getClass().getResource("/iconWhite.png")).getImage();
		frame.setIconImage(icon);
		frame.setTitle("Mists of the Abandoned Etherdungeon");	
		frame.getContentPane().setLayout(null);
		Image img_itemBK = new ImageIcon(this.getClass().getResource("/shopBK.jpg")).getImage();
		
		JLabel l3_price = new JLabel("Price: " + items.get(2).getPrice());
		l3_price.setHorizontalAlignment(SwingConstants.CENTER);
		l3_price.setForeground(Color.WHITE);
		l3_price.setFont(new Font("Arial", Font.BOLD, 16));
		l3_price.setBounds(658, 483, 252, 24);
		frame.getContentPane().add(l3_price);
		
		JLabel l2_price = new JLabel("Price: " + items.get(1).getPrice());
		l2_price.setHorizontalAlignment(SwingConstants.CENTER);
		l2_price.setForeground(Color.WHITE);
		l2_price.setFont(new Font("Arial", Font.BOLD, 16));
		l2_price.setBounds(347, 483, 252, 24);
		frame.getContentPane().add(l2_price);
		
		JLabel l1_price = new JLabel("Price: " + items.get(0).getPrice());
		l1_price.setHorizontalAlignment(SwingConstants.CENTER);
		l1_price.setForeground(Color.WHITE);
		l1_price.setFont(new Font("Arial", Font.BOLD, 16));
		l1_price.setBounds(51, 483, 252, 24);
		frame.getContentPane().add(l1_price);
		
		label_2 = new JLabel(String.valueOf(this.human.getBudget()));
		label_2.setHorizontalAlignment(SwingConstants.LEFT);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Arial", Font.BOLD, 24));
		label_2.setBounds(186, 539, 117, 41);
		frame.getContentPane().add(label_2);
		
		JLabel lblBudget = new JLabel("Budget:");
		lblBudget.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBudget.setForeground(Color.WHITE);
		lblBudget.setFont(new Font("Arial", Font.BOLD, 24));
		lblBudget.setBounds(51, 538, 123, 41);
		frame.getContentPane().add(lblBudget);
		
		
		label_1 = new JLabel(String.valueOf(Collections.frequency(human.getItems(), items.get(1))));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Arial", Font.BOLD, 24));
		label_1.setBounds(450, 430, 46, 40);
		frame.getContentPane().add(label_1);
		
		label = new JLabel(String.valueOf(Collections.frequency(human.getItems(), items.get(0))));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 24));
		label.setBounds(152, 430, 46, 40);
		frame.getContentPane().add(label);
		
		JLabel item1 = new JLabel("");
		item1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (human.getBudget() < items.get(0).getPrice()) {
					msgbox("Insuficient founds to buy this item");
					return;
				}
				human.takeCoins(items.get(0).getPrice());
				human.addItems(items.get(0));
				label.setText(String.valueOf(Collections.frequency(human.getItems(), items.get(0))));
				label_2.setText(String.valueOf(human.getBudget()));
			}
		});
		Image img_item1 = new ImageIcon(this.getClass().getResource("/i1.png")).getImage();
		item1.setIcon(new ImageIcon( img_item1));
		item1.setHorizontalAlignment(SwingConstants.CENTER);
		item1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		item1.setBounds(51, 154, 252, 353);
		frame.getContentPane().add(item1);
		
		JLabel item2 = new JLabel("");
		Image img_item2 = new ImageIcon(this.getClass().getResource("/i2.png")).getImage();
		item2.setIcon(new ImageIcon( img_item2));
		item2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		item2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (human.getBudget() < items.get(1).getPrice()) {
					msgbox("Insuficient founds to buy this item");
					return;
				}
				human.takeCoins(items.get(1).getPrice());
				human.addItems(items.get(1));
				label_1.setText(String.valueOf(Collections.frequency(human.getItems(), items.get(1))));
				label_2.setText(String.valueOf(human.getBudget()));
			}
		});
		item2.setHorizontalAlignment(SwingConstants.CENTER);
		item2.setBounds(347, 154,  252, 353);
		frame.getContentPane().add(item2);
		
		JLabel item3 = new JLabel("");
		Image img_item3 = new ImageIcon(this.getClass().getResource("/i3.png")).getImage();
		item3.setIcon(new ImageIcon( img_item3));
		item3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		item3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (human.getBudget() < items.get(2).getPrice()) {
					msgbox("Insuficient founds to buy this item");
					return;
				}
				human.takeCoins(items.get(2).getPrice());
				label_2.setText(String.valueOf(human.getBudget()));
				items.get(2).execute(game);
				msgbox("On the next level all the heroes start with the maximum health");
			}
		});
		item3.setHorizontalAlignment(SwingConstants.CENTER);
		item3.setBounds(658, 154,  252, 353);
		frame.getContentPane().add(item3);
		
		JButton btnNewButton = new JButton("Continue to battle");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.updateFromStore();
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(713, 539, 201, 40);
		frame.getContentPane().add(btnNewButton);
		
		
		JLabel itemBK = new JLabel("");
		itemBK.setIcon(new ImageIcon( img_itemBK));
		itemBK.setHorizontalAlignment(SwingConstants.CENTER);
		itemBK.setBounds(0, 0, 954, 605);
		frame.getContentPane().add(itemBK);
	}
	
	@Override
	public void run() {
		frame.setVisible(true);
		
	}
}
