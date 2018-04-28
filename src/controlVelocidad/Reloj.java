package controlVelocidad;

public class Reloj extends Thread {

	private ControlVelocidad controlVelocidad;
	private boolean ejecutando = true;
	
	public Reloj(ControlVelocidad controlVelocidad) {
		this.controlVelocidad = controlVelocidad;
		ejecutando = true;
	}
	
	public void run() {
		
		while(ejecutando) {
			controlVelocidad.conducir();
		}
	}
	
	public void terminate() {
		ejecutando = false;
	}
}
