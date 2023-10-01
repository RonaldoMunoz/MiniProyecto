import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Menu {

    public Menu() {
    
    }

    public boolean comprobarCiudad( String city){
        C_origen c1=null;
        c1=C_origen.valueOf(city); // Intentar convertir la entrada a un valor del enum
        if(c1.toString().equals(city)){
        return true;}
        else{
            return false;
        }
        
    }


    public void insertCandidato() {
        Candidato candidato[] = new Candidato[100];
        Scanner dato = new Scanner(System.in);
        // *Candidato(String nombre, String cedula, C_origen c_origen, Partido_p
        // partido_politico,
        // * List<String> promesas,Inclinacion inclinacion) *//
        for(int i = 0; i<candidato.length;i++){
        
        System.out.println("Ingrese el nombre del candidato:");
        String nombre = dato.nextLine();
        System.out.println("Ingrese la identificación del candidato:");
        String identificacion = dato.nextLine();
        System.out.println("Ingrese la ciudad de origen del candidato:");
        C_origen ciudadOrigen = null;
        String c_origen = dato.nextLine().toUpperCase();
        ciudadOrigen=C_origen.valueOf(c_origen);
        while(true){
        if(comprobarCiudad(c_origen)){
            System.out.println("");
            break;
        }
        else{
            System.out.println("Ingresa una ciudad valida");
        } }
        Partido_p p1 = null ;
        System.out.println("Ingrese el partido politico al que pertenece");
        String partido_politico = dato.nextLine();
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
        candidato[i] = new Candidato(nombre,identificacion,ciudadOrigen,p1,propuestas,inclinacion);
        }
    }
}

