package practicum;

import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void testGetName_shouldReturnName() {
        String bunName = "bun with sesame";
        float bunPrice = 50;
        Bun bun = new Bun(bunName, bunPrice);

        Assert.assertEquals(bunName, bun.getName());
    }

    @Test
    public void testGetPrice_shouldReturnPrice() {
        String bunName = "bun with sesame";
        float bunPrice = 50;
        Bun bun = new Bun(bunName, bunPrice);

        Assert.assertEquals(bunPrice, bun.getPrice(), 0);
    }
}
