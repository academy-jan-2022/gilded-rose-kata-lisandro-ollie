package com.gildedrose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class GildedRose {
    Item[] items;
    List<String> specialItems = Arrays.asList(
            "Aged Brie",
            "Sulfuras, Hand of Ragnaros",
            "Backstage passes to a TAFKAL80ETC concert"
    );
    int maxQuality = 50;
    int minQuality = 0;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (!specialItems.contains(item.name)){
                decreaseQualityFor(item);
                decreaseSellInFor(item);
                continue;
            }


            increaseQualityFor(item);

            if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {

                if (item.sellIn < 11) {
                    increaseQualityFor(item);
                }

                if (item.sellIn < 6) {
                    increaseQualityFor(item);
                }
            }

            decreaseSellInFor(item);


            if (isExpired(item)) {

                if (item.name.equals("Aged Brie")) {
                    increaseQualityFor(item);
                }

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    item.quality = minQuality;
                }
            }
        }
    }

    private boolean isExpired(Item item) {
        return item.sellIn < 0;
    }

    private void increaseQualityFor(Item item) {
        if (item.quality < maxQuality) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQualityFor(Item item) {
        if (item.quality > minQuality && !specialItems.contains(item.name)) {
            int decreaseBy = isExpired(item) ? 2 : 1;
            item.quality = item.quality - decreaseBy;
        }
    }

    private void decreaseSellInFor(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros"))
            item.sellIn = item.sellIn - 1;
    }
}
