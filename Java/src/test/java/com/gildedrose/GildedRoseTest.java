package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void
    should_not_decrease_sell_in_of_sulfuras_items(){
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
    }

    @Test
    void
    should_not_decrease_quality_of_sulfuras_items(){
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].quality);
    }

}
