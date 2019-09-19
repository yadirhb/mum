package hospital;

public class Medication extends VisitResult {

    @Override
    public ResultType getType() {
        return ResultType.Medication;
    }
}
