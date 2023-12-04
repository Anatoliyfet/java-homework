package ru.sberbank.edu;

import jdk.internal.util.ArraysSupport;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class CustomArrayImpl<E> implements CustomArray {
    private int size;

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    protected transient int modCount = 0;

    transient Object[] elementData;

    @Override
    public String toString() {
        return "CustomArrayImpl{" +
                "size=" + size +
                ", modCount=" + modCount +
                ", elementData=" + Arrays.toString(elementData) +
                '}';
    }

    public CustomArrayImpl() {

        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;

    }

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
        modCount++;
        add(item, elementData, size);
        return true;
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
    public void remove(int index) {

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

    /**
     * This helper method split out from add(E) to keep method
     * bytecode size under 35 (the -XX:MaxInlineSize default value),
     * which helps when add(E) is called in a C1-compiled loop.
     */
    private void add(Object e, Object[] elementData, int s) {
        if (s == elementData.length)
            elementData = grow(size + 1);
        elementData[s] = e;
        size = s + 1;
    }

    private Object[] grow() {
        return grow(size + 1);
    }

    /**
     * Increases the capacity to ensure that it can hold at least the
     * number of elements specified by the minimum capacity argument.
     *
     * @param minCapacity the desired minimum capacity
     * @throws OutOfMemoryError if minCapacity is less than zero
     */
    private Object[] grow(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity > 0 || elementData != DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            int newCapacity = ArraysSupport.newLength(oldCapacity,
                    minCapacity - oldCapacity, /* minimum growth */
                    oldCapacity >> 1           /* preferred growth */);
            return elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            return elementData = new Object[Math.max(DEFAULT_CAPACITY, minCapacity)];
        }
    }

}
