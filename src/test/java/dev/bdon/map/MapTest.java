package dev.bdon.map;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Iterator;

import static dev.bdon.TestUtils.assertEmpty;

public class MapTest {

    private <K, V> Map<K, V> createMap() {
        return new TestMap<>(new HashMap<>());
    }

    @Test
    void should_put_and_get_entries() {
        Map<String, Integer> map = createMap();
        assertEmpty(map);

        map.put("Alpha", 1);
        assert map.size() == 1;
        assert map.get("Alpha") == 1;

        map.put("Beta", 2);
        assert map.size() == 2;
        assert map.get("Alpha") == 1;
        assert map.get("Beta") == 2;

        map.put("Charlie", 3);
        assert map.size() == 3;
        assert map.get("Alpha") == 1;
        assert map.get("Beta") == 2;
        assert map.get("Charlie") == 3;

        map.put("Alpha", 11);
        assert map.size() == 3;
        assert map.get("Alpha") == 11;
        assert map.get("Beta") == 2;
        assert map.get("Charlie") == 3;

        map.put("Delta", 4);
        assert map.size() == 4;
        assert map.get("Alpha") == 11;
        assert map.get("Beta") == 2;
        assert map.get("Charlie") == 3;
        assert map.get("Delta") == 4;

        map.put("Delta", 44);
        assert map.size() == 4;
        assert map.get("Alpha") == 11;
        assert map.get("Beta") == 2;
        assert map.get("Charlie") == 3;
        assert map.get("Delta") == 44;

        map.put("Beta", 22);
        assert map.size() == 4;
        assert map.get("Alpha") == 11;
        assert map.get("Beta") == 22;
        assert map.get("Charlie") == 3;
        assert map.get("Delta") == 44;
    }

    @Test
    void should_return_if_map_contains_keys() {
        Map<String, Integer> map = createMap();
        assertEmpty(map);

        assert !map.containsKey("Alpha");
        assert !map.containsKey("Beta");
        assert !map.containsKey("Charlie");
        assert !map.containsKey("Delta");

        map.put("Alpha", 1);
        assert map.containsKey("Alpha");

        map.put("Beta", 2);
        assert map.containsKey("Alpha");
        assert map.containsKey("Beta");

        map.put("Charlie", 3);
        assert map.containsKey("Alpha");
        assert map.containsKey("Beta");
        assert map.containsKey("Charlie");

        map.put("Delta", 4);
        assert map.containsKey("Alpha");
        assert map.containsKey("Beta");
        assert map.containsKey("Charlie");
        assert map.containsKey("Delta");
    }

    @Test
    void should_return_if_map_contains_values() {
        Map<String, Integer> map = createMap();
        assertEmpty(map);

        assert !map.containsValue(1);
        assert !map.containsValue(2);
        assert !map.containsValue(3);
        assert !map.containsValue(4);

        map.put("Alpha", 1);
        assert map.containsValue(1);

        map.put("Beta", 2);
        assert map.containsValue(1);
        assert map.containsValue(2);

        map.put("Charlie", 3);
        assert map.containsValue(1);
        assert map.containsValue(2);
        assert map.containsValue(3);

        map.put("Delta", 4);
        assert map.containsValue(1);
        assert map.containsValue(2);
        assert map.containsValue(3);
        assert map.containsValue(4);
    }

    @Test
    void should_return_if_map_contains_entries() {
        Map<String, Integer> map = createMap();
        assertEmpty(map);

        assert !map.containsEntry("Alpha", 1);
        assert !map.containsEntry("Beta", 2);
        assert !map.containsEntry("Charlie", 3);
        assert !map.containsEntry("Delta", 4);

        map.put("Alpha", 1);
        assert map.containsEntry("Alpha", 1);
        assert !map.containsEntry("Alpha", 1234);

        map.put("Beta", 2);
        assert map.containsEntry("Alpha", 1);
        assert map.containsEntry("Beta", 2);
        assert !map.containsEntry("Beta", 2314);

        map.put("Charlie", 3);
        assert map.containsEntry("Alpha", 1);
        assert map.containsEntry("Beta", 2);
        assert map.containsEntry("Charlie", 3);
        assert !map.containsEntry("Charlie", 2315);

        map.put("Delta", 4);
        assert map.containsEntry("Alpha", 1);
        assert map.containsEntry("Beta", 2);
        assert map.containsEntry("Charlie", 3);
        assert map.containsEntry("Delta", 4);
        assert !map.containsEntry("Delta", 2353);
    }

    @Test
    void should_remove_entries_from_map_by_key_one_by_one() {
        Map<String, Integer> map = createMap();
        assertEmpty(map);

        map.put("Alpha", 1);
        map.put("Beta", 2);
        map.put("Beta", 22);
        map.put("Charlie", 3);
        map.put("Alpha", 11);
        map.put("Delta", 4);
        map.put("Delta", 44);
        map.put("Charlie", 33);

        assert map.size() == 4;
        assert map.containsEntry("Alpha", 11);
        assert map.containsEntry("Beta", 22);
        assert map.containsEntry("Charlie", 33);
        assert map.containsEntry("Delta", 44);

        map.remove("Beta");
        assert map.size() == 3;
        assert map.containsEntry("Alpha", 11);
        assert !map.containsEntry("Beta", 22);
        assert map.containsEntry("Charlie", 33);
        assert map.containsEntry("Delta", 44);

        map.remove("Delta");
        assert map.size() == 2;
        assert map.containsEntry("Alpha", 11);
        assert !map.containsEntry("Beta", 22);
        assert map.containsEntry("Charlie", 33);
        assert !map.containsEntry("Delta", 44);

        map.remove("Charlie");
        assert map.size() == 1;
        assert map.containsEntry("Alpha", 11);
        assert !map.containsEntry("Beta", 22);
        assert !map.containsEntry("Charlie", 33);
        assert !map.containsEntry("Delta", 44);

        map.remove("Alpha");
        assertEmpty(map);
        assert !map.containsEntry("Alpha", 11);
        assert !map.containsEntry("Beta", 22);
        assert !map.containsEntry("Charlie", 33);
        assert !map.containsEntry("Delta", 44);
    }

    private static class TestMap<K, V> implements Map<K, V> {

        private final java.util.Map<K, V> delegate;

        public TestMap(java.util.Map<K, V> map) {
            this.delegate = map;
        }

        @Override
        public void put(K key, V value) {
            delegate.put(key, value);
        }

        @Override
        public V get(K key) {
            return delegate.get(key);
        }

        @Override
        public int size() {
            return delegate.size();
        }

        @Override
        public boolean isEmpty() {
            return delegate.isEmpty();
        }

        @Override
        public boolean containsKey(K key) {
            return delegate.containsKey(key);
        }

        @Override
        public boolean containsValue(V value) {
            return delegate.containsValue(value);
        }

        @Override
        public boolean containsEntry(K key, V value) {
            return delegate.entrySet().stream()
                    .anyMatch(e -> key.equals(e.getKey()) && value.equals(e.getValue()));
        }

        @Override
        public Iterator<Entry<K, V>> iterator() {
            return delegate.entrySet().stream()
                    .map(e -> new Entry<>(e.getKey(), e.getValue()))
                    .toList()
                    .iterator();
        }

        @Override
        public boolean remove(K key) {
            return delegate.remove(key) != null;
        }

        @Override
        public boolean remove(K key, V value) {
            return delegate.remove(key, value);
        }
    }
}
