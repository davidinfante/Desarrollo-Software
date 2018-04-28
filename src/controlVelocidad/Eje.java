package controlVelocidad;

public class Eje {

	private final double radio = 1; //metros
	private int rpm;
	private final int  MAXRPM = 1000000000;
	private int velocidad;
	
	
	public Eje() {
		rpm = 0;
		velocidad = 0;
	}
	
	public void variarRPM(int cantidad) { //synchronized
		rpm += cantidad;
		
		if(rpm < 0) {
			rpm = 0;
		}
		else if (rpm > MAXRPM) {
			rpm = MAXRPM;
		}
		
		calcularVelocidad();
	}
	
	public void calcularVelocidad() { //synchronized
		velocidad = (int) (rpm*radio*60/1000); // km/h
	}
	
	public int getVelocidad() { //synchronized
		return velocidad;
	}
	
}
