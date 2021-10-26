package elementos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Puntaje {

	private Juego j;
	int puntaje;

	// constructor
	public Puntaje(Juego j) {
		this.j = j;
	}

	// pintar puntaje
	public void paint(Graphics2D g) {
		puntaje = (j.bloque.getPuntaje());
		g.setColor(Color.CYAN);
		g.setFont(new Font("Candara", Font.ITALIC, 40));
		g.drawString(String.valueOf(puntaje), 10, 40);
	}

	// devolver puntaje
	public int getPuntaje() {
		return puntaje;
	}

}
