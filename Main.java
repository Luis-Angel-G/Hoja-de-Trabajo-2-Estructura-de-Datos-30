import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IStack<Integer> stack = new Stack<>();

        System.out.println("Introduce la expresión (números y operadores separados por espacio):");
        String input = scanner.nextLine();
        String[] tokens = input.split(" ");

        for (String token : tokens) {
            if (isInteger(token)) {
                stack.push(Integer.parseInt(token));
                System.out.println("Pila después de push: " + getStackContent(stack));
            } else if (isOperator(token)) {
                try {
                    int operandoB = stack.pop();
                    int operandoA = stack.pop();

                    int resultado = stack.operation(token.charAt(0), operandoA, operandoB);
                    stack.push(resultado);

                    System.out.println("Pila después de operación '" + token + "': " + getStackContent(stack));
                } catch (Exception e) {
                    System.out.println("Error: No hay suficientes operandos para realizar la operación.");
                    scanner.close();
                    return;
                }
            } else {
                System.out.println("Error: Token no reconocido: " + token);
            }
        }

        try {
            System.out.println("Resultado final: " + stack.pop());
        } catch (Exception e) {
            System.out.println("Error: La expresión es incorrecta.");
        }

        scanner.close();
    }

    public static boolean isInteger(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("%");
    }

    // Método auxiliar para mostrar el contenido del stack desde last hacia atrás
    public static String getStackContent(IStack<Integer> stack) {
        Stack<Integer> tempStack = (Stack<Integer>) stack;
        Node<Integer> currentNode = tempStack.last;  // Recorrer desde el último
        StringBuilder content = new StringBuilder("[");

        boolean firstElement = true;
        while (currentNode != null && currentNode.getValue() != null) {
            if (!firstElement) {
                content.insert(1, ", ");
            }
            content.insert(1, currentNode.getValue());
            currentNode = currentNode.getPrevious();
            firstElement = false;
        }
        content.append("]");
        return content.toString();
    }
}

