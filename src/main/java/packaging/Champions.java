package packaging;

import model.Car;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Champions {
    public List<Car> champions;

    public Champions(List<Car> champions) {
        this.champions = champions;
    }

    public List<String> names() {
        List<String> names = new LinkedList<>();
        Iterator<Car> iter = champions.iterator();
        while (iter.hasNext()) {
            names.add(iter.next().name());
        }
        return names;
    }

    public String namesWithComma() {
        StringBuilder names = new StringBuilder();

        for (Car champion : champions) {
            names.append(champion.name());
            names.append(", ");
        }
        return names.substring(0, names.length() - 2);
    }
}
