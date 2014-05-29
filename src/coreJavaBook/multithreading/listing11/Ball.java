package coreJavaBook.multithreading.listing11;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Pi³ka poruszaj¹ca siê o pdbijaj¹ca od krawêdzi komponentu.
 */
public class Ball {

	/**
	 * Przesuwa pi³kê do nastêpnej pozycji, zmieniaj¹c kierunek ruchu, jeœli
	 * natrafi na krawêdŸ.
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
	 * Tworzy kszta³t pi³ki dla bie¿¹cej pozycji.
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
