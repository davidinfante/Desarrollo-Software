package GUI;

import java.awt.FlowLayout;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import controlVelocidad.ControlVelocidad;
import controlVelocidad.Estado;
import monitorizacion.Monitor;

public class pantallaVelocidad extends JFrame implements Runnable {

	private static final long serialVersionUID = 1L;
	private static DecimalFormat df2 = new DecimalFormat(".##");
	// Labels
	private JLabel velocidad;
	private JLabel combustible;
	private JLabel vueltasDesde;
	private JLabel alertas;
	private JLabel distancia;
	// Panels
	private JPanel panel;
	private JPanel panelEstados;
	private JPanel panelCombustible;
	private JPanel panelMecanico;
	// Buttons
	private JToggleButton onOff;
	private JToggleButton frenar;
	private JRadioButton acelerar;
	private JRadioButton parar;
	private JRadioButton mantener;
	private JRadioButton reiniciar;
	private JButton repostar;
	private JButton vueltasAceite;
	private JButton vueltasPastillas;
	private JButton vueltasRevision;
	private JButton cambioAceite;
	private JButton cambioPastillas;
	private JButton cambioRevision;
	
	private ControlVelocidad controlVelocidad;
	private Monitor monitor;
	public Thread thr;
	
	
	public pantallaVelocidad(ControlVelocidad controlVelocidad, Monitor monitor) {
		setTitle("Pr�ctica 2 - Jose Fidel Ariza, David Infante");
		setSize(1000, 450);
		setBackground(Color.WHITE);
		
		panel = new JPanel();
		panel.setLayout(new FlowLayout());
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel);
		
