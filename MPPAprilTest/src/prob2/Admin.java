package prob2;

public class Admin {
    private final Department[] departments;

    public Admin(Department[] departments) {
        if(departments == null) throw new NullPointerException("Departments cannot be null");
        this.departments = departments;
    }
    //implement
    public String hourlyCompanyMessage() {
        StringBuilder result = new StringBuilder();
        for(Department d : this.departments) {
            result.append(this.format(d.getName(), d.nextMessage()));
        }
        return result.toString();
    }

    public String format(String name, String message){
        return name + ": " + message + "\n";
    }
}
