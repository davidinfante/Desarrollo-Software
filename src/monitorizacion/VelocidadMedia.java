package monitorizacion;

public class VelocidadMedia {

	private int velocidad_media;
	private int sumatoria_velocidad;
	private int muestreo;
	
	public VelocidadMedia() {
		velocidad_media = 0;
		sumatoria_velocidad = 0;
		muestreo = 1;
	}
	
	public void calcular(int velocidad) {
		if(velocidad != 0) {
			
			sumatoria_velocidad += velocidad;
			velocidad_media = sumatoria_velocidad/muestreo;
			muestreo++;
		}
	}
	
	public int getVelocidadMedia() {
		return velocidad_media;
	}
	
}
