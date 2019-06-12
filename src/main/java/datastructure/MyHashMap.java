package datastructure;

public class MyHashMap<K,V> {
    // Create Entry class

    private class Entry<K,V> {
        private K key;
        private V value;
        private Entry<K,V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Create array with capacity
    // Create size

    private static int INITIAL_CABACITY = 1 << 4;  // 16
//    private int capacity;  // 16
    private int size = 0;
    private Entry<K,V>[] bucket;


    public MyHashMap() {
        this(INITIAL_CABACITY);
    }

    public MyHashMap(int capacity) {
        bucket = new Entry[capacity];
    }

    public void put(K key, V value) {
        // Create entry obj
        Entry<K, V> entry = new Entry<>(key, value);

        // Get hashcode & bucket location
        int bucketLocation = getBucketLocation(key);

        // if location not null
        // traverse all nodes, if any key equal update value & return
        // Else last not add entry
        Entry<K, V> current = bucket[bucketLocation];
        if (current != null) {
            while (current.next != null) {
                // If first match equal
                if (current.key.equals(entry.key)) {
                    current.value = entry.value;
                    return;
                }
                current = current.next;
            }
            if (current.key.equals(entry.key)) {
                current.value = entry.value;
            } else {
                current.next = entry;
            }
        } else {
            bucket[bucketLocation] = entry;
        }
    }

    private int getBucketLocation(K key) {
        return key.hashCode()% bucket.length;
    }

    public V get(K key) {
        int bucketLocation = getBucketLocation(key);
        Entry<K, V> current = bucket[bucketLocation];
        while (current != null) {
            if (current.key.equals(key)) {
                return current.value;
            }
            current = current.next;
        }
        return null;
    }
}
