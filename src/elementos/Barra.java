package elementos;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Barra {

	private static final int ANCHO = 100;
	private static final int ALTO = 20;

	int x = 0;
	int y = 400;
	int xa = 0;
	int ya = 0;
	private Juego j;

	public Barra(Juego j) {
		this.j = j;
	}

	// movimiento de la barra, limitado al ancho y alto
	public void mover() {
		if (x + xa > 0 && x + xa < j.getWidth() - ANCHO)
			x = x + xa;
		if (y + ya > 0 && y + ya < j.getHeight() - ALTO)
			y = y + ya;
	}

	// accion al soltar tecla
	public void keyReleased(KeyEvent e) {
		xa = 0;
		ya = 0;
	}

	// accion al presionar tecla
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -5;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 5;
	}

	// dibujar barra
	public void paint(Graphics2D g) {
		g.fillRect(x, y, ANCHO, ALTO);
	}

	// dibujo de la hitbox de la barra
	public Rectangle getBounds() {
		return new Rectangle(x, y, ANCHO, ALTO);
	}

	// devolver coordenada y
	public int getY() {
		return y;
	}

	// devolver coordenada x
	public int getX() {
		return x;
	}

	public int getAncho() {
		return ANCHO;
	}

	public int getAlto() {
		return ALTO;
	}

}
