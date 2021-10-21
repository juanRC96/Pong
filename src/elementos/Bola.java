package elementos;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bola {

	private static final int DIAMETRO = 30;

	int x = 300;
	int y = 0;
	// velocidad de desplazamiento
	int xa = 5;
	int ya = 5;
	int puntaje = 0;

	private Juego j;

	public Bola(Juego j) {
		this.j = j;
	}

	public void mover() {

		// movimiento de la bola
		if (x + xa < 0)
			xa = -xa;
		if (x + xa > j.getWidth() - DIAMETRO)
			xa = -xa;
		if (y + ya < 0)
			ya = -ya;
		if (y + ya > j.getHeight() - DIAMETRO)
			j.juegoTerminado();

		// calculo del rebote al colisionar
		if (collision()) {

			if (j.barra.getY() - j.barra.getAlto() > y) {
				ya = -ya;
			}
			if (j.barra.getY() + j.barra.getAlto() < y) {
				ya = -ya;
			}
			if (j.barra.getX() - j.barra.getAncho() > x) {
				xa = -xa;
			}
			if (j.barra.getX() + j.barra.getAncho() < x) {
				xa = -xa;
			}
			puntaje = puntaje + 1;
		}
		x = x + xa;
		y = y + ya;
	}

	// devuelvo el puntaje
	public int getPuntaje() {
		return puntaje;
	}

	// dibujo de la bola
	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETRO, DIAMETRO);
	}

	// cuando dos figuras se pisan, devuelve un true
	private boolean collision() {
		return j.barra.getBounds().intersects(getBounds());
	}

	// dibujo de la hitbox de la bola
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETRO, DIAMETRO);
	}
}
