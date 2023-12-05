package hw2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static hw2.ClassObjectInfo.getInfo;
import static hw2.ClassObjectInfo.invokeMakeSound;

public class Main {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>();
        animals.add(new Dog("Sharik", 3, true));
        animals.add(new Dog("Tuzik", 5, true));
        animals.add(new Dog("Mopsik", 2, false));
        animals.add(new Cat("Murzik", 1, true));
        animals.add(new Cat("Barsik", 2, true));
        animals.add(new Cat("Sphinx", 3, false));

        for (Animal animal : animals) {
            System.out.println("Object: " + animal);
            getInfo(animal);
            invokeMakeSound(animal);
            System.out.println();
        }

    }


}
