package elementos;

import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bola {

	private static final int DIAMETRO = 50;

	int x = 200;
	int y = 0;
	int xa = 2;
	int ya = 2;
	int puntaje = 0;
	
	private Juego j;

	public Bola(Juego j) {
		this.j = j;
	}

	public void mover() {

		// movimiento de la bola
		if (x + xa < 0)
			xa = 3;
		if (x + xa > j.getWidth() - DIAMETRO)
			xa = -3;
		if (y + ya < 0)
			ya = 3;
		if (y + ya > j.getHeight() - DIAMETRO)
			j.juegoTerminado();

		// segun la posicion de la bola y la barra cambia la direccion del rebote
		if (collision()) {

			if (j.barra.getY() - j.barra.getAlto() > y ) {
				ya = -3;
			}
			if (j.barra.getY() + j.barra.getAlto() < y) {
				ya = 3;
			}
			if (j.barra.getX() - j.barra.getAncho() > x) {
				xa = 3;
			}
			if (j.barra.getX() + j.barra.getAncho() < x) {
				xa = -3;
			}
			
			puntaje = puntaje + 1;
		}

		x = x + xa;
		y = y + ya;

	}
	
	//devuelvo el puntaje
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

	//dibujo de la hitbox de la bola
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETRO, DIAMETRO);
	}
}
