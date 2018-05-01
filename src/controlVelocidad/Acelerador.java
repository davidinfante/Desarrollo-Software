package controlVelocidad;

public final class Acelerador {

	private Eje eje;
	private final double aceleracion = 0.1;
	
	public Acelerador(Eje eje) {
		this.eje = eje;
	}
	
	public void acelerar() {
		eje.variarVueltas(aceleracion);
	}

}
