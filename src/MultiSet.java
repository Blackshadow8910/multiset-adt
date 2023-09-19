public interface MultiSet<T> {
    public boolean add(T value);
    public void remove(T value);
    public boolean contains(T value);
    public boolean isEmpty();
    public int count(T value);
    public int size();
}
