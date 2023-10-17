package seedu.duke.data.dish;

import java.util.ArrayList;

public class Dish {
    private String name;
    private ArrayList<Ingredient> ingredients;
    private float price;

    public Dish(String name, ArrayList<Ingredient> ingredients, float price) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }
    public Dish(String name, float price) {
        this.name = name;
        this.ingredients = null;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float newPrice) {
        this.price = newPrice;
    }

    public String toString() {
        return this.name + " $" + this.price;
    }
}
