
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
                System.out.println("Ingresa el NUMERO de candidatos a ingresar");
                sizeA.nextLine(); // Limpiar el búfer de entrada
            }
        }
        
        Candidato candidato[] = new Candidato[size];
        Menu1op option1 = null;
        m1.cleanScreen();
        boolean end = false;
        String opt;



        do {
            while(true){
            try {
                m1.menu1();
                opt = opcionesm1.nextLine().toUpperCase();
                option1 = Menu1op.valueOf(opt);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("Seleccione una opcion valida");
                opcionesm1.nextLine();
            } }
            switch (option1) {
                case A:
                    m1.insertCandidato(candidato);
                    System.out.println("Salio switcht");
                    break;
                case B:
                    if (candidato[0] == null) {
                        System.out.println("Primero debes ingresar almenos un candidato");
                        break;
                    } else {
                        m1.actualizarCandidato(candidato);

                        break;
                    }
                case C:
                    if (candidato[0] == null) {
                        System.out.println("Primero debes ingresar almenos un candidato");
                        break;
                    } else {
                        m1.eliminarCandidato(candidato);
                        break;
                    }
                case D:
                    if (candidato[0] == null) {
                        System.out.println("Primero debes ingresar almenos un candidato");
                        break;
                    } else {
                        m1.buscarCandidato(candidato);
                        break;
                    }
                case E:
                    if (candidato[0] == null) {
                        System.out.println("Primero debes ingresar almenos un candidato");
                        break;
                    } else {
                        System.out.println(candidato.length);
                        for (int i = 0; i < candidato.length; i++){
                            candidato[i].listarDatos();
                        }
                        System.out.println("Presiona Enter para continuar...");
                        sizeA.nextLine();
                        break;

                    }

                case F:
                    if (candidato[0] == null) {
                        System.out.println("Primero debes ingresar almenos un candidato");
                        break;
                    } else {
                        end = true;
                        break;
                    }
                default:
                    System.out.println("Ingrese una opcion valida");

            }
        opt = "";
        } while (end == false);
    opcionesm1.close();
    sizeA.close();
    }
    
}
