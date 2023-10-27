package estudiante;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.*;
import java.io.*;

public class Estudiantes2023 {
    private static ArrayList<Estudiante> estudiantes;

    public Estudiantes2023() {
        estudiantes = new ArrayList<>();
        cargarArchivo();
    }
    public void adicionar(Estudiante estudiante) {
		// TODO Auto-generated method stub
    	estudiantes.add(estudiante);
	}
    public void añadir() {
        Scanner scanner = new Scanner(System.in);
        	System.out.println("Ingrese nombre del estudiante: ");
        	String nombre = scanner.nextLine();
        	
        	System.out.println("Ingrese apellido del estudiante: ");
        	String apellido = scanner.nextLine();
        	
        	System.out.println("Ingrese ciclo del estudiante: ");
        	int ciclo = scanner.nextInt();
        	
        	System.out.println("Ingrese pension del estudiante: ");
        	double pension = scanner.nextDouble();
        
        	Estudiante es = new Estudiante(0,nombre+" "+apellido, ciclo, pension);
        	adicionar(es);
        	
        	System.out.println("Se añadio con exito!");
    
    		listarEstudiantes();
    }

      public void eliminar() {
    	Scanner scanner = new Scanner(System.in);

    	System.out.println("Ingrese el codigo del estudiante a elimminar: ");
        	  int codigoaEliminar = scanner.nextInt();
        	  
        	  for (Estudiante estudiante : estudiantes) {
				if(estudiante.getCodigo()==codigoaEliminar) {
					estudiantes.remove(estudiante);
					break;
				}
			}
    	listarEstudiantes();
	}

    public Estudiante obtener(int pos) {    
        return null;
    }
    public void sumarPensiones() {
    	double sumatotal=0;
    	
    	for (Estudiante estudiante : estudiantes) {
			sumatotal+=estudiante.getPension();
		}
    	System.out.println("La suma total de las pensiones es:"+sumatotal);
    }

    public Estudiante buscar(int codigo) {
	  Scanner scanner = new Scanner(System.in);

    	System.out.println("Ingrese el codigo del estudiante: ");
        	  int codigoBuscar = scanner.nextInt();
        	  
        	  for (Estudiante estudiante : estudiantes) {
				if(estudiante.getCodigo()==codigoBuscar) {
					System.out.println("Se ha encontrado: Codigo " + estudiante.getCodigo());
					break;
				}
        	  }
        	  Scanner scanner1 = new Scanner(System.in);

          	System.out.println("Ingrese el apellido del estudiante a elimminar: ");
              	 String codigoBuscar1 = scanner1.nextLine();
              	  
              	  for (Estudiante estudiante : estudiantes) {
      				if(estudiante.getNombre()==codigoBuscar1) {
      					System.out.println("Se ha encontrado: Apellido"+ estudiante.getNombre());
      					break;
}

    public int tamano() {
        //Introduce c�digo        
	  return estudiantes.size();
	}

    public void listarEstudiantes(){
        for (Estudiante estudiante : estudiantes) {
        	System.out.println("Codigo: " + estudiante.getCodigo() +
        			", Nombre: " + estudiante.getNombre() + ", Ciclo: " + estudiante.getCiclo() +
        			", Pension: " + estudiante.getPension());
        }
    }
    
    public void ordenarEstudiantesPorApellido() { 
 	   List<Estudiante> estudiantesOrdenados=estudiantes.stream().sorted(Comparator.comparing(Estudiante::getNombre)).collect(Collectors.toList());
 	   
 	   for (Estudiante estudiante : estudiantesOrdenados) {
 		System.out.println(estudiante);
 	}

     }
    
    public void ordenarEstudiantesPorPension() { 
 	   List<Estudiante> estudiantesOrdenados=estudiantes.stream().sorted(Comparator.comparingDouble(Estudiante::getPension)).collect(Collectors.toList());
 	   
 	   for (Estudiante estudiante : estudiantesOrdenados) {
 		System.out.println(estudiante);
 	}

     }
    

    // M�todos para manipular el archivo de texto
    private void readFromInputStream(InputStream inputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String linea;
        while ((linea = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(linea, ",");
            createStudent(st);
        }
        br.close();
    }

	// M�todo que a�adir a los estudiantes del archivo .txt en el arrayList estudiantes.
    private void createStudent(StringTokenizer st){
        int codigo = Integer.parseInt(st.nextToken().trim());
        String nombre = st.nextToken().trim();
        int ciclo = Integer.parseInt(st.nextToken().trim());
        double pension = Double.parseDouble(st.nextToken().trim());
        Estudiante estudiante = new Estudiante(codigo, nombre, ciclo, pension);
        adicionar(estudiante);
    }

    // M�todos para manipular el archivo de texto
    private void cargarArchivo() {
        try {
            File file = new File("./src/estudiantes.txt");
            Class<Estudiantes2023> clazz = Estudiantes2023.class;
            InputStream inputStream = clazz.getResourceAsStream("/estudiantes.txt");
            if (file.exists()) {
                readFromInputStream(inputStream);
            } else
                JOptionPane.showMessageDialog(null,
                        "El archivo estudiantes.txt no existe");
        } catch (Exception x) {
            JOptionPane.showMessageDialog(null, "Se produjo un error= " + x);
        }
    }
}
