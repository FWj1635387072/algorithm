package 算法书例子.第三章.单链表;

public interface MyList<Anytype>{
    Anytype get(int idx);

    Anytype set(int idx, Anytype newVal);

    void add(int idx, Anytype x);

    void remove(int idx);

    int size();

    boolean isEmpty();

    boolean contains(Object element);
}
