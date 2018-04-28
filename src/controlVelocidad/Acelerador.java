package controlVelocidad;

public class Acelerador {

	private boolean acelerando;
	private Eje eje;
	private final int aceleracion = 1;
	
	public Acelerador(Eje eje) {
		acelerando = false;
		this.eje = eje;
	}
	
	public void acelerar() {
		eje.variarRPM(aceleracion);
	}
	
	// public double actualizar()
	
	public void soltar() {
		acelerando = false;
	}
	
	public void pisar() {
		acelerando = true;
	}
	
	public boolean getAcelerando() {
		return acelerando;
	}
}
