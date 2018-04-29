package monitorizacion;

public class ConsumoMedio {

	private double consumo_medio;
	private double sumatoria_consumo;
	private int muestreo;
	private double nivel_anterior;
	private Deposito deposito;
	
	public ConsumoMedio(Deposito deposito) {
		consumo_medio = 0;
		sumatoria_consumo = 0;
		muestreo = 1;
		this.deposito = deposito;
		nivel_anterior = deposito.getNivel();
		
	}
	
	public void calcular() {
		double consumido = nivel_anterior - deposito.getNivel();
		if( consumido > 0) {
			sumatoria_consumo += consumido;
		}
		consumo_medio = sumatoria_consumo/muestreo;
		muestreo++;
		nivel_anterior = deposito.getNivel();
	}
	
	public double getConsumoMedio() {
		return consumo_medio; 
	}
	
}
