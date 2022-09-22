import java.io.*;

import javax.swing.JFileChooser;

/**
 * 
 * @author Javier Cereceda
 * @Desccription - Modelo del sistema modelo vista controlador. Tiene
 *               interacción con los datos externos al programa y contacta con
 *               la vista
 *
 */
public class Modelo {
	private Vista vista;
	private InputStream entrada;
	private FileOutputStream fout;
	private FileInputStream fis;
	private String notas;
	private File f;

	/**
	 * Constructor por defecto
	 */
	public Modelo() {

		try {
			f = new File("notas.txt");
			fout = new FileOutputStream(f, true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Asigna unica vista de la aplicacion
	 * @param vista2
	 */
	public void setVista(Vista vista2) {
		vista = vista2;
	}

	/**
	 * Introduce en el archivo externo la nota y fecha introducidas por el usuario
	 * @param nota
	 * @param fecha
	 */
	public void guardarNota(String nota, String fecha) {
		String total = nota + "\t" + fecha + "\n";
		try {
			fout.write(total.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

		vista.notaGuardada();
	}

	/**
	 * Trae los datos del archivo leyendolo y le informa a la visa que los tiene preparados
	 * @throws IOException
	 */
	public void verNotas() throws IOException {
		fis = new FileInputStream(f);
		int i;
		notas = "";
		i = fis.read();
		while (i != -1) {
			notas += (char) i;
			i = fis.read();
		}
		fis.close();
		vista.ponerNotas();
	}

	/**
	 * Devuelve las notas solicitadas por la vista
	 * @return notas
	 */
	public String getNotas() {
		return notas;
	}

}
