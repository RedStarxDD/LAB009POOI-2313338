package estudiante;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
    	Scanner scanner=new Scanner(System.in);
        Estudiantes2023 estudiantes = new Estudiantes2023();
        
        mostrarMenu();
        boolean esperarOpcion=true;
        
        while (esperarOpcion && scanner.hasNextInt()) {
           int opcion=scanner.nextInt();
            
           switch (opcion) {
    		case 1:
    			estudiantes.añadir();
    			break;
    		case 2:
    			System.out.println("PUEDE BUSCAR POR NOMBRE O CODIGO. ELEGIR UNA OPCIÓN:\n"
    					+"A – APELLIDO\n"
    					+"B – CODIGO");
    			String letra=scanner.next();
    			switch (letra) {
				case "A":
				case "a":
					estudiantes.buscarPorApellido();
					break;
				case "B":
				case "b":
					estudiantes.buscarPorCodigo();
					break;

				default:
					System.out.println("Opción inválida");
					break;
				}
    			break;
    		case 3:
    			estudiantes.eliminar();
    			break;
    		case 4:
    			
    			break;
    		case 5:
    			estudiantes.modificarMinusculas();
    			break;
    		case 6:
    			estudiantes.listarEstudiantes();
    			break;
    		case 7:
    			estudiantes.ordenarEstudiantes("apellido");
    			break;
    		case 8:
    			estudiantes.ordenarEstudiantes("pension");
    			break;
    		case 9:
    			estudiantes.sumarPensiones();
    			break;
    		case 10:
    			System.out.println("Saliendo del sistema");
    			esperarOpcion=false;
    			scanner.close();
    			break;

    		default:
    			System.out.println("La opción ingresada no está en la lista");
    			break;
    		}
           if(esperarOpcion) mostrarMenu();
		}
    }
    
    public static void mostrarMenu() {
        System.out.println("****** BIENVENIDOS AL SISTEMA DE GESTION DE ESTUDIANTES ********\n"
				+ "1-NUEVO ESTUDIANTE\n"
				+ "2-BUSCAR ESTUDIANTE\n"
				+ "3-ELIMINAR ESTUDIANTE\n"
				+ "4-MODIFICAR ESTUDIANTE\n"
				+ "5-MODIFICAR APELLIDOS EN MINÚSCULAS\n"
				+ "6-VER TODOS LOS ESTUDIANTES\n"
				+ "7-VER TODOS LOS ESTUDIANTE POR APELLIDOS\n"
				+ "8-VER TODOS LOS ESTUDIANTE POR PENSIÓN\n"
				+ "9-TOTAL DE PENSIONES\n"
				+ "10-SALIR\n"
        		+ "¿QUÉ ACTIVIDAD DESEA EJECUTAR?");
    	
    }
}