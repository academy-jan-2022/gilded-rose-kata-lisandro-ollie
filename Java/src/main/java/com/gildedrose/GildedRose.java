package com.gildedrose;

import java.util.Objects;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            if (Objects.equals(item.name, "Aged Brie")
                || Objects.equals(item.name, "Backstage passes to a TAFKAL80ETC concert")) {

                increaseQualityFor(item);

                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    if (item.sellIn < 11) {
                        increaseQualityFor(item);
                    }

                    if (item.sellIn < 6) {
                        increaseQualityFor(item);
                    }
                }
            } else {
                decreaseQualityFor(item);
            }
            decreaseSellInFor(item);

            if (item.sellIn < 0) {
                if (item.name.equals("Aged Brie")) {
                    increaseQualityFor(item);
                } else {
                    if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        item.quality = 0;
                    } else {
                        decreaseQualityFor(item);
                    }
                }
            }
        }
    }

    private void increaseQualityFor(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQualityFor(Item item) {
        if (item.quality > 0 && !item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.quality = item.quality - 1;
        }
    }

    private void decreaseSellInFor(Item item) {
        if (!item.name.equals("Sulfuras, Hand of Ragnaros"))
            item.sellIn = item.sellIn - 1;
    }
}
