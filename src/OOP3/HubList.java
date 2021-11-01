package OOP3;

import java.util.ArrayList;
import java.util.Comparator;

interface HubListImpl<E> {
    void add(E element);
    E removeAt(int index);
    void sort(Comparator<? super E> c);
    int find(E element);
}

public class HubList<E> implements HubListImpl<E> {
    private ArrayList<E> _list = new ArrayList<>();

    @Override
    public void add(E element) {
        _list.add(element);
    }

    @Override
    public E removeAt(int index) {
        return _list.remove(index);
    }

    @Override
    public void sort(Comparator<? super E> c) {
        _list.sort(c);
    }

    @Override
    public int find(E element) {
        for (int i = 0; i < _list.size(); i++){
            if (_list.get(i) == element){
                return i;
            }
        }
        return -1;
    }

    public String toString() {
        return _list.toString();
    }
}