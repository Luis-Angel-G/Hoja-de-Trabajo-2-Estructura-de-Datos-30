public class Stack<T> implements IStack {
    Node<T> first;
    Node<T> last;

    public void push(T value) {
        last.setNext(new Node<T>(value));
        last = last.getNext();
        last.setPrevious(last);
    }

    public int pop() {
        T value = last.getValue();
        last = last.getPrevious();
        last.setNext(null);
        return (int)value;
    }

    public int operation(char operator, int value1, int value2) {
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