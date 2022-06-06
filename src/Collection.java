import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

interface MyArrayList<E> {
    void add(E e);
    void remove(E e);
    E get(int index);
    void set(int index, E e);
    int size();
}

class Collection<T> implements MyArrayList<T> {
    private List<T> list;

    Collection() {
        list = new ArrayList<T>();
    }

    @Override
    public void add(T t) {
        list.add(t);
    }

    @Override
    public void remove(T t) {
        list.remove(t);
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public void set(int index, T t) {
        list.set(index, t);
    }

    @Override
    public int size() {
        return list.size();
    }
}

interface MyHashTable<K, V> {
    V get(K key);
    void put(K key, V value);
    void remove(K key);
    boolean containsKey(K key);
    int size();
}

class HashTable<K, V> implements MyHashTable<K, V> {
    private HashMap<K, V> list;

    HashTable() {
        list = new HashMap<K, V>();
    }

    @Override
    public V get(K key) {
        return list.get(key);
    }

    @Override
    public void put(K key, V value) {
        list.put(key, value);
    }

    @Override
    public void remove(K key) {
        list.remove(key);
    }

    @Override
    public boolean containsKey(K key) {
        return list.containsKey(key);
    }

    @Override
    public int size() {
        return list.size();
    }
}