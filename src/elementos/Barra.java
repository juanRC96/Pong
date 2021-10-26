package elementos;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Barra {

	private static final int ANCHO = 100;
	private static final int ALTO = 40;

	int x = 0;
	int y = 600;
	int xa = 0;
	int ya = 0;
	private Juego j;
	private Image imagen;

	// constructor
	public Barra(Juego j) {
		this.j = j;
	}

	// movimiento de la barra, limitado al ancho y alto
	public void mover() {
		if (x + xa > 0 && x + xa < j.getWidth() - ANCHO)
			x = x + xa;
	}

	// accion al soltar tecla
	public void detenerBarra() {
		xa = 0;
		ya = 0;
	}

	// desplazamiento de barra
	public void direccionBarra(String d) {
		switch (d) {
		case "IZQ":
			xa = -5;
			break;
		case "DER":
			xa = 5;
			break;
		}
	}

	// dibujar barra
	public void paint(Graphics2D g) {
		/*g.setColor(Color.GREEN);
		g.fillRect(x, y, ANCHO, ALTO);*/
		imagen = new ImageIcon(this.getClass().getResource("barra.png")).getImage();
		g.drawImage(imagen,x,y,ANCHO,ALTO,null);	
	}

	// dibujo de la hitbox de la barra
	public Rectangle getBounds() {
		return new Rectangle(x, y, ANCHO, ALTO);
	}

	// cambiar direccion de la bola al detectar colision
	public void cambiarRebote() {
		if (j.bola.getColisionConBarra()) {
			j.bola.cambiarDireccionBa();
		}
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
