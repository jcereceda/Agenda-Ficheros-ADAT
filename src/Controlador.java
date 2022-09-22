import java.io.IOException;
/**
 * Controlador del sistema Modelo Vista Controlador, comunica la vista con los datos
 * @author Javier Cereceda
 *
 */
public class Controlador {
	private Modelo modelo;
	private Vista vista;

	/**
	 * Setter del modelo por defecto
	 * @param modelo2
	 */
	public void setModelo(Modelo modelo2) {
		modelo = modelo2;
	}

	/**
	 * Setter de la vista en este caso una
	 * @param vista2
	 */
	public void setVista(Vista vista2) {
		vista = vista2;
	}

	/**
	 * Metodo para pedir datos a la vista y enviarselos al modelo
	 */
	public void guardar() {
		String nota = vista.getNota();
		String fecha = vista.getFecha();
		modelo.guardarNota(nota,fecha);
	}

	/**
	 * Metodo para pedir al modelo que devuelva las notas
	 * @throws IOException
	 */
	public void verNotas() throws IOException {
		modelo.verNotas();
	}

}
