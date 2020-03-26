import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy {
    List<Order> orders = new ArrayList<>();
    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        if (bar.isHappyHour()) {
            bar.order(drink, recipe);
        }
        orders.add(new Order(drink, recipe, bar));
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        for (Order order: orders){
            if (order.getBar().isHappyHour()){
                order.getBar().order(order.getDrink(), order.getRecipe());
            }
        }
    }

    @Override
    public void happyHourEnded(StringBar bar) {

    }
}
