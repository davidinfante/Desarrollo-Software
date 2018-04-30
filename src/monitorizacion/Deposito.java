package monitorizacion;

public class Deposito {

	private double nivel;
	private final double TOPE = 500;
	private final double CONST_CONSUMO = 0.1;
	
	public Deposito() {
		nivel = TOPE;
	}
	
	public void actualizar(int velocidad) {
		nivel -= velocidad*CONST_CONSUMO;
		if(nivel < 0) nivel=0;
	}
	
	public double getNivel() {
		return nivel;
	}
	
	public void repostar() {
		nivel = TOPE;
	}
	
	public double getTope() {
		return TOPE;
	}
	
}
