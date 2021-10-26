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

	// movimiento de la bola
	public void mover() {

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

	// cambiar direccion de la bola
	public void cambiarDireccion() {

		if (j.bloque.getY() + j.bloque.getAlto() > y) {
			ya = -ya;
		} else if (j.bloque.getY() - j.bloque.getAlto() < y) {
			ya = -ya;
		}
	}

	// dibujo de la bola
	public void paint(Graphics2D g) {
		g.setColor(Color.RED);
		g.fillOval(x, y, DIAMETRO, DIAMETRO);
	}

	// cuando la barra y la bola colisionan devuelve true
	public boolean getColisionConBarra() {
		return j.barra.getBounds().intersects(getBounds());
	}
	
	// cuando el bloque y la bola colisionan devuelve true
	public boolean getColisionConBloque() {
		return j.bloque.getBounds().intersects(getBounds());
	}

	// dibujo de la hitbox de la bola
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETRO, DIAMETRO);
	}
}
