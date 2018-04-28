package controlVelocidad;

public class prueba {
	public static void main( String[] args ) throws InterruptedException {
		ControlVelocidad controlVelocidad = new ControlVelocidad();
		controlVelocidad.start();
		pantallaVelocidad pantalla = new pantallaVelocidad(controlVelocidad);
		pantalla.setVisible(true);
		pantalla.thr.start();
		Thread.sleep(3000);
		controlVelocidad.moverPalanca(Estado.ACELERANDO);
		Thread.sleep(3000);
		controlVelocidad.moverPalanca(Estado.MANTENIENDO);
		Thread.sleep(3000);
		controlVelocidad.moverPalanca(Estado.ACELERANDO);
		Thread.sleep(3000);
		controlVelocidad.moverPalanca(Estado.REINICIANDO);
	}
}
