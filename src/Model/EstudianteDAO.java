package Model;

import java.util.ArrayList;
import java.util.Iterator;

import Persistencia.EstudianteDTO;

public class EstudianteDAO {
	/**
	 * Atributo para definir un arreglo de tama�o indefinido de tipo estudiantes.
	 */
	private ArrayList<EstudianteDTO> estudiantes = new ArrayList<>();

	/**
	 * M�todo para crear un estudiante
	 * 
	 * @param matricula
	 * @param nombres
	 * @param apellidos
	 * @param sexo
	 * @param edad
	 * @param curso
	 * @return
	 */
	public boolean crear(int matricula, String apellidos, String nombres, String sexo, int edad, String curso) {
		var Student = new EstudianteDTO(matricula,apellidos , nombres, sexo, edad, curso);
		if (buscar_Matricula(matricula) == null) {
			estudiantes.add(Student);
			return true;
		}
		return false;
	}

	/**
	 * M�todo para buscar estudiantes por curso
	 * 
	 * @param curso
	 * @return
	 */
	public ArrayList<EstudianteDTO> buscar_Curso(String curso) {
		var encuentro = new ArrayList<EstudianteDTO>();
		for (EstudianteDTO busquedaC : estudiantes) {
			if (busquedaC.getCurso().contains(curso)) {
				encuentro.add(busquedaC);
				encuentro.sort(busquedaC);
			}
		}
		return encuentro;
	}

	/**
	 * M�todo para buscar un estudiante por matr�cula
	 * 
	 * @param matricula
	 * @return
	 */
	public EstudianteDTO buscar_Matricula(int matricula) {
		for (EstudianteDTO buscarMa : estudiantes) {
			if (buscarMa.getMatricula() == matricula) {
				return buscarMa;
			}
		}
		return null;
	}

	/**
	 * M�todo para buscar estudiantes en la ejecuci�n
	 * 
	 * @return
	 */
	public ArrayList<EstudianteDTO> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(ArrayList<EstudianteDTO> estudiantes) {
		this.estudiantes = estudiantes;
	}

}
