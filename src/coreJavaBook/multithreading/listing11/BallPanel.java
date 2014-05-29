package coreJavaBook.multithreading.listing11;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * Panel rysuj¹cy pi³ki.
 */
public class BallPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -426020521160151395L;

	/**
	 * Dodaje pi³kê do panelu
	 * 
	 * @param b
	 *            dodawana pi³ka
	 */
	public void add(Ball b) {
		balls.add(b);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		for (Ball b : balls) {
			g2.fill(b.getShape());
		}
	}

	private ArrayList<Ball> balls = new ArrayList<Ball>();
}
