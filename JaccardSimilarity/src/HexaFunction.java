@FunctionalInterface
interface HexaFunction<U, V, W, X, Y, Z, R> {
    R apply(U u, V v, W w, X x, Y y, Z z);
}