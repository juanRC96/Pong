package elementos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Puntaje {

	private Juego j;
	private int puntaje;

	// constructor
	public Puntaje(Juego j) {
		this.j = j;
	}
	
	// pintar puntaje
	public void paint(Graphics2D g) {
		g.setColor(Color.CYAN);
		g.setFont(new Font("Candara", Font.ITALIC, 40));
		g.drawString(String.valueOf(getPuntaje()), 10, 40);
	}
	
	//devolver puntaje
	public int getPuntaje() {
		puntaje = (j.bloque.getCantColisiones())*5;
		return puntaje;
	}
}
