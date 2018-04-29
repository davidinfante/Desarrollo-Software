package monitorizacion;


public class RelojMonitor extends Thread {

	private int intervalo;
	private Monitor monitor;
	private boolean ejecutando = true;
	private volatile double tiempo_total;
	
	public RelojMonitor(Monitor monitor, int intervalo) {
		this.monitor = monitor;
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
			monitor.monitorizar();
		}
	}
	
	public void terminate() {
		ejecutando = false;
	}
	
	public double getTiempoTotal() {
		return tiempo_total/1000; //segundos
	}
}
