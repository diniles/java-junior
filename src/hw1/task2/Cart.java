package hw1.task2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Корзина
 *
 * @param <T> Еда
 */
public class Cart<T extends Food> {

    /**
     * Товары в магазине
     */
    private final ArrayList<T> foodstuffs;
    private final UMarket market;
    private final Class<T> clazz;

    public Cart(Class<T> clazz, UMarket market) {
        this.clazz = clazz;
        this.market = market;
        foodstuffs = new ArrayList<>();
    }

    public Collection<T> getFoodstuffs() {
        return foodstuffs;
    }

    /**
     * Распечатать список продуктов в корзине
     */
    public void printFoodstuffs() {
        AtomicInteger index = new AtomicInteger(1);
        foodstuffs.forEach(food -> {
            System.out.printf("[%d] %s (Белки: %s Жиры: %s Углеводы: %s)\n",
                    index.getAndIncrement(), food.getName(),
                    food.getProteins() ? "Да" : "Нет",
                    food.getFats() ? "Да" : "Нет",
                    food.getCarbohydrates() ? "Да" : "Нет");
        });
    }

    /**
     * Балансировка корзины new version
     */
    public void cardBalancing() {
        boolean proteins = foodstuffs.stream().anyMatch(Food::getProteins);
        boolean fats = foodstuffs.stream().anyMatch(Food::getFats);
        boolean carbohydrates = foodstuffs.stream().anyMatch(Food::getCarbohydrates);

        if (proteins && fats && carbohydrates) {
            System.out.println("Корзина уже сбалансирована по БЖУ.");
            return;
        }

        List<Food> food = market.getThings(Food.class).stream().toList();

        if (!proteins) {
            Food containProteins = food.stream().filter(Food::getProteins).findFirst().orElse(null);
            if (containProteins != null) {
                foodstuffs.add((T) containProteins);
                proteins = true;
            }
        }

        if (!fats) {
            Food containFats = food.stream().filter(Food::getFats).findFirst().orElse(null);
            if (containFats != null) {
                foodstuffs.add((T) containFats);
                fats = true;
            }
        }

        if (!carbohydrates) {
            Food containCarbohydrates = food.stream().filter(Food::getCarbohydrates).findFirst().orElse(null);
            if (containCarbohydrates != null) {
                foodstuffs.add((T) containCarbohydrates);
                carbohydrates = true;
            }
        }

        if (proteins && fats && carbohydrates)
            System.out.println("Корзина сбалансирована по БЖУ.");
        else
            System.out.println("Невозможно сбалансировать корзину по БЖУ.");

    }
//    public void cardBalancing() {
//        boolean proteins = false;
//        boolean fats = false;
//        boolean carbohydrates = false;
//
//        for (var food : foodstuffs) {
//            if (!proteins && food.getProteins())
//                proteins = true;
//            else if (!fats && food.getFats())
//                fats = true;
//            else if (!carbohydrates && food.getCarbohydrates())
//                carbohydrates = true;
//            if (proteins && fats && carbohydrates)
//                break;
//        }
//
//        if (proteins && fats && carbohydrates) {
//            System.out.println("Корзина уже сбалансирована по БЖУ.");
//            return;
//        }
//
//        for (var thing : market.getThings(Food.class)) {
//            if (!proteins && thing.getProteins()) {
//                proteins = true;
//                foodstuffs.add((T) thing);
//            } else if (!fats && thing.getFats()) {
//                fats = true;
//                foodstuffs.add((T) thing);
//            } else if (!carbohydrates && thing.getCarbohydrates()) {
//                carbohydrates = true;
//                foodstuffs.add((T) thing);
//            }
//            if (proteins && fats && carbohydrates)
//                break;
//        }
//
//        if (proteins && fats && carbohydrates)
//            System.out.println("Корзина сбалансирована по БЖУ.");
//        else
//            System.out.println("Невозможно сбалансировать корзину по БЖУ.");
//
//    }

}
