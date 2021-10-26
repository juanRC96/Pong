package elementos;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

public class Bloque {

	private int x = 100;
	private int y = 100;
	private int ANCHO = 100;
	private int ALTO = 20;
	private Juego j;
	private Image imagen;
	int puntaje;

	Random random = new Random();

	// constructor
	public Bloque(Juego j) {
		this.j = j;
	}

	// devolver puntaje
	public int getPuntaje() {
		return puntaje;
	}

	// cambiar posicion del bloque y direccion de la bola
	public void cambiarPosicionRebote() {
		if (j.bola.getColisionConBloque() == true) {
			puntaje = puntaje + 1;
			j.bola.cambiarDireccionBl();
			x = random.nextInt(j.getWidth() - ANCHO);
			y = random.nextInt(j.getHeight() - 400);
		}
	}

	// dibujar bloque
	public void paint(Graphics2D g) {	
		imagen = new ImageIcon(this.getClass().getResource("bloque.png")).getImage();
		g.drawImage(imagen,x,y,ANCHO,ALTO,null);	
	}

	// devolver bordes del bloque
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

	// devolver ancho
	public int getAncho() {
		return ANCHO;
	}

	// devolver alto
	public int getAlto() {
		return ALTO;
	}
}
