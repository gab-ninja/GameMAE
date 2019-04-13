package MAE;

import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GI_Store implements Runnable {

	private JFrame frame;
	private Game game;

	public GI_Store(Game game) {
		this.game = game;
		initialize();
	}
	
	private void cardClick(int card) {
		System.out.println(card);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1069, 678);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStore = new JLabel("Store");
		lblStore.setFont(new Font("Arial", Font.BOLD, 18));
		lblStore.setHorizontalAlignment(SwingConstants.CENTER);
		lblStore.setBounds(434, 64, 152, 84);
		frame.getContentPane().add(lblStore);
		
		JLabel lblNewLabel = new JLabel("Item1");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cardClick(1);
			}
		});
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblNewLabel.setBounds(90, 200, 219, 272);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("Item2");
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cardClick(2);
			}
		});
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(407, 200, 219, 272);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Item3");
		label_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				cardClick(3);
			}
		});
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(730, 200, 219, 272);
		frame.getContentPane().add(label_1);
		
		JButton btnNewButton = new JButton("Continue to battle");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.updateFromStore();
				frame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(755, 544, 204, 25);
		frame.getContentPane().add(btnNewButton);
	}
	
	@Override
	public void run() {
		frame.setVisible(true);
		
	}
}
