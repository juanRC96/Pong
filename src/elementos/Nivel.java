package elementos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Nivel {

	private Juego j;
	
	//constructor
	public Nivel(Juego j) {
		this.j = j;
	}
	
	// pintar nivel
	public void paint(Graphics2D g) {
		g.setColor(Color.RED);
		g.setFont(new Font("Candara", Font.ITALIC, 30));
		g.drawString("Nivel", 140, 40);
		g.drawString(String.valueOf((int)j.bola.getVelocidad()-4), 210, 40);
	}
}
