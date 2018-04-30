package controlVelocidad;

public class Eje {

	private final double radio = 1; //metros
	private double vueltas;
	private final int  MAXVUELTAS = 2000;
	private int velocidad;
	private double distancia_recorrida;
	private int vueltas_totales;
	private double intervalo;
	
	
	public Eje(int intervalo) {
		vueltas = 0;
		velocidad = 0;
		distancia_recorrida = 0;
		vueltas_totales = 0;
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
	
	synchronized public void calcularVelocidad() {
		velocidad = (int) (vueltas*radio*60/1000); // km/h
		calcularDistancia();
		calcularVueltas();
	}
	
	
	synchronized public void calcularDistancia() {
		distancia_recorrida += (velocidad * (intervalo/3600) * 1000);
	}
	
	synchronized public void calcularVueltas() {
		vueltas_totales += (int) ((velocidad * (intervalo/3600) * 1000) / (2*Math.PI*radio));
	}
	
	synchronized public int getVelocidad() {
		return velocidad;
	}
	
	synchronized public double getDistancia() {
		return distancia_recorrida;
	}
	
	synchronized public int getVueltas() {
		return vueltas_totales;
	}
	
	synchronized public void reseteo() {
		vueltas_totales = 0;
	}
}
