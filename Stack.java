public class Stack<T> implements IStack<T> {
    Node<T> first;
    Node<T> last;

    @Override
    public void push(T value) {
        last.setNext(new Node<T>(value));
        last = last.getNext();
        last.setPrevious(last);
    }

    @Override
    public T pop() {
        T value = last.getValue();
        last = last.getPrevious();
        last.setNext(null);
        return value;
    }

    @Override
    public T operation(char operator, T value1, T value2) {
        switch(operator) {
            case '+':
                return value1 + value2;
            case '-':
                return value1 - value2;
            case '*':
                return value1 * value2;
            case '/':
                return value1 / value2;
            case '%':
                return value1 % value2;
            default:
                return 0;
        }
    }
}