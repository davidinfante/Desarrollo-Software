package controlVelocidad;

public class Registro {

	private int velocidadConstante;
	private Eje eje;
	
	
	public Registro(Eje eje) {
		velocidadConstante = 0;
		this.eje = eje;
	}
	
	public void registrarVelocidad() { //synchronized
		velocidadConstante = eje.getVelocidad();
	}
	
	public int getVelocidadConstante() { //synchronized
		return velocidadConstante;
	}
}
