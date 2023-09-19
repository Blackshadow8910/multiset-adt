import java.util.ArrayList;

public class ArrayListMultiSet<T> implements MultiSet<T> {
    private ArrayList<T> list = new ArrayList<>();

    @Override
    public boolean add(T value) {
        list.add(value);
        return true;
    }

    @Override
    public void remove(T value) {
        list.remove(value);
    }

    @Override
    public boolean contains(T value) {
        return list.contains(value);
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int count(T value) {
        int n = 0;
        for (T i : list) {
            if (i == value) {
                n++;
            }
        }
        return n;
    }

    @Override
    public int size() {
        return list.size();
    }
}
