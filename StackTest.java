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
    public void ItShouldPopTheLastElement() {
        stack.push(80);
        int result = stack.pop();
        assertEquals(80, result);
    }

}
