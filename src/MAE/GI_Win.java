package MAE;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GI_Win implements Runnable {
	private JFrame frame;
	
	public GI_Win() {
		initialize();
	}

	@Override
	public void run() {
		frame.setVisible(true);
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1209, 689);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		Image icon = new ImageIcon(this.getClass().getResource("/iconWhite.png")).getImage();
		frame.setIconImage(icon);
		frame.setLocationRelativeTo(null);
		frame.setTitle("Mists of the Abandoned Etherdungeon");
		
		JLabel lblNewLabel = new JLabel("New label");
		Image bk = new ImageIcon(this.getClass().getResource("/sda.png")).getImage();
		lblNewLabel.setBounds(0, 0, 1208, 657);
		lblNewLabel.setIcon(new ImageIcon( bk));
		frame.getContentPane().add(lblNewLabel);
	}
}