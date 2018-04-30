package controlVelocidad;

public class Acelerador {

	//private boolean acelerando;
	private Eje eje;
	private final double aceleracion = 0.1;
	
	public Acelerador(Eje eje) {
		//acelerando = false;
		this.eje = eje;
	}
	
	public void acelerar() {
		eje.variarVueltas(aceleracion);
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
