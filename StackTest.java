import static org.junit.Assert.assertEquals;
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

    }

    @Test
    public void ItShouldPopTheLastElement() {
        stack.push(80);
        int result = stack.pop();
        assertEquals(80, result);
    }

}