		velocidad = new JLabel();
		combustible = new JLabel();
		vueltasDesde = new JLabel("Vueltas desde: ");
		alertas = new JLabel("Alerta: ");
		alertas.setForeground(Color.RED);
		distancia = new JLabel();
		
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
		acelerar.setBackground(Color.WHITE);
		acelerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	acelerarActionPerformed(evt);
            }
        });
		
		parar = new JRadioButton("Parar", true);
		parar.setBackground(Color.WHITE);
		parar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	pararActionPerformed(evt);
            }
        });
		
		mantener = new JRadioButton("Mantener", false);
		mantener.setBackground(Color.WHITE);
		mantener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	mantenerActionPerformed(evt);
            }
        });
		
		reiniciar = new JRadioButton("Reiniciar", false);
		reiniciar.setBackground(Color.WHITE);
		reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	reiniciarActionPerformed(evt);
            }
        });
		
		repostar = new JButton("Repostar");
		repostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	repostarActionPerformed(evt);
            }
        });
		
		vueltasAceite = new JButton("Vueltas aceite");
		vueltasAceite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	vueltasAceiteActionPerformed(evt);
            }
        });
		
		vueltasPastillas = new JButton("Vueltas pastillas");
		vueltasPastillas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	vueltasPastillasActionPerformed(evt);
            }
        });
		
		vueltasRevision = new JButton("Vueltas revisi�n");
		vueltasRevision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	vueltasRevisionActionPerformed(evt);
            }
        });
		
		cambioAceite = new JButton("Cambio aceite");
		cambioAceite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	cambioAceiteActionPerformed(evt);
            }
        });
		
		cambioPastillas = new JButton("Cambio pastillas");
		cambioPastillas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	cambioPastillasActionPerformed(evt);
            }
        });
		
		cambioRevision = new JButton("Revisi�n");
		cambioRevision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	cambioRevisionActionPerformed(evt);
            }
        });
		
		panel.add(velocidad);
		panel.add(onOff);
		panel.add(frenar);
		panel.add(distancia);
		
		panelEstados = new JPanel();
		panelEstados.setBackground(Color.WHITE);
		panelEstados.setBorder(new TitledBorder(new EtchedBorder(), "Palanca"));
		
		panel.add(panelEstados);
		panelEstados.add(acelerar);
		panelEstados.add(parar);
		panelEstados.add(mantener);
		panelEstados.add(reiniciar);
		
		panelCombustible = new JPanel();
		panelCombustible.setBackground(Color.WHITE);
		panelCombustible.setBorder(new TitledBorder(new EtchedBorder(), "Dep�sito"));
		
		panel.add(panelCombustible);
		panelCombustible.add(combustible);
		panelCombustible.add(repostar);
		
		panelMecanico = new JPanel();
		panelMecanico.setBackground(Color.WHITE);
		panelMecanico.setBorder(new TitledBorder(new EtchedBorder(), "Mec�nico"));
		
		panel.add(panelMecanico);
		panelMecanico.add(vueltasAceite);
		panelMecanico.add(vueltasPastillas);
		panelMecanico.add(vueltasRevision);
		panelMecanico.add(cambioAceite);
		panelMecanico.add(cambioPastillas);
		panelMecanico.add(cambioRevision);
		
		panel.add(vueltasDesde);
		panel.add(alertas);
		
		this.controlVelocidad = controlVelocidad;
		this.monitor = monitor;
		thr = new Thread(this);
	}
	
	// Acci�n Bot�n onOff
	private void onOffActionPerformed(java.awt.event.ActionEvent evt) {
		controlVelocidad.cambiarEstadoMotor();
		if (!onOff.isSelected()) {
			parar.setSelected(true);
			acelerar.setSelected(false);
			mantener.setSelected(false);
			reiniciar.setSelected(false);
			controlVelocidad.moverPalanca(Estado.PARADO);
		}
	}
	
	// Acci�n Bot�n frenar
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
	
	// Acci�n Bot�n acelerar
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
	
	// Acci�n Bot�n parar
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
		
	// Acci�n Bot�n mantener
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
		
	// Acci�n Bot�n reiniciar
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
	
	// Acci�n Bot�n repostar
	private void repostarActionPerformed(java.awt.event.ActionEvent evt) {
		monitor.repostar();
	}
	
	// Acci�n Bot�n vueltasAceite
	private void vueltasAceiteActionPerformed(java.awt.event.ActionEvent evt) {
		vueltasDesde.setText("Vueltas desde el �ltimo cambio de aceite: " + String.valueOf((int) monitor.getVueltasAceite()));
	}
	
	// Acci�n Bot�n vueltasPastillas
	private void vueltasPastillasActionPerformed(java.awt.event.ActionEvent evt) {
		vueltasDesde.setText("Vueltas desde el �ltimo cambio de pastillas: " + String.valueOf((int) monitor.getVueltasPastillas()));
	}

	// Acci�n Bot�n vueltasRevision
	private void vueltasRevisionActionPerformed(java.awt.event.ActionEvent evt) {
		vueltasDesde.setText("Vueltas desde la �ltima revisi�n: " + String.valueOf((int) monitor.getVueltasRevision()));
	}
	
	// Acci�n Bot�n cambioAceite
	private void cambioAceiteActionPerformed(java.awt.event.ActionEvent evt) {
		monitor.cambioAceite();
	}
	
	// Acci�n Bot�n cambioPastillas
	private void cambioPastillasActionPerformed(java.awt.event.ActionEvent evt) {
		monitor.cambioPastillas();
	}

	// Acci�n Bot�n cambioRevision
	private void cambioRevisionActionPerformed(java.awt.event.ActionEvent evt) {
		monitor.cambioRevision();
	}
	
	
	
	public void run() {
		while (true) {
			velocidad.setText("Velocidad: " + String.valueOf((int) controlVelocidad.getVelocidad()) + " km/h");
			combustible.setText("Combustible: " + df2.format(monitor.getNivelDeposito()));
			distancia.setText("Distancia recorrida: " + df2.format(controlVelocidad.getDistancia()) + " m");
			if(monitor.notificarAceite())
				alertas.setText("Alerta: Es necesario un cambio de aceite.");
			else if (monitor.notificarPastillas())
				alertas.setText("Alerta: Es necesario un cambio de pastillas.");
			else if (monitor.notificarRevision())
				alertas.setText("Alerta: Es necesario realizar una revisi�n.");
			
			if (controlVelocidad.getVelocidad() == 0 && !controlVelocidad.getEstadoMotor()) {
				repostar.setEnabled(true);
				cambioAceite.setEnabled(true);
				cambioPastillas.setEnabled(true);
				cambioRevision.setEnabled(true);
			} else {
				repostar.setEnabled(false);
				cambioAceite.setEnabled(false);
				cambioPastillas.setEnabled(false);
				cambioRevision.setEnabled(false);
			}
		}
	}
	
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				ControlVelocidad controlVelocidad = new ControlVelocidad(500);
				Monitor monitor = new Monitor(controlVelocidad, 500);
				pantallaVelocidad display = new pantallaVelocidad(controlVelocidad, monitor);
				display.setVisible(true);
				
				controlVelocidad.start();
				monitor.start();
				display.thr.start();
			}
		});
    }
	
}
