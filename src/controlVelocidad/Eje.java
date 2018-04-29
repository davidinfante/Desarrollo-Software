package controlVelocidad;

public class Eje {

	private final double radio = 1; //metros
	private double rpm;
	private final int  MAXRPM = 2000;
	private int velocidad;
	
	
	public Eje() {
		rpm = 0;
		velocidad = 0;
	}
	
	synchronized public void variarRPM(double cantidad) { //synchronized
		rpm += cantidad;
		
		if (rpm < 0) {
			rpm = 0;
		}
		else if (rpm > MAXRPM) {
			rpm = MAXRPM;
		}
	}
	
	synchronized public void calcularVelocidad() { //synchronized
		velocidad = (int) (rpm*radio*60/1000); // km/h
	}
	
	synchronized public int getVelocidad() { //synchronized
		System.out.println(velocidad);
		return velocidad;
	}
	
}
