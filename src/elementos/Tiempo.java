package elementos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Tiempo {

	private Timer t;
	private int i;

	// constructor
	public Tiempo() {
	}

	// temporizador
	public void temporizador() {
		t = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				i++;
			}
		});
		t.start();
	}

	// devolver tiempo
	private int getTiempo() {
		return i;
	}

	// pintar tiempo
	public void paint(Graphics2D g) {
		g.setColor(Color.YELLOW);
		g.setFont(new Font("Candara", Font.ITALIC, 40));
		g.drawString(String.valueOf(getTiempo()), 340, 40);
	}
}
