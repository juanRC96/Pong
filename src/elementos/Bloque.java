package elementos;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Bloque {
	
	private int x = 100;
	private int y = 100;
	private int ANCHO = 100;
	private int ALTO = 20;
	private Juego j;
	int puntaje;
	
	Random random = new Random();
	
	public Bloque(Juego j) {
		this.j = j;
	}
	
	public int getPuntaje() {
		return puntaje;
	}
	
	public void cambiarPosicionRebote() {
		if (j.bola.getColisionConBloque() == true) {
			puntaje = puntaje + 1;
			j.bola.cambiarDireccionBl();
			x = random.nextInt(j.getWidth() - ANCHO);
			y = random.nextInt(j.getHeight() - 300);}
	}
		
	public void paint(Graphics2D g){
		g.setColor(Color.MAGENTA);
		g.fillRect(x, y, ANCHO, ALTO);
	}
	
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
