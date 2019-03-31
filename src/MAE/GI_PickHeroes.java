package MAE;

import java.awt.*;
import javax.swing.*;

public class GI_PickHeroes {

	private JFrame frame;

	public GI_PickHeroes() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1440, 800);
		Image icon = new ImageIcon(this.getClass().getResource("/icon.png")).getImage();
		frame.setIconImage(icon);
		frame.setTitle("Mists of the Abandoned Etherdungeon");		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		Image bk = new ImageIcon(this.getClass().getResource("/PickCharacters.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon( bk));
		lblNewLabel.setBounds(0, 0, 1700, 1000);
		frame.getContentPane().add(lblNewLabel);
	}
}
