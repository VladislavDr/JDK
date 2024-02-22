package task3;

public class Pair<T, E> {
    private T t;
    private E e;

    public Pair(T t, E e) {
        this.t = t;
        this.e = e;
    }

    public T getFirst() {
        return t;
    }

    public E getSecond() {
        return e;
    }

    @Override
    public String toString() {
        return "T = " + t.getClass().getSimpleName() +
                ", E = " + e.getClass().getSimpleName();
    }
}
