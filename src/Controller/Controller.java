package Controller;

import java.util.Scanner;

import Model.Academia;

/*
 * Clase en la que su funcion controlara toda la aplicacion
 */

public class Controller {

	/**
	 * Atributo donde se trae el modelo
	 */
	private Academia academia = new Academia();

	/**
	 * Atributo donde se utiliza la entrada del usuario.
	 */
	private Scanner entrada = new Scanner(System.in);

	/**
	 * Método donde funciona toda la consola
	 */

	public void Funcionalidad() {
		if (academia.getCdb().conectar() == 0) {
			academia.EstudiantesAgregados();
			System.out.println("Esta es la cantidad de estudiantes de la base de datos: "
					+ academia.getEstudiantes().getEstudiantes().size());
		}
		boolean activo = true;
		while (activo) {	
			System.out.println("Bienvenido a ACADEMIA, Selecciona la siguiente Opcion que desees: " + "\n"
					+ "[1] Registrar Estudiante Nuevo\n" + "[2] Consultar por Curso\n" + "[3] Cerrar");
			String Opcion = entrada.nextLine();

			switch (Opcion) {
			case "1": {
				System.out.print("Ingresa Apellido\n");
				String apellido = entrada.nextLine();
				System.out.print("Ingresa Nombre\n");
				String nombres = entrada.nextLine();
				System.out.print("Ingresa [M o F]\n");
				String sexo = entrada.nextLine();
				System.out.print("Ingrese la Edad\n");
				int edad = entrada.nextInt();
				System.out.print("Ingresa El curso\n");
				entrada.nextLine();
				String curso = entrada.nextLine();
				academia.crear(academia.getEstudiantes().getEstudiantes().size() + 1, nombres, apellido, sexo, edad,
						curso);
				break;
			}
			case "2": {
				System.out.print("Ingresa el curso que desee buscar: \n");
				String datos = entrada.nextLine();
				var estudiantes = academia.getEstudiantes().buscar_Curso(datos);
				if (!datos.isEmpty()) {
					System.out.println("Registros del curso: \"" + datos + "\".");
				}
				System.out.println("Matrícula\tNombre Completo\tSexo\tEdad\tCurso");
				for (int i = 0; i < estudiantes.size(); i++) {
					System.out.println(estudiantes.get(i).getMatricula() + "\t" + estudiantes.get(i).getNombres() + " "
							+ estudiantes.get(i).getApellidos() + "\t" + estudiantes.get(i).getSexo() + "\t"
							+ estudiantes.get(i).getEdad() + "\t" + estudiantes.get(i).getCurso());
				}
				break;
			}
			case "3": {
				if (academia.getCdb().terminarconexion() == 0) {
					System.out.println("Sesion Terminada");
					activo = false;
					break;
				}
			}
			}
		}
	}

}