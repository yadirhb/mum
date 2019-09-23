package school;

public class Grade {
    private Evaluation evaluation;
    private Course course;
    private Student student;
    private Teacher teacher;

    public Course getCourse() {
        return course;
    }

    public Evaluation getEvaluation() {
        return evaluation;
    }

    public Student getStudent() {
        return student;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
