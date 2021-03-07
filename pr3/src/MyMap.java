import java.util.*;

public class MyMap<K, V> implements Map<K, V> {
    private ArrayList<K> keys;
    private ArrayList<V> values;

    public MyMap() {
        keys = new ArrayList<>();
        values = new ArrayList<>();
    }

    @Override
    synchronized public int size() {
        return keys.size();
    }

    @Override
    synchronized public boolean isEmpty() {
        return keys.isEmpty();
    }

    @Override
    synchronized public boolean containsKey(Object key) {
        return keys.contains(key);
    }

    @Override
    synchronized public boolean containsValue(Object value) {
        return values.contains(value);
    }

    @Override
    synchronized public V get(Object key) {
        return values.get(keys.indexOf(key));
    }

    @Override
    synchronized public V put(K key, V value) {
        if (containsKey(key)) {
            return value;
        }

        keys.add(key);
        values.add(value);
        return value;
    }

    @Override
    synchronized public V remove(Object key) {
        int index = keys.indexOf(key);
        keys.remove(index);
        return values.remove(index);
    }

    @Override
    synchronized public void putAll(Map<? extends K, ? extends V> m) {
        m.forEach(this::put);
    }

    @Override
    synchronized public void clear() {
        keys.clear();
        values.clear();
    }

    @Override
    synchronized public Set<K> keySet() {
        return new HashSet(keys);
    }

    @Override
    synchronized public Collection<V> values() {
        return values;
    }

    @Override
    synchronized public Set<Entry<K, V>> entrySet() {
        HashSet<Entry<K, V>> set = new HashSet<>();

        for (int i = 0; i < keys.size(); i++) {
            set.add(new MyEntry<>(keys.get(i), values.get(i)));
        }

        return set;
    }

    private static class MyEntry<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public MyEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            this.value = value;
            return value;
        }

        @Override
        public boolean equals(Object o) {
            return hashCode() == o.hashCode();
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }
    }
}
