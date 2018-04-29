package controlVelocidad;

public class Freno {

	private boolean frenando;
	private Eje eje;
	private final double desaceleracion = -100;
	
	public Freno(Eje eje) {
		frenando = false  ;
		this.eje = eje;
	}
	
	public void frenar(String tipo) {
		double desaceleracion_f = 0;
		if(tipo == "suave")
			desaceleracion_f = -10;
		else if(tipo == "brusco")
			desaceleracion_f = desaceleracion;
		eje.variarVueltas(desaceleracion_f);
	}
	
	public void cambiarEstadoFreno() {
		frenando = !frenando;
	}
	
	public boolean getFrenando() {
		return frenando;
	}
}
