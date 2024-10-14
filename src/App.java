import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MetodoOrdenamiento metodoOrdenamiento = new MetodoOrdenamiento();
        int opcion;
        int[] arreglo = null;

        do {
            System.out.println("\nMenu Principal");
            System.out.println("1. Ingresar un arreglo");
            System.out.println("2. Ordenar Arreglo");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            try {
                opcion = Integer.parseInt(scanner.nextLine());

                if (opcion == 1) {
                    int tamanio = metodoOrdenamiento.validarEntradaPositiva(scanner);
                    arreglo = new int[tamanio];
                    for (int i = 0; i < tamanio; i++) {
                        System.out.print("Ingrese el valor para " + (i + 1) + ": ");
                        try {
                            arreglo[i] = Integer.parseInt(scanner.nextLine());
                        } catch (NumberFormatException e) {
                            System.out.println("Entrada inválida. Debe ser un número entero.");
                            i--; // Repetir el ciclo para este índice
                        }
                    }
                    System.out.println("Arreglo ingresado: " + Arrays.toString(arreglo));
                } else if (opcion == 2) {
                    if (arreglo == null) {
                        System.out.println("Primero ingrese un arreglo.");
                    } else {
                        System.out.println("Escoja un método de ordenamiento:");
                        System.out.println("1. Burbuja Normal");
                        System.out.println("2. Selección");
                        System.out.println("3. Inserción");
                        System.out.println("4. Burbuja Mejorada");
                        int metodo = Integer.parseInt(scanner.nextLine());

                        System.out.println("Escoja ascendente o descendente:");
                        System.out.println("1. Ascendente");
                        System.out.println("2. Descendente");
                        boolean ascendente = Integer.parseInt(scanner.nextLine()) == 1;

                        System.out.println("¿Quiere ver cada paso?");
                        System.out.println("1. Si");
                        System.out.println("2. No");
                        boolean logs = Integer.parseInt(scanner.nextLine()) == 1;

                        switch (metodo) {
                            case 1:
                                arreglo = metodoOrdenamiento.burbujaNormal(arreglo, ascendente, logs);
                                break;
                            case 2:
                                arreglo = metodoOrdenamiento.seleccion(arreglo, ascendente, logs);
                                break;
                            case 3:
                                arreglo = metodoOrdenamiento.insercion(arreglo, ascendente, logs);
                                break;
                            case 4:
                                arreglo = metodoOrdenamiento.burbujaMejorada(arreglo, ascendente, logs);
                                break;
                            default:
                                System.out.println("Opción inválida.");
                        }

                        System.out.println("Arreglo ordenado: " + Arrays.toString(arreglo));
                    }
                } else if (opcion != 0) {
                    System.out.println("Opción inválida, intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ser un número entero.");
                opcion = -1; // Para que no salga del bucle
            }
        } while (opcion != 0);

        System.out.println("Programa terminado.");
    }
}