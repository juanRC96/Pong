package elementos;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Bola {

	private static final int DIAMETRO = 40;

	// posicion inicial
	private int x = 250;
	private int y = 0;
	// velocidad de desplazamiento
	private double xa = 5;
	private double ya = 5;
	private double velocidad;

	private Image imagen;

	private Juego j;

	// constructor
	public Bola(Juego j) {
		this.j = j;
	}

	// dibujo de la bola
	public void paint(Graphics2D g) {
		imagen = new ImageIcon(this.getClass().getResource("bola.png")).getImage();
		g.drawImage(imagen, x, y, DIAMETRO, DIAMETRO, null);
	}

	// movimiento de la bola
	public void mover() {

		if (x + xa < 0) {
			xa = -xa;
		}
		if (x + xa > j.getWidth() - DIAMETRO) {
			xa = -xa;
		}
		if (y + ya < 0) {
			ya = -ya;
		}
		if (y + ya > j.getHeight() - DIAMETRO) {
			j.juegoTerminado();
		}

		x = x + (int) xa;
		y = y + (int) ya;
	}

	// aumentar velocidad de la bola
	private void aumentarVelocidad() {
		if (xa < 0) {
			xa = xa - 0.2;
		}
		if (xa > 0) {
			xa = xa + 0.2;
		}
		if (ya < 0) {
			ya = ya - 0.2;
		}
		if (ya > 0) {
			ya = ya + 0.2;
		}
	}

	// cambiar direccion de la bola al colisionar con el bloque
	public void cambiarDireccionBl() {

		if (j.bloque.getY() + j.bloque.getAlto() > y) {
			ya = -ya;
		} else if (j.bloque.getY() < y) {
			ya = -ya;
		}
		aumentarVelocidad();
	}

	// cambiar direccion de la bola al colisionar con la barra
	public void cambiarDireccionBa() {

		if (j.barra.getY() + j.barra.getAlto() > y) {
			ya = -ya;
		} else if (j.barra.getY() < y) {
			ya = -ya;
		}
	}

	// devolver velocidad de la bola
	public double getVelocidad() {
		if (xa > 0) {
			velocidad = xa;
		}
		if (xa < 0) {
			velocidad = -xa;
		}
		return velocidad;
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
