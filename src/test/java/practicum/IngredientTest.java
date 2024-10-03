package practicum;

import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    @Test
    public void testGetName_shouldReturnName() {
        String ingredientName = "tomato";
        float ingredientPrice = 15;
        IngredientType ingredientType = IngredientType.FILLING;
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);

        Assert.assertEquals(ingredientName, ingredient.getName());
    }

    @Test
    public void testGetPrice_shouldReturnPrice() {
        String ingredientName = "cabbage";
        float ingredientPrice = 10;
        IngredientType ingredientType = IngredientType.FILLING;
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);

        Assert.assertEquals(ingredientPrice, ingredient.getPrice(), 0);
    }

    @Test
    public void testGetType_shouldReturnType() {
        String ingredientName = "mayonnaise";
        float ingredientPrice = 17;
        IngredientType ingredientType = IngredientType.SAUCE;
        Ingredient ingredient = new Ingredient(ingredientType, ingredientName, ingredientPrice);

        Assert.assertEquals(ingredientType, ingredient.getType());
    }
}
