package 算法书例子.第三章;


import java.util.Iterator;

public class MyArrayList1<AnyType> implements Iterable<AnyType> {
    private static final int DEFAULT_CAPACITY = 10;
    private int theSize;
    private AnyType[] theItems;

    public MyArrayList1() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        theSize = 0;
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < DEFAULT_CAPACITY)
            return;
        AnyType[] oldItems = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++)
            theItems[i] = oldItems[i];
    }


    public AnyType get(int idx) {
        if (idx > size() || idx < 0)
            throw new ArrayIndexOutOfBoundsException();
        return theItems[idx];
    }

    public void set(int idx, AnyType newVal) {
        if (idx < 0 || idx > size())
            throw new ArrayIndexOutOfBoundsException();
        theItems[idx] = newVal;
    }

    public void add(AnyType x) {
        add(size(), x);
    }

    public void add(int idx, AnyType x) {
        if (theItems.length == idx)
            ensureCapacity(size() * 2 + 1);
        for (int i = size(); i > idx; i--)
            theItems[i + 1] = theItems[i];
        theItems[idx] = x;
        theSize++;
    }


    public void remove(int idx) {
        if (size() > idx)
            throw new ArrayIndexOutOfBoundsException();
        for (int i = idx; i < size() + 1; i++)
            theItems[i] = theItems[i + 1];
        theSize--;
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }


    public Iterator<AnyType> iterator() {
        return new ArrayListIterator<AnyType>();
    }

    private class ArrayListIterator<Anytype> implements Iterator<AnyType> {
        private int current = 0;

        @Override

        public boolean hasNext() {
            return current < size();
        }

        @Override
        public AnyType next() {
            if (!hasNext())
                throw new ArrayIndexOutOfBoundsException();
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList1.this.remove(--current);
        }
    }
}
