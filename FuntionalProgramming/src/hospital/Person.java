package hospital;

public abstract class Person {
    protected String name;
    private int age = 10;

    protected Person(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }
}
