package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {


    @Test
    void foo() {
        Item item = new Item("foo", 0, 0);
        GildedRose app = setUpGildedRose(item);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    void
    should_not_decrease_sell_in_of_sulfuras_items(){
        Item sulfurasItem = new Item("Sulfuras, Hand of Ragnaros", 10, 10);
        GildedRose app = setUpGildedRose(sulfurasItem);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
    }

    @Test
    void
    should_not_decrease_quality_of_sulfuras_items(){
        Item sulfurasItem = new Item("Sulfuras, Hand of Ragnaros", 10, 10);
        GildedRose app = setUpGildedRose(sulfurasItem);
        app.updateQuality();
        assertEquals(10, app.items[0].quality);
    }

    @Test
    void
    Should_increase_quality_of_aged_brie_if_less_than_50(){

    }

    private GildedRose setUpGildedRose(Item item){
        return setUpGildedRose(new Item[]{item});
    }
    private GildedRose setUpGildedRose(Item[] items){
        return new GildedRose(items);
    }

}
