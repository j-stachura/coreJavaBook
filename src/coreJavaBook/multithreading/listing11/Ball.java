package coreJavaBook.multithreading.listing11;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Pi�ka poruszaj�ca si� o pdbijaj�ca od kraw�dzi komponentu.
 */
public class Ball {

	/**
	 * Przesuwa pi�k� do nast�pnej pozycji, zmieniaj�c kierunek ruchu, je�li
	 * natrafi na kraw�d�.
	 */
	public void move(Rectangle2D bounds) {
		x += dx;
		y += dy;
		if (x < bounds.getMinX()) {
			x = bounds.getMinX();
			dx = -dx;
		}
		if (x + XSIZE >= bounds.getMaxX()) {
			x = bounds.getMaxX() - XSIZE;
			dx = -dx;
		}
		if (y < bounds.getMinY()) {
			y = bounds.getMinY();
			dy = -dy;
		}
		if (y + YSIZE >= bounds.getMaxY()) {
			y = bounds.getMaxY() - YSIZE;
			dy = -dy;
		}
	}

	/**
	 * Tworzy kszta�t pi�ki dla bie��cej pozycji.
	 */
	public Ellipse2D getShape() {
		return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
	}

	private static final int XSIZE = 15;
	private static final int YSIZE = 15;
	private double x = 0;
	private double y = 0;
	private double dx = 1;
	private double dy = 1;
}
