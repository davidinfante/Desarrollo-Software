package monitorizacion;

import controlVelocidad.ControlVelocidad;

public class Monitor {

	private Deposito deposito;
	private ManejadorNotificaciones manejadorNotificaciones;
	private VelocidadMedia velocidadMedia;
	private ConsumoMedio consumoMedio;
	private RelojMonitor relojMonitor;
	private ControlVelocidad controlVelocidad;
	
	public Monitor(ControlVelocidad controlVelocidad, int intervalo) {
		this.controlVelocidad = controlVelocidad;
		deposito = new Deposito();
		manejadorNotificaciones = new ManejadorNotificaciones();
		velocidadMedia = new VelocidadMedia();
		consumoMedio = new ConsumoMedio(deposito);
		relojMonitor = new RelojMonitor(this, intervalo);
	}
	
	public void start() {
		relojMonitor.start();
	}
	
	public void monitorizar() {
		deposito.actualizar(controlVelocidad.getVelocidad());
		velocidadMedia.calcular(controlVelocidad.getVelocidad());
		consumoMedio.calcular();
		manejadorNotificaciones.actualizar(controlVelocidad.getVueltasTotales());
	}
	
	public int getVelocidadMedia() {
		return velocidadMedia.getVelocidadMedia();
	}
	
	public double getConsumoMedio() {
		return consumoMedio.getConsumoMedio();
	}
	
	public boolean notificarAceite() {
		return manejadorNotificaciones.notificarAceite();
	}
	
	public boolean notificarPastillas() {
		return manejadorNotificaciones.notificarPastillas();
	}
	
	public boolean notificarRevision() {
		return manejadorNotificaciones.notificarRevision();
	}
	
	public double getNivelDeposito() {
		return deposito.getNivel();
	}
	
	public void repostar() {
		this.deposito.repostar();
	}
	
	public double getTopeDeposito() {
		return this.deposito.getTope();
	}
	
	public double getVueltasAceite() {
		return manejadorNotificaciones.getVueltasAceite();
	}
	
	public double getVueltasPastillas() {
		return manejadorNotificaciones.getVueltasPastillas();
	}
	
	public double getVueltasRevision() {
		return manejadorNotificaciones.getVueltasRevision();
	}
	
	public void cambioAceite() {
		manejadorNotificaciones.cambioAceite();
	}
	
	public void cambioPastillas() {
		manejadorNotificaciones.cambioPastillas();;
	}
	
	public void cambioRevision() {
		manejadorNotificaciones.cambioRevision();
	}
}
