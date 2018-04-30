package monitorizacion;

public class ManejadorNotificaciones {

	private double vueltas_aceite;
	private double vueltas_pastillas;
	private double vueltas_revision;
	
	private double vueltas_aceite_anteriores;
	private double vueltas_pastillas_anteriores;
	private double vueltas_revision_anteriores;
	
	private final double LIMITE_ACEITE = 100; //100 5000000
	private final double LIMITE_PASTILLAS = 150; //150 100000000
	private final double LIMITE_REVISION = 200; //200 1000000000
	
	public ManejadorNotificaciones() {
		vueltas_aceite = 0;
		vueltas_pastillas = 0;
		vueltas_revision = 0;
		vueltas_aceite_anteriores = 0;
		vueltas_pastillas_anteriores = 0;
		vueltas_revision_anteriores = 0;
	}
	
	public void actualizar(double vueltas_totales) {
		vueltas_aceite = vueltas_totales - vueltas_aceite_anteriores;
		vueltas_pastillas = vueltas_totales - vueltas_pastillas_anteriores;
		vueltas_revision = vueltas_totales - vueltas_revision_anteriores;
	}
	
	public boolean notificarAceite() {
		if(vueltas_aceite >= LIMITE_ACEITE) {
			return true;
		}
		else
			return false;
	}
	
	public boolean notificarPastillas() {
		if(vueltas_pastillas >= LIMITE_PASTILLAS) {
			return true;
		}
		else
			return false;
	}
	
	public boolean notificarRevision() {
		if(vueltas_revision >= LIMITE_REVISION) {
			return true;
		}
		else
			return false;
	}
	
	public double getVueltasAceite() {
		return vueltas_aceite;
	}
	
	public double getVueltasPastillas() {
		return vueltas_pastillas;
	}
	
	public double getVueltasRevision() {
		return vueltas_revision;
	}
	
	public void cambioAceite() {
		vueltas_aceite_anteriores += vueltas_aceite;
	}
	
	public void cambioPastillas() {
		vueltas_pastillas_anteriores += vueltas_pastillas;
	}
	
	public void cambioRevision() {
		vueltas_revision_anteriores += vueltas_revision;
	}
	
}
