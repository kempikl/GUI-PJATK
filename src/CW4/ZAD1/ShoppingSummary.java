package CW4.ZAD1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ShoppingSummary {
    public static void main(String[] args) {
        Map<String, List<Purchase>> shoppingData = new HashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(Path.of("src/CW4/ZAD1/purchases.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                String name = parts[0];
                String product = parts[1];
                int price = Integer.parseInt(parts[2]);

                shoppingData.computeIfAbsent(name, k -> new ArrayList<>()).add(new Purchase(product, price));
            }
        } catch (IOException e) {
            System.out.println("Błąd wczytywania pliku (" + e.getMessage() + ")");
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Path.of("summary.txt"))) {
            for (Map.Entry<String, List<Purchase>> entry : shoppingData.entrySet()) {
                String name = entry.getKey();
                List<Purchase> purchases = entry.getValue();

                int purchaseCount = purchases.size();
                int totalAmount = purchases.stream().mapToInt(Purchase::getPrice).sum();
                Set<String> uniqueProducts = new HashSet<>();
                for (Purchase purchase : purchases) {
                    uniqueProducts.add(purchase.getName());
                }
                int uniqueProductCount = uniqueProducts.size();

                writer.write(name + " " + purchaseCount + " " + uniqueProductCount + " " + totalAmount);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Błąd zapisu pliku (" + e.getMessage() + ")");
        }
    }
}
