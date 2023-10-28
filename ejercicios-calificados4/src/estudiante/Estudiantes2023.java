package estudiante;

import java.util.*;
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
    	
    	int codigo=estudiantes.get(estudiantes.size() - 1).getCodigo()+1;
    	Estudiante es = new Estudiante(codigo,nombre+" "+apellido, ciclo, pension);
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
	//Introduce c�digo
        return null;
    }

    public void buscarPorCodigo() {
    	Scanner scanner = new Scanner(System.in);
    	
		System.out.println("Ingrese el codigo del estudiante: ");
		  int codigoBuscar = scanner.nextInt();
		  
		  for (Estudiante estudiante : estudiantes) {
			if(estudiante.getCodigo()==codigoBuscar) {
				System.out.println("Se ha encontrado: Código " + estudiante);
				return;
			}
		  }
    }
    
    public void buscarPorApellido() {
    	Scanner scanner = new Scanner(System.in);
		 System.out.println("Ingrese el nombre y apellido del estudiante: ");
		 String apellidoBuscar = scanner.nextLine();
		 for (Estudiante estudiante : estudiantes) {
			if(estudiante.getNombre().equalsIgnoreCase(apellidoBuscar)) {
				System.out.println("Se ha encontrado: Apellido"+ estudiante);
				return;
			}
		 }
    }
    
    public void sumarPensiones() {
    	double sumatotal=0;
    	
    	for (Estudiante estudiante : estudiantes) {
			sumatotal+=estudiante.getPension();
		}
    	System.out.println("La suma total de las pensiones es:"+sumatotal);
    }
    
    public int tamano() {
        //Introduce c�digo        
	  return estudiantes.size();
	}

    public void listarEstudiantes(){
        for (Estudiante estudiante : estudiantes) {
        	System.out.println("Código: " + estudiante.getCodigo() +
        			", Nombre: " + estudiante.getNombre() + ", Ciclo: " + estudiante.getCiclo() +
        			", Pensión: " + estudiante.getPension());
        }
    }
    
    public void ordenarEstudiantes(String tipo) {
    	List<Estudiante> estudiantesOrdenados=new ArrayList<Estudiante>();
    	
    	switch (tipo) {
		case "apellido":
		 	   estudiantesOrdenados=estudiantes.stream().sorted(Comparator.comparing(Estudiante::getNombre)).collect(Collectors.toList());			
			break;
		case "pension":
			estudiantesOrdenados=estudiantes.stream().sorted(Comparator.comparingDouble(Estudiante::getPension)).collect(Collectors.toList());			break;

		default:
			break;
		}
 	   
    	for (Estudiante estudiante : estudiantesOrdenados) {
    		System.out.println(estudiante);
 	   	}
     }
     public void modificar() {   	 
   	 Scanner scanner = new Scanner(System.in);
   	 
   	 System.out.print("Ingrese el código del estudiante a modificar: ");
   	 int codigoModificar = scanner.nextInt();
    	  
    	  for (Estudiante estudiante : estudiantes) {
				if(estudiante.getCodigo()==codigoModificar){
					scanner.nextLine();
					System.out.println("Ingrese nombre del estudiante: ");
			    	String nombre = scanner.nextLine();
			    	
			    	System.out.println("Ingrese apellido del estudiante: ");
			    	String apellido = scanner.nextLine();
			    	
			    	System.out.println("Ingrese ciclo del estudiante: ");
			    	int ciclo = scanner.nextInt();
			    	
			    	System.out.println("Ingrese pension del estudiante: ");
			    	double pension = scanner.nextDouble();

					estudiante.setNombre(nombre+" "+apellido);
					estudiante.setCiclo(ciclo);
					estudiante.setPension(pension);
					
					System.out.println("¡Se modificó con éxito!");
				}
    	  }
 	    listarEstudiantes();
     }
	
    public void modificarMinusculas() {
    	for (Estudiante estudiante : estudiantes) {
			if(estudiante.getNombre().substring(0,1).equals(estudiante.getNombre().substring(0,1).toLowerCase())){
				estudiante.setNombre(estudiante.getNombre().substring(0,1).toUpperCase()+estudiante.getNombre().substring(1));
			}
		}
    	
    	System.out.println("Valores cambiados");
    	listarEstudiantes();
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
