package cajero;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		System.out.println("********************************************************");
		System.out.println("REGISTRE 5 USUARIOS PARA PODER USAR EL CAJERO AUTOMATICO");
		System.out.println("********************************************************");

		final int CANTIDADUSUARIOS = 5;

		CajeroAutomatico[] vectorUsuarios = new CajeroAutomatico[CANTIDADUSUARIOS];

		String nombre = "";
		String apellido = "";
		long dni = 0;
		long contraseña;
		long monto = 0;

		CajeroAutomatico usuarioGuardado = null;

		for (int i = 0; i < CANTIDADUSUARIOS; i++) {
			System.out.println("\n[" + i + "]" + "Ingrese el nombre de la persona numero " + (i + 1));
			nombre = entrada.nextLine();
			clearScanner(entrada);

			while (nombre == "") {
				System.out.println("Error !! Ingrese un nombre valido");
				nombre = entrada.nextLine();
				clearScanner(entrada);
			}

			System.out.println("\n[" + i + "]" + "Ingrese el apellido de la persona numero " + (i + 1));
			apellido = entrada.nextLine();
			clearScanner(entrada);

			while (apellido == "") {
				System.out.println("Error !! Ingrese un apellido valido");
				apellido = entrada.nextLine();
				clearScanner(entrada);
			}

			System.out.println("\n[" + i + "]" + "Ingrese el DNI de la persona numero " + (i + 1));
			dni = entrada.nextLong();
			clearScanner(entrada);

			System.out.println("\n[" + i + "]" + "Ingrese la contrasenia de la persona numero " + (i + 1));
			contraseña = entrada.nextLong();
			clearScanner(entrada);

			vectorUsuarios[i] = new CajeroAutomatico(nombre, apellido, contraseña, dni, monto);
		}

		int ciclo = 0;

		do {
			System.out.println("\n***************");
			System.out.println("INICIAR SESION");
			System.out.println("***************");

			System.out.println("\nIngresa tu documento");
			long documentoIngresado = entrada.nextLong();
			clearScanner(entrada);

			boolean documentoEncontrado = false;

			for (int i = 0; i < CANTIDADUSUARIOS; i++) {
				if (documentoIngresado == vectorUsuarios[i].getDni()) {
					documentoEncontrado = true;
				}
			}

			if (documentoEncontrado == false) {
				System.out.println("Error !! No existe un usuario con el documento ingresado");
			}

			if (documentoEncontrado == true) {
				boolean contraseñaEncontrada = false;
				do {
					System.out.println("\nIngresa tu contrasenia");
					long contraseñaIngresada = entrada.nextLong();
					clearScanner(entrada);

					for (int i = 0; i < CANTIDADUSUARIOS; i++) {
						if (contraseñaIngresada == vectorUsuarios[i].getContraseña()) {
							contraseñaEncontrada = true;
							usuarioGuardado = vectorUsuarios[i];
						}
					}

					if (contraseñaEncontrada == false) {
						System.out.println("Error !! No existe un usuario con la contraseña ingresada");
					}
				} while (contraseñaEncontrada == false);

				System.out.println("\n******************************************");
				System.out.println("Bienvenido al cajero automatico " + nombre.toUpperCase());
				System.out.println("*******************************************");
				ciclo = 1;
			}

		} while (ciclo != 1);

		do {
			System.out.println("\n1- DEPOSITAR");
			System.out.println("2- EXTRAER");
			System.out.println("3- CONSULTAR");
			System.out.println("4- SALIR");
			int opcion = entrada.nextInt();

			switch (opcion) {
			case 1:
				System.out.println("\n" + nombre.toUpperCase() + " INGRESE LA CANTIDAD A DEPOSITAR");
				monto = entrada.nextLong();
				usuarioGuardado.depositar(monto);
				System.out.println("DEPOSITASTE $" + monto);
				break;
			case 2:
				System.out.println("\n" + nombre.toUpperCase() + " INGRESE LA CANTIDAD A EXTRAER");
				monto = entrada.nextLong();
				if(usuarioGuardado.consultar() < monto) {
					System.out.println("No tienes saldo suficiente");
				} else {
					usuarioGuardado.extraer(monto);
					System.out.println("RETIRASTE $" + monto);
				}
				break;
			case 3:
				System.out.println("Su saldo actual es de $" + usuarioGuardado.consultar());
				break;
			case 4:
				System.out.println("Saliendo del cajero");
				ciclo = 2;
				break;
			default:
				System.out.println("Error !! No ingresaste una opcion valida");
				break;
			}
		} while (ciclo != 2);
	}

	public static void clearScanner(Scanner entrada) {
		String line = null;
		while (!(line = entrada.nextLine()).isEmpty())
			;
	}

}
