package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoldenMasterTest {
    private Item[] items;
    private GildedRose app;

    @BeforeEach
    void set_up(){
        items = new Item[] {
            new Item("+5 Dexterity Vest", 10, 20), //
            new Item("Aged Brie", 2, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6) };

        app = new GildedRose(items);

    }

    @Test void
    should_update_items_quality_day_1(){
        Item[] expectedItems = new Item[] {
            new Item("+5 Dexterity Vest", 9, 19), //
            new Item("Aged Brie", 1, 1), //
            new Item("Elixir of the Mongoose", 4, 6), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21),
            new Item("Backstage passes to a TAFKAL80ETC concert", 9, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 2, 5) };

        app.updateQuality();

        assertEquals(expectedItems.length, items.length);

        for(int i = 0; i < items.length; i++){
            assertEquals(expectedItems[i].toString(), items[i].toString());
        }
    }

    @Test void
    should_update_items_quality_day_2(){
        Item[] expectedItems = new Item[] {
            new Item("+5 Dexterity Vest", 8, 18), //
            new Item("Aged Brie", 0, 2), //
            new Item("Elixir of the Mongoose", 3, 5), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 13, 22),
            new Item("Backstage passes to a TAFKAL80ETC concert", 8, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 3, 50),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 1, 4) };

        app.updateQuality();
        app.updateQuality();

        assertEquals(expectedItems.length, items.length);

        for(int i = 0; i < items.length; i++){
            assertEquals(expectedItems[i].toString(), items[i].toString());
        }
    }

    @Test void
    should_update_items_quality_day_6(){
        Item[] expectedItems = new Item[] {
            new Item("+5 Dexterity Vest", 4, 14), //
            new Item("Aged Brie", -4, 10), //
            new Item("Elixir of the Mongoose", -1, 0), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 9, 27),
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", -3, 0) };

        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();
        app.updateQuality();

        assertEquals(expectedItems.length, items.length);

        for(int i = 0; i < items.length; i++){
            assertEquals(expectedItems[i].toString(), items[i].toString());
        }
    }

}
