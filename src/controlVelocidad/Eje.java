package controlVelocidad;

public class Eje {

	private final double radio = 1; //metros
	private double rpm;
	private final int  MAXRPM = 2000;
	private int velocidad;
	private double distancia_recorrida;
	private int vueltas_totales;
	
	
	public Eje() {
		rpm = 0;
		velocidad = 0;
		distancia_recorrida = 0;
		vueltas_totales = 0;
	}
	
	synchronized public void variarRPM(double cantidad) {
		rpm += cantidad;
		
		if (rpm < 0) {
			rpm = 0;
		}
		else if (rpm > MAXRPM) {
			rpm = MAXRPM;
		}
	}
	
	synchronized public void calcularVelocidad() {
		velocidad = (int) (rpm*radio*60/1000); // km/h
	}
	
	synchronized public int getVelocidad() {
		return velocidad;
	}
	
	synchronized public void calcularDistancia(double tiempo) {
		distancia_recorrida = (velocidad*0.2777) * tiempo; //0.2777 == 1000/3600
	}
	
	synchronized public void calcularVueltas() {
		vueltas_totales = (int) (distancia_recorrida / (2*Math.PI*radio));
	}
	
	synchronized public double getDistancia() {
		return distancia_recorrida;
	}
	
	synchronized public int getVueltas() {
		return vueltas_totales;
	}
}
