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
					if(freno.getFrenando())
						freno.frenar();
					break;
					
				case ACELERANDO:
					acelerador.acelerar();
					break;
					
				case MANTENIENDO:
					registro.registrarVelocidad();
					automatico.mantenerVelocidad();
					break;
					
				case REINICIANDO:
					automatico.mantenerVelocidad();
					break;
			}
		}
		else {
			
			freno.frenar();
		}
	}
	
	public void moverPalanca(Estado estado) {
		palanca.setEstado(estado);
	}
	
	public int getVelocidad() {
		return eje.getVelocidad();
	}
	
	public int getVelocidadConstante() {
		return registro.getVelocidadConstante();
	}
	
}
