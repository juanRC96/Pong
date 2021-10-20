package elementos;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bola {

	private static final int DIAMETRO = 50;

	int x = 100;
	int y = 0;
	int xa = 2;
	int ya = 2;
	private Juego j;

	public Bola(Juego j) {
		this.j = j;
	}

	public void mover() {

		// movimiento de la bola
		if (x + xa < 0)
			xa = 2;
		if (x + xa > j.getWidth() - 50)
			xa = -2;
		if (y + ya < 0)
			ya = 2;
		if (y + ya > j.getHeight() - 50)
			ya = -2;

		// segun la posicion de la bola y la barra cambia la direccion del rebote
		if (collision()) {

			if (j.barra.getY() > y) {
				ya = -2;
			}
			if (j.barra.getY() < y) {
				ya = 2;
			}
			if (j.barra.getX() > x) {
				xa = -2;
			}
			if (j.barra.getX() < x) {
				xa = 2;
			}
		}

		x = x + xa;
		y = y + ya;

	}

	// dibujo de la bola
	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETRO, DIAMETRO);
	}

	// cuando dos figuras se pisan, devuelve un true
	private boolean collision() {
		return j.barra.getBounds().intersects(getBounds());
	}

	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETRO, DIAMETRO);
	}
}
