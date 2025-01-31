/**
 * La interfaz IStack define los métodos necesarios para el funcionamiento del Stack, es
 * la interfaz compartida entre los grupos de la clase
* @Project : Hoja de trabajo 2
* @author (Creado en conjunto con los grupos del salón)
* Creacion 28.01.2025
* Ultima modificacion 29.01.2025
* @File Name: IStack.java
 */

/*
 * Interfaz para la clase Stack, que contiene los métodos push, pop y operation.
 */
public interface IStack<T> {

    /**
     * Agrega un valor a la pila.
     *
     * @param value el valor a ser agregado a la pila
     */
    void push(T value);

    /**
     * Elimina y devuelve el valor en la parte superior de la pila.
     *
     * @return el valor en la parte superior de la pila
     */
    T pop();

    /**
     * Realiza una operación con dos valores utilizando el operador dado.
     *
     * @param operator el operador a ser utilizado en la operación
     * @param value1 el primer valor para la operación
     * @param value2 el segundo valor para la operación
     * @return el resultado de la operación
     */
    T operation(char operator, T value1, T value2);
}