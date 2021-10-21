package elementos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Juego extends JPanel {

	private static final long serialVersionUID = 1L;

	Barra barra = new Barra(this);
	Bola bola = new Bola(this);

	// constructor
	public Juego() {

		// color de fondo del jpanel
		this.setBackground(Color.BLACK);

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				barra.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				barra.keyPressed(e);
			}
		});
		setFocusable(true);
	}

	// devolver puntaje
	private int getPuntaje() {
		return bola.getPuntaje();
	}

	// animar objetos
	private void mover() {
		barra.mover();
		bola.mover();
	}

	// alerta de juego terminado
	public void juegoTerminado() {
		JOptionPane.showMessageDialog(this, this.getPuntaje(), "Su puntaje", JOptionPane.OK_OPTION);
		System.exit(ABORT);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		// barra
		g2d.setColor(Color.GREEN);
		barra.paint(g2d);
		// bola
		g2d.setColor(Color.RED);
		bola.paint(g2d);
		// puntuacion
		g2d.setColor(Color.CYAN);
		g2d.setFont(new Font("Candara", Font.ITALIC, 40));
		g2d.drawString(String.valueOf(getPuntaje()), 10, 40);
	}

	// main
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Ventana");
		Juego j = new Juego();
		frame.add(j);
		frame.setSize(400, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		while (true) {
			j.repaint();
			j.mover();
			Thread.sleep(10);
		}

	}
}