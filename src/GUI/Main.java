package GUI;

import javax.swing.JApplet;

import controlVelocidad.ControlVelocidad;
import monitorizacion.Monitor;

public class Main extends JApplet {

	private static final long serialVersionUID = 1L;

	public void init() {
		setSize(780, 400);
		ControlVelocidad controlVelocidad = new ControlVelocidad(500);
		Monitor monitor = new Monitor(controlVelocidad, 500);
		pantallaVelocidad display = new pantallaVelocidad(controlVelocidad, monitor);
		display.setVisible(true);
		
		add(display);
		
		controlVelocidad.start();
		monitor.start();
		display.thr.start();
	}
}
