package 算法书例子.第三章.单链表;

import com.sun.xml.internal.bind.AnyTypeAdapter;
import org.junit.Test;
import org.w3c.dom.ls.LSException;
import 算法书例子.第三章.MyArrayList;

import java.util.Objects;

public class SingleList<AnyType> implements MyList {
    private static class Node<Anytype> {
        public Node(Anytype data, Node<Anytype> prev, Node<Anytype> next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        private Anytype data;
        private Node<Anytype> prev;
        private Node<Anytype> next;
    }

    public SingleList() {
        doClear();
    }

    public void clear() {
        doClear();
    }

    private void doClear() {
        beginMaker = new Node<>(null, null, null);
        endMaker = new Node<>(null, beginMaker, null);
        beginMaker.next = endMaker;
        theSize = 0;
    }


    @Override
    public Object get(int idx) {
        if (idx < 0 || idx > size())
            return null;
        Node<AnyType> temp = beginMaker;
        for (int i = 0; i < idx; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    @Override
    public Object set(int idx, Object newVal) {
        if (idx < 0 || idx > size())
            throw new IndexOutOfBoundsException();
        Node<AnyType> temp = beginMaker;
        for (int i = 0; i < idx; i++) {
            temp = temp.next;
        }
        AnyType a = temp.data;
        temp.data = (AnyType) newVal;
        return a;
    }

    @Test
    public void test1() {
        SingleList<Integer> mylist = new SingleList<>();
        mylist.add(0);
        mylist.add(1);
        mylist.add(2);
    }

    @Override
    public void add(int idx, Object x) {
        if (idx < 0 || idx > size())
            throw new IndexOutOfBoundsException();
        Node<AnyType> last = endMaker.prev;
    }

    public void add(AnyType x) {
        add(size(), x);
    }

    @Override
    public void remove(int idx) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object element) {
        return false;
    }

    private int theSize = 0;
    private Node<AnyType> beginMaker;
    private Node<AnyType> endMaker;
}
