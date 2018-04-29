package GUI;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controlVelocidad.ControlVelocidad;
import controlVelocidad.Estado;

public class pantallaVelocidad extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private JLabel velocidad;
	private JPanel panel;
	private JPanel panel2;
	private JToggleButton onOff;
	private JToggleButton frenar;
	private JRadioButton acelerar;
	private JRadioButton parar;
	private JRadioButton mantener;
	private JRadioButton reiniciar;
	private ControlVelocidad controlVelocidad;
	public Thread thr;
	// Atributos de tiempo
	public static double startTime;
	public static double endTime;
	public static double totalTime;
	
	public pantallaVelocidad(ControlVelocidad controlVelocidad) {
		setSize(750, 500);
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		getContentPane().add(panel);
		velocidad = new JLabel();
		
		onOff = new JToggleButton("Encendido / Apagado", false);
		onOff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	onOffActionPerformed(evt);
            }
        });
		
		frenar = new JToggleButton("Frenar", false);
		frenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	frenarActionPerformed(evt);
            }
        });
		
		acelerar = new JRadioButton("Acelerar", false);
		acelerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	acelerarActionPerformed(evt);
            }
        });
		
		parar = new JRadioButton("Parar", true);
		parar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	pararActionPerformed(evt);
            }
        });
		
		mantener = new JRadioButton("Mantener", false);
		mantener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	mantenerActionPerformed(evt);
            }
        });
		
		reiniciar = new JRadioButton("Reiniciar", false);
		reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	reiniciarActionPerformed(evt);
            }
        });
		
		panel.add(velocidad);
		panel.add(onOff);
		panel.add(frenar);
		
		panel2 = new JPanel();
		panel2.setBorder(new TitledBorder(new EtchedBorder(), "Estados"));
		
		panel.add(panel2);
		panel2.add(acelerar);
		panel2.add(parar);
		panel2.add(mantener);
		panel2.add(reiniciar);
		
		
		this.controlVelocidad = controlVelocidad;
		thr = new Thread(this);
	}
	
	// Acción Botón onOff
	private void onOffActionPerformed(java.awt.event.ActionEvent evt) {
		if (onOff.isSelected()) {
			controlVelocidad.cambiarEstadoMotor();
		} else {
			controlVelocidad.cambiarEstadoMotor();
			
			endTime = System.nanoTime();
			totalTime = (double) (endTime - startTime)/1000000000.0; //Nanosegundos a segundos
			controlVelocidad.informacionEje(totalTime);
		}
	}
	
	// Acción Botón frenar
	private void frenarActionPerformed(java.awt.event.ActionEvent evt) {
		if (frenar.isSelected()) {
			if (!parar.isSelected()) parar.setSelected(true);
			acelerar.setSelected(false);
			mantener.setSelected(false);
			reiniciar.setSelected(false);
			controlVelocidad.cambiarEstadoFreno();
			controlVelocidad.moverPalanca(Estado.PARADO);
		} else {
			controlVelocidad.cambiarEstadoFreno();
		}
	}
	
	// Acción Botón acelerar
	private void acelerarActionPerformed(java.awt.event.ActionEvent evt) {
		if (acelerar.isSelected()) {
			parar.setSelected(false);
			mantener.setSelected(false);
			reiniciar.setSelected(false);
			if (frenar.isSelected()) {
				frenar.setSelected(false);
				controlVelocidad.cambiarEstadoFreno();
			}
			controlVelocidad.moverPalanca(Estado.ACELERANDO);
		} else if (!parar.isSelected() && !mantener.isSelected() && !reiniciar.isSelected()) {
			acelerar.setSelected(true);
		}
	}
	
	// Acción Botón parar
	private void pararActionPerformed(java.awt.event.ActionEvent evt) {
		if (parar.isSelected()) {
			acelerar.setSelected(false);
			mantener.setSelected(false);
			reiniciar.setSelected(false);
			controlVelocidad.moverPalanca(Estado.PARADO);
		} else if (!acelerar.isSelected() && !mantener.isSelected() && !reiniciar.isSelected()) {
			parar.setSelected(true);
		}
	}
		
	// Acción Botón mantener
	private void mantenerActionPerformed(java.awt.event.ActionEvent evt) {
		if (mantener.isSelected()) {
			acelerar.setSelected(false);
			parar.setSelected(false);
			reiniciar.setSelected(false);
			if (frenar.isSelected()) {
				frenar.setSelected(false);
				controlVelocidad.cambiarEstadoFreno();
			}
			controlVelocidad.moverPalanca(Estado.MANTENIENDO);
		} else if (!acelerar.isSelected() && !parar.isSelected() && !reiniciar.isSelected()) {
			mantener.setSelected(true);
		}
	}
		
	// Acción Botón reiniciar
	private void reiniciarActionPerformed(java.awt.event.ActionEvent evt) {
		if (reiniciar.isSelected()) {
			acelerar.setSelected(false);
			parar.setSelected(false);
			mantener.setSelected(false);
			if (frenar.isSelected()) {
				frenar.setSelected(false);
				controlVelocidad.cambiarEstadoFreno();
			}
			controlVelocidad.moverPalanca(Estado.REINICIANDO);
		} else if (!acelerar.isSelected() && !parar.isSelected() && !mantener.isSelected()) {
			reiniciar.setSelected(true);
		}
	}
	
	public void run() {
		while (true) {
			velocidad.setText("Velocidad: " + String.valueOf((int) controlVelocidad.getVelocidad())+" km/h");
		}
	}
	
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				ControlVelocidad controlVelocidad = new ControlVelocidad();
				pantallaVelocidad display = new pantallaVelocidad(controlVelocidad);
				display.setVisible(true);
				
				startTime = System.nanoTime();
				
				controlVelocidad.start();
				display.thr.start();
			}
		});
    }
	
}
