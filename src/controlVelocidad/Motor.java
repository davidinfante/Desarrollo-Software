package controlVelocidad;

public class Motor {

	private boolean estado;
	
	public Motor() {
		estado = true;
	}
	
	public boolean getEstado() {
		return estado;
	}
	
	public void cambiarEstado() {
		estado = !estado;
	}
}
