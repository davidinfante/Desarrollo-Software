package controlVelocidad;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class pantallaVelocidad extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private static JLabel label;
	private static JPanel panel;
	private ControlVelocidad controlVelocidad;
	public Thread thr;
	
	public pantallaVelocidad(ControlVelocidad controlVelocidad) {
		setSize(400, 100);
		panel = new JPanel();
		getContentPane().add(panel);
		label = new JLabel();
		panel.add(label);
		this.controlVelocidad = controlVelocidad;
		thr = new Thread(this);
	}
	
	public void run() {
		while (true) {
			label.setText(String.valueOf(controlVelocidad.getVelocidad()));
		}
	}
}
