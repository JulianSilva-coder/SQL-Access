package Persistencia;

import java.util.Comparator;

/*
 * Clase para definir un objeto de tipo estudiante
 */
public class EstudianteDTO implements Comparator<EstudianteDTO>{
	private int matricula;
	private String nombres;
	private String apellidos;
	private String sexo;
	private int edad;
	private String curso;
	
	public EstudianteDTO(int matricula, String nombres, String apellidos, String sexo, int edad, String curso) {
		this.matricula = matricula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.edad = edad;
		this.curso = curso;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "EstudianteDTO [matricula=" + matricula + ", nombres=" + nombres + ", apellidos=" + apellidos + ", sexo="
				+ sexo + ", edad=" + edad + ", curso=" + curso + "]";
	}

	@Override
	public int compare(EstudianteDTO o1, EstudianteDTO o2) {
		
		return o1.getCurso().compareTo(o2.getCurso());
		
	}
}
