package Persistencia;

import java.io.*;
import java.util.*;
import com.healthmarketscience.jackcess.*;

/*
 * Conexion_BD esta clase se encarga de conectar la base de datos.
 */

public class Conexion_BD {
	private String router;
	private Database base_dato;
	
	public Conexion_BD(String router) {
		this.router = router;
	}

	/*
	 * Metodo para conectar la base de datos
	 */
	public int conectar() {
		try {
			base_dato = DatabaseBuilder.open(new File(router));
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}
	/*
	 * La clave primaria nunca puede ser String porque es el identificador de cada entidad.
	 */
	public ArrayList<String> ObtenerEstudiantes() {
		ArrayList<String> recorrido = new ArrayList<>();
		try {
			Table tabla = base_dato.getTable("Estudiante");
			for (Row registro : tabla) {
				recorrido.add(registro.get("Matricula") + ";" + registro.getString("Apellidos") + ";"
						+ registro.getString("Nombres") + ";" + registro.getString("Sexo") + ";"
						+ registro.get("Edad") + ";" + registro.getString("Curso"));
			}
		} catch (Exception e) {
			recorrido = null;
		}
		return recorrido;
	}

	/*
	 * Metodo para añadir un estudiante a la base de datos (@param matricula, @param
	 * nombres, @param apellidos, @param sexo, @param edad, @param curso).
	 */
	public void agregarEstudiante(int matricula, String nombres, String apellidos, String sexo, int edad,
			String curso) {
		try {
			Table tabla = base_dato.getTable("Estudiante");
			tabla.addRow(matricula, apellidos, nombres, sexo, edad, curso);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * Metodo para terminar la conexion de base de datos
	 */
	public int terminarconexion() {
		try {
			base_dato.close();
		} catch (Exception e) {
			return -1;
		}
		return 0;
	}
}
