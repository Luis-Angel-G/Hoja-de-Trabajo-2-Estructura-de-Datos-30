/**
 * Se intercambio la clase Stack con el grupo 6, donde se encuentra Alejandra Avilés.
 */

/**
 * La clase Stack implementa la interfaz IStack.
 * @Project : Hoja de trabajo 2
 * @author Luis Girón
 * Creacion 28.01.2025
 * Ultima modificacion 30.01.2025
 * @File Name: Stack.java
 */

/**
 * La clase Stack implementa la interfaz IStack y proporciona la funcionalidad de una pila.
 *
 * @param <T> el tipo de elementos en la pila
 */
public class Stack<T> implements IStack<T> {

    /** Creación del primer valor de la pila como nulo. */
    Node<T> first = new Node<>(null);

    /** Creación del último valor de la pila como el primero. */
    Node<T> last = first;

    /**
     * Agrega un valor a la pila.
     *
     * @param value el valor a ser agregado a la pila
     */
    @Override
    public void push(T value) {
        last.setNext(new Node<>(value));
        Node<T> aux = last;
        last = last.getNext();
        last.setPrevious(aux);
    }

    /**
     * Elimina y devuelve el valor en la parte superior de la pila.
     *
     * @return el valor en la parte superior de la pila
     * @throws IllegalStateException si la pila está vacía
     */
    @Override
    public T pop() {
        if (last == null) {
            throw new IllegalStateException("La pila esta vacia");
        }
        T value = last.getValue();
        last = last.getPrevious();
        if (last != null) {
            last.setNext(null);
        } else {
            first = null;
        }
        return value;
    }

    /**
     * Realiza una operación con dos valores utilizando el operador dado.
     *
     * @param operator el operador a ser utilizado en la operación
     * @param value1 el primer valor para la operación
     * @param value2 el segundo valor para la operación
     * @return el resultado de la operación
     */
    @Override
    @SuppressWarnings({"unchecked", "UnnecessaryBoxing"})
    public T operation(char operator, T value1, T value2) {
        int result = 0;
        int v1 = ((Integer) value1);
        int v2 = ((Integer) value2);
        switch (operator) {
            case '+':
                result = v1 + v2;
                break;
            case '-':
                result = v1 - v2;
                break;
            case '*':
                result = v1 * v2;
                break;
            case '/':
                if (v2 != 0) {
                    result = v1 / v2;
                } else {
                    throw new ArithmeticException("Division por cero");
                }
                break;
            default:
                throw new IllegalArgumentException("Operador no soportado");
        }
        return (T) Integer.valueOf(result);
    }
}