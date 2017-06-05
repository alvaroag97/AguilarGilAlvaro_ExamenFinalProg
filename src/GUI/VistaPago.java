package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Controlador.Controlador;
import Models.Coche;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

public class VistaPago {

	private JFrame frame;

	private Date date;

	/**
	 * Para abrir la ventana desde otro frame
	 * 
	 * @return
	 */
	public JFrame getFrame() {
		return frame;
	}

	private JTextField txtMatricula;

	// Botones
	private JButton btnEntrada;
	private JButton btnPago;
	private JButton btnCaja;
	private JButton btnSalida;

	// Labels
	private JLabel lblMatricula;
	private JLabel lblHoraEntrada;
	private JLabel lblHoraSalida;
	private JTextField txtEntrada;
	private JTextField txtSalida;
	private JButton btnBuscar;
	private JLabel lblTotalAPagar;
	private JTextField txtPago;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaPago window = new VistaPago();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VistaPago() {
		initialize();
		setPropiedades();
		setAdapters();
		Fechafin();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		btnEntrada = new JButton("Entrada vehiculo");

		btnEntrada.setFont(new Font("Tahoma", Font.PLAIN, 11));

		btnPago = new JButton("Pago y salida");

		btnCaja = new JButton("Caja del dia");
	

		lblMatricula = new JLabel("Matricula");

		txtMatricula = new JTextField();

		btnSalida = new JButton("Pagar y salir");
		

		btnPago.setEnabled(false);
	}

	/**
	 * Poner las propiedades de cada contenido
	 */
	private void setPropiedades() {
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		btnEntrada.setBounds(20, 33, 116, 93);
		frame.getContentPane().add(btnEntrada);

		btnPago.setBounds(158, 33, 116, 93);
		frame.getContentPane().add(btnPago);

		btnCaja.setBounds(292, 33, 116, 93);
		frame.getContentPane().add(btnCaja);

		lblMatricula.setBounds(72, 150, 130, 14);
		frame.getContentPane().add(lblMatricula);

		txtMatricula.setBounds(158, 147, 116, 20);
		frame.getContentPane().add(txtMatricula);
		txtMatricula.setColumns(10);

		btnSalida.setBounds(227, 276, 130, 58);
		frame.getContentPane().add(btnSalida);

		lblHoraEntrada = new JLabel("Hora entrada");
		lblHoraEntrada.setBounds(72, 198, 130, 14);
		frame.getContentPane().add(lblHoraEntrada);

		lblHoraSalida = new JLabel("Hora salida");
		lblHoraSalida.setBounds(72, 238, 130, 14);
		frame.getContentPane().add(lblHoraSalida);

		txtEntrada = new JTextField();
		txtEntrada.setColumns(10);
		txtEntrada.setBounds(158, 195, 116, 20);
		frame.getContentPane().add(txtEntrada);

		txtSalida = new JTextField();
		txtSalida.setColumns(10);
		txtSalida.setBounds(158, 235, 116, 20);
		frame.getContentPane().add(txtSalida);

		btnBuscar = new JButton("Buscar");

		btnBuscar.setBounds(47, 276, 130, 58);
		frame.getContentPane().add(btnBuscar);

		lblTotalAPagar = new JLabel("Total a pagar");
		lblTotalAPagar.setBounds(328, 150, 150, 14);
		frame.getContentPane().add(lblTotalAPagar);

		txtPago = new JTextField();
		txtPago.setBounds(315, 175, 86, 20);
		frame.getContentPane().add(txtPago);
		txtPago.setColumns(10);
	}

	/**
	 * Poner las acciones y los clicked
	 */
	private void setAdapters() {
		
		/**
		 * Pasar a la entrada
		 */
		btnEntrada.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				VistaEntrada Entrada = new VistaEntrada();
				Entrada.getFrame().setVisible(true);
				frame.dispose();

			}
		});
		/**
		 * Llama al metodo buscar
		 */
		btnBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				buscar();
			}
		});
		/**
		 * Llama a la caja
		 */
		btnCaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
				JOptionPane.showMessageDialog(frame, "Funcion aun no realizada");
			}
		});
		/**
		 * Se suponia que era para guardar el dinero y deletear, pero no me ha dado tiempo
		 */
		btnSalida.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
		});
	}

	/**
	 * Rellenar los campos
	 * 
	 * @param c
	 */
	private void Rellenar(Coche c) {

		for (int i = 0; i < Controlador.ObtenerLista().size(); i++) {
			if (txtMatricula.getText().equals(Controlador.ObtenerCoche(i).getMatricula())) {

				txtMatricula.setText(c.getMatricula());
				txtEntrada.setText("" + c.getEntrada());
			} else if (!txtMatricula.getText().equals(Controlador.ObtenerCoche(i).getMatricula())) {
				JOptionPane.showMessageDialog(frame, "No Existe");
			}
		}
		
	

		
	}

	/**
	 * Poner la fecha salida
	 */
	private void Fechafin() {
		date = new Date();

		txtSalida.setText("" + date);
	}

	/**
	 * Busca el coche y calcula el tiempo
	 */
	private void buscar() {
		for (int i = 0; i < Controlador.ObtenerLista().size(); i++) {
			Rellenar(Controlador.ObtenerCoche(Controlador.indice));
			if (txtMatricula.getText().equals(Controlador.ObtenerCoche(i).getMatricula())) {

				float entrada = Controlador.ObtenerCoche(i).getEntrada().getTime();

				float salida = date.getTime();

				float diferencia = (salida / 1000) - (entrada / 1000);
				float menor = 0;// Entre 0 y 30 min
				float medio = 0;// entre 31 y 60 min
				float superior = 0;// entre 61 y 720
				if (diferencia > 0 && diferencia < 30) {

					menor = (float) (diferencia * 0.6);
					txtPago.setText("" + menor);

				} else if (diferencia > 30 && diferencia < 61) {

					medio = (float) (diferencia * 0.1);
					txtPago.setText("" + medio);

				} else if (diferencia > 60 && diferencia < 720) {

					superior = (float) (diferencia * 0.03);
					txtPago.setText("" + superior);
				}

			}
		}

	}
}
