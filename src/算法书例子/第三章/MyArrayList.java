package 算法书例子.第三章;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyArrayList<AnyType> implements Iterable<AnyType> {

    private static final int DEFAULT_CAPACITY = 10;//定义容量
    private int theSize;                            //ArrayList大小
    private AnyType[] theItems;                     //ArrayList存储位置

    public MyArrayList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    /**
     * 初始化
     */
    private void doClear() {
        theSize = 0;
        ensureCapacity(DEFAULT_CAPACITY);
    }

    public int size() {
        return theSize;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void trimToSize() {
        ensureCapacity(size());
    }

    /**
     * 获取idx位置上的元素
     *
     * @param idx
     * @return
     */
    public AnyType get(int idx) {
        //判断idx是否合法
        if (idx < 0 || idx >= size())
            throw new ArrayIndexOutOfBoundsException();
        return theItems[idx];
    }

    /**
     * 修改idx位置上的元素
     *
     * @param idx
     * @param newVal
     * @return
     */
    public AnyType set(int idx, AnyType newVal) {
        if (idx < 0 || idx >= size())
            throw new ArrayIndexOutOfBoundsException();
        AnyType old = theItems[idx];
        theItems[idx] = newVal;
        return old;
    }

    /**
     * 确保ArrayList大小合适，扩容
     *
     * @param newCapacity
     */
    private void ensureCapacity(int newCapacity) {
        if (newCapacity < theSize)
            return;
        AnyType[] old = theItems;
        theItems = (AnyType[]) new Object[newCapacity];
        for (int i = 0; i < size(); i++)
            theItems[i] = old[i];
    }

    /**
     * 在ArrayList末尾添加
     *
     * @param x
     * @return
     */
    public boolean add(AnyType x) {
        add(size(), x);
        return true;
    }

    /**
     * 在idx后添加元素
     *
     * @param idx
     * @param x
     */
    public void add(int idx, AnyType x) {
        if (theItems.length == size())
            ensureCapacity(size() * 2 + 1);
        for (int i = theSize; i > idx; i--)
            theItems[i] = theItems[i - 1];
        theItems[idx] = x;
        theSize++;
    }

    /**
     * 移除idx上的元素
     *
     * @param idx
     * @return
     */
    public AnyType remove(int idx) {
        AnyType removeItem = theItems[idx];
        for (int i = idx; i < size() - 1; i++)
            theItems[i] = theItems[i + 1];
        theSize--;
        return removeItem;
    }

    @Override
    public Iterator<AnyType> iterator() {
        return new ArrayListIterator();
    }

    /**
     * 内部类，迭代器
     * 使用内部类，免去了在外部新建迭代器导致引用混乱
     */
    private class ArrayListIterator implements Iterator<AnyType> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size();
        }

        @Override
        public AnyType next() {
            if (!hasNext())
                throw new NoSuchElementException();
            return theItems[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(--current);
        }
    }

    @Test
    public void test() {
        MyArrayList<Integer> myList = new MyArrayList<>();

        myList.add(10);
        System.out.println(myList.get(0));

        myList.remove(0);

        System.out.println(myList.isEmpty());

        myList.add(20);
        for (Integer i : myList) {
            System.out.println(i);
        }

        System.out.println("--------");
        myList.add(12);
        Iterator i = myList.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    @Test
    public void test1() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        myArrayList.add(10);
        myArrayList.add(11);
        myArrayList.add(12);
        myArrayList.add(13);
        myArrayList.remove(2);

        Iterator i = myArrayList.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
