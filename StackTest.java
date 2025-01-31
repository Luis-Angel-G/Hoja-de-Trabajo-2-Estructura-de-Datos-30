import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;

import org.junit.Before;
import org.junit.Test;

/**
 * Esta clase maneja pruebas como agregar un nuevo elemento a la pila y asignarlo como el último elemento, obtener el elemento anterior de la pila, hacer pop y el último elemento es el previo,
 * agregar y eliminar el último elemento de la pila, lanzar una excepción si se hace pop cuando el último elemento es nulo, sumar, restar, multiplicar, dividir, aplicar módulo, lanzar una
 * excepción cuando se intenta dividir por cero y lanzar una excepción cuando se intenta realizar una operación ilegal.
 * @Project : Hoja de trabajo 2
 * @author Sarah Estrada
 * Creacion 29.01.2025
 * Ultima modificacion 30.01.2025
 * @File Name: StackTest.java
 */

/**
 * La clase StackTest contiene pruebas unitarias para la clase Stack.
 */
public class StackTest {

    private Stack<Integer> stack;

    /**
     * Configura una nueva instancia de Stack antes de cada prueba.
     */
    @Before
    public void SetStack() {
        stack = new Stack<>();
    }

    /**
     * Prueba que se pueda agregar un nuevo elemento a la pila y que se asigne como el último elemento.
     */
    @Test
    public void ItShouldPushaNewElementtotheStackandAssignedAsLastElement() {
        stack.push(80);
        assertEquals(Integer.valueOf(80), stack.last.getValue());
    }

    /**
     * Prueba que se pueda obtener el elemento anterior en la pila.
     */
    @Test
    public void ItShouldGetPreviousElement() {
        stack.push(80);
        stack.push(90);
        stack.push(100);
        assertEquals(Integer.valueOf(90), stack.last.getPrevious().getValue());

    }

    /**
     * Prueba que al hacer pop el último elemento es el previo.
     */
    @Test
    public void WhenItPopsLastElementIsThePreviousOne() {
        stack.push(70);
        stack.push(90);
        stack.pop();
        assertEquals(Integer.valueOf(70), stack.last.getValue());

    }

    /**
     * Prueba que se pueda agregar y eliminar el último elemento de la pila.
     */
    @Test
    public void ItShouldPopTheLastElement() {
        stack.push(80);
        int result = stack.pop();
        assertEquals(80, result);
    }

    /**
     * Prueba que se lance una excepción si se intenta hacer pop cuando el último elemento es nulo.
     */
    @Test
    public void IfLastIsNullThrowException() {
        stack.push(80);
        stack.pop();
        assertNull(stack.last.getValue());
    }

    /**
     * Prueba que se debe de sumar 2 valores a la pila.
     */
    @Test
    public void ItShouldAddTwoValues() {
        assertEquals(Integer.valueOf(80), stack.operation('+', 50, 30));
    }

    /**
     * Prueba que se debe de restar 2 valores a la pila.
     */
    @Test
    public void ItShouldSubstractTwoValues() {
        assertEquals(Integer.valueOf(20), stack.operation('-', 50, 30));
    }

    /**
     * Prueba que se debe de multiplicar 2 valores a la pila.
     */
    @Test
    public void ItShouldMultiplyTwoValues() {
        assertEquals(Integer.valueOf(1500), stack.operation('*', 50, 30));
    }

    /**
     * Prueba que se debe de dividir 2 valores a la pila.
     */
    @Test
    public void ItShouldDivideTwoValues() {
        assertEquals(Integer.valueOf(6), stack.operation('/', 18, 3));
    }
    /**
     * Prueba que se debe de aplicar módulo.
     */
    @Test
    public void ItShouldPerformTheOperationModulo() {
        assertEquals(Integer.valueOf(1), stack.operation('%', 10, 3));
    }

    /**
     * Prueba que se lance una excepción cuando se intenta dividir por cero.
     */
    @Test
    public void ItShouldThrowExceptionWhenItDividingByZero() {
        assertThrows(ArithmeticException.class, () -> stack.operation('/', 80, 0));
    }

    /**
     * Prueba que se lance una excepción cuando se intenta realizar una operación ilegal.
     */
    @Test
    public void ItShouldThrowExceptionWhenItsAIllegalArgumentOperatior() {
        assertThrows(IllegalArgumentException.class, () -> stack.operation('x', 4, 2));
    }

}
