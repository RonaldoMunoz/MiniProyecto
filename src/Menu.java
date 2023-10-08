import java.util.Scanner;
import java.util.ArrayList;
import java.util.Objects;

public class Menu {

    public Menu() {
    }

    public void menu1() {
        System.out.println("   [C R U D] \n");
        System.out.println("[A]<- Insertar candidato \n");
        System.out.println("[B}<- Actualizar candidato \n");
        System.out.println("[C]<- Eliminar candidato \n");
        System.out.println("[D]<- Buscar candidato por nombre \n");
        System.out.println("[E]<- Listar todos los candidatoS \n");
        System.out.println("[F]<- Si desea continuar con el ingreso de votos \n");
    }

    public void menu2(Candidato candidato[]) {
        Scanner dato = new Scanner(System.in);
        for (int i = 0; i < candidato.length; i++) {
            System.out.println("Ingrese los votos del candidato: \n");
            candidato[i].listarDatos();
            System.out.println("N. Votos: \n");
            int votos = dato.nextInt();
            candidato[i].setN_votos(votos);
        }

    }

    public void cleanScreen() {
        System.out.print("\033[H\033[2J"); /* Limpiar consola */
        System.out.flush();
    }

    public void propuestaAdd(ArrayList<String> promesas) {
        Scanner prop = new Scanner(System.in);
        String promesa;
        System.out.println("Agregue sus propuestas separadas por coma");
        do {
            promesa = prop.nextLine();
            promesas.add(promesa);
            System.out.println("Propuesta ingresada con exito... \n");
            System.out.println("Si desea agregar una promesa digite -> [S] \n De lo contrario digite -> [N]");
            promesa = " ";
            promesa = prop.nextLine().toUpperCase();
            if (promesa.equals("N")) {
                break;
            } else if (promesa.equals("S")) {
                promesa = " ";
            } else {
                System.out.println("Digite una opcion valida");
            }

        } while (true);
    }

    public void insertCandidato(Candidato[] candidato) {

        /* Creamos el array de objetos */
        String request = " ";
        Partido_p p1 = null;
        C_origen c1 = null;
        Inclinacion inclinacion = null;
        ArrayList<String> promesas = new ArrayList<>();

        Scanner dato = new Scanner(System.in);
        for (int i = 0; i < candidato.length; i++) { /* Iniciamos el for para ir creando los objetos nuevos */
            System.out.println("Candidato #" + i + 1 + "\n");
            System.out.println("Ingrese el nombre del candidato:");
            String nombre = dato.nextLine();
            System.out.println("Ingrese la identificación del candidato:");
            String identificacion = dato.nextLine();
            do {
                try {
                    System.out.println("Ingrese la ciudad de origen del candidato:");
                    String c_origen = dato.nextLine().replace(" ", "_");
                    c_origen.replace(" ", "_");
                    c1 = C_origen.valueOf(c_origen.toUpperCase());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Ingrese una ciudad valida");
                }
            } while (true);
            do {
                try {
                    System.out.println("Ingrese el partido politico al que pertenece");
                    String partido_politico = dato.nextLine().replace(" ", "_");
                    p1 = Partido_p.valueOf(partido_politico.toUpperCase());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Digite una opcion valida");
                }

            } while (true);
            propuestaAdd(promesas);
            do {
                try {
                    System.out.println("Ingrese Su inclinacion politica;....");
                    String inclinacion_p = dato.nextLine().replace(" ", "_");
                    inclinacion = Inclinacion.valueOf(inclinacion_p.toUpperCase());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Digite una opcion valida");
                }
            } while (true);
            candidato[i] = new Candidato(nombre, identificacion, c1, p1, promesas, inclinacion, 0);
        }
    }

    public void actualizarCandidato(Candidato[] candidato) {
        Scanner target = new Scanner(System.in);
        Scanner dato = new Scanner(System.in);
        String inclinacion_p;
        System.out.println("Digite el nombre del candidato que desea actualizar;... \n");
        String buscar = target.nextLine();
        for (int i = 0; i < candidato.length; i++) {
            if (candidato[i].getNombre().equals(buscar)) {
                Partido_p p1 = null;
                C_origen c1 = null;
                Inclinacion inclinacion = null;
                ArrayList<String> promesas = new ArrayList<>();

                System.out.println("Ingrese el nombre del candidato:");
                String nombre = dato.nextLine();
                System.out.println("Ingrese la identificación del candidato:");
                String identificacion = dato.nextLine();
                do {
                    try {
                        System.out.println("Ingrese la ciudad de origen del candidato:");
                        String c_origen = dato.nextLine().replace(" ", "_");
                        c_origen.replace(" ", "_");
                        c1 = C_origen.valueOf(c_origen.toUpperCase());
                        System.out.println("check");
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Ingrese una ciudad valida");
                    }
                } while (true);
                do {
                    try {
                        System.out.println("Ingrese el partido politico al que pertenece");
                        String partido_politico = dato.nextLine().replace(" ", "_");
                        p1 = Partido_p.valueOf(partido_politico.toUpperCase());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Digite una opcion valida");
                    }

                } while (true);
                propuestaAdd(promesas);
                do {
                    try {
                        System.out.println("Ingrese Su inclinacion politica;...." + inclinacion);
                        inclinacion_p = dato.nextLine();
                        inclinacion = Inclinacion.valueOf(inclinacion_p.toUpperCase());
                        break;
                    } catch (IllegalArgumentException e) {
                        System.out.println("Digite una opcion valida");
                    }
                } while (true);

                candidato[i].setNombre(nombre);
                candidato[i].setCedula(identificacion);
                candidato[i].setC_origen(c1);
                candidato[i].setInclinacion(inclinacion);
                candidato[i].setPromesas(promesas);
                candidato[i].setPartido_politico(p1);
            } else {
                System.out.println("El usuario no fue encontrado.\n Revisa si escribiste su nombre bien");
            }

        }

    }

    public void buscarCandidato(Candidato[] candidato) {
        Scanner target = new Scanner(System.in);
        System.out.println("Digite el nombre del candidato que desea buscar;... \n");
        String buscar = target.nextLine();
        boolean find = false;
        for (int i = 0; i < candidato.length; i++) {
            if (candidato[i].getNombre().equals(buscar)) {
                find = true;
                candidato[i].listarDatos();
            }
        }
        if (!find) {
            System.out.println("No se encontro el candidato");
        }
    }

    public void eliminarCandidato(Candidato[] candidato) {
        Scanner target = new Scanner(System.in);
        System.out.println("Digite el numero de cedula del candidato que desea eliminar;... \n");
        String buscar = target.nextLine();
        for (int i = 0; i < candidato.length; i++) {
            if (candidato[i].getCedula().equals(buscar)) {
                candidato[i].listarDatos();
                System.out.println(" Ha sido eliminado con exito \n");
                candidato[i] = null;
                break;
            }
        }

    }
}
