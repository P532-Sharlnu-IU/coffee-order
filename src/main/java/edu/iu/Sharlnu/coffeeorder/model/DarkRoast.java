package edu.iu.Sharlnu.coffeeorder.model;

public class DarkRoast extends Beverage{

    @Override
    public String getDescription() {
        return "Dark roast";
    }
    @Override
    public float cost() {
        return 1.99F;
    }


}
