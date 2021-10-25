package elementos;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Bola {

	private static final int DIAMETRO = 30;

	// posicion inicial
	int x = 250;
	int y = 0;
	// velocidad de desplazamiento
	int xa = 7;
	int ya = 7;
	int colision = 0;

	private Juego j;

	// constructor
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

		x = x + xa;
		y = y + ya;
	}

	public void cambiarDireccionBa() {
		
		if (j.barra.getY() - j.barra.getAlto() > y) {
			ya = -ya;
			if (j.barra.getX() - j.barra.getAncho() > x) {
				xa = -xa;
			}
			else if (j.barra.getX() + j.barra.getAncho() < x) {
				xa = -xa;
			}
		}
		else if (j.barra.getY() + j.barra.getAlto() < y) {
			ya = -ya;
			if (j.barra.getX() - j.barra.getAncho() > x) {
				xa = -xa;
			}
			else if (j.barra.getX() + j.barra.getAncho() < x) {
				xa = -ya;
			}
		}
		colision = colision + 1;
	}

	public void cambiarDireccionBl() {
		
		if (j.bloque.getY() + j.bloque.getAlto() > y) {
			ya = -ya;
			if (j.bloque.getX() - j.bloque.getAncho() > x) {
				xa = -xa;
			}
			else if (j.bloque.getX() + j.bloque.getAncho() < x) {
				xa = -xa;
			}
		}
		else if (j.bloque.getY() - j.bloque.getAlto() < y) {
			ya = -ya;
			if (j.bloque.getX() - j.bloque.getAncho() > x) {
				xa = -xa;
			}
			else if (j.bloque.getX() + j.bloque.getAncho() < x) {
				xa = -ya;
			}
		}
		colision = colision + 1;
	}

	// devolver cantidad de colisiones
	public int getCantColision() {
		return colision;
	}

	// dibujo de la bola
	public void paint(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, DIAMETRO, DIAMETRO);
	}

	// cuando dos figuras se pisan, devuelve un true
	public boolean getColisionConBarra() {
		return j.barra.getBounds().intersects(getBounds());
	}

	public boolean getColisionConBloque() {
		return j.bloque.getBounds().intersects(getBounds());
	}

	// dibujo de la hitbox de la bola
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETRO, DIAMETRO);
	}
}
