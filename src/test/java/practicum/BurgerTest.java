package practicum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;

    @Test
    public void testSetBun_shouldSetBun() {
        Burger burger = new Burger();

        burger.setBuns(bun);

        Assert.assertEquals(bun, burger.getBun());
    }

    @Test
    public void testAddIngredient_shouldAddIngredient() {
        Burger burger = new Burger();

        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);

        burger.addIngredient(ingredient);

        Assert.assertEquals(1, burger.getIngredients().size());
        Assert.assertEquals(ingredient, burger.getIngredients().get(0));
    }

    @Test
    public void testRemoveIngredient_shouldRemoveIngredient() {
        Burger burger = new Burger();

        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);

        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        Assert.assertTrue(burger.getIngredients().isEmpty());
    }

    @Test
    public void testMoveIngredient_shouldMoveIngredient() {
        Burger burger = new Burger();

        Ingredient ingredient1 = new Ingredient(IngredientType.SAUCE, "hot sauce", 100);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "sour cream", 200);


        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.moveIngredient(0, 1);

        Assert.assertEquals(2, burger.getIngredients().size());
        Assert.assertEquals(ingredient2, burger.getIngredients().get(0));
        Assert.assertEquals(ingredient1, burger.getIngredients().get(1));
    }

    @Test
    public void testGetPrice_shouldGetPrice() {
        Mockito.when(bun.getPrice()).thenReturn(100f);

        Burger burger = new Burger();

        burger.setBuns(bun);

        Assert.assertEquals(200, burger.getPrice(), 0);
        Mockito.verify(bun, Mockito.times(1)).getPrice();
    }
}
