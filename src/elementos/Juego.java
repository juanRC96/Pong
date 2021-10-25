package elementos;

import java.awt.Color;
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
	Bloque bloque = new Bloque(this);
	Tiempo tiempo = new Tiempo();
	Puntaje puntaje = new Puntaje(this);

	// CONSTRUCTOR
	public Juego() {
		// iniciar temporizador
		tiempo.temporizador();
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

	// animar objetos
	private void mover() throws InterruptedException {
		barra.mover();
		bola.mover();
		barra.cambiarRebote();
		bloque.cambiarPosicionRebote();
	}

	// alerta de juego terminado
	public void juegoTerminado() {
		JOptionPane.showMessageDialog(this, "Su puntaje es: " + puntaje.getPuntaje());
		System.exit(ABORT);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// dibujo los componentes
		barra.paint(g2d);
		bola.paint(g2d);
		bloque.paint(g2d);
		tiempo.paint(g2d);
		puntaje.paint(g2d);
	}

	// main
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Ventana");
		Juego j = new Juego();
		frame.add(j);
		frame.setSize(400, 800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//game loop
		while (true) {
			j.repaint();
			j.mover();
			Thread.sleep(10);
		}

	}
}