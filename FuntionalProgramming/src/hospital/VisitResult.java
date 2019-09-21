package hospital;

public abstract class VisitResult {
    private long id;
    public abstract ResultType getType();
    public long getId() {
        return id;
    }
}
