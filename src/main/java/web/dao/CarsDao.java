package web.dao;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
@Component
public class CarsDao {
    private List<Car> cars;
    {
        cars = new ArrayList<>();

        cars.add(new Car(12,"toyota","red"));
        cars.add(new Car(14,"wag","white"));
        cars.add(new Car(17,"jelly","orange"));
        cars.add(new Car(19,"meren","blue"));
        cars.add(new Car(11,"tesla","black"));
        cars.add(new Car(66,"UAZ","green"));

    }

    public List<Car> index() {
        return cars;
    }
    public List<Car> show (int size) {
        return cars
                .stream()
                .limit(size)
                .toList();

    }

}

