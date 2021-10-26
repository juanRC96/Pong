package elementos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
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

	Image imagen;

	// CONSTRUCTOR
	public Juego() {
		// iniciar temporizador
		tiempo.temporizador();
		// recibir teclas
		recibirTeclas();
	}

	// recibir teclas
	private void recibirTeclas() {

		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				barra.detenerBarra();
			}

			@Override
			public void keyPressed(KeyEvent e) {
				int tecla = e.getKeyCode();

				switch (tecla) {
				case KeyEvent.VK_LEFT:
					barra.direccionBarra("IZQ");
					break;
				case KeyEvent.VK_RIGHT:
					barra.direccionBarra("DER");
					break;
				case KeyEvent.VK_E:
					System.exit(0);

				}
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
		JOptionPane.showMessageDialog(this, "Su puntaje es " + puntaje.getPuntaje());
		System.exit(ABORT);
	}

	// cuando el tiempo llegue a 60 segundos, el juego se termina
	public void verificarTiempo() {
		if (tiempo.getTiempo() >= 60) {
			juegoTerminado();
		}
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// fondo de pantalla
		imagen = new ImageIcon(this.getClass().getResource("fondo.png")).getImage();
		g.drawImage(imagen, 0, 0, null);

		// dibujo los componentes
		barra.paint(g2d);
		bola.paint(g2d);
		bloque.paint(g2d);
		tiempo.paint(g2d);
		puntaje.paint(g2d);
	}

	// main
	public static void main(String[] args) throws InterruptedException {
		JFrame frame = new JFrame("Juego");
		Juego j = new Juego();
		frame.add(j);
		frame.setSize(400, 800);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// game loop
		while (true) {
			j.repaint();
			j.mover();
			j.verificarTiempo();
			Thread.sleep(10);
		}

	}
}