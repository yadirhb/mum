class PatientRecord<T> {
    private T record;
    private Patient patient;

    public Patient getPatient() {
        return patient;
    }

    public T getRecord() {
        return record;
    }
}