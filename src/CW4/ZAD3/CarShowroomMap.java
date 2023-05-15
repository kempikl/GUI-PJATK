package CW4.ZAD3;

import java.util.*;

public class CarShowroomMap {
    public static void main(String[] args) {
        String[] arr = {
                "salon A", "Mercedes", "130000",
                "salon B", "Mercedes", "120000",
                "salon C", "Ford", "110000",
                "salon B", "Opel", "90000",
                "salon C", "Honda", "95000",
                "salon A", "Ford", "105000",
                "salon A", "Renault", "75000"
        };

        Map<String, List<Car>> showroomMap = new HashMap<>();

        for (int i = 0; i < arr.length; i += 3) {
            String showroom = arr[i];
            String brand = arr[i + 1];
            String price = arr[i + 2];

            Car car = new Car(brand, price);

            if (showroomMap.containsKey(showroom)) {
                showroomMap.get(showroom).add(car);
            } else {
                List<Car> carList = new ArrayList<>();
                carList.add(car);
                showroomMap.put(showroom, carList);
            }
        }

        System.out.println(showroomMap);

        String cheapestCarShowroom = "";
        String cheapestCarBrand = "";
        int cheapestCarPrice = Integer.MAX_VALUE;

        for (Map.Entry<String, List<Car>> entry : showroomMap.entrySet()) {
            String showroom = entry.getKey();
            List<Car> cars = entry.getValue();

            for (Car car : cars) {
                int carPrice = Integer.parseInt(car.price);

                if (carPrice < cheapestCarPrice) {
                    cheapestCarPrice = carPrice;
                    cheapestCarBrand = car.brand;
                    cheapestCarShowroom = showroom;
                }
            }
        }

        System.out.println("\n" + cheapestCarBrand + " in " + cheapestCarShowroom + " for " + cheapestCarPrice);
    }
}

