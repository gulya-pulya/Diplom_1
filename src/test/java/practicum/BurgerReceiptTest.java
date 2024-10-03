package practicum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import java.util.List;

@RunWith(Parameterized.class)
public class BurgerReceiptTest {

    private final Bun bun;
    private final List<Ingredient> ingredients;
    private final String expectedString;

    public BurgerReceiptTest(Bun bun, List<Ingredient> ingredients, String expectedString) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expectedString = expectedString;
    }


    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][] {
                { new Bun("black bun", 20), List.of(new Ingredient(IngredientType.SAUCE, "ketchup", 100)), "(==== black bun ====)\n= sauce ketchup =\n(==== black bun ====)\n" + String.format("%nPrice: %f%n", 140f)},
                { new Bun("black bun", 20), List.of(new Ingredient(IngredientType.SAUCE, "ketchup", 100), new Ingredient(IngredientType.FILLING, "tomato", 200)), "(==== black bun ====)\n= sauce ketchup =\n= filling tomato =\n(==== black bun ====)\n" + String.format("%nPrice: %f%n", 340f)},
        };
    }

    @Test
    public void testGetReceipt_shouldReturnRecipe() {
        Burger burger = new Burger();

        burger.setBuns(bun);

        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }

        Assert.assertEquals(expectedString, burger.getReceipt());
    }
}
