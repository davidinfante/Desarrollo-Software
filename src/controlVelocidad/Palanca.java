package controlVelocidad;

public final class Palanca {

	private Estado estado;
	
	public Palanca() {
		estado = Estado.PARADO;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	public Estado getEstado() {
		return estado;
	}
}
