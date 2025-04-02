package edu.iu.Sharlnu.coffeeorder.model;

public record Receipt(int id,String description, float cost) {

    public String toLine() {
        return String.format("%d,%.2f,%s", id(), cost, description);
    }

    public String toLine(int id) {
        return String.format("%d,%.2f,%s", id, cost, description);
    }

    public static Receipt fromLine(String line) {
        String[] tokens = line.split(",");
        return new Receipt(Integer.parseInt(tokens[0]), tokens[2], Float.parseFloat(tokens[1]));
    }

}
