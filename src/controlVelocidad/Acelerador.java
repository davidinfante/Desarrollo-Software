package controlVelocidad;

public class Acelerador {

	//private boolean acelerando;
	private Eje eje;
	private final double aceleracion = 0.001;
	
	public Acelerador(Eje eje) {
		//acelerando = false;
		this.eje = eje;
	}
	
	public void acelerar() {
		eje.variarRPM(aceleracion);
	}
	
	// public double actualizar()
	
	/*public void soltar() {
		acelerando = false;
	}
	
	public void pisar() {
		acelerando = true;
	}
	
	public boolean getAcelerando() {
		return acelerando;
	}*/
}
