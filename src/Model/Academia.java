package Model;

import java.util.Iterator;

import Persistencia.Conexion_BD;

/*
 * Clase para definir la clase contenedora osea tener todos los modelos en este solo
 */

public class Academia {

	/*
	 * Atributo para definir la clase de la conexion de la base de datos. llamado de
	 * la persistencia Conexion_BD para la conexion
	 */
	private Conexion_BD Cdb = new Conexion_BD("ACADEMIA.accdb");
	/*
	 * Atributo para definir el DAO de estudiante.
	 */
	private EstudianteDAO estudiantes = new EstudianteDAO();

	/*
	 * Metodo para Restaurar los estudiantes de la base de datos y agregarlos a la
	 * ejecucion final
	 */
	public void EstudiantesAgregados() {
		var BDestudiantes = Cdb.ObtenerEstudiantes();
		for (int i = 0; i < BDestudiantes.size(); i++) {
			var estudiante = BDestudiantes.get(i).split(";");
			// Aqui saco de la informacion en las casillas desde base de datos.
			estudiantes.crear(Integer.parseInt(estudiante[0]), estudiante[1], estudiante[2], estudiante[3],
					Integer.parseInt(estudiante[4]), estudiante[5]);
		}
	}
	 /**
     * Método para crear un estudiante y guardarlo en la base de datos.
     * @param matricula
     * @param nombres
     * @param apellidos
     * @param sexo
     * @param edad
     * @param curso
     */
	
	public void crear(int matricula, String nombres, String apellidos, String sexo, int edad, String curso) {
		if(estudiantes.crear(matricula, nombres, apellidos, sexo, edad, curso)) {
			Cdb.agregarEstudiante(matricula, nombres, apellidos, sexo, edad, curso);
			
            //Validación en caso de que el ID que trae Access sea el mismo del tamaño del arreglo
			
		}else if(estudiantes.crear(matricula + 1, nombres, apellidos, sexo, edad, curso)) {
			Cdb.agregarEstudiante(matricula + 1, nombres, apellidos, sexo, edad, curso);
		}
	}
	public Conexion_BD getCdb() {
		return Cdb;
	}
	public void setCdb(Conexion_BD cdb) {
		Cdb = cdb;
	}
	public EstudianteDAO getEstudiantes() {
		return estudiantes;
	}
	public void setEstudiantes(EstudianteDAO estudiantes) {
		this.estudiantes = estudiantes;
	}
	
}
