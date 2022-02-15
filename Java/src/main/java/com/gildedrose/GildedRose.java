package com.gildedrose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class GildedRose {
    Item[] items;
    List<String> specialItems = Arrays.asList(
            "Aged Brie",
            "Backstage passes to a TAFKAL80ETC concert"
    );
    int maxQuality = 50;
    int minQuality = 0;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if(isLegendary(item))
                continue;

            if (isRegularItem(item)){
                int decreaseBy = isExpired(item) ? 2 : 1;
                decreaseQualityFor(item, decreaseBy);
                decreaseSellInFor(item);
                continue;
            }

            decreaseSellInFor(item);

            if (isAgedBrie(item)){
                int increaseBy = isExpired(item) ? 2 : 1;
                increaseQualityFor(item, increaseBy);
            }

            if (isBackstagePass(item)) {
                int increaseBy = 1;

                if (item.sellIn <= 10) {
                    increaseBy++;
                }

                if (item.sellIn <= 5) {
                    increaseBy++;
                }

                increaseQualityFor(item, increaseBy);

                if (isExpired(item))
                    decreaseQualityFor(item, item.quality);

            }
        }
    }

    private boolean isRegularItem(Item item) {
        return !specialItems.contains(item.name);
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isExpired(Item item) {
        return item.sellIn <= 0;
    }

    private void increaseQualityFor(Item item, int increaseBy) {
        int total = item.quality + increaseBy;
        item.quality = total > maxQuality ? maxQuality : total;
    }

    private void decreaseQualityFor(Item item, int decreaseBy) {
        if (item.quality > minQuality) {
            item.quality = item.quality - decreaseBy;
        }
    }

    private void decreaseSellInFor(Item item) {
            item.sellIn = item.sellIn - 1;
    }

    private boolean isLegendary(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

}
