import java.util.InputMismatchException;
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

        m1.menu2(candidato); /* Puede modificarlo */
        // Parte 3 de aqui para bajo
        for (int i = 0; i < candidato.length; i++) { /*
                                                      * Forma brusca de mostrar los datos de los candidatos puede ser
                                                      * mejorado
                                                      */
            if (candidato[i] != null) {
                candidato[i].listarDatosVotos();
            }
        }

    }
}
