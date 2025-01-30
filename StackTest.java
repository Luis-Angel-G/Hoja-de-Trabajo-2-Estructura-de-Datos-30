import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class StackTest {

    private Stack<Integer> stack;

    @Before
    void SetStack() {
        stack = new Stack<>();
    }

    @Test
    public void ItShouldPopTheLastElement() {
        stack.push(10);
        stack.push(1);
        int result = stack.pop();
        assertEquals(1, result);
    }

}
