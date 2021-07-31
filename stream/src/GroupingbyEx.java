import java.util.*;
import java.util.stream.Collectors;

public class GroupingbyEx {
    public static void main(String...args){
        Map<Boolean, Food> o =
                Food.menu.stream().collect(
                        Collectors.partitioningBy(Food::isVegetarian,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparingInt(Food::getCalories)),
                                        Optional::get)));
        System.out.println(o);

    }
}

enum Type { MEAT, FISH, OTHER }
class Food {

    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Food(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }
    @Override
    public String toString() {
        return name;
    }

    public static final List<Food> menu =
            Arrays.asList( new Food("pork", false, 1800, Type.MEAT),
                    new Food("beef", false, 7100, Type.MEAT),
                    new Food("chicken", false, 1400, Type.MEAT),
                    new Food("french fries", true, 1530, Type.OTHER),
                    new Food("rice", true, 3510, Type.OTHER),
                    new Food("season fruit", true, 1120, Type.OTHER),
                    new Food("pizza", true, 5150, Type.OTHER),
                    new Food("prawns", false, 1400, Type.FISH),
                    new Food("salmon", false, 4150, Type.FISH));
}
