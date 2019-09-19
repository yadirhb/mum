package hospital;

public class Lab extends VisitResult {

    @Override
    public ResultType getType() {
        return ResultType.Lab;
    }
}
