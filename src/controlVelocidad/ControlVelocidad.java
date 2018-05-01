package controlVelocidad;

public class ControlVelocidad {

	private Eje eje;
	private Acelerador acelerador;
	private Freno freno;
	private Registro registro;
	private Automatico automatico;
	private Motor motor;
	private Palanca palanca;
	private RelojControl relojControl;

	
	public ControlVelocidad(int intervalo) {
		eje =  new Eje(intervalo);
		acelerador = new Acelerador(eje);
		freno = new Freno(eje);
		registro = new Registro(eje);
		automatico = new Automatico(acelerador, freno, registro, eje);
		motor = new Motor();
		palanca = new Palanca();
		relojControl = new RelojControl(this, intervalo);
	}
	
	public void start() {
		relojControl.start();
	}
	
	public void controlarEstados() {
	
		if(motor.getEstado()) {
			
			switch (palanca.getEstado()) {
			
				case PARADO:	
					if(freno.getFrenando())	freno.frenar("brusco");
					else freno.frenar("suave");
					eje.actualizarParametros();
					break;
					
				case ACELERANDO:
					acelerador.acelerar();
					eje.actualizarParametros();
					break;
					
				case MANTENIENDO:
					registro.registrarVelocidad();
					automatico.mantenerVelocidad();
					eje.actualizarParametros();
					break;
					
				case REINICIANDO:
					automatico.mantenerVelocidad();
					eje.actualizarParametros();
					break;
			}
		}
		else {
			freno.frenar("suave");
			eje.actualizarParametros();
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
	
	public double getVueltasTotales() {
		return eje.getVueltas();
	}
	
	public boolean getEstadoMotor() {
		return motor.getEstado();
	}
	
}
