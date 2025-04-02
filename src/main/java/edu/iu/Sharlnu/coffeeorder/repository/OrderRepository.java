package edu.iu.Sharlnu.coffeeorder.repository;
import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.ArrayList;

import edu.iu.Sharlnu.coffeeorder.model.*;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {
    public OrderRepository(){
        File databaseFile = new File("coffee/db.txt");
        if (!databaseFile.exists()) {
            try {
                databaseFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace(); // Handle the exception properly
            }
        }
    }

    private static final String NEW_LINE = System.lineSeparator();
    private static final String DATABASE_NAME = "coffee/db.txt";

    public List<Receipt> findAll() throws IOException {
        List<Receipt> result = new ArrayList<>();
        Path path = Paths.get(DATABASE_NAME);
        List<String> data = Files.readAllLines(path);
        for (String line : data) {
            if(!line.trim().isEmpty()) {
                Receipt r = Receipt.fromLine(line);
                result.add(r);
            }
        }

        return result;
    }

    private static void appendToFile(Path path, String content)
            throws IOException {
        Files.write(path,
                content.getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    private AtomicInteger orderID = new AtomicInteger();

    public Receipt add(OrderData order) throws Exception {
        List<Receipt> rec = findAll();
        int id = orderID.incrementAndGet();
        Beverage beverage = null;
        switch (order.beverage().toLowerCase()) {
            case "dark roast":
                beverage = new DarkRoast();
                break;
            case "house blend":
                beverage = new HouseBlend();
                break;
            case "espresso":
                beverage = new Espresso();
                break;
            case "decaf":
                beverage = new Decaf();
                break;
        }
        if (beverage == null) {
            throw new Exception("Beverage type '%s' is not valid!".formatted(order.beverage()));
        }
        for(String condiment : order.condiments()) {
            switch (condiment.toLowerCase()) {
                case "milk":
                   beverage = new Milk(beverage);
                   break;
                case "mocha":
                    beverage = new Mocha(beverage);
                    break;
                case "soy":
                    beverage = new Soy(beverage);
                    break;
                case "whip":
                    beverage = new Whip(beverage);
                    break;
                default:
                    throw new Exception("Condiment type '%s' is not valid".formatted(condiment));
            }
        }
        Receipt receipt = new Receipt(id, beverage.getDescription(), beverage.cost());
        Path path = Paths.get(DATABASE_NAME);
        String receiptLine = receipt.toLine();
        appendToFile(path, receiptLine + NEW_LINE);
        return receipt;
    }
}
