@FunctionalInterface
interface TetraFunction<V, W, X, Y, R> {
    R apply(V v, W w, X x, Y y);
}