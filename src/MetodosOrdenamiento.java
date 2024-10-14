import java.util.Arrays;
import java.util.Scanner;
class MetodoOrdenamiento {
    int[] burbujaNormal(int[] arreglo, boolean ascendente, boolean logs) {
        int n = arreglo.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if ((ascendente && arreglo[j] > arreglo[j + 1]) || (!ascendente && arreglo[j] < arreglo[j + 1])) {
                    int temp = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp;
                }
            }
            if (logs) {
                System.out.println("Paso " + (i + 1) + ": " + Arrays.toString(arreglo));
            }
        }
        return arreglo;
    }

    int[] seleccion(int[] arreglo, boolean ascendente, boolean logs) {
        int tamanio = arreglo.length;
        for (int i = 0; i < tamanio - 1; i++) {
            int indice = i;
            for (int j = i + 1; j < tamanio; j++) {
                if (ascendente) {
                    if (arreglo[j] < arreglo[indice]) {
                        indice = j;
                    }
                } else {
                    if (arreglo[j] > arreglo[indice]) {
                        indice = j;
                    }
                }
            }
            int aux = arreglo[indice];
            arreglo[indice] = arreglo[i];
            arreglo[i] = aux;
            
            if (logs) {
                System.out.println("Paso " + (i + 1) + ": " + Arrays.toString(arreglo));
            }
        }
        return arreglo;
    }

    int[] insercion(int[] arreglo, boolean ascendente, boolean logs) {
        int n = arreglo.length;
        for (int i = 1; i < n; i++) {
            int actual = arreglo[i];
            int j = i - 1;
            while (j >= 0 && ((ascendente && arreglo[j] > actual) || (!ascendente && arreglo[j] < actual))) {
                arreglo[j + 1] = arreglo[j];
                j--;
            }
            arreglo[j + 1] = actual;
            if (logs) {
                System.out.println("Paso " + i + ": " + Arrays.toString(arreglo));
            }
        }
        return arreglo;
    }

    int[] burbujaMejorada(int[] arreglo, boolean ascendente, boolean logs) {
        int n = arreglo.length;
        boolean intercambio;
        for (int i = 0; i < n; i++) {
            intercambio = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if ((ascendente && arreglo[j] > arreglo[j + 1]) || (!ascendente && arreglo[j] < arreglo[j + 1])) {
                    int aux = arreglo[j];
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = aux;
                    intercambio = true;
                }
                if (logs) {
                    System.out.println("j=" + j + ": " + Arrays.toString(arreglo));
                }
            }
            if (!intercambio) {
                break;
            }
            if (logs) {
                System.out.println("Paso " + (i + 1) + ": " + Arrays.toString(arreglo));
            }
        }
        return arreglo;
    }

    int validarEntradaPositiva(Scanner scanner) {
        int numero;
        while (true) {
            System.out.print("Ingrese un número positivo para el tamaño del arreglo: ");
            try {
                numero = Integer.parseInt(scanner.nextLine());
                if (numero > 0) {
                    break;
                } else {
                    System.out.println("El número debe ser positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Debe ser un número entero.");
            }
        }
        return numero;
    }
}
