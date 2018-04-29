package controlVelocidad;

public class Reloj extends Thread {

	private final int INTERVALO = 500;
	private ControlVelocidad controlVelocidad;
	private boolean ejecutando = true;
	private double tiempo_total;
	
	public Reloj(ControlVelocidad controlVelocidad) {
		this.controlVelocidad = controlVelocidad;
		ejecutando = true;
		tiempo_total = 0.0;
	}
	
	public void run() {
		while(ejecutando) {
			controlVelocidad.conducir();
		}
	}
	
	public void terminate() {
		ejecutando = false;
	}
	
	public double getTiempoTotal() {
		return tiempo_total/1000; //segundos
	}
}
