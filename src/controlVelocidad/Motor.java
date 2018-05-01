package controlVelocidad;

public final class Motor {

	private boolean estado;
	
	public Motor() {
		estado = false;
	}
	
	public boolean getEstado() {
		return estado;
	}
	
	public void cambiarEstado() {
		estado = !estado;
	}
}
