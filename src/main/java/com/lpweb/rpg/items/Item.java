package com.lpweb.rpg.items;

/**
 * Item that can be sold in the store.
 */
public abstract class Item implements Comparable<Item>
{
    /**
     * Price in store of the item.
     */
    protected int price;

    public Item(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public int compareTo(Item item) {
        return this.price - item.price;
    }
}