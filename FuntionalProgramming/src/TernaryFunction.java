@FunctionalInterface
public interface TernaryFunction<X, Y, Z, R> {
    R process(X x, Y y, Z z);
}