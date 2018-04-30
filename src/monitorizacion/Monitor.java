package monitorizacion;

import controlVelocidad.ControlVelocidad;
import controlVelocidad.Eje;

public class Monitor {

	private Deposito deposito;
	private ManejadorNotificaciones manejadorNotificaciones;
	private VelocidadMedia velocidadMedia;
	private ConsumoMedio consumoMedio;
	private RelojMonitor relojMonitor;
	private Eje eje;
	
	public Monitor(ControlVelocidad controlVelocidad, int intervalo) {
		this.eje = controlVelocidad.getEje();
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
		deposito.actualizar(eje.getVelocidad());
		velocidadMedia.calcular(eje.getVelocidad());
		consumoMedio.calcular();
		manejadorNotificaciones.actualizar(eje.getVueltas());
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
