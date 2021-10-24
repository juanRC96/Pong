package elementos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Juego extends JPanel {

	private static final long serialVersionUID = 1L;

	Barra barra = new Barra(this);
	Bola bola = new Bola(this);
	public Timer t;
	int i = 0;

	// CONSTRUCTOR
	public Juego() {
		// temporizador
		temporizador();
		// recibir teclas
		recibirTeclas();
		// color de fondo
		setBackground(Color.BLACK);
	}

	private void recibirTeclas() {

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

	// temporizador
	private void temporizador() {
		t = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				i++;
			}
		});
		t.start();
	}

	// devolver tiempo temporizador
	private int getTiempo() {
		return i;
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
		barra.paint(g2d);
		// bola
		bola.paint(g2d);
		// puntuacion
		g2d.setColor(Color.CYAN);
		g2d.setFont(new Font("Candara", Font.ITALIC, 40));
		g2d.drawString(String.valueOf(getPuntaje()), 10, 40);
		// temporizador
		g2d.setColor(Color.YELLOW);
		g2d.setFont(new Font("Candara", Font.ITALIC, 40));
		g2d.drawString(String.valueOf(getTiempo()), 340, 40);
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