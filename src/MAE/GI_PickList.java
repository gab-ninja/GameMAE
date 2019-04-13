package MAE;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class GI_PickList implements Runnable {

	private JFrame frame;
	private ArrayList<Item> potions = new ArrayList<Item>();
	
	public GI_PickList(ArrayList<Item> potions) {
		this.potions = potions;
		initialize();
	}

	private void initialize() {		
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 368, 353);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JList list = new JList(potions.toArray());
		list.setFont(new Font("Arial", Font.PLAIN, 14));
		list.setBounds(56, 112, 257, 128);
		frame.getContentPane().add(list);
		
		JLabel lblItems = new JLabel("Items");
		lblItems.setHorizontalAlignment(SwingConstants.CENTER);
		lblItems.setFont(new Font("Arial", Font.BOLD, 18));
		lblItems.setBounds(56, 13, 257, 34);
		frame.getContentPane().add(lblItems);
		
		JLabel lblSelectTheItem = new JLabel("<html><p>Select the item you want to use and then press \"Use\" </p></html>");
		lblSelectTheItem.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectTheItem.setFont(new Font("Arial", Font.PLAIN, 14));
		lblSelectTheItem.setBounds(56, 46, 257, 53);
		frame.getContentPane().add(lblSelectTheItem);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 frame.dispose();
			}
		});
		btnNewButton.setBounds(56, 253, 119, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnUse = new JButton("Use");
		btnUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO code for executing potion
				frame.dispose();
			}
		});
		btnUse.setBackground(Color.WHITE);
		btnUse.setForeground(Color.BLACK);
		btnUse.setBounds(194, 253, 119, 25);
		frame.getContentPane().add(btnUse);
	}
	
	@Override
	public void run() {
		frame.setVisible(true);
		
	}
}
