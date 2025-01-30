import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class StackTest {

    private Stack<Integer> stack;

    @Before
    public void SetStack() {
        stack = new Stack<>();
    }

    @Test
    public void ItShouldPushaNewElementtotheStackandAssignedAsLastElement() {
        stack.push(80);
        assertEquals(Integer.valueOf(80), stack.last.getValue());
    }

    @Test
    public void ItShouldGetPreviousElement() {
        stack.push(80);
        stack.push(90);
        stack.push(100);
        assertEquals(Integer.valueOf(90), stack.last.getPrevious().getValue());

    }

    @Test
    public void WhenItPopsLastElementIsThePreviousOne() {
        stack.push(70);
        stack.push(90);
        stack.pop();
        assertEquals(Integer.valueOf(70), stack.last.getValue());

    }

    @Test
    public void ItShouldPopTheLastElement() {
        stack.push(80);
        int result = stack.pop();
        assertEquals(80, result);
    }

    @Test
    public void IfLastIsNullThrowException() {
        stack.push(80);
        stack.pop();
        assertNull(stack.last.getValue());
    }

    @Test
    public void ItShouldAddTwoValues() {
        assertEquals(Integer.valueOf(80), stack.operation('+', 50, 30));
    }

    @Test
    public void ItShouldSubstractTwoValues() {
        assertEquals(Integer.valueOf(20), stack.operation('-', 50, 30));
    }

    @Test
    public void ItShouldMultiplyTwoValues() {
        assertEquals(Integer.valueOf(1500), stack.operation('*', 50, 30));
    }

    @Test
    public void ItShouldDivideTwoValues() {
        assertEquals(Integer.valueOf(6), stack.operation('/', 18, 3));
    }

    @Test
    public void ItShouldPerformTheOperationModulo() {
        assertEquals(Integer.valueOf(1), stack.operation('%', 10, 3));
    }

}
