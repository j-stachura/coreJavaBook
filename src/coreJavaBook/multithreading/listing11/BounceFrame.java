package coreJavaBook.multithreading.listing11;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BounceFrame extends JFrame {
	/**
	 * 
	 */
	private BallPanel panel;
	public static final int DEFAULT_WIDTH = 450;
	public static final int DEFAULT_HEIGHT = 350;
	public static final int STEPS = 1000;
	public static final int DELAY = 3;
	private static final long serialVersionUID = 3068397678130994789L;

	/**
	 * Konstruuje ramkê zawieraj¹c¹ panel, w którym animowana bêdzie pi³ka i
	 * pokazane przyciski Start i Close.
	 */
	public BounceFrame() {
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setTitle("Bounce");

		panel = new BallPanel();
		add(panel, BorderLayout.CENTER);
		JPanel buttonPanel = new JPanel();
		addButton(buttonPanel, "Start", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				addBall();
			}
		});

		addButton(buttonPanel, "Close", new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		add(buttonPanel, BorderLayout.SOUTH);
	}

	public void addButton(Container c, String title, ActionListener listener) {
		JButton button = new JButton(title);
		c.add(button);
		button.addActionListener(listener);
	}

	public void addBall() {
		try {
			Ball ball = new Ball();
			panel.add(ball);

			for (int i = 1; i <= STEPS; i++) {
				ball.move(panel.getBounds());
				panel.paint(panel.getGraphics());
				Thread.sleep(DELAY);
			}
		} catch (InterruptedException e) {

		}
	}

	
}