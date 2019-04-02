package MAE;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Teste extends Thread {
	
	private JFrame frame;

	
	@Override
	public void run() {
		System.out.println("Hello from another thread");
		initialize();
	}

	public Teste() {
		System.out.println("Its in the init");
		//initialize();
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
