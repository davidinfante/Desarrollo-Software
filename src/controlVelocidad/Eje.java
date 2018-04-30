package controlVelocidad;

public class Eje {

	private final double radio = 0.5; //metros
	private double vueltas;
	private final int  MAXVUELTAS = 4;
	private int velocidad;
	private double distancia_total;
	private double vueltas_totales;
	private double intervalo;
	private double distancia;
	
	
	public Eje(int intervalo) {
		vueltas = 0;
		velocidad = 0;
		distancia_total = 0;
		vueltas_totales = 0;
		distancia = 0;
		this.intervalo = intervalo/1000.0; //segundos
	}
	
	synchronized public void variarVueltas(double cantidad) {
		vueltas += cantidad;
		
		if (vueltas < 0) {
			vueltas = 0;
		}
		else if (vueltas > MAXVUELTAS) {
			vueltas = MAXVUELTAS;
		}
	}
	
	synchronized public void actualizarParametros() {
		calcularDistancia();
		calcularVelocidad();
		calcularVueltas();
	}
	
	synchronized public void calcularVelocidad() {
		velocidad = (int) ((distancia/intervalo)*3600/1000); // km/h
	}
	
	
	synchronized public void calcularDistancia() {
		distancia = vueltas*(2*Math.PI*radio);//(velocidad * (intervalo/3600) * 1000);
		distancia_total += distancia;
	}
	
	synchronized public void calcularVueltas() {
		vueltas_totales += vueltas;
	}
	
	synchronized public int getVelocidad() {
		return velocidad;
	}
	
	synchronized public double getDistancia() {
		return distancia_total;
	}
	
	synchronized public double getVueltas() {
		return vueltas_totales;
	}
	
	synchronized public void reseteo() {
		vueltas_totales = 0;
	}
}
