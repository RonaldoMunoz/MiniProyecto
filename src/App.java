
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Menu m1 = new Menu();
        int size = 0;
        Scanner opcionesm1 = new Scanner(System.in);
        Scanner sizeA = new Scanner(System.in);
        m1.cleanScreen();
        while (true) {
            try {
                System.out.println("Ingresa la cantidad de candidatos que vas a ingresar:");
                size = sizeA.nextInt();
                break; // Salir del bucle si la entrada es válida
            } catch (InputMismatchException e) {
                sizeA.nextLine(); // Limpiar el búfer de entrada
            }
        }

        Candidato candidato[] = new Candidato[size];
        Menu1op option1 = null;
        m1.cleanScreen();
        boolean end = false;
        String opt;

        do {
            while (true) {
                try {
                    m1.menu1();
                    opt = opcionesm1.nextLine().toUpperCase();
                    option1 = Menu1op.valueOf(opt);
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("Seleccione una opcion valida");
                    opcionesm1.nextLine();
                }
            }
            switch (option1) {
                case A:
                    m1.insertCandidato(candidato);

                    break;
                case B:
                    if (m1.nullArray(candidato) == true) {
                        System.out.println("Primero debes ingresar almenos un candidato");
                        break;
                    } else {
                        m1.actualizarCandidato(candidato);
                        break;
                    }
                case C:
                    if (m1.nullArray(candidato) == true) {
                        System.out.println("Primero debes ingresar almenos un candidato");
                        break;
                    } else {
                        m1.eliminarCandidato(candidato);
                        System.out.println("Presiona Enter para continuar...");
                        opcionesm1.nextLine();
                        break;
                    }
                case D:
                    if (m1.nullArray(candidato) == true) {
                        System.out.println("Primero debes ingresar almenos un candidato");
                        break;
                    } else {
                        m1.buscarCandidato(candidato);
                        System.out.println("Presiona Enter para continuar...");
                        opcionesm1.nextLine();
                        break;
                    }
                case E:
                    if (m1.nullArray(candidato) == true) {
                        System.out.println("Primero debes ingresar almenos un candidato");
                        break;
                    } else {

                        for (int i = 0; i < candidato.length; i++) {
                            if (candidato[i] != null) {
                                candidato[i].listarDatos();
                            }
                        }
                        System.out.println("Presiona Enter para continuar...");
                        opcionesm1.nextLine();
                        break;
                    }
                case F:
                    if (m1.nullArray(candidato) == true) {
                        System.out.println("Primero debes ingresar almenos un candidato");
                        break;
                    } else {
                        end = true;
                        break;
                    }
                default:
                    System.out.println("Ingrese una opcion valida");
            }
        } while (end == false);
        // MENU PARTE 3
        Scanner menu3 = new Scanner(System.in);
        int opcionMenu3;
        boolean flag = false;
        while(flag != true){
        while (true) {
            try {
                for (int i = 0; i < candidato.length; i++) {
                    if (candidato[i] != null) {
                        System.out.println("Ingrese el número de votos para " + candidato[i].getNombre() + ": ");
                        int votos = opcionesm1.nextInt();
                        candidato[i].setN_votos(votos);
                    }
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Haz ingresado un tipo de dato no valido\n");
                opcionesm1.nextLine(); /* Limpiamos el buffer */
            } }

            for (int i = 0; i < candidato.length; i++) {
                for (int j = 0; j < candidato.length; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (candidato[i].getN_votos() > candidato[j].getN_votos()) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if(flag = false) {
                    System.out.println(
                            "No hay un candidato que haya ganado la votacion, se necesita hacer una segunda vuelta\n");
                    opcionesm1.nextLine();
                }
            }
        }
        do {
            System.out.println("\n Menú de Opciones: \n");
            System.out.println("[1] <- Mostrar Ganador \n");
            System.out.println("[2] <- Mostar partido con más candidatos inscritos \n");
            System.out.println("[3] <- Mostrar top 3 de ciudades con menos candidatos \n");
            System.out.println("[4] <- Salir \n");
            opcionMenu3 = menu3.nextInt();

            switch (opcionMenu3) {
                case 1:
                    m1.cleanScreen();
                    // Mostrar el candidato ganador
                    Candidato ganador = candidato[0];
                    for (int i = 1; i < candidato.length; i++) {
                        if (candidato[i].getN_votos() > ganador.getN_votos()) {
                            ganador = candidato[i];
                        }
                    }
                    // Mostrar el candidato ganador
                    System.out.println("El candidato que ganó es:\n");
                    ganador.listarDatosVotos();
                    break;
                case 2:
                    m1.cleanScreen();
                    // Mostrar partido con más candidatos
                    Map<Partido_p, Integer> contadorPartidos = new HashMap<>();
                    for (Candidato candidatoActual : candidato) {
                        Partido_p partido = candidatoActual.getPartido_politico();
                        contadorPartidos.put(partido, contadorPartidos.getOrDefault(partido, 0) + 1);
                    }
                    Partido_p partidoMasCandidatos = null;
                    int maxCandidatos = 0;
                    for (Map.Entry<Partido_p, Integer> entry : contadorPartidos.entrySet()) {
                        if (entry.getValue() > maxCandidatos) {
                            maxCandidatos = entry.getValue();
                            partidoMasCandidatos = entry.getKey();
                        }
                    }
                    System.out.println(
                            "El partido con más candidatos inscritos es: " + partidoMasCandidatos.displayNameEnum());
                    break;
                case 3:
                    m1.cleanScreen();
                    /* Mostrar top 3 de ciudades con menos candidatos */
                    Map<String, Integer> conteoCiudades = new HashMap<>();
                    ArrayList<String> ciudades = new ArrayList<>();

                    for (Candidato c : candidato) {
                        String ciudadOrigen = c.getC_origen().toString();
                        ciudades.add(ciudadOrigen);
                        conteoCiudades.merge(ciudadOrigen, 1, Integer::sum);
                    }

                    ArrayList<String> top3Ciudades = new ArrayList<>(conteoCiudades.keySet());
                    top3Ciudades.sort((c1, c2) -> conteoCiudades.get(c1).compareTo(conteoCiudades.get(c2)));
                    top3Ciudades = new ArrayList<>(top3Ciudades.subList(0, Math.min(3, top3Ciudades.size())));

                    /* Comprobar si todas las ciudades tienen el mismo número de candidatos */
                    boolean todasCiudadesIguales = top3Ciudades.size() > 0 && conteoCiudades
                            .get(top3Ciudades.get(0)) == conteoCiudades.get(top3Ciudades.get(top3Ciudades.size() - 1));

                    if (todasCiudadesIguales) {
                        System.out.println("Las ciudades tienen el mismo numero de candidatos");
                    } else {
                        /* Imprimir el top 3 de ciudades con menos candidatos */
                        System.out.println("\nTop 3 de ciudades con menos candidatos:");
                        for (String ciudad : top3Ciudades) {
                            System.out.println(ciudad + ": " + conteoCiudades.get(ciudad));
                        }
                    }
                    break;
                case 4:
                    System.out.println("Salir del menu");
                    break;
                default:
                    System.out.println("Ingrese una opción válida");
            }
        } while (opcionMenu3 != 4);
    }
}
