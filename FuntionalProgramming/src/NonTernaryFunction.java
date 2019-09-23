public interface NonTernaryFunction<X,Y,Z,R> {
    R process(X x, Y y, Z z);
}
