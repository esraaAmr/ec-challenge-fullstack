package services;

import domain.interfaces.Shippable;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ShippingService {

    public static void ship(List<Shippable> items) {
        System.out.println("** Shipment Notice **");

        double totalWeight = 0.0;
        Map<String, Integer> countMap = new LinkedHashMap<>();
        Map<String, Double> weightMap = new HashMap<>();

        for (Shippable item : items) {
            String name = item.getName();
            double weight = item.getWeight();
            countMap.put(name, countMap.getOrDefault(name, 0) + 1);
            weightMap.putIfAbsent(name, weight);
            totalWeight += weight;
        }

        countMap.forEach((name, count) -> {
            double weightInGrams = weightMap.get(name) * count * 1000;
            System.out.printf("%dx %s\t%.0f g%n", count, name, weightInGrams);
        });

        System.out.printf("Total package weight %.1f kg%n", totalWeight);
    }

}
