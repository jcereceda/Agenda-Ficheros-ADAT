import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
/**
 * 
 * @author Javier Cereceda
 * @Description - vista y elementos de la vista o pantalla
 */
public class Vista extends JFrame {

	private Modelo modelo;
	private Controlador controlador;
	private static Container contenedorPrincipal;
	private JScrollPane scrollPane;
	private JTextArea txtANota;
	private JButton btnGuardar;
	private JSpinner spinnerFecha;
	private JLabel lblNotaGuardada;

	/**
	 * Constructor por defecto
	 */
	public Vista() {
		getContentPane().setBackground(new Color(152, 251, 152));
		getContentPane().setForeground(new Color(0, 0, 0));
		setTitle("Agenda simple con ficheros");
		modelo = new Modelo();
		controlador = new Controlador();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(431, 276);
		setLocationRelativeTo(null);

		contenedorPrincipal = getContentPane();
		contenedorPrincipal.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(33, 35, 156, 156);
		getContentPane().add(scrollPane);

		txtANota = new JTextArea();
		txtANota.setWrapStyleWord(true);
		txtANota.setLineWrap(true);
		txtANota.setFont(new Font("Calibri", Font.PLAIN, 12));
		scrollPane.setViewportView(txtANota);

		spinnerFecha = new JSpinner();
		spinnerFecha.setFont(new Font("Calibri", Font.PLAIN, 12));
		spinnerFecha.setModel(new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_YEAR));
		spinnerFecha.setBounds(269, 35, 103, 20);
		getContentPane().add(spinnerFecha);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setBackground(new Color(250, 128, 114));
		btnGuardar.setForeground(new Color(0, 0, 0));
		btnGuardar.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlador.guardar();
			}
		});
		btnGuardar.setBounds(269, 98, 124, 21);
		getContentPane().add(btnGuardar);

		JButton btnVer = new JButton("Ver Notas");
		btnVer.setBackground(new Color(250, 128, 114));
		btnVer.setFont(new Font("Calibri", Font.PLAIN, 13));
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controlador.verNotas();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnVer.setBounds(269, 145, 124, 21);
		getContentPane().add(btnVer);

		lblNotaGuardada = new JLabel("");
		lblNotaGuardada.setFont(new Font("Calibri", Font.PLAIN, 13));
		lblNotaGuardada.setBounds(54, 200, 121, 39);
		getContentPane().add(lblNotaGuardada);

	}

	/**
	 * Setter del controlador por defecto
	 * @param controlador2
	 */
	public void setControlador(Controlador controlador2) {
		controlador = controlador2;
	}

	/**
	 * Setter del modelo por defecto
	 * @param modelo2
	 */
	public void setModelo(Modelo modelo2) {
		modelo = modelo2;
	}

	/**
	 * Getter del controlador para nuevas notas
	 * @return nota
	 */
	public String getNota() {
		return txtANota.getText();
	}
	/**
	 * Getter llamado para la fecha de la nueva nota
	 * @return fecha
	 */

	public String getFecha() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String fecha = dateFormat.format(spinnerFecha.getValue());
		return fecha;
	}

	/**
	 * Metodo para confirmar que una nota esta guardada
	 */
	public void notaGuardada() {
		txtANota.setText("");
		lblNotaGuardada.setText("Nota Guardada");
	}

	/**
	 * Metodo para poner notas
	 */
	public void ponerNotas() {
		String notas = modelo.getNotas();
		txtANota.setText(notas);
		lblNotaGuardada.setText("");

	}
}
