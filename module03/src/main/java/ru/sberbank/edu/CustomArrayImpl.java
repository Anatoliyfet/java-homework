package ru.sberbank.edu;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomArrayImpl<T> implements CustomArray{
    private int size;
    /**
     * @return
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * @return
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add single item.
     *
     * @param item
     */
    @Override
    public boolean add(Object item) {
        return false;
    }

    /**
     * Add all items.
     *
     * @param items
     * @throws IllegalArgumentException if parameter items is null
     */
    @Override
    public boolean addAll(Object[] items) {
        return false;
    }

    /**
     * Add all items.
     *
     * @param items
     * @throws IllegalArgumentException if parameter items is null
     */
    @Override
    public boolean addAll(Collection items) {
        return false;
    }

    /**
     * Add items to current place in array.
     *
     * @param index - index
     * @param items - items for insert
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     * @throws IllegalArgumentException       if parameter items is null
     */
    @Override
    public boolean addAll(int index, Object[] items) {
        return false;
    }

    /**
     * Get item by index.
     *
     * @param index - index
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    @Override
    public Object get(int index) {
        return null;
    }

    /**
     * Set item by index.
     *
     * @param index - index
     * @param item
     * @return old value
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    @Override
    public Object set(int index, Object item) {
        return null;
    }

    /**
     * Remove item by index.
     *
     * @param index - index
     * @throws ArrayIndexOutOfBoundsException if index is out of bounds
     */
    @Override
    public void remove(int index) throws ArrayIndexOutOfBoundsException {

    }

    /**
     * Remove item by value. Remove first item occurrence.
     *
     * @param item - item
     * @return true if item was removed
     */
    @Override
    public boolean remove(Object item) {
        return false;
    }

    /**
     * Checks if item exists.
     *
     * @param item - item
     * @return true or false
     */
    @Override
    public boolean contains(Object item) {
        return false;
    }

    /**
     * Index of item.
     *
     * @param item - item
     * @return index of element or -1 of list doesn't contain element
     */
    @Override
    public int indexOf(Object item) {
        return 0;
    }

    /**
     * Grow current capacity to store new elements if needed.
     *
     * @param newElementsCount - new elements count
     */
    @Override
    public void ensureCapacity(int newElementsCount) {

    }

    /**
     * Get current capacity.
     */
    @Override
    public int getCapacity() {
        return 0;
    }

    /**
     * Reverse list.
     */
    @Override
    public void reverse() {

    }

    /**
     * Get copy of current array.
     */
    @Override
    public Object[] toArray() {
        return new Object[0];
    }
}
