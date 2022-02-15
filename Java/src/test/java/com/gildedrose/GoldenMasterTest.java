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
            new Item("Aged Brie", -1, 0), //
            new Item("Elixir of the Mongoose", 5, 7), //
            new Item("Super random item", -1, 7), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, 48),
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, 45),
            new Item("Backstage passes to a TAFKAL80ETC concert", 0, 48),
            new Item("Super random item", -2, 0),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 3, 6) };


        app = new GildedRose(items);

    }

    @Test void
    should_update_items_quality_day_1(){
        Item[] expectedItems = new Item[] {
            new Item("+5 Dexterity Vest", 9, 19), //
            new Item("Aged Brie", 1, 1), //
            new Item("Aged Brie", -2, 2), //
            new Item("Elixir of the Mongoose", 4, 6), //
            new Item("Super random item", -2, 5), //
            new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 14, 21),
            new Item("Backstage passes to a TAFKAL80ETC concert", 9, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 4, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 3, 50),
            new Item("Backstage passes to a TAFKAL80ETC concert", 3, 48),
            new Item("Backstage passes to a TAFKAL80ETC concert", -1, 0),
            new Item("Super random item", -3, 0),
            // this conjured item does not work properly yet
            new Item("Conjured Mana Cake", 2, 5) };

        app.updateQuality();

        assertEquals(expectedItems.length, app.items.length);

        for(int i = 0; i < app.items.length; i++){
            assertEquals(expectedItems[i].toString(), app.items[i].toString());
        }
    }

}
