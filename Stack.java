public class Stack<T> implements IStack<T> {
    Node<T> first = new Node<>(null);
    Node<T> last = first;

    @Override
    public void push(T value) {
        last.setNext(new Node<>(value));
        Node<T> aux = last;
        last = last.getNext();
        last.setPrevious(aux);
    }

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
                if (v2 == 0) {
                    throw new ArithmeticException("División por 0");
                }
                result = v1 / v2;
                break;
            case '%':
                result = v1 % v2;
                break;
            default:
                throw new IllegalArgumentException("Operador no valido");
        }
        return (T) Integer.valueOf(result);
    }
}