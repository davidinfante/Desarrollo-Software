package controlVelocidad;

public class ControlVelocidad {

	private Eje eje;
	private Acelerador acelerador;
	private Freno freno;
	private Registro registro;
	private Automatico automatico;
	private Motor motor;
	private Palanca palanca;
	private Reloj reloj;

	
	public ControlVelocidad() {
		eje =  new Eje();
		acelerador = new Acelerador(eje);
		freno = new Freno(eje);
		registro = new Registro(eje);
		automatico = new Automatico(acelerador, freno, registro, eje);
		motor = new Motor();
		palanca = new Palanca();
		reloj = new Reloj(this);
	}
	
	public void start() {
		reloj.start();
	}
	
	public void conducir() {
	
		if(motor.getEstado()) {
			
			switch (palanca.getEstado()) {
			
				case PARADO:	
					if(freno.getFrenando())	freno.frenar("brusco");
					else freno.frenar("suave");
					eje.calcularVelocidad();
					break;
					
				case ACELERANDO:
					acelerador.acelerar();
					eje.calcularVelocidad();
					break;
					
				case MANTENIENDO:
					registro.registrarVelocidad();
					automatico.mantenerVelocidad();
					eje.calcularVelocidad();
					break;
					
				case REINICIANDO:
					automatico.mantenerVelocidad();
					eje.calcularVelocidad();
					break;
			}
		}
		else {
			freno.frenar("suave");
			eje.calcularVelocidad();
		}
	}
	
	public void moverPalanca(Estado estado) {
		palanca.setEstado(estado);
	}
	
	public int getVelocidad() {
		return eje.getVelocidad();
	}
	
	public void cambiarEstadoMotor() {
		this.motor.cambiarEstado();
	}
	
	public void cambiarEstadoFreno() {
		this.freno.cambiarEstadoFreno();
	}
	
	public void informacionEje(double tiempo) {
		eje.calcularDistancia(tiempo);
		eje.calcularVueltas();
		System.out.println("La distancia recorrida es: " + eje.getDistancia() + " km, las vueltas del eje son: " + eje.getVueltas());
	}
}
