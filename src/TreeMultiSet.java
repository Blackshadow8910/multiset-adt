public class TreeMultiSet<T> implements MultiSet<T> {
    private Tree<T> tree = new Tree<>();

    @Override
    public boolean add(T value) {
        tree.insert(value);
        return true;
    }

    @Override
    public void remove(T value) {
        tree.deleteItem(value);
    }

    @Override
    public boolean contains(T value) {
        return tree.contains(value);
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public int count(T value) {
        return tree.count(value);
    }

    @Override
    public int size() {
        return tree.size();
    }
}
