package monitorizacion;

public class ManejadorNotificaciones {

	private int vueltas_aceite;
	private int vueltas_pastillas;
	private int vueltas_revision;
	
	private int vueltas_aceite_anteriores;
	private int vueltas_pastillas_anteriores;
	private int vueltas_revision_anteriores;
	
	private final int LIMITE_ACEITE = 2000;//5000000;
	private final int LIMITE_PASTILLAS = 4000;//100000000;
	private final int LIMITE_REVISION = 8000;//1000000000;
	
	public ManejadorNotificaciones() {
		vueltas_aceite = 0;
		vueltas_pastillas = 0;
		vueltas_revision = 0;
		vueltas_aceite_anteriores = 0;
		vueltas_pastillas_anteriores = 0;
		vueltas_revision_anteriores = 0;
	}
	
	public void actualizar(int vueltas_totales) {
		vueltas_aceite = vueltas_totales - vueltas_aceite_anteriores;
		vueltas_pastillas = vueltas_totales - vueltas_pastillas_anteriores;
		vueltas_revision = vueltas_totales - vueltas_revision_anteriores;
	}
	
	public boolean notificarAceite() {
		if(vueltas_aceite >= LIMITE_ACEITE) {
			vueltas_aceite_anteriores += LIMITE_ACEITE;
			return true;
		}
		else
			return false;
	}
	
	public boolean notificarPastillas() {
		if(vueltas_pastillas >= LIMITE_PASTILLAS) {
			vueltas_pastillas_anteriores += LIMITE_PASTILLAS;
			return true;
		}
		else
			return false;
	}
	
	public boolean notificarRevision() {
		if(vueltas_revision >= LIMITE_REVISION) {
			vueltas_revision_anteriores += LIMITE_REVISION;
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
	
}
