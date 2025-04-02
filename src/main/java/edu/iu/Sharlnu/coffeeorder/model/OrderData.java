package edu.iu.Sharlnu.coffeeorder.model;

import java.util.List;

public record OrderData(String beverage, List<String> condiments) {
}
