package hw2;

public class Cat extends Animal {
    private final boolean hasWool;

    public Cat(String name, int age, boolean hasWool) {
        super(name, age);
        this.hasWool = hasWool;
    }

    public void makeSound() {
        System.out.printf("The %s purrs...\n", getName());
    }

    @Override
    public String toString() {
        return "Cat{" + "name='" + getName() + '\'' +
                ", age=" + getAge() + ", hasTale=" + hasWool +
                '}';
    }
}
