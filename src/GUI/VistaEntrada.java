package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Controlador.Controlador;

public class VistaEntrada {

	private JFrame frame;
	private JTextField txtMatricula;
	// Botones
	private JButton btnEntrada;
	private JButton btnPago;
	private JButton btnCaja;
	private JButton btnRegistrar;

	// Labels
	private JLabel lblMatricula;

	/**
	 * Para llamar al frame desde otra ventana
	 * 
	 * @return
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaEntrada window = new VistaEntrada();
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
	public VistaEntrada() {
		initialize();
		setPropiedades();
		setAdapters();
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

		btnRegistrar = new JButton("Registrar");

		btnEntrada.setEnabled(false);
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

		lblMatricula.setBounds(69, 192, 130, 14);
		frame.getContentPane().add(lblMatricula);

		txtMatricula.setBounds(158, 189, 116, 20);
		frame.getContentPane().add(txtMatricula);
		txtMatricula.setColumns(10);

		btnRegistrar.setBounds(144, 277, 130, 58);
		frame.getContentPane().add(btnRegistrar);
	}

	/**
	 * Poner las acciones y los clicked
	 */
	private void setAdapters() {

		btnPago.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if (Controlador.ObtenerLista().isEmpty()) {

					JOptionPane.showMessageDialog(frame, "No hay ningun coche");
				} else {
					Date date = new Date();

					VistaPago Pago = new VistaPago();
					Pago.getFrame().setVisible(true);
					frame.dispose();
				}
			}
		});
		btnCaja.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {

				JOptionPane.showMessageDialog(frame, "Funcion aun no realizada");
			}
		});

		btnRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				Date date = new Date();
			
						Controlador.AniadirCoche(txtMatricula.getText(), date);

			}
		});
	}
}
