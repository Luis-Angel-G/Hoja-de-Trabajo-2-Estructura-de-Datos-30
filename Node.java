/**
 * Esta clase maneja funcionalidades como obtener siguiente, definir siguiente, obtener
 * anterior, definir anterior, y obtener valor.
 * @Project : Hoja de trabajo 2
 * @author Luis Girón
 * Creacion 28.01.2025
 * Ultima modificacion 30.01.2025
 * @File Name: Node.java
 */

/**
 * La clase Node representa un nodo en una estructura de datos enlazada.
 *
 * @param <T> el tipo de valor que almacena el nodo
 */
public class Node<T> {
    Node<T> next = null;
    Node<T> previous = null;
    T value;

    /**
     * Constructor que inicializa el nodo con un valor.
     *
     * @param value el valor a ser almacenado en el nodo
     */
    public Node(T value) {
        this.value = value;
    }

    /**
     * Constructor por defecto.
     */
    public Node() {
    }

    /**
     * Obtiene el siguiente nodo.
     *
     * @return el siguiente nodo
     */
    public Node<T> getNext() {
        return next;
    }

    /**
     * Establece el siguiente nodo.
     *
     * @param next el nodo a ser establecido como siguiente
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

    /**
     * Obtiene el nodo anterior.
     *
     * @return el nodo anterior
     */
    public Node<T> getPrevious() {
        return previous;
    }

    /**
     * Establece el nodo anterior.
     *
     * @param previous el nodo a ser establecido como anterior
     */
    public void setPrevious(Node<T> previous) {
        this.previous = previous;
    }

    /**
     * Obtiene el valor almacenado en el nodo.
     *
     * @return el valor almacenado en el nodo
     */
    public T getValue() {
        return value;
    }
}