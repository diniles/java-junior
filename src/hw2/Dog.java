package hw2;

public class Dog extends Animal {
    private boolean hasTale;

    public Dog(String name, int age, boolean hasTale) {
        super(name, age);
        this.hasTale = hasTale;
    }

    public void makeBark() {
        System.out.printf("the %s barks...", getName());
    }

    @Override
    public String toString() {
        return "Dog{" + "name='" + getName() + '\'' +
                ", age=" + getAge() + ", hasTale=" + hasTale +
                '}';
    }
}
