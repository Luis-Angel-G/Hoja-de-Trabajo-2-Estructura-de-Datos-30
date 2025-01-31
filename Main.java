import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        try (BufferedReader br = new BufferedReader(new FileReader("datos.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(" ");
                for (String token : tokens) {
                    System.out.println("Processing token: " + token);
                    if (isOperator(token)) {
                        if (stack.last == null || stack.last.getPrevious() == null) {
                            throw new IllegalStateException("Not enough operands in the stack");
                        }
                        int b = stack.pop();
                        int a = stack.pop();
                        int result = stack.operation(token.charAt(0), a, b);
                        stack.push(result);
                    } else {
                        stack.push(Integer.parseInt(token));
                    }
                    printStack(stack);
                }
                if (stack.last == null) {
                    throw new IllegalStateException("No result in the stack");
                }
                System.out.println("Resultado: " + stack.pop());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static boolean isOperator(String token) {
        return "+-*/%".contains(token);
    }

    private static void printStack(Stack<Integer> stack) {
        Node<Integer> current = stack.first.getNext();
        System.out.print("Stack: ");
        while (current != null) {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}