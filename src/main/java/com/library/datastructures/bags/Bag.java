package com.library.datastructures.bags;

import com.library.datastructures.hashtables.HashTableSeparateChaining;

import java.util.Iterator;
import java.util.function.Consumer;

public class Bag<T> implements BagADT<T> {

    private final HashTableSeparateChaining<T, Integer> items;

    public Bag() {
        items = new HashTableSeparateChaining<>();
    }

    @Override
    public int size() {
        return items.size();
    }

    @Override
    public void add(T item) {
        if (!items.hasKey(item)) {
            items.add(item, 1);
        } else {
            int multiplicity = items.get(item);
            items.add(item, ++multiplicity);
        }
    }

    @Override
    public void remove(T item) {
        if (items.hasKey(item)) {
            int multiplicity = items.get(item);
            if (multiplicity == 0) {
                items.remove(item);
            } else {
                items.add(item, --multiplicity);
            }
        }
    }

    @Override
    public boolean has(T item) {
        return items.hasKey(item);
    }

    @Override
    public BagADT<T> union(BagADT<T> right) {
        BagADT<T> newBag = new Bag<>();
        for (T item : this) {
            int multiplicity = multiplicity(item);
            if (right.has(item)) {
                multiplicity = Math.max(multiplicity, right.multiplicity(item));
            }
            for (int i = 0; i < multiplicity; i++) {
                newBag.add(item);
            }
        }
        for (T item : right) {
            if (!newBag.has(item)) {
                int multiplicity = right.multiplicity(item);
                for (int i = 0; i < multiplicity; i++) {
                    newBag.add(item);
                }
            }
        }
        return newBag;
    }

    @Override
    public BagADT<T> intersection(BagADT<T> right) {
        BagADT<T> newBag = new Bag<>();
        BagADT<T> smaller, bigger;

        if (right.size() < this.size()) {
            smaller = right;
            bigger = this;
        } else {
            smaller = this;
            bigger = right;
        }

        for (T item : smaller) {
            if (bigger.has(item)) {
                int multiplicity = Math.min(
                    smaller.multiplicity(item),
                    right.multiplicity(item)
                );
                for (int i = 0; i < multiplicity; i++) {
                    newBag.add(item);
                }
            }
        }

        return newBag;
    }

    @Override
    public BagADT<T> difference(BagADT<T> right) {
        BagADT<T> newBag = this.copy();
        for (T item : right) {
            if (newBag.has(item)) {

                int multiplicityLeft = newBag.multiplicity(item);
                int multiplicityRight = right.multiplicity(item);

                int removeTimes = multiplicityRight;
                if (multiplicityLeft <= multiplicityRight) {
                    removeTimes = multiplicityLeft;
                }

                for (int i = 0; i < removeTimes; i++) {
                    newBag.remove(item);
                }
            }
        }
        return newBag;
    }

    private BagADT<T> copy() {
        BagADT<T> newBag = new Bag<>();
        for (T item : this) {
            int multiplicity = this.multiplicity(item);
            for (int i = 0; i < multiplicity; i++) {
                newBag.add(item);
            }
        }
        return newBag;
    }

    @Override
    public int multiplicity(T item) {
        return items.hasKey(item) ? items.get(item) : 0;
    }

    @Override
    public String toString() {
        return "Bag ["
            + ", " + items +
            "]";
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> iterator = items.iterator();
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return iterator.hasNext();
            }

            @Override
            public T next() {
                return iterator.next();
            }

            @Override
            public void remove() {
                iterator.remove();
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        for (T t : this) {
            action.accept(t);
        }
    }
}
