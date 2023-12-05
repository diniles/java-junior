package hw2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ClassObjectInfo {
    public static void getInfo(Animal animal) {
        Class<?> animalClass = animal.getClass();
        System.out.println("Class: " + animalClass.getName());

        Field[] fields = animalClass.getDeclaredFields();
        System.out.println("Fields:");
        for (Field field : fields) {
            System.out.println("  " + field.getType().getName() + " " + field.getName());
        }


        Constructor<?>[] constructors = animalClass.getConstructors();
        System.out.println("Constructors:");
        for (Constructor<?> constructor : constructors) {
            System.out.print("  " + animalClass.getSimpleName() + "(");
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                System.out.print(parameterTypes[i].getSimpleName());
                if (i < parameterTypes.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println(")");
        }
    }

    public static <T> void invokeMakeSound(T animal) {
        try {
            Method makeSoundMethod = animal.getClass().getMethod("makeSound");
            makeSoundMethod.invoke(animal);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Method \"makeSound\" not found");
        }
    }
}
