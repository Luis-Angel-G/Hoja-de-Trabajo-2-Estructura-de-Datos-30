import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
* Clase principal para ejecutar el programa de la calculadora.
* Gestiona la interacción con el usuario y las funcionalidades de la calculadora.
* @Project : Hoja de trabajo 2
* @author Vernel Hernández
* Creacion 28.01.2025
* Ultima modificacion 30.01.2025
* @File Name: Main.java
*/

/**
 * La clase Main contiene el método principal que lee un archivo de texto y procesa
 * los elementos para realizar operaciones en una pila.
 */
public class Main {

    /**
     * El método principal que ejecuta el programa.
     *
     * @param args los argumentos de la línea de comandos
     */
    public static void main(String[] args) {

        // Instancia inicial del stack
        Stack<Integer> stack = new Stack<>();

        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] elementos = linea.split(" ");
                for (String elemento : elementos) {
                    System.out.println("Procesando elemento: " + elemento);
                    if (isOperator(elemento)) {
                        if (stack.last == null || stack.last.getPrevious() == null) {
                            throw new IllegalStateException("No hay suficientes operandos en la pila");
                        }
                        int b = stack.pop();
                        int a = stack.pop();
                        int resultado = stack.operation(elemento.charAt(0), a, b);
                        stack.push(resultado);
                    } else {
                        stack.push(Integer.parseInt(elemento));
                    }
                    printStack(stack);
                }
                if (stack.last == null) {
                    throw new IllegalStateException("No hay resultado en la pila");
                }
                System.out.println("Resultado: " + stack.pop());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Verifica si el elemento es un operador.
     *
     * @param elemento el elemento a verificar
     * @return true si el elemento es un operador, false en caso contrario
     */
    private static boolean isOperator(String elemento) {
        return "+-*/%".contains(elemento);
    }

    /**
     * Imprime el estado actual de la pila.
     *
     * @param stack la pila a imprimir
     */
    private static void printStack(Stack<Integer> stack) {
        Node<Integer> actual = stack.first;
        System.out.print("Stack: ");
        while (actual != null) {
            System.out.print(actual.getValue() + " ");
            actual = actual.getNext();
        }
        System.out.println();
    }
}