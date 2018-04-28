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
	
	public void soltar() {
		frenando = false;
	}
	
	public void pisar() {
		frenando = true;
	}
	
	public boolean getFrenando() {
		return frenando;
	}
}
