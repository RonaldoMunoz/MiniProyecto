import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Menu {
    
    public Menu() {
    }


    public void cleanScreen(){
        System.out.print("\033[H\033[2J");  /* Limpiar consola*/
        System.out.flush();
    }


    public void insertCandidato(Candidato[] candidato) {
         /* Creamos el array de objetos */
        Scanner dato = new Scanner(System.in);
        for (int i = 0; i < candidato.length; i++) { /*Iniciamos el for para ir creando los objetos nuevos */
            System.out.println("Ingrese el nombre del candidato:");
            String nombre = dato.nextLine();
            System.out.println("Ingrese la identificación del candidato:");
            String identificacion = dato.nextLine();
            C_origen c1 = null;

            do {
                try{
            System.out.println("Ingrese la ciudad de origen del candidato:");
            String c_origen = dato.nextLine().replace(" ","_");
            c_origen.replace(" ","_" ); 
                    c1 = C_origen.valueOf(c_origen.toUpperCase());
                    System.out.println("check");
                    break;
            } 
        
            catch(IllegalArgumentException e){
                System.out.println("Ingrese una ciudad valida");
            }
            } while(true);

            Partido_p p1 = null;
            System.out.println("Ingrese el partido politico al que pertenece");
            String partido_politico = dato.nextLine().toUpperCase();
            p1 = Partido_p.valueOf(partido_politico);
            System.out.println("Ingrese Su inclinacion politica;....");
            String inclinacion = dato.nextLine();
            List<String> propuestas = new ArrayList<>();
            System.out.println("Ingrese las propuestas del candidato (separadas por coma):");
            String propuestasStr = dato.nextLine();
            String[] propuestasArray = propuestasStr.split(",");
            for (String propuesta : propuestasArray) {
                propuestas.add(propuesta.trim());
            }
            candidato[i] = new Candidato(nombre, identificacion, c1, p1, propuestas, inclinacion,0);
            System.out.println("Deseas agregar otro candidato?... S/N");
            System.out.println(":... S / N \n");
            String request = dato.nextLine();
            if(request.equals("S")){
                System.out.println("");
            }
            else if(request.equals(("N"))){
                dato.close();
                break;
            }
            else{
                System.out.println("Digite una opcion valida!");
                continue;
            
            }
        }
    }
    public void actualizarCandidato(Candidato[] candidato){
        Scanner dato = new Scanner(System.in);
        Scanner target = new Scanner(System.in);
        System.out.println("Digite el nombre del candidato que desea actualizar;... \n");
        String buscar = target.nextLine();
        for(int i = 0; i < candidato.length; i++){
            if(candidato[i].getNombre().equals(buscar)){
            System.out.println("Ingrese el nombre del candidato:");
            String nombre = dato.nextLine();
            System.out.println("Ingrese la identificación del candidato: \n ");
            String identificacion = dato.nextLine();
            System.out.println("Ingrese la ciudad de origen del candidato: \n ");
            C_origen ciudadOrigen = null;
            String c_origen = dato.nextLine().toUpperCase();
            ciudadOrigen = C_origen.valueOf(c_origen);
            while (true) {
                if (comprobarCiudad(c_origen)) {
                    System.out.println("");
                    break;
                } else {
                    System.out.println("Ingresa una ciudad valida \n");
                }
            }
            Partido_p p1 = null;
            System.out.println("Ingrese el partido politico al que pertenece\n");
            String partido_politico = dato.nextLine().toUpperCase();
            p1 = Partido_p.valueOf(partido_politico);
            System.out.println("Ingrese Su inclinacion politica;....");
            String inclinacion = dato.nextLine();
            List<String> propuestas = new ArrayList<>();
            System.out.println("Ingrese las propuestas del candidato (separadas por coma): \n");
            String propuestasStr = dato.nextLine();
            String[] propuestasArray = propuestasStr.split(",");
            for (String propuesta : propuestasArray) {
                propuestas.add(propuesta.trim());
            }
            dato.close();
            target.close();
            candidato[i].setNombre(nombre);
            candidato[i].setCedula(identificacion);
            candidato[i].setC_origen(ciudadOrigen);
            candidato[i].setInclinacion(inclinacion);
            candidato[i].setPartido_politico(p1);
            }

        }
            
        }

    public void buscarCandidato(Candidato[] candidato){
        Scanner target = new Scanner(System.in);
        System.out.println("Digite el numero de cedula del candidato que desea buscar;... \n");
        String buscar = target.nextLine();
        for(int i = 0; i < candidato.length; i++){
            if(candidato[i].getCedula().equals(buscar)){
            target.close();
            System.out.println(candidato[i].toString());
            }
        } 
    }

    public void eliminarCandidato(Candidato[] candidato){
        Scanner target = new Scanner(System.in);
        System.out.println("Digite el numero de cedula del candidato que desea eliminar;... \n");
        String buscar = target.nextLine();
        for(int i = 0; i < candidato.length; i++){
            if(candidato[i].getCedula().equals(buscar)){
                candidato[i]=null;
                System.out.println("El candidato: \n"+ candidato[i].toString()+"Ha sido eliminado con exito \n");
                target.close();
                break;
            }
        } 
        
    }
    }
