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

	
	public ControlVelocidad(int intervalo) {
		eje =  new Eje(intervalo);
		acelerador = new Acelerador(eje);
		freno = new Freno(eje);
		registro = new Registro(eje);
		automatico = new Automatico(acelerador, freno, registro, eje);
		motor = new Motor();
		palanca = new Palanca();
		reloj = new Reloj(this, intervalo);
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
					eje.calcularDistancia();
					break;
					
				case ACELERANDO:
					acelerador.acelerar();
					eje.calcularVelocidad();
					eje.calcularDistancia();
					break;
					
				case MANTENIENDO:
					registro.registrarVelocidad();
					automatico.mantenerVelocidad();
					eje.calcularVelocidad();
					eje.calcularDistancia();
					break;
					
				case REINICIANDO:
					automatico.mantenerVelocidad();
					eje.calcularVelocidad();
					eje.calcularDistancia();
					break;
			}
		}
		else {
			freno.frenar("suave");
			eje.calcularVelocidad();
			eje.calcularDistancia();
		}
	}
	
	public void moverPalanca(Estado estado) {
		palanca.setEstado(estado);
	}
	
	public int getVelocidad() {
		return eje.getVelocidad();
	}
	
	public double getDistancia() {
		return eje.getDistancia();
	}
	
	public void cambiarEstadoMotor() {
		this.motor.cambiarEstado();
	}
	
	public void cambiarEstadoFreno() {
		this.freno.cambiarEstadoFreno();
	}
	
	public int getVueltasTotales() {
		return eje.getVueltas();
	}
	
	public Eje getEje() {
		return eje;
	}
	
	public boolean getEstadoMotor() {
		return motor.getEstado();
	}
	
}
