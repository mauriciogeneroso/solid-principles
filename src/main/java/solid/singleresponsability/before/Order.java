package solid.singleresponsability.before;

import solid.singleresponsability.Item;

import java.math.BigDecimal;
import java.util.List;

public class Order {

    public BigDecimal calculateTotalSum() {
        return null;
    }

    public List<Item> getItems() {
        return null;
    }

    public long getItemCount() {
        return 0;
    }

    public void addItem(Item item) {

    }

    public boolean deleteItem(Item item) {
        return true;
    }

    public void printOrder() {

    }

    public void showOrder() {

    }

    public boolean load() {
        return true;
    }

    public boolean save() {
        return true;
    }

    public boolean update() {
        return true;
    }

    public boolean delete() {
        return true;
    }
}
