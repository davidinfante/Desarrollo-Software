package controlVelocidad;

public class Freno {

	private boolean frenando;
	private Eje eje;
	private final int desaceleracion = -1;
	
	public Freno(Eje eje) {
		frenando = false  ;
		this.eje = eje;
	}
	
	public void frenar() {
		eje.variarRPM(desaceleracion);
	}
	
	//public double actualizar()
	
	public void cambiarEstadoFreno() {
		frenando = !frenando;
	}
	
	public boolean getFrenando() {
		return frenando;
	}
}
