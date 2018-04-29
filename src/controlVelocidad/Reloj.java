package controlVelocidad;

public class Reloj extends Thread {

	private int intervalo;
	private ControlVelocidad controlVelocidad;
	private boolean ejecutando = true;
	private volatile double tiempo_total;
	
	public Reloj(ControlVelocidad controlVelocidad, int intervalo) {
		this.controlVelocidad = controlVelocidad;
		ejecutando = true;
		tiempo_total = 0.0;
		this.intervalo = intervalo;
	}
	
	public void run() {
		while(ejecutando) {
			
			try {
				sleep(intervalo);
				tiempo_total += intervalo;
			} catch (InterruptedException e) {
				e.printStackTrace();
				ejecutando = false;
			}
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
