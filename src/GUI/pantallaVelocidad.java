package GUI;

import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.Color;

import controlVelocidad.ControlVelocidad;
import controlVelocidad.Estado;
import monitorizacion.Monitor;

public class pantallaVelocidad extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;
	private static DecimalFormat df2 = new DecimalFormat(".##");
	// Labels
	private JLabel velocidad;
	private JLabel combustible;
	private JLabel vueltasDesde;
	private JLabel alertaAceite;
	private JLabel alertaPastillas;
	private JLabel alertaRevision;
	private JLabel distancia;
	private JLabel velocidad_media;
	private JLabel consumo_medio;
	// Panels
	private JPanel panel;
	private JPanel panel_principal;
	private JPanel panelEstados;
	private JPanel panelCombustible;
	private JPanel panelMecanico;
	private JPanel panelInforMec;
	private JPanel infor1;
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
		setSize(780, 400);
		setBackground(Color.WHITE);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		add(panel);
		
		velocidad = new JLabel();
		combustible = new JLabel();
		vueltasDesde = new JLabel("Vueltas desde: ");
		alertaAceite = new JLabel("Alerta aceite: CORRECTO");
		alertaPastillas = new JLabel("Alerta pastillas: CORRECTO");
		alertaRevision = new JLabel("Alerta revisión: CORRECTO");
		distancia = new JLabel();
		velocidad_media = new JLabel();
		consumo_medio = new JLabel();
		
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
		
		vueltasRevision = new JButton("Vueltas revisión");
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
		
		cambioRevision = new JButton("Revisión");
		cambioRevision.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	cambioRevisionActionPerformed(evt);
            }
        });
		
		panel_principal = new JPanel();
		panel_principal.setBackground(Color.WHITE);
		
		panel.add(panel_principal);
		panel_principal.add(velocidad);
		panel_principal.add(onOff);
		panel_principal.add(frenar);
		panel_principal.add(distancia);
		
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
		panelCombustible.setBorder(new TitledBorder(new EtchedBorder(), "Depósito"));
		
		panel.add(panelCombustible);
		panelCombustible.add(combustible);
		panelCombustible.add(repostar);
		
		panelMecanico = new JPanel();
		panelMecanico.setBackground(Color.WHITE);
		panelMecanico.setBorder(new TitledBorder(new EtchedBorder(), "Mecánico"));
		
		panel.add(panelMecanico);
		panelMecanico.add(vueltasAceite);
		panelMecanico.add(vueltasPastillas);
		panelMecanico.add(vueltasRevision);
		panelMecanico.add(cambioAceite);
		panelMecanico.add(cambioPastillas);
		panelMecanico.add(cambioRevision);
		
		panelInforMec = new JPanel();
		panelInforMec.setBackground(Color.WHITE);
		panelInforMec.setBorder(new TitledBorder(new EtchedBorder(), "Información Mecánico"));
		
		infor1 = new JPanel();
		infor1.setBackground(Color.WHITE);
		infor1.setLayout(new BoxLayout(infor1, BoxLayout.PAGE_AXIS));
		
		panel.add(panelInforMec);
		panelInforMec.add(infor1, BorderLayout.EAST);
		infor1.add(vueltasDesde);
		infor1.add(velocidad_media);
		infor1.add(consumo_medio);
		infor1.add(alertaAceite);
		infor1.add(alertaPastillas);
		infor1.add(alertaRevision);
		
		this.controlVelocidad = controlVelocidad;
		this.monitor = monitor;
		thr = new Thread(this);
	}
	
	// Acción Botón onOff
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
	
	// Acción Botón repostar
	private void repostarActionPerformed(java.awt.event.ActionEvent evt) {
		monitor.repostar();
	}
	
	// Acción Botón vueltasAceite
	private void vueltasAceiteActionPerformed(java.awt.event.ActionEvent evt) {
		vueltasDesde.setText("Vueltas desde el último cambio de aceite: " + String.valueOf((int) monitor.getVueltasAceite()));
	}
	
	// Acción Botón vueltasPastillas
	private void vueltasPastillasActionPerformed(java.awt.event.ActionEvent evt) {
		vueltasDesde.setText("Vueltas desde el último cambio de pastillas: " + String.valueOf((int) monitor.getVueltasPastillas()));
	}

	// Acción Botón vueltasRevision
	private void vueltasRevisionActionPerformed(java.awt.event.ActionEvent evt) {
		vueltasDesde.setText("Vueltas desde la última revisión: " + String.valueOf((int) monitor.getVueltasRevision()));
	}
	
	// Acción Botón cambioAceite
	private void cambioAceiteActionPerformed(java.awt.event.ActionEvent evt) {
		monitor.cambioAceite();
	}
	
	// Acción Botón cambioPastillas
	private void cambioPastillasActionPerformed(java.awt.event.ActionEvent evt) {
		monitor.cambioPastillas();
	}

	// Acción Botón cambioRevision
	private void cambioRevisionActionPerformed(java.awt.event.ActionEvent evt) {
		monitor.cambioRevision();
	}
	
	
	
	public void run() {
		while (true) {
			velocidad.setText("Velocidad: " + String.valueOf((int) controlVelocidad.getVelocidad()) + " km/h");
			combustible.setText("Combustible: " + df2.format(monitor.getNivelDeposito()));
			distancia.setText("Distancia recorrida: " + df2.format(controlVelocidad.getDistancia()) + " m");
			velocidad_media.setText("Velocidad media: " + monitor.getVelocidadMedia());
			consumo_medio.setText("Consumo medio: " + df2.format(monitor.getConsumoMedio()));
			
			
			if(monitor.notificarAceite()) {
				alertaAceite.setText("Alerta: Es necesario un cambio de aceite.");
				alertaAceite.setForeground(Color.RED);
			} else {
				alertaAceite.setText("Alerta aceite: CORRECTO");
				alertaAceite.setForeground(Color.BLACK);
			}	
			
			if (monitor.notificarPastillas()) {
				alertaPastillas.setText("Alerta: Es necesario un cambio de pastillas.");
				alertaPastillas.setForeground(Color.RED);
			} else {
				alertaPastillas.setText("Alerta pastillas: CORRECTO");
				alertaPastillas.setForeground(Color.BLACK);
			}
			
			if (monitor.notificarRevision()) {
				alertaRevision.setText("Alerta: Es necesario realizar una revisión.");
				alertaRevision.setForeground(Color.RED);
			} else {
				alertaRevision.setText("Alerta revisión: CORRECTO");
				alertaRevision.setForeground(Color.BLACK);
			}
			
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
	
}
