package solid.singleresponsability.before;

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

    public List<Item> load() {
        return null;
    }

    public boolean save(Item item) {
        return true;
    }

    public boolean update(Item item) {
        return true;
    }

    public boolean delete(Item item) {
        return true;
    }
}
